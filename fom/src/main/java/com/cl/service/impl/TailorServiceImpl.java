package com.cl.service.impl;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.dao.*;
import com.cl.entity.*;
import com.cl.service.IFinanceService;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ITailorService;
import com.cl.utils.DateUtil;
import com.cl.utils.ExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TailorServiceImpl
 * @Description 裁剪业务实现类
 * @Author 陈龙
 * @Date 2019/7/29 16:39
 * @Version 1.0
 **/
@Service
@Transactional
public class TailorServiceImpl implements ITailorService {

    @Resource
    private TailorMapper tailorMapper;

    @Resource
    private OrderManageMapper orderManageMapper;

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private IFinanceService financeService;

    @Resource
    private FinanceMapper financeMapper;

    @Resource
    private StockMapper stockMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public PageInfo<TailorResBean> queryTailorList(RequestBeanModel<TailorReqBean> reqBeanModel) {
        TailorReqBean tailorReqBean = reqBeanModel.getReqData();
        if(tailorReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || tailorReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!orgId.equals(Long.valueOf(DictionaryConstants.ADMIN_ORG_ID))){
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
            tailorReqBean.setProducer(sysOrgEntity.getName());
        }else{
            tailorReqBean.setProducer(null);
        }
        //分页查询
        PageHelper.startPage(tailorReqBean.getPageNum() , tailorReqBean.getPageSize());
        PageHelper.orderBy("t.last_update_time desc");
        List<TailorResBean> tailorResBeanList = this.tailorMapper.queryTailorList(tailorReqBean);
        return new PageInfo<>(tailorResBeanList);
    }


    @Override
    public void updateTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {
        TailorReqBean tailorReqBean = reqBeanModel.getReqData();
        TailorEntity tailorEntity = this.checkParameter(tailorReqBean);
        tailorEntity.setLastUpdateUser(reqBeanModel.getUsername());//最后修改人
        tailorEntity.setLastUpdateTime(new Date());//最后修改时间
        TailorEntity tailorEntityById = this.tailorMapper.selectByPrimaryKey(tailorReqBean.getId());
        //修改裁剪数据
        int i = this.tailorMapper.updateByPrimaryKeySelective(tailorEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "修改裁剪数据失败!");
        //根据订单编号获取对应的订单对象
        OrderManageEntity orderManageEntity = this.purchaseMapper.selectOrder(tailorReqBean.getOrderNo());
        //扣除库存
        this.updateStock(orderManageEntity , tailorReqBean.getActualCutQuantity() , tailorEntityById.getActualCutQuantity());
        if(StringUtils.isNotBlank(tailorReqBean.getActualCutQuantity())){
            if(!orderManageEntity.getOrderStatus().equals(DictionaryConstants.ORDER_STATUS_ALREADY_TAILOR)){
                //修改订单状态
                OrderManageEntity updateOrderManageEntity = new OrderManageEntity();
                updateOrderManageEntity.setId(orderManageEntity.getId());
                updateOrderManageEntity.setOrderStatus(DictionaryConstants.ORDER_STATUS_ALREADY_TAILOR);
                Integer j = this.orderManageMapper.updateByPrimaryKeySelective(updateOrderManageEntity);
                Assert.isTrue(j.equals(DictionaryConstants.ALL_BUSINESS_ONE), "修改订单状态失败!");
                //查询此订单号是否生成了财务数据
                FinanceEntityExample financeEntityExample = new FinanceEntityExample();
                FinanceEntityExample.Criteria criteria = financeEntityExample.createCriteria();
                criteria.andOrderNoEqualTo(tailorReqBean.getOrderNo());
                List<FinanceEntity> financeEntityList = this.financeMapper.selectByExample(financeEntityExample);
                if(financeEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO){
                    //生成财务数据
                    FinanceEntity financeEntity = new FinanceEntity();
                    financeEntity.setOrderNo(tailorReqBean.getOrderNo());
                    financeEntity.setCreateUser(reqBeanModel.getUserId());
                    financeEntity.setLastUpdateUser(reqBeanModel.getUserId());
                    this.financeService.insertFinance(financeEntity);
                }
            }
        }
    }

    /**
     * 扣除库存
     * @param orderManageEntity
     */
    private void updateStock(OrderManageEntity orderManageEntity , String actualCutQuantity ,Integer oldActualCutQuantity){
        StockEntityExample stockEntityExample = new StockEntityExample();
        StockEntityExample.Criteria criteria = stockEntityExample.createCriteria();
        criteria.andOrderNoEqualTo(orderManageEntity.getOrderNo());
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        //根据订单sku获取对应的所有库存数据
        List<StockEntity> stockEntityList = this.stockMapper.selectByExample(stockEntityExample);
        Assert.notEmpty(stockEntityList , "此裁剪单对应的订单没有库存数据无法扣除!");
        for(StockEntity stockEntity : stockEntityList){
            PurchaseEntityExample purchaseEntityExample = new PurchaseEntityExample();
            PurchaseEntityExample.Criteria criteriaPurchase = purchaseEntityExample.createCriteria();
            criteriaPurchase.andOrderNoEqualTo(orderManageEntity.getOrderNo());
            criteriaPurchase.andMaterielSkuEqualTo(stockEntity.getMaterialSku());
            criteriaPurchase.andPurchaseStatusNotEqualTo(DictionaryConstants.DETELE);
            //根据订单号和库存对应的物料sku获取采购单信息
            List<PurchaseEntity> purchaseEntityList = this.purchaseMapper.selectByExample(purchaseEntityExample);
            Assert.notEmpty(purchaseEntityList , "此订单号和对应的库存物料sku未找到采购单号,无法获取单件用量!");
            PurchaseEntity purchaseEntity = purchaseEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
            Assert.notNull(purchaseEntity.getSimpleUse() , "此订单号和物料sku获取的采购单号对应的单件用量为空!");
            if(!oldActualCutQuantity.equals(DictionaryConstants.ALL_BUSINESS_ZERO)) {
                actualCutQuantity = String.valueOf(Integer.valueOf(actualCutQuantity) - oldActualCutQuantity);
            }
            //单件用量*实裁数
            Integer tailorStock = purchaseEntity.getSimpleUse().multiply(new BigDecimal(actualCutQuantity)).setScale(DictionaryConstants.ALL_BUSINESS_ZERO , BigDecimal.ROUND_UP).intValue();
            Integer stock = stockEntity.getStock();
            stockEntity.setStock(stock - tailorStock);
            int i = this.stockMapper.updateByPrimaryKeySelective(stockEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改库存失败!");
        }
    }


    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return !matcher.matches();
    }

    /**
     *  校验 编辑时带过来的参数并转换成entity
     * @param
     */
    private TailorEntity checkParameter(TailorReqBean tailorReqBean){
        TailorEntity tailorEntity = new TailorEntity();
        Assert.notNull(tailorReqBean.getId() , "请选择一条数据,ID不能为空!");
        Assert.hasText(tailorReqBean.getOrderNo() , "订单号不能为空!");
        if(StringUtils.isNotBlank(tailorReqBean.getActualCutQuantity())){
            String actualCutQuantityRegexp = "^[1-9][0-9]{0,8}$";
            if(match(actualCutQuantityRegexp , tailorReqBean.getActualCutQuantity())) {
                throw new BusinessException("实裁数量格式规则: 必须是整数在0-999999999之间! ");
            }
            tailorEntity.setActualCutQuantity(Integer.valueOf(tailorReqBean.getActualCutQuantity()));//实裁剪数量
            tailorEntity.setTailoStatus(DictionaryConstants.ORDER_STATUS_ALREADY_PURCHASE);//裁剪状态
            //当前时间减去生成时间 等于耗时
            TailorEntity tailorEntityById = this.tailorMapper.selectByPrimaryKey(tailorReqBean.getId());
            Assert.notNull(tailorEntityById , "未找到对应的裁剪数据,错误ID!");
            Date createTime = tailorEntityById.getCreateTime();
            Date date = new Date();
            //计算耗时
            long m = (date.getTime() - createTime.getTime())/DictionaryConstants.H;
            BigDecimal consumingTime = new BigDecimal((double) m);
            tailorEntity.setConsumingTime(consumingTime);//耗时
        }else{
            throw new BusinessException("实裁数量不能为空!");
        }
        if(StringUtils.isNotBlank(tailorReqBean.getMonovalent())){
            String monvalentRegexp =  "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(match(monvalentRegexp ,tailorReqBean.getMonovalent())){
                throw new BusinessException("单价规则:整数位最多10位,小数位最多2位! ");
            }
            tailorEntity.setMonovalent(new BigDecimal(tailorReqBean.getMonovalent()));//单价
        }
        tailorEntity.setId(tailorReqBean.getId());//id
        tailorEntity.setTailorName(tailorReqBean.getTailorName());//裁剪人员
        return tailorEntity;
    }

    @Override
    public void insertTailor(TailorEntity tailorEntity) {
        int i = this.tailorMapper.insertSelective(tailorEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "新增裁剪数据失败!");
    }

    @Override
    public void exportTailor(HttpServletResponse response, TailorReqBean tailorReqBean , String userId) {
        Assert.hasText(userId , "userId不能为空!");
        String userIdRegexp = "^[1-9][0-9]{0,8}$";
        if(match(userIdRegexp , userId)) {
            throw new BusinessException("userId规则: 必须是整数在0-999999999之间! ");
        }
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(userId));
        if(null == sysUserEntity){
            throw new BusinessException(DictionaryConstants.failCode,"userId对应的用户不存在, 请求失败!");
        }
        //转码
        tailorReqBean = this.decodeTailorReqBean(tailorReqBean);
        tailorReqBean.setPageNum(DictionaryConstants.ALL_BUSINESS_ONE);
        tailorReqBean.setPageSize(DictionaryConstants.PAGE_SIZE);
        RequestBeanModel requestBeanModel = new RequestBeanModel();
        requestBeanModel.setReqData(tailorReqBean);
        requestBeanModel.setUserId(userId);
        //查询结果
        List<TailorResBean> tailorResBeanList = this.queryTailorList(requestBeanModel).getList();
        //表头
        String[] headers = {"订单编号(orderNo)" , "SKU(sku)" , "生产方(producer)" , "应裁数量(answerCutQuantity)" ,"实裁数量(actualCutQuantity)",
                            "裁剪小组名(tailorName)" , "裁剪单价(monovalent)"};
        ExcelUtils.exportExcel("裁床列表信息" , headers , tailorResBeanList , response , DateUtil.DATESHOWFORMAT);
    }

    private TailorReqBean decodeTailorReqBean(TailorReqBean tailorReqBean) {
        // 编码
        final String UTF_8 = "UTF-8";
        try {
            // 订单号
            if (StringUtils.isNotBlank(tailorReqBean.getOrderNo())) {
                tailorReqBean.setOrderNo(URLDecoder.decode(tailorReqBean.getOrderNo(), UTF_8));
            }
            // sku
            if (StringUtils.isNotBlank(tailorReqBean.getSku())) {
                tailorReqBean.setSku(URLDecoder.decode(tailorReqBean.getSku(), UTF_8));
            }
            // 生产方
            if (StringUtils.isNotBlank(tailorReqBean.getProducer())) {
                tailorReqBean.setProducer(URLDecoder.decode(tailorReqBean.getProducer(), UTF_8));
            }
            // 裁剪小组
            if (StringUtils.isNotBlank(tailorReqBean.getTailorName())) {
                tailorReqBean.setTailorName(URLDecoder.decode(tailorReqBean.getTailorName(), UTF_8));
            }
            // 裁剪状态
            if (StringUtils.isNotBlank(tailorReqBean.getTailorStatus())) {
                tailorReqBean.setTailorStatus(URLDecoder.decode(tailorReqBean.getTailorStatus(), UTF_8));
            }
            //下单开始时间
            if (StringUtils.isNotBlank(tailorReqBean.getStartDate())) {
                tailorReqBean.setStartDate(URLDecoder.decode(tailorReqBean.getStartDate(), UTF_8));
            }
            //下单结束时间
            if (StringUtils.isNotBlank(tailorReqBean.getEndDate())) {
                tailorReqBean.setEndDate(URLDecoder.decode(tailorReqBean.getEndDate(), UTF_8));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return tailorReqBean;
    }
}

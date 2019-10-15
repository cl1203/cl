package com.cl.service.impl;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.*;
import com.cl.entity.*;
import com.cl.service.IPulldownMenuService;
import com.cl.service.IPurchaseService;
import com.cl.service.ITailorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PurchaseServiceImpl
 * @Description 采购实现类
 * @Author 陈龙
 * @Date 2019/7/24 15:16
 * @Version 1.0
 **/
@Service
@Transactional
public class PurchaseServiceImpl implements IPurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private OrderManageMapper orderManageMapper;

    @Resource
    private ITailorService iTailorService;

    @Resource
    private IObjectTransformer<PurchaseEntity , PurchaseResBean> purchaseTransformer;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private TailorMapper tailorMapper;

    @Resource
    private StockMapper stockMapper;

    @Override
    public PageInfo<PurchaseResBean> queryPurchaseList(RequestBeanModel<PurchaseReqBean> reqBeanModel) {
        PurchaseReqBean purchaseReqBean = reqBeanModel.getReqData();
        if(purchaseReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || purchaseReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!orgId.equals(Long.valueOf(DictionaryConstants.ADMIN_ORG_ID))){
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
            purchaseReqBean.setOrgName(sysOrgEntity.getName());
        }else{
            purchaseReqBean.setOrgName(null);
        }
        PageHelper.startPage(purchaseReqBean.getPageNum() , purchaseReqBean.getPageSize() , "p.last_update_time desc");
        List<PurchaseEntity> purchaseEntityList = this.purchaseMapper.selectPurchaseList(purchaseReqBean);
        List<PurchaseResBean> purchaseResBeanList = this.purchaseTransformer.transform(purchaseEntityList);
        return new PageInfo<>(purchaseResBeanList);
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

    @Override
    public void updatePurchase(RequestBeanModel<PurchaseReqBean> reqBeanModel) {
        PurchaseReqBean purchaseReqBean = reqBeanModel.getReqData();
        //根据订单编号获取对应的订单对象
        OrderManageEntity orderManageEntity = this.purchaseMapper.selectOrder(purchaseReqBean.getOrderNo());
        //校验修改的参数
        PurchaseEntity purchaseEntity = this.checkParameter(purchaseReqBean , orderManageEntity);
        PurchaseEntity purchaseEntityById = this.purchaseMapper.selectByPrimaryKey(purchaseReqBean.getId());
        purchaseEntity.setLastUpdateTime(new Date());//最后修改时间
        purchaseEntity.setLastUpdateUser(reqBeanModel.getUsername());//最后修改人
        //修改采购表
        int i = this.purchaseMapper.updateByPrimaryKeySelective(purchaseEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改采购数据失败!");
        //录入实采 更新库存
        this.updateStock(orderManageEntity , purchaseEntityById , purchaseReqBean.getActualPickQuantity());
        //修改订单的entity
        OrderManageEntity updateOrderEntity = new OrderManageEntity();
        updateOrderEntity.setId(orderManageEntity.getId());
        //判断采购对应的订单状态是否变为采购中 如果没有  则修改订单状态为采购中
        if(orderManageEntity.getOrderStatus().equals(DictionaryConstants.ORDER_STATUS_WAIT_PURCHASE)){
            updateOrderEntity.setOrderStatus(DictionaryConstants.ORDER_STATUS_ALREADY_PURCHASE);
            int k = this.orderManageMapper.updateByPrimaryKeySelective(updateOrderEntity);
            Assert.isTrue(k > DictionaryConstants.ALL_BUSINESS_ZERO , "修改订单状态失败!");
        }
        //此订单号对应的待采购和采购中的所有采购单数量 1:查询待采购和采购中所有采购单  2:查询采购中的所有采购单
        Integer purchaseNum = this.purchaseMapper.selectPurchaseNumByOrderNo(purchaseReqBean.getOrderNo() , DictionaryConstants.ALL_BUSINESS_ONE.byteValue());
        //此订单号对应的采购中的所有采购单数量
        Integer purchaseNumIng = this.purchaseMapper.selectPurchaseNumByOrderNo(purchaseReqBean.getOrderNo() , DictionaryConstants.ALL_BUSINESS_ZERO.byteValue());
        if(purchaseNum.equals(purchaseNumIng)){
            TailorEntityExample tailorEntityExample = new TailorEntityExample();
            TailorEntityExample.Criteria criteria = tailorEntityExample.createCriteria();
            criteria.andOrderNoEqualTo(purchaseReqBean.getOrderNo());
            List<TailorEntity> tailorEntityList = this.tailorMapper.selectByExample(tailorEntityExample);
            if(tailorEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO){
                int j = this.purchaseMapper.updatePurchaseStatusByOrderNo(purchaseReqBean.getOrderNo());//修改为采购已完成
                Assert.isTrue(j > DictionaryConstants.ALL_BUSINESS_ZERO , "修改采购单状态失败!");
                updateOrderEntity.setOrderStatus(DictionaryConstants.ORDER_STATUS_WAIT_TAILOR);//修改订单为待裁剪
                updateOrderEntity.setWaitTailorTime(new Date());
                int k = this.orderManageMapper.updateByPrimaryKeySelective(updateOrderEntity);
                Assert.isTrue(k > DictionaryConstants.ALL_BUSINESS_ZERO , "修改订单状态失败!");
                //调用生成裁剪数据接口
                this.insertTailor(purchaseReqBean , orderManageEntity , reqBeanModel);
            }else{
                if(purchaseEntityById.getPurchaseType().equalsIgnoreCase("面料A")) {
                    //计算应裁数
                    BigDecimal answerCutQuantity = this.CalculationAnswerCutQuantity(purchaseReqBean.getOrderNo());
                    TailorEntity tailorEntity = tailorEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
                    tailorEntity.setAnswerCutQuantity(answerCutQuantity.intValue());
                    Integer l = this.tailorMapper.updateByPrimaryKeySelective(tailorEntity);
                    Assert.isTrue(l.equals(DictionaryConstants.ALL_BUSINESS_ONE) , "修改应裁数失败!");
                }
            }
        }
    }

    /**
     * 更新库存
     * @param orderManageEntity
     * @param purchaseEntityById
     */
    private void updateStock(OrderManageEntity orderManageEntity , PurchaseEntity purchaseEntityById , String actualPickQuantity){
        StockEntityExample stockEntityExample = new StockEntityExample();
        StockEntityExample.Criteria criteriaStock = stockEntityExample.createCriteria();
        criteriaStock.andOrderNoEqualTo(orderManageEntity.getOrderNo());
        criteriaStock.andMaterialSkuEqualTo(purchaseEntityById.getMaterielSku());
        criteriaStock.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        List<StockEntity> stockEntityList = this.stockMapper.selectByExample(stockEntityExample);
        Assert.notEmpty(stockEntityList , "此采购单对应的物料sku没有对应的库存数据,无法更新!");
        StockEntity stockEntity = stockEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
        Integer stock = stockEntity.getStock();
        stock = stock + Integer.valueOf(actualPickQuantity);
        stockEntity.setStock(stock);
        int i = this.stockMapper.updateByPrimaryKeySelective(stockEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改库存失败!");
    }



    /**
     * 新增裁剪数据
     * @param purchaseReqBean
     * @param orderManageEntity
     * @param reqBeanModel
     */
    private void insertTailor(PurchaseReqBean purchaseReqBean ,OrderManageEntity orderManageEntity , RequestBeanModel<PurchaseReqBean> reqBeanModel){
        TailorEntity tailorEntity = new TailorEntity();
        tailorEntity.setOrderNo(purchaseReqBean.getOrderNo());//订单号
        //计算应裁数
        BigDecimal answerCutQuantity = this.CalculationAnswerCutQuantity(purchaseReqBean.getOrderNo());
        tailorEntity.setAnswerCutQuantity(answerCutQuantity.intValue());
        //根据订单ID 查询最近的同样sku的订单信息
        OrderManageEntity orderManageEntityOrderBy = this.orderManageMapper.selectProducer(orderManageEntity.getId());
        if(null != orderManageEntityOrderBy){
            //根据订单的sku查询最近一次裁剪表中的单价
            BigDecimal monovalent = this.purchaseMapper.selectTailorBySku(orderManageEntityOrderBy.getSku());//单价
            if(null != monovalent){
                tailorEntity.setMonovalent(monovalent);
            }
        }
        tailorEntity.setLastUpdateUser(reqBeanModel.getUsername());//修改人
        tailorEntity.setCreateUser(reqBeanModel.getUsername());//新增人
        this.iTailorService.insertTailor(tailorEntity);
    }

    /**
     * 计算应裁数
     * @param orderNo
     */
    private BigDecimal CalculationAnswerCutQuantity(String orderNo){
        //根据订单号查询物料分类为面料A的采购单
        PurchaseEntity purchaseEntityByOrderNo = this.purchaseMapper.selectPurchaseListByOrderNo(orderNo);
        if(null == purchaseEntityByOrderNo){
            return new BigDecimal(DictionaryConstants.ALL_BUSINESS_ZERO);
        }
        BigDecimal singleUse = purchaseEntityByOrderNo.getSimpleUse();//单件用量
        Assert.notNull(singleUse , "单件用量为空!无法计算应裁数量!");
        BigDecimal actualPickQuantity = purchaseEntityByOrderNo.getActualPickQuantity();//实采数量
        BigDecimal answerCutQuantity = (actualPickQuantity.divide(singleUse , DictionaryConstants.ALL_BUSINESS_ZERO , BigDecimal.ROUND_HALF_UP));//应裁数量
        return answerCutQuantity;
    }


    /**
     *  校验 编辑时带过来的参数并转换成entity
     * @param purchaseReqBean
     */
    private PurchaseEntity checkParameter(PurchaseReqBean purchaseReqBean , OrderManageEntity orderManageEntity){
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        Assert.notNull(purchaseReqBean.getId() , "请选择一条数据,ID不能为空!");
        Assert.hasText(purchaseReqBean.getOrderNo() , "订单号不能为空!");
        Assert.hasText(purchaseReqBean.getActualPickQuantity() , "实采数量不能为空,用来计算应裁数!");
        Assert.hasText(purchaseReqBean.getSupplierName() ,"供应商不能为空!");
        String regexp = "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}";
        if(match(regexp , purchaseReqBean.getActualPickQuantity())) {
            throw new BusinessException("实采数量规则:整数位最多10位,小数位最多2位! ");
        }
        purchaseEntity.setActualPickQuantity(new BigDecimal(purchaseReqBean.getActualPickQuantity()));//实采数量
        Date orderTime = orderManageEntity.getOrderTime();//下单时间
        if(null != orderTime){
            Date date = new Date();
            //计算耗时
            long m = (date.getTime() - orderTime.getTime())/DictionaryConstants.H;
            BigDecimal consumingTime = new BigDecimal((double) m);
            purchaseEntity.setConsumingTime(consumingTime);//采购耗时
        }
        purchaseEntity.setPurchaseStatus(DictionaryConstants.ORDER_STATUS_ALREADY_PURCHASE);//采购状态
        //录入实采数量时 校验是否存在采购日期 如果没有 就是当前录入时间
        PurchaseEntity purchaseEntityById = this.purchaseMapper.selectByPrimaryKey(purchaseReqBean.getId());
        Assert.notNull(purchaseEntityById , "未找到对应的采购数据,错误ID!");
        if(null == purchaseEntityById.getPurchaseTime()){
            purchaseEntity.setPurchaseTime(new Date());//采购日期
        }
        Assert.hasText(purchaseReqBean.getActualPickMonovalent() , "实采单价不能为空!");
        if(match(regexp , purchaseReqBean.getActualPickMonovalent())) {
            throw new BusinessException("实采单价规则:整数位最多10位,小数位最多2位! ");
        }
        //实采单价
        purchaseEntity.setActualPickMonovalent(new BigDecimal(purchaseReqBean.getActualPickMonovalent()));
        //实采总额
        BigDecimal actualPickTotal = new BigDecimal(purchaseReqBean.getActualPickQuantity()).multiply(new BigDecimal(purchaseReqBean.getActualPickMonovalent()));
        purchaseEntity.setActualPickTotal(actualPickTotal.setScale(DictionaryConstants.PERMISSION_TYPE_TWO , BigDecimal.ROUND_HALF_UP));
        purchaseEntity.setId(purchaseReqBean.getId());//id
        purchaseEntity.setSupplierName(purchaseReqBean.getSupplierName());//供应商
        return purchaseEntity;
    }
}

package com.cl.service.impl;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.PulldownMenuMapper;
import com.cl.dao.PurchaseMapper;
import com.cl.dao.TailorMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.TailorEntity;
import com.cl.service.ITailorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
    private PulldownMenuMapper pulldownMenuMapper;

    @Override
    public PageInfo<TailorResBean> queryTailorList(RequestBeanModel<TailorReqBean> reqBeanModel) {
        TailorReqBean tailorReqBean = reqBeanModel.getReqData();
        if(tailorReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || tailorReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //分页查询
        PageHelper.startPage(tailorReqBean.getPageNum() , tailorReqBean.getPageSize());
        //生产方查询条件是否有值
        this.getOrgIdByProducer(tailorReqBean);
        List<TailorResBean> tailorResBeanList = this.tailorMapper.queryTailorList(tailorReqBean);
       /*tailorResBeanList.forEach(tailorResBean -> {
            //根据订单号查询二次工艺信息
            List<SecondaryProcessResBean> secondaryProcessResBeanList = this.orderManageMapper.selectSecondaryProcessByOrderNo(tailorResBean.getOrderNo());
            tailorResBean.setSecondaryProcessResBeanList(secondaryProcessResBeanList);
        });*/
        return new PageInfo<>(tailorResBeanList);
    }

    /**
     * 如果生产方查询条件有值 先匹配对应的组织ID  根据组织ID关联订单
     * @param tailorReqBean
     */
    private void getOrgIdByProducer(TailorReqBean tailorReqBean){
        if(StringUtils.isNotBlank(tailorReqBean.getProducer())){
            PulldownMenuResBean pulldownMenuResBean = new PulldownMenuResBean();
            pulldownMenuResBean.setName(tailorReqBean.getProducer());
            List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuResBean);
            if(CollectionUtils.isNotEmpty(pulldownMenuResBeanList)){
                Long orgId = pulldownMenuResBeanList.get(0).getId();
                tailorReqBean.setProducerOrgId(orgId);
            }
        }
    }

    @Override
    public void updateTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {
        TailorReqBean tailorReqBean = reqBeanModel.getReqData();
        TailorEntity tailorEntity = this.checkParameter(tailorReqBean);
        tailorEntity.setLastUpdateUser(reqBeanModel.getUsername());//最后修改人
        tailorEntity.setLastUpdateTime(new Date());//最后修改时间
        //修改裁剪数据
        int i = this.tailorMapper.updateByPrimaryKeySelective(tailorEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "修改裁剪数据失败!");
        //根据订单编号获取对应的订单对象
        OrderManageEntity orderManageEntity = this.purchaseMapper.selectOrder(tailorReqBean.getOrderNo());
        //修改订单状态
        OrderManageEntity updateOrderManageEntity = new OrderManageEntity();
        updateOrderManageEntity.setId(orderManageEntity.getId());
        updateOrderManageEntity.setOrderStatus(DictionaryConstants.ORDER_STATUS_ALREADY_TAILOR);
        int j = this.orderManageMapper.updateByPrimaryKeySelective(updateOrderManageEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "修改订单状态失败!");
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
        return matcher.matches();
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
            if(!match(actualCutQuantityRegexp , tailorReqBean.getActualCutQuantity())) {
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
        }
        if(StringUtils.isNotBlank(tailorReqBean.getMonovalent())){
            String monvalentRegexp =  "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(!match(monvalentRegexp ,tailorReqBean.getMonovalent())){
                throw new BusinessException("单价规则:整数位最多10位,小数位最多2位! ");
            }
            tailorEntity.setMonovalent(new BigDecimal(tailorReqBean.getMonovalent()));//单价
        }
        tailorEntity.setId(tailorReqBean.getId());//id
        if(StringUtils.isNotBlank(tailorReqBean.getTailorUserNameId())){
            tailorEntity.setTailorUserId(Long.valueOf(tailorReqBean.getTailorUserNameId()));//裁剪人员
        }
        return tailorEntity;
    }

    @Override
    public void insertTailor(TailorEntity tailorEntity) {
        int i = this.tailorMapper.insertSelective(tailorEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "新增裁剪数据失败!");
    }
}

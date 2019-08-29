package com.cl.service.impl;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.bean.res.OrderQuantityResBean;
import com.cl.bean.res.SecondaryProcessResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.service.IOrderManageService;
import com.cl.service.IPulldownMenuService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static com.cl.comm.constants.DictionaryConstants.ADMIN_ORG_ID;

/**
 * @ClassName OrderManageServiceImpl
 * @Description 订单管理业务实现类
 * @Author 陈龙
 * @Date 2019/7/20 17:32
 * @Version 1.0
 **/
@Service
@Transactional
public class OrderManageServiceImpl implements IOrderManageService {

    @Resource
    private OrderManageMapper orderManageMapper;

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private IObjectTransformer<OrderManageEntity , OrderManageResBean> orderManageTransformer;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Override
    public PageInfo<OrderManageResBean> queryOrderList(RequestBeanModel<OrderManageReqBean> reqBeanModel) {
        OrderManageReqBean orderManageReqBean = reqBeanModel.getReqData();
        if(orderManageReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || orderManageReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        SysOrgEntity sysOrgEntity = null;
        if(!Long.valueOf(ADMIN_ORG_ID).equals(orgId)){
            sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
        }
        //分页查询
        PageInfo<OrderManageEntity> orderManageEntityPageInfo = this.orderManageMapper.selectOrderManagePageInfo(orderManageReqBean , sysOrgEntity);
        //entity转resBean
        PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageTransformer.transform(orderManageEntityPageInfo);
        List<OrderManageResBean> orderManageResBeanList = orderManageResBeanPageInfo.getList();
        if(CollectionUtils.isNotEmpty(orderManageResBeanList)){
            orderManageResBeanList.forEach(orderManageResBean -> {
                //根据订单号查询下单数量信息
                List<OrderQuantityResBean> orderQuantityResBeanList = this.orderManageMapper.selectOrderQuantityByOrderNo(orderManageResBean.getOrderNo());
                orderManageResBean.setOrderQuantityResBeanList(orderQuantityResBeanList);
                //根据订单号查询二次工艺信息
                List<SecondaryProcessResBean> secondaryProcessResBeanList = this.orderManageMapper.selectSecondaryProcessByOrderNo(orderManageResBean.getOrderNo());
                orderManageResBean.setSecondaryProcessResBeanList(secondaryProcessResBeanList);
            });
        }
        orderManageResBeanPageInfo.setList(orderManageResBeanList);
        return orderManageResBeanPageInfo;
    }

    @Override
    public void distributionOrder(RequestBeanModel<DistributionOrderReqBean> reqBeanModel) {
        //根据用户id查询对应的组织
        Long orgIdByUserId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!orgIdByUserId.equals(Long.valueOf(ADMIN_ORG_ID))){
            throw new BusinessException("只有系统管理员用户才能重新分单");
        }
        OrderManageEntity orderManageEntity = new OrderManageEntity();
        List<Long> orderIdList = reqBeanModel.getReqData().getOrderIdList();
        Long orgId = reqBeanModel.getReqData().getOrgId();
        SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
        Assert.notNull(sysOrgEntity , "生产方不存在!");
        Assert.isTrue(sysOrgEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "生产方已被删除!");
        orderManageEntity.setProducer(sysOrgEntity.getName());
        orderManageEntity.setLastUpdateTime(new Date());
        orderManageEntity.setLastUpdateUser(reqBeanModel.getUsername());
        for(Long orderId : orderIdList){
            OrderManageEntity orderManageEntityByOrderId = this.orderManageMapper.selectByPrimaryKey(orderId);
            Assert.notNull(orderManageEntityByOrderId , "订单数据错误!");
            orderManageEntity.setId(orderId);
            int i = this.orderManageMapper.updateByPrimaryKeySelective(orderManageEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "分单失败!");
        }
    }

    @Override
    public String queryProducer(RequestBeanModel<SingleParam> reqBeanModel) {
        String orderId = reqBeanModel.getReqData().getParam();
        Assert.hasText(orderId , "请选择一条记录!");
        OrderManageEntity orderManageEntity = this.orderManageMapper.selectProducer(Long.valueOf(orderId));
        if(null == orderManageEntity){
            return null;
        }
        return orderManageEntity.getProducer();
    }
}

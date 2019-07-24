package com.cl.service.impl;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.bean.res.OrderQuantityResBean;
import com.cl.bean.res.SecondaryProcessResBean;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderQuantityEntity;
import com.cl.entity.SecondaryProcessEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.service.IOrderManageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageInfo<OrderManageResBean> queryOrderList(RequestBeanModel<OrderManageReqBean> reqBeanModel) {
        OrderManageReqBean orderManageReqBean = reqBeanModel.getReqData();
        if(orderManageReqBean.getPageNum() < 1 || orderManageReqBean.getPageSize() < 1){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }

        //分页查询
        PageInfo<OrderManageEntity> orderManageEntityPageInfo = this.orderManageMapper.selectOrderManagePageInfo(orderManageReqBean);
        //entity转resBean
        PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageTransformer.transform(orderManageEntityPageInfo);
        List<OrderManageResBean> orderManageResBeanList = orderManageResBeanPageInfo.getList();
        orderManageResBeanList.forEach(orderManageResBean -> {
            //根据订单号查询下单数量信息
            List<OrderQuantityResBean> orderQuantityResBeanList = this.orderManageMapper.selectOrderQuantityByOrderNo(orderManageResBean.getOrderNo());
            orderManageResBean.setOrderQuantityResBeanList(orderQuantityResBeanList);
            //根据订单号查询二次工艺信息
            List<SecondaryProcessResBean> secondaryProcessResBeanList = this.orderManageMapper.selectSecondaryProcessByOrderNo(orderManageResBean.getOrderNo());
            orderManageResBean.setSecondaryProcessResBeanList(secondaryProcessResBeanList);
        });
        orderManageResBeanPageInfo.setList(orderManageResBeanList);
        return orderManageResBeanPageInfo;
    }

    @Override
    public void distributionOrder(RequestBeanModel<DistributionOrderReqBean> reqBeanModel) {
        OrderManageEntity orderManageEntity = new OrderManageEntity();
        List<Long> orderIdList = reqBeanModel.getReqData().getOrderIdList();
        Long orgId = reqBeanModel.getReqData().getOrgId();
        SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
        Assert.isNull(sysOrgEntity , "生产方不存在!");
        orderManageEntity.setProducerOrgId(orgId);
        for(Long orderId : orderIdList){
            OrderManageEntity orderManageEntityByOrderId = this.orderManageMapper.selectProducer(orderId);
            Assert.isNull(orderManageEntityByOrderId , "订单数据错误!");
            orderManageEntity.setId(orderId);
            int i = this.orderManageMapper.updateByPrimaryKeySelective(orderManageEntity);
            Assert.isTrue(i == 1 , "分单失败!");
        }
    }

    @Override
    public String queryProducer(RequestBeanModel<SingleParam> reqBeanModel) {
        String orderId = reqBeanModel.getReqData().getParam();
        Assert.hasText(orderId , "请选择一条记录!");
        OrderManageEntity orderManageEntity = this.orderManageMapper.selectProducer(Long.valueOf(orderId));
        String producer;
        if(null == orderManageEntity){
            return null;
        }
        if(null != orderManageEntity.getProducerOrgId()){
            //根据组织ID查询组织名称
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orderManageEntity.getProducerOrgId());
            producer = sysOrgEntity.getName();
        }else{
            producer = orderManageEntity.getProducer();
        }
        return producer;
    }
}

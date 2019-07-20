package com.cl.transform;

import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.SysOrgEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OrderManageTransform
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/20 17:57
 * @Version 1.0
 **/
@Service
public class OrderManageTransform extends AbstractObjectTransformer<OrderManageEntity , OrderManageResBean> {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Override
    public OrderManageResBean transform(OrderManageEntity orderManageEntity) {
        if(null == orderManageEntity){
            return null;
        }
        OrderManageResBean orderManageResBean = new OrderManageResBean();
        orderManageResBean.setOrderNumber(orderManageEntity.getOrderNumber());
        if(null != orderManageEntity.getOrderTime()){
            orderManageResBean.setOrderTime(orderManageEntity.getOrderTime());
        }
        orderManageResBean.setSurplusTime(orderManageEntity.getSurplusTime());
        orderManageResBean.setOrderStatus(orderManageEntity.getOrderStatus());
        orderManageResBean.setSku(orderManageEntity.getSku());
        if(null != orderManageEntity.getOrderQuantity()){
            orderManageResBean.setOrderQuantity(orderManageEntity.getOrderQuantity());
        }
        orderManageResBean.setSecondaryProcess(orderManageEntity.getSecondaryProcess());
        if(null != orderManageEntity.getProducerOrgId()){
            //根据组织ID查询组织名称
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orderManageEntity.getProducerOrgId());
            orderManageResBean.setProducer(sysOrgEntity.getName());
        }else{
            orderManageResBean.setProducer(orderManageEntity.getProducer());
        }
        return orderManageResBean;
    }
}

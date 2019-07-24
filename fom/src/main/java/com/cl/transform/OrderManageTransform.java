package com.cl.transform;

import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.util.DateUtils;
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
        orderManageResBean.setId(orderManageEntity.getId());//id
        orderManageResBean.setOrderNo(orderManageEntity.getOrderNo());//订单号
        if(null != orderManageEntity.getOrderTime()){//下单时间
            orderManageResBean.setOrderTime(orderManageEntity.getOrderTime());
        }
        orderManageResBean.setSurplusTime(orderManageEntity.getSurplusTime());//剩余时间
        if(null != orderManageEntity.getOrderStatus()){//订单状态
            switch(orderManageEntity.getOrderStatus()){
                case 1:
                    orderManageResBean.setOrderStatusName("待采购");
                    break;
                case 2:
                    orderManageResBean.setOrderStatusName("采购中");
                    break;
                case 3:
                    orderManageResBean.setOrderStatusName("待裁剪");
                    break;
                case 4:
                    orderManageResBean.setOrderStatusName("已裁剪");
                    break;
            }
        }
        orderManageResBean.setOrderImgUrl(orderManageEntity.getOrderImgUrl());//图片url
        orderManageResBean.setSku(orderManageEntity.getSku());//sku
        if(null != orderManageEntity.getIsFirst()){//是否首单
            orderManageResBean.setIsFirst(orderManageEntity.getIsFirst());
        }
        if(null != orderManageEntity.getOrderQuantity()){//订单件数
            orderManageResBean.setOrderQuantity(orderManageEntity.getOrderQuantity());
        }
        if(null != orderManageEntity.getProducerOrgId()){//生产方
            //根据组织ID查询组织名称
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orderManageEntity.getProducerOrgId());
            orderManageResBean.setProducer(sysOrgEntity.getName());
        }else{
            orderManageResBean.setProducer(orderManageEntity.getProducer());
        }
        return orderManageResBean;
    }
}

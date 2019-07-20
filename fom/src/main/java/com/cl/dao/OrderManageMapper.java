package com.cl.dao;

import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderManageEntityExample;
import com.cl.entity.SysOrgEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * OrderManageMapper继承基类
 */
@Repository
public interface OrderManageMapper extends MyBatisBaseDao<OrderManageEntity, Long, OrderManageEntityExample> {

    /**
     * @Author 陈龙
     * @Description 分页查询
     * @Date 20:33 2019/7/20
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.entity.OrderManageEntity>
     **/
    default PageInfo<OrderManageEntity> selectOrderManagePageInfo(RequestBeanModel<OrderManageReqBean> reqBeanModel){
        OrderManageReqBean orderManageReqBean = reqBeanModel.getReqData();
        Page<OrderManageEntity> page = PageHelper.startPage(orderManageReqBean.getPageNum() , orderManageReqBean.getPageSize() , "last_update_time");
        OrderManageEntityExample orderManageEntityExample = new OrderManageEntityExample();
        OrderManageEntityExample.Criteria criteria = orderManageEntityExample.createCriteria();
        if(StringUtils.isNotBlank(orderManageReqBean.getOrderNumber())){
            criteria.andOrderNumberEqualTo(orderManageReqBean.getOrderNumber());
        }
        if(StringUtils.isNotBlank(orderManageReqBean.getSku())){
            criteria.andSkuEqualTo(orderManageReqBean.getSku());
        }
        if(null != orderManageReqBean.getOrderStatus()){
            criteria.andOrderStatusEqualTo(orderManageReqBean.getOrderStatus());
        }
        if(null != orderManageReqBean.getOrderTime()){
            criteria.andOrderTimeEqualTo(orderManageReqBean.getOrderTime());
        }
        List<OrderManageEntity> orderManageEntityList = this.selectByExample(orderManageEntityExample);
        PageInfo<OrderManageEntity> orderManageEntityPageInfo = new PageInfo<>(page);
        orderManageEntityPageInfo.setList(orderManageEntityList);
        return orderManageEntityPageInfo;
    }

    /**
     * @Author 陈龙
     * @Description 根据订单ID查询上一次生产方
     * @Date 20:33 2019/7/20
     * @Param [orderId]
     * @return com.cl.entity.SysOrgEntity
     **/
    OrderManageEntity selectProducer(Long orderId);

}
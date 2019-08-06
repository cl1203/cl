package com.cl.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderQuantityResBean;
import com.cl.bean.res.SecondaryProcessResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderManageEntityExample;
import com.cl.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
    default PageInfo<OrderManageEntity> selectOrderManagePageInfo(OrderManageReqBean orderManageReqBean){
        Page<OrderManageEntity> page = PageHelper.startPage(orderManageReqBean.getPageNum() , orderManageReqBean.getPageSize() , "last_update_time DESC");
        OrderManageEntityExample orderManageEntityExample = new OrderManageEntityExample();
        OrderManageEntityExample.Criteria criteria = orderManageEntityExample.createCriteria();
        if(StringUtils.isNotBlank(orderManageReqBean.getOrderNo())){
            criteria.andOrderNoEqualTo(orderManageReqBean.getOrderNo());
        }
        if(StringUtils.isNotBlank(orderManageReqBean.getSku())){
            criteria.andSkuEqualTo(orderManageReqBean.getSku());
        }
        if(StringUtils.isNotBlank(orderManageReqBean.getOrderStatus())){
            criteria.andOrderStatusEqualTo(Byte.valueOf(orderManageReqBean.getOrderStatus()));
        }else{
            criteria.andOrderStatusNotEqualTo(DictionaryConstants.ORDER_STATUS_DELETED);
        }
        if(StringUtils.isNotBlank(orderManageReqBean.getOrderTime())){
            criteria.andOrderTimeEqualTo(DateUtils.getDateToString(orderManageReqBean.getOrderTime() , DateUtils.DATESHOWFORMAT));
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

    /**
     * @Author 陈龙
     * @Description 根据订单号查询下单数量信息
     * @Date 16:49 2019/7/24
     * @Param [orderNo]
     * @return java.util.List<com.cl.bean.res.OrderQuantityResBean>
     **/
    List<OrderQuantityResBean> selectOrderQuantityByOrderNo(String orderNo);

    /**
     * @Author 陈龙
     * @Description 根据订单号查询二次工艺信息
     * @Date 16:50 2019/7/24
     * @Param [orderNo]
     * @return java.util.List<com.cl.bean.res.SecondaryProcessResBean>
     **/
    List<SecondaryProcessResBean> selectSecondaryProcessByOrderNo(String orderNo);

    List<OrderManageEntity> selectByParams(Map<String,Object> params);
}
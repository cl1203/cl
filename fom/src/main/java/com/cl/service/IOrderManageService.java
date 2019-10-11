package com.cl.service;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageInsertReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

/**
 * 订单service
 * @author xujun
 *
 */
public interface IOrderManageService {

	/**
	 * @Author 陈龙
	 * @Description 获取订单列表
	 * @Date 20:15 2019/7/20
	 * @Param [reqBeanModel]
	 * @return com.github.pagehelper.PageInfo<com.cl.bean.res.OrderManageResBean>
	 **/
	PageInfo<OrderManageResBean> queryOrderList(RequestBeanModel<OrderManageReqBean> reqBeanModel);

	/**
	 * @Author 陈龙
	 * @Description 分单
	 * @Date 20:15 2019/7/20
	 * @Param [reqBeanModel]
	 * @return void
	 **/
	void distributionOrder(RequestBeanModel<DistributionOrderReqBean> reqBeanModel);

	/**
	 * @Author 陈龙
	 * @Description 根据ID获取上一次生产方
	 * @Date 20:15 2019/7/20
	 * @Param [id]
	 * @return java.lang.String
	 **/
	String queryProducer(RequestBeanModel<SingleParam> reqBeanModel);

    /**
     * 新增订单
     * @param reqBeanModel
     */
	void insertOrder(RequestBeanModel<OrderManageInsertReqBean> reqBeanModel);
}

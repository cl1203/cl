package com.cl.service;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

/**
 * 订单service
 * @author xujun
 *
 */
public interface IOrderManageService {

	/**
	 * 查询订单列表
	 * @param reqBeanModel
	 * @return
	 */
	PageInfo<OrderManageResBean> queryOrderList(RequestBeanModel<OrderManageReqBean> reqBeanModel);

	/**
	 * 分单 
	 * @param reqBeanModel
	 */
	void distributionOrder(RequestBeanModel<DistributionOrderReqBean> reqBeanModel);
}

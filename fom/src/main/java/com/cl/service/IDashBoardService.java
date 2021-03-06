package com.cl.service;

import com.cl.bean.req.AbnormalReqBean;
import com.cl.bean.req.DashBoardReqBean;
import com.cl.bean.res.AbnormalResBean;
import com.cl.bean.res.DashBoardResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

public interface IDashBoardService {

	PageInfo<DashBoardResBean> queryForecastInfo(RequestBeanModel<DashBoardReqBean> reqBeanModel) throws Exception;

	void updateOrderRemark(RequestBeanModel<DashBoardReqBean> reqBeanModel);

	PageInfo<AbnormalResBean> queryAbnormalList(RequestBeanModel<AbnormalReqBean> reqBeanModel);

	void updateAbnormal(RequestBeanModel<AbnormalReqBean> reqBeanModel);
	
}

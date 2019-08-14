package com.cl.service;

import com.cl.bean.req.DashBoardReqBean;
import com.cl.bean.res.DashBoardResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

public interface IDashBoardService {

	PageInfo<DashBoardResBean> queryForecaseInfo(RequestBeanModel<DashBoardReqBean> reqBeanModel);

	
}

package com.cl.service;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

public interface IStockService {

	PageInfo<StockResBean> queryStockList(RequestBeanModel<StockReqBean> reqBeanModel);

}

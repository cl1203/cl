package com.cl.service;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

public interface IStockService {

	public PageInfo<StockResBean> queryStockList(RequestBeanModel<StockReqBean> reqBeanModel);

	public void updateStock(RequestBeanModel<StockReqBean> reqBeanModel);

}

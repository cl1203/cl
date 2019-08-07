package com.cl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.Status;
import com.cl.dao.StockMapper;
import com.cl.service.IStockService;
import com.github.pagehelper.PageInfo;

@Service("stockService")
public class StockServiceImpl implements IStockService {

	@Autowired
	private StockMapper stockMapper;
	
	@Override
	public PageInfo<StockResBean> queryStockList(RequestBeanModel<StockReqBean> reqBeanModel) {
		StockReqBean stockReqBean = reqBeanModel.getReqData();
        validateParams(stockReqBean);
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(stockReqBean.getSku())) {
        	params.put("sku", stockReqBean.getSku());
        }
        int offset = (stockReqBean.getPageNum() - 1) * stockReqBean.getPageSize();
        params.put("offset", offset);
        params.put("pageSize", stockReqBean.getPageSize());
        List<StockResBean> stockList = stockMapper.selectByParams(params);
        PageInfo<StockResBean> stockResBeanPageInfo = new PageInfo<>(stockList);
        return stockResBeanPageInfo;
	}

    private void validateParams(StockReqBean stockReqBean) {
    	if(stockReqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
    	if(stockReqBean.getPageNum() == null || stockReqBean.getPageNum() < 1) {
    		stockReqBean.setPageNum(ApiConstants.DEFAULT_PAGE_NUM);
    	}
    	if(stockReqBean.getPageSize() == null || stockReqBean.getPageSize() < 1) {
    		stockReqBean.setPageSize(ApiConstants.DEFAULT_PAGE_SIZE);
    	}
    }

}

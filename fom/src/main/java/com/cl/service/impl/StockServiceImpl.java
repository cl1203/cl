package com.cl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.Status;
import com.cl.dao.StockMapper;
import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;
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
        int offset = (stockReqBean.getPageNum() - 1) * stockReqBean.getPageSize() + 1;
        params.put("offset", offset);
        params.put("limit", stockReqBean.getPageSize());
        List<String> orderNoList = stockMapper.selectOrderNoByParams(params);
        List<StockResBean> stockList = stockMapper.selectByOrderNoList(orderNoList);
        PageInfo<StockResBean> stockResBeanPageInfo = new PageInfo<>(stockList);
        return stockResBeanPageInfo;
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStock(RequestBeanModel<StockReqBean> reqBeanModel) {
		StockReqBean stockReqBean = reqBeanModel.getReqData();
        validateUpdateParams(stockReqBean);
        StockEntityExample example = new StockEntityExample();
        StockEntityExample.Criteria criteria = example.createCriteria();
        criteria.andSkuEqualTo(stockReqBean.getSku());
        criteria.andPurchaseCodeEqualTo(stockReqBean.getPurchaseNo());
        List<StockEntity> stockList = stockMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(stockList)) {
        	throw new BusinessException(Status.NOT_EXISTS_STOCK);
        }
        if(stockList.size() > 1) {
        	throw new BusinessException(Status.DUPLICATE_STOCK);
        }
        StockEntity entity = stockList.get(0);
        entity.setStock(stockReqBean.getStock());
        entity.setLastUpdateUser(reqBeanModel.getUsername());
        entity.setLastUpdateTime(new Date());
        stockMapper.updateByPrimaryKeySelective(entity);
	}

    private void validateUpdateParams(StockReqBean stockReqBean) {
    	if(stockReqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
    	if(StringUtils.isBlank(stockReqBean.getSku())) {
    		throw new BusinessException("sku编码不能为空！");
    	}
    	if(StringUtils.isBlank(stockReqBean.getPurchaseNo())) {
    		throw new BusinessException("采购单编码不能为空！");
    	}
    	if(stockReqBean.getStock() == null || stockReqBean.getStock() < 0) {
    		throw new BusinessException("库存不能为空且不能小于0！");
    	}
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

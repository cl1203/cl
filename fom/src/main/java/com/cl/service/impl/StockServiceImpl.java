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
import com.cl.bean.res.MaterialResBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.Status;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.PurchaseMapper;
import com.cl.dao.StockMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.PurchaseEntity;
import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;
import com.cl.service.IStockService;
import com.github.pagehelper.PageInfo;

@Service("stockService")
public class StockServiceImpl implements IStockService {

	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Override
	public PageInfo<StockResBean> queryStockList(RequestBeanModel<StockReqBean> reqBeanModel) {
		StockReqBean stockReqBean = reqBeanModel.getReqData();
        validateParams(stockReqBean);
        Map<String,Object> params = new HashMap<>();
        if(StringUtils.isNotBlank(stockReqBean.getSku())) {
        	params.put("sku", stockReqBean.getSku());
        }
        int offset = (stockReqBean.getPageNum() - 1) * stockReqBean.getPageSize();
        params.put("offset", offset);
        params.put("limit", stockReqBean.getPageSize());
        List<String> skuList = stockMapper.selectSkuByParams(params);
        List<StockResBean> stockList = stockMapper.selectBySkuList(skuList);
        for(StockResBean bean : stockList) {
        	params.clear();
        	params.put("sku", bean.getSku());
        	params.put("offset", ApiConstants.DEFAULT_OFFSET);
        	params.put("limit", ApiConstants.PAGE_SIZE_ONE);
        	List<OrderManageEntity> orderList = orderManageMapper.selectByParams(params);
        	if(CollectionUtils.isNotEmpty(orderList)) {
        		bean.setOrderImgUrl(orderList.get(0).getOrderImgUrl());
        	}
        	List<MaterialResBean> materiaList = bean.getMateriaList();
        	if(CollectionUtils.isNotEmpty(materiaList)) {
        		getPropertyByMateriaList(materiaList);
        	}
        }
		return new PageInfo<>(stockList);
	}
	
	private void getPropertyByMateriaList(List<MaterialResBean> materiaList) {
		for(MaterialResBean bean : materiaList) {
			Map<String,Object> params = new HashMap<>();
        	params.put("materialSku", bean.getMaterielSku());
        	params.put("offset", ApiConstants.DEFAULT_OFFSET);
        	params.put("limit", ApiConstants.PAGE_SIZE_ONE);
        	PurchaseEntity p = purchaseMapper.selectByMaterialSku(bean.getMaterielSku());
        	if(p != null) {
        		bean.setSupplierName(p.getSupplierName());
        		bean.setSupplierCode(p.getSupplierCode());
        		bean.setSupplierColorNumber(p.getSupplierColorNumber());
        		bean.setPurchaseType(p.getPurchaseType());
        		bean.setMaterielType(p.getMaterielType());
        		bean.setMaterielName(p.getMaterielName());
        		bean.setMaterielColor(p.getMaterielColor());
        	}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateStock(RequestBeanModel<StockReqBean> reqBeanModel) {
		StockReqBean stockReqBean = reqBeanModel.getReqData();
        validateUpdateParams(stockReqBean);
        StockEntityExample example = new StockEntityExample();
        StockEntityExample.Criteria criteria = example.createCriteria();
        criteria.andSkuEqualTo(stockReqBean.getSku());
        criteria.andMaterialSkuEqualTo(stockReqBean.getMaterialSku());
        List<StockEntity> stockList = stockMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(stockList)) {
        	throw new BusinessException(Status.NOT_EXISTS_STOCK);
        }
        if(stockList.size() > 1) {
        	throw new BusinessException(Status.DUPLICATE_STOCK);
        }
        StockEntity entity = stockList.get(0);
        entity.setStock(entity.getStock() + stockReqBean.getStock());
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
    	if(StringUtils.isBlank(stockReqBean.getMaterialSku())) {
    		throw new BusinessException("物料SKU不能为空！");
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

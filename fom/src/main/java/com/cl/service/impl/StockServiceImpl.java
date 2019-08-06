package com.cl.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.StockMapper;
import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;
import com.cl.service.IStockService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("stockService")
public class StockServiceImpl implements IStockService {

	@Autowired
	private StockMapper stockMapper;
	
//	@Autowired
//	private IObjectTransformer<StockEntity, StockResBean> transFormer;
	
	@Override
	public PageInfo<StockResBean> queryStockList(RequestBeanModel<StockReqBean> reqBeanModel) {
		StockReqBean stockReqBean = reqBeanModel.getReqData();
        if(stockReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || stockReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //分页查询
        StockEntityExample example = new StockEntityExample();
        StockEntityExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(stockReqBean.getSku())) {
        	criteria.andSkuEqualTo(stockReqBean.getSku());
        }
        List<StockEntity> stockList = stockMapper.selectByExample(example);
        Page<StockEntity> page = PageHelper.startPage(stockReqBean.getPageNum() , stockReqBean.getPageSize() , "last_update_time DESC");
        PageInfo<StockEntity> stockEntityPageInfo = new PageInfo<StockEntity>(page);
        stockEntityPageInfo.setList(stockList);
        return null;
        //entity转resBean
//        PageInfo<StockResBean> stockResBeanPageInfo = transFormer.transform(stockEntityPageInfo);
//        return stockResBeanPageInfo;
	}

}

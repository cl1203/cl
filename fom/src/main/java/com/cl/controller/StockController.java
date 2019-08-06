package com.cl.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.bean.req.StockReqBean;
import com.cl.bean.res.StockResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IStockService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/stock")
@CrossOrigin
@Api(description = "库存管理")
public class StockController {
	 
    @Resource
    private IStockService stockService;
    
    @PostMapping("/queryOrderList")
    @ApiOperation(value = "查询库存列表" , notes = "根据条件查询库存列表")
    public ResponseBeanModel<PageInfo<StockResBean>> queryStockList(@RequestBody RequestBeanModel<StockReqBean> reqBeanModel){
    	PageInfo<StockResBean> resBean = stockService.queryStockList(reqBeanModel);
    	return new ResponseBeanModel<>(resBean);
    }
    
}

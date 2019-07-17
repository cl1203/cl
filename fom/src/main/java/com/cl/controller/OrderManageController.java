package com.cl.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IOrderManageService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Api(description = "订单管理接口")
public class OrderManageController {
	 
	/**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private IOrderManageService orderManageService;
    
    /**
     * 查询订单列表
     * @param reqBeanModel
     * @return
     */
    @PostMapping("/queryOrderList")
    @ApiOperation(value = "查询订单列表" , notes = "根据条件查询订单列表")
    public ResponseBeanModel<PageInfo<OrderManageResBean>> queryOrderList(@RequestBody RequestBeanModel<OrderManageReqBean> reqBeanModel){
    	LOGGER.info("OrderManageController------queryOrderList  start......" );
    	PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageService.queryOrderList(reqBeanModel);
    	LOGGER.info("OrderManageController------queryOrderList  end......" );
    	return new ResponseBeanModel<>(orderManageResBeanPageInfo);
    }
    
    /**
     * 分单
     * @param reqBeanModel
     * @return
     */
    @PostMapping("/distributionOrder")
    @ApiOperation(value = "分单接口" , notes = "根据订单ID的list和组织ID绑定 进行分单")
    public ResponseBeanModel<Void> distributionOrder(@RequestBody @Valid RequestBeanModel<DistributionOrderReqBean> reqBeanModel){
    	LOGGER.info("OrderManageController------distributionOrder  start......" );
    	this.orderManageService.distributionOrder(reqBeanModel);
    	LOGGER.info("OrderManageController------distributionOrder  end......" );
    	return new ResponseBeanModel<>("分单成功");
    }
}

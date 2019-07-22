package com.cl.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.cl.comm.model.SingleParam;
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
@Api(description = "订单管理接口文档")
public class OrderManageController {
	 
	/**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManageController.class);

    @Resource
    private IOrderManageService orderManageService;
    
    /**
     * @Author 陈龙
     * @Description 查询订单列表
     * @Date 20:14 2019/7/20
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.OrderManageResBean>>
     **/
    @PostMapping("/queryOrderList")
    @ApiOperation(value = "查询订单列表" , notes = "根据条件查询订单列表")
    public ResponseBeanModel<PageInfo<OrderManageResBean>> queryOrderList(@RequestBody @Valid RequestBeanModel<OrderManageReqBean> reqBeanModel){
    	LOGGER.info("OrderManageController------queryOrderList  start......" );
    	PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageService.queryOrderList(reqBeanModel);
    	LOGGER.info("OrderManageController------queryOrderList  end......" );
    	return new ResponseBeanModel<>(orderManageResBeanPageInfo);
    }
    
    /**
     * @Author 陈龙
     * @Description 分单接口
     * @Date 20:13 2019/7/20
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/distributionOrder")
    @ApiOperation(value = "分单接口" , notes = "根据订单ID的list和组织ID绑定 进行分单")
    public ResponseBeanModel<Void> distributionOrder(@RequestBody @Valid RequestBeanModel<DistributionOrderReqBean> reqBeanModel){
    	LOGGER.info("OrderManageController------distributionOrder  start......" );
    	this.orderManageService.distributionOrder(reqBeanModel);
    	LOGGER.info("OrderManageController------distributionOrder  end......" );
    	return new ResponseBeanModel<>("分单成功");
    }

    /**
     * @Author 陈龙
     * @Description 根据ID获取上一次生产方
     * @Date 20:15 2019/7/20
     * @Param [id]
     * @return java.lang.String
     **/
    @PostMapping("/queryProducer")
    @ApiOperation(value = "根据ID查询上一次生产方" , notes = "根据ID查询上一次生产方")
    public ResponseBeanModel<SingleParam> queryProducer(@RequestBody RequestBeanModel<SingleParam> reqBeanModel){
        LOGGER.info("OrderManageController------queryProducer  start......" );
        SingleParam singleParam = new SingleParam();
        String producer = this.orderManageService.queryProducer(reqBeanModel);
        singleParam.setParam(producer);
        LOGGER.info("OrderManageController------queryProducer  end......" );
        return new ResponseBeanModel<>(singleParam);
    }
}

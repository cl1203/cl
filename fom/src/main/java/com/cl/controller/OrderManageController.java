package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.req.OrderManageInsertReqBean;
import com.cl.bean.req.OrderManageReqBean;
import com.cl.bean.res.OrderManageResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.IOrderManageService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@CrossOrigin
@Api(description = "订单管理接口文档")
public class OrderManageController {
	 

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
    @LoggerManage(description = "查询订单列表")
    public ResponseBeanModel<PageInfo<OrderManageResBean>> queryOrderList(@RequestBody @Valid RequestBeanModel<OrderManageReqBean> reqBeanModel){
    	PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageService.queryOrderList(reqBeanModel);
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
    @LoggerManage(description = "分单接口")
    public ResponseBeanModel<Void> distributionOrder(@RequestBody @Valid RequestBeanModel<DistributionOrderReqBean> reqBeanModel){
    	this.orderManageService.distributionOrder(reqBeanModel);
    	return new ResponseBeanModel<>("分单成功!");
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
    @LoggerManage(description = "根据ID查询上一次生产方")
    public ResponseBeanModel<SingleParam> queryProducer(@RequestBody RequestBeanModel<SingleParam> reqBeanModel){
        SingleParam singleParam = new SingleParam();
        String producer = this.orderManageService.queryProducer(reqBeanModel);
        singleParam.setParam(producer);
        return new ResponseBeanModel<>(singleParam);
    }

    /**
     * 新增订单
     * @param reqBeanModel
     * @return
     */
    @PostMapping("/insertOrder")
    @ApiOperation(value = "新增订单" , notes = "新增订单")
    @LoggerManage(description = "新增订单")
    public ResponseBeanModel<Void> insertOrder(@RequestBody @Valid RequestBeanModel<OrderManageInsertReqBean> reqBeanModel){
        this.orderManageService.insertOrder(reqBeanModel);
        return new ResponseBeanModel<>("新增订单成功!");
    }
}

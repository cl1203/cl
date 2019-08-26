package com.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.AbnormalReqBean;
import com.cl.bean.req.DashBoardReqBean;
import com.cl.bean.res.AbnormalResBean;
import com.cl.bean.res.DashBoardResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IDashBoardService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
@Api(description = "看板管理")
public class DashBoardController {
	 
    @Autowired
    private IDashBoardService dashBoardService;
    
    @PostMapping("/queryForecastInfo")
    @ApiOperation(value = "预报看板" , notes = "根据条件查询预报看板")
    @LoggerManage(description = "预报看板")
    public ResponseBeanModel<PageInfo<DashBoardResBean>> queryForecastInfo(@RequestBody RequestBeanModel<DashBoardReqBean> reqBeanModel) throws Exception{
    	PageInfo<DashBoardResBean> resBean = dashBoardService.queryForecastInfo(reqBeanModel);
    	return new ResponseBeanModel<>(resBean);
    }
    
    @PostMapping("/updateOrderRemark")
    @ApiOperation(value = "修改订单备注" , notes = "修改订单备注")
    @LoggerManage(description = "修改订单备注")
    public ResponseBeanModel<Void> updateOrderRemark(@RequestBody RequestBeanModel<DashBoardReqBean> reqBeanModel){
    	dashBoardService.updateOrderRemark(reqBeanModel);
    	return new ResponseBeanModel<>("修改成功");
    }
    
    @PostMapping("/queryAbnormalList")
    @ApiOperation(value = "预报看板" , notes = "根据条件查询预报看板")
    @LoggerManage(description = "预报看板")
    public ResponseBeanModel<PageInfo<AbnormalResBean>> queryAbnormalList(@RequestBody RequestBeanModel<AbnormalReqBean> reqBeanModel) throws Exception{
    	PageInfo<AbnormalResBean> resBean = dashBoardService.queryAbnormalList(reqBeanModel);
    	return new ResponseBeanModel<>(resBean);
    }
}

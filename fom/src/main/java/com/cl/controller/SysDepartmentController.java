package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.SysDepartmentReqBean;
import com.cl.bean.res.SysDepartmentResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.ISysDepartmentService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@Api(description = "部门管理接口文档")
@RequestMapping("/department")
public class SysDepartmentController {

    @Resource
    private ISysDepartmentService sysDepartmentService;

    @PostMapping("/querySysDepartmentList")
    @ApiOperation(value = "查询部门数据列表" , notes = "查询部门数据列表")
    @LoggerManage(description = "查询部门数据列表")
    public ResponseBeanModel<PageInfo<SysDepartmentResBean>> querySysDepartmentList(@RequestBody @Valid RequestBeanModel<SysDepartmentReqBean> reqBeanModel){
        PageInfo<SysDepartmentResBean> sysDepartmentResBeanPageInfo = this.sysDepartmentService.querySysDepartmentList(reqBeanModel);
        return new ResponseBeanModel<>(sysDepartmentResBeanPageInfo);
    }

    @PostMapping("/insertSysDepartment")
    @ApiOperation(value = "新增部门数据列表" , notes = "新增部门数据列表")
    @LoggerManage(description = "新增部门数据列表")
    public ResponseBeanModel<Void> insertSysDepartment(@RequestBody RequestBeanModel<SysDepartmentReqBean> reqBeanModel){
        this.sysDepartmentService.insertSysDepartment(reqBeanModel);
        return new ResponseBeanModel<>("新增部门成功!");
    }

    @PostMapping("/updateSysDepartment")
    @ApiOperation(value = "修改部门数据列表" , notes = "修改部门数据列表")
    @LoggerManage(description = "修改部门数据列表")
    public ResponseBeanModel<Void> updateSysDepartment(@RequestBody RequestBeanModel<SysDepartmentReqBean> reqBeanModel){
        this.sysDepartmentService.updateSysDepartment(reqBeanModel);
        return new ResponseBeanModel<>("修改部门成功!");
    }

    @PostMapping("/deleteSysDepartment")
    @ApiOperation(value = "删除部门数据列表" , notes = "删除部门数据列表")
    @LoggerManage(description = "删除部门数据列表")
    public ResponseBeanModel<Void> deleteSysDepartment(@RequestBody RequestBeanModel<List<SingleParam>> reqBeanModel){
        this.sysDepartmentService.deleteSysDepartment(reqBeanModel);
        return new ResponseBeanModel<>("删除部门成功！");
    }
}

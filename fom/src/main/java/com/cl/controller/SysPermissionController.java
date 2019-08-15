package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.SysPermissionReqBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.ISysPermissionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysPermissionController
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 15:07
 * @Version 1.0
 **/
@RestController
@RequestMapping("/permission")
@CrossOrigin
@Api(value = "菜单管理接口文档")
public class SysPermissionController {

    @Resource
    private ISysPermissionService sysPermissionService;

    /**
     * @Author 陈龙
     * @Description 获取菜单列表
     * @Date 15:04 2019/8/14
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.SysPermissionResBean>
     **/
    @PostMapping("/querySysPermissionList")
    @ApiOperation(value = "查询菜单列表" , notes = "根据条件查询菜单列表")
    @LoggerManage(description = "查询菜单列表")
    public ResponseBeanModel<PageInfo<SysPermissionResBean>> querySysPermissionListc(@RequestBody RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        PageInfo<SysPermissionResBean> sysPermissionResBeanPageInfo = this.sysPermissionService.querySysPermissionList(reqBeanModel);
        return new ResponseBeanModel<>(sysPermissionResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 新增菜单
     * @Date 15:05 2019/8/14
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/insertSysPermission")
    @ApiOperation(value = "新增菜单数据" , notes = "新增菜单数据")
    @LoggerManage(description = "新增菜单数据")
    public ResponseBeanModel<Void> insertSysPermission(@RequestBody RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        this.sysPermissionService.insertSysPermission(reqBeanModel);
        return new ResponseBeanModel<>("新增菜单成功!");
    }

    /**
     * @Author 陈龙
     * @Description 修改菜单信息
     * @Date 15:05 2019/8/14
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/updateSysPermission")
    @ApiOperation(value = "修改菜单信息" , notes = "修改菜单信息")
    @LoggerManage(description = "修改菜单信息")
    public ResponseBeanModel<Void> updateSysPermission(@RequestBody RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        this.sysPermissionService.updateSysPermission(reqBeanModel);
        return new ResponseBeanModel<>("新增菜单成功!");
    }

    /**
     * @Author 陈龙
     * @Description 删除用户
     * @Date 20:37 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/deleteSysPermission")
    @ApiOperation(value = "删除菜单" , notes = "删除菜单")
    @LoggerManage(description = "删除菜单")
    public ResponseBeanModel<Void> deleteSysPermission(@RequestBody RequestBeanModel<List<SingleParam>> reqBeanModel){
        this.sysPermissionService.deleteSysPermission(reqBeanModel);
        return new ResponseBeanModel<>("删除用户成功!");
    }
}

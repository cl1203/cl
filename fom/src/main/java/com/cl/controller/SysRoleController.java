package com.cl.controller;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.ISysRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName SysRoleController
 * @Description 角色controller
 * @Author 陈龙
 * @Date 2019/8/6 20:12
 * @Version 1.0
 **/
@RestController
@RequestMapping("/role")
@CrossOrigin
@Api(description = "角色管理接口文档")
public class SysRoleController {

    @Resource
    private ISysRoleService iSysRoleService;

    /**
     * @Author 陈龙
     * @Description 查询角色列表
     * @Date 20:31 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.SysRoleResBean>>
     **/
    @PostMapping("/querySysRoleList")
    @ApiOperation(value = "查询角色列表" , notes = "根据条件查询角色列表")
    public ResponseBeanModel<PageInfo<SysRoleResBean>> querySysRoleList(@RequestBody @Valid RequestBeanModel<SysRoleReqBean> reqBeanModel){
        PageInfo<SysRoleResBean> sysRoleResBeanPageInfo = this.iSysRoleService.querySysRoleList(reqBeanModel);
        return new ResponseBeanModel<>(sysRoleResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 新增角色
     * @Date 20:37 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/insertSysRole")
    @ApiOperation(value = "新增角色" , notes = "根据条件新增角色列表")
    public ResponseBeanModel<Void> insertSysRole(@RequestBody RequestBeanModel<SysRoleReqBean> reqBeanModel){
        this.iSysRoleService.insertSysRole(reqBeanModel);
        return new ResponseBeanModel<>("新增角色成功!");
    }

    /**
     * @Author 陈龙
     * @Description 修改角色
     * @Date 20:37 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/updateSysRole")
    @ApiOperation(value = "修改角色" , notes = "根据条件修改角色")
    public ResponseBeanModel<Void> updateSysRole(@RequestBody RequestBeanModel<SysRoleReqBean> reqBeanModel){
        this.iSysRoleService.updateSysRole(reqBeanModel);
        return new ResponseBeanModel<>("修改角色成功!");
    }

    /**
     * @Author 陈龙
     * @Description 删除角色
     * @Date 20:37 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/deleteSysRole")
    @ApiOperation(value = "删除角色" , notes = "根据条件删除角色")
    public ResponseBeanModel<Void> deleteSysRole(@RequestBody RequestBeanModel<List<SingleParam>> reqBeanModel){
        this.iSysRoleService.deleteSysRole(reqBeanModel);
        return new ResponseBeanModel<>("删除角色成功!");
    }

}

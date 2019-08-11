package com.cl.controller;

import com.cl.bean.req.SysUserReqBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.ISysUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName SysUserController
 * @Description 权限--用户controller
 * @Author 陈龙
 * @Date 2019/8/11 18:45
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@Api(description = "用户管理接口文档")
@CrossOrigin
public class SysUserController {

    @Resource
    private ISysUserService sysUserService;

    /**
     * @Author 陈龙
     * @Description 查询用户列表
     * @Date 18:49 2019/8/11
     * @Param [reqBeanMode]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.SysUserResBean>>
     **/
    @PostMapping("/querySysUserList")
    @ApiOperation(value = "查询用户列表" , notes = "根据条件查询用户列表")
    public ResponseBeanModel<PageInfo<SysUserResBean>> querySysUserList(@RequestBody @Valid RequestBeanModel<SysUserReqBean> reqBeanModel){
        PageInfo<SysUserResBean> sysUserResBeanPageInfo = this.sysUserService.querySysUserList(reqBeanModel);
        return new ResponseBeanModel<>(sysUserResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 新增用户
     * @Date 18:49 2019/8/11
     * @Param [reqBeanMode]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.SysUserResBean>>
     **/
    @PostMapping("/insertSysUser")
    @ApiOperation(value = "新增用户" , notes = "根据条件新增用户")
    public ResponseBeanModel<Void> insertSysUser(@RequestBody RequestBeanModel<SysUserReqBean> reqBeanModel){
        this.sysUserService.insertSysUser(reqBeanModel);
        return new ResponseBeanModel<>("新增用户成功!");
    }

    /**
     * @Author 陈龙
     * @Description 修改用户
     * @Date 18:49 2019/8/11
     * @Param [reqBeanMode]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.SysUserResBean>>
     **/
    @PostMapping("/updateSysUser")
    @ApiOperation(value = "修改用户" , notes = "根据条件修改用户")
    public ResponseBeanModel<Void> updateSysUser(@RequestBody RequestBeanModel<SysUserReqBean> reqBeanModel){
        this.sysUserService.updateSysUser(reqBeanModel);
        return new ResponseBeanModel<>("修改用户成功!");
    }

    /**
     * @Author 陈龙
     * @Description 删除用户
     * @Date 20:37 2019/8/6
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.lang.Void>
     **/
    @PostMapping("/deleteSysUser")
    @ApiOperation(value = "删除用户" , notes = "根据删除用户")
    public ResponseBeanModel<Void> deleteSysUser(@RequestBody RequestBeanModel<List<SingleParam>> reqBeanModel){
        this.sysUserService.deleteSysUser(reqBeanModel);
        return new ResponseBeanModel<>("删除用户成功!");
    }
}

package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.ISysOrgService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName SysOrgController
 * @Description 权限--组织 控制层
 * @Author 陈龙
 * @Date 2019/7/31 17:20
 * @Version 1.0
 **/
@RestController
@RequestMapping("/org")
@CrossOrigin
@Api(description = "组织管理接口文档")
public class SysOrgController {


    @Resource
    private ISysOrgService iSysOrgService;

    /**
     * @Author 陈龙
     * @Description 新增权限组织
     * @Date 17:14 2019/7/31
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.SysOrgResBean>
     **/
    @PostMapping("/querySysOrgList")
    @ApiOperation(value = "查询组织列表" , notes = "根据条件查询组织列表")
    @LoggerManage(description = "查询组织列表")
    public ResponseBeanModel<PageInfo<SysOrgResBean>> querySysOrgList(@RequestBody @Valid RequestBeanModel<SysOrgReqBean> reqBeanModel){
        PageInfo<SysOrgResBean> sysOrgResBeanPageInfo = this.iSysOrgService.querySysOrgList(reqBeanModel);
        return new ResponseBeanModel<>(sysOrgResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 新增权限组织
     * @Date 17:10 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/insertSysOrg")
    @ApiOperation(value = "新增组织数据" , notes = "根据条件新增组织数据")
    @LoggerManage(description = "新增组织数据")
    public ResponseBeanModel<Void> insertSysOrg(@RequestBody RequestBeanModel<SysOrgReqBean> reqBeanModel){
        this.iSysOrgService.insertSysOrg(reqBeanModel);
        return new ResponseBeanModel<>("新增组织成功!");
    }

    /**
     * @Author 陈龙
     * @Description 删除权限组织
     * @Date 17:10 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/deleteSysOrg")
    @ApiOperation(value = "删除组织数据" , notes = "根据条件删除组织数据")
    @LoggerManage(description = "删除组织数据")
    public ResponseBeanModel<Void> deleteSysOrg(@RequestBody RequestBeanModel<List<SingleParam>> reqBeanModel){
        this.iSysOrgService.deleteSysOrg(reqBeanModel);
        return new ResponseBeanModel<>("删除组织成功!");
    }

    /**
     * @Author 陈龙
     * @Description 修改权限组织
     * @Date 17:10 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/updateSysOrg")
    @ApiOperation(value = "修改组织数据" , notes = "根据条件修改组织数据")
    @LoggerManage(description = "修改组织数据")
    public ResponseBeanModel<Void> updateSysOrg(@RequestBody RequestBeanModel<SysOrgReqBean> reqBeanModel){
        this.iSysOrgService.updateSysOrg(reqBeanModel);
        return new ResponseBeanModel<>("修改组织成功!");
    }
}

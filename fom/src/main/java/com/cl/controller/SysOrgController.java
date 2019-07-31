package com.cl.controller;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.ISysOrgService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Api(description = "组织接口文档")
public class SysOrgController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TailorController.class);

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
    @ApiOperation(value = "查询组织列表" , notes = "查询组织列表")
    public ResponseBeanModel<PageInfo<SysOrgResBean>> querySysOrgList(@RequestBody @Valid RequestBeanModel<SysOrgReqBean> reqBeanModel){
        LOGGER.info("SysOrgController------querySysOrgList  start......" );
        PageInfo<SysOrgResBean> sysOrgResBeanPageInfo = this.iSysOrgService.querySysOrgList(reqBeanModel);
        LOGGER.info("SysOrgController------querySysOrgList  end......" );
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
    @ApiOperation(value = "新增组织数据" , notes = "新增组织数据")
    public ResponseBeanModel<Void> insertSysOrg(@RequestBody RequestBeanModel<SysOrgReqBean> reqBeanModel){
        LOGGER.info("SysOrgController------insertSysOrg  start......" );
        this.iSysOrgService.insertSysOrg(reqBeanModel);
        LOGGER.info("SysOrgController------insertSysOrg  end......" );
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
    @ApiOperation(value = "删除组织数据" , notes = "删除组织数据")
    public ResponseBeanModel<Void> deleteSysOrg(@RequestBody RequestBeanModel<List<Long>> reqBeanModel){
        LOGGER.info("SysOrgController------insertSysOrg  start......" );
        this.iSysOrgService.deleteSysOrg(reqBeanModel);
        LOGGER.info("SysOrgController------insertSysOrg  end......" );
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
    @ApiOperation(value = "修改组织数据" , notes = "修改组织数据")
    public ResponseBeanModel<Void> updateSysOrg(@RequestBody RequestBeanModel<SysOrgReqBean> reqBeanModel){
        LOGGER.info("SysOrgController------insertSysOrg  start......" );
        this.iSysOrgService.updateSysOrg(reqBeanModel);
        LOGGER.info("SysOrgController------insertSysOrg  end......" );
        return new ResponseBeanModel<>("修改组织成功!");
    }
}

package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.PulldownMenuReqBean;
import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.service.IPulldownMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PulldownMenuController
 * @Description 所有下拉菜单controller
 * @Author 陈龙
 * @Date 2019/7/20 18:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pulldown")
@CrossOrigin
@Api(description = "所有下拉菜单接口文档")
public class PulldownMenuController {

    @Resource
    private IPulldownMenuService pulldownMenuService;

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单 或者根据条件查询
     * @Date 20:13 2019/7/20
     * @Param []
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryOrgPulldownMenu")
    @ApiOperation(value = "查询组织下拉菜单,或者根据条件查询" , notes = "查询所有组织下拉菜单,或者根据条件查询")
    @LoggerManage(description = "查询组织下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryOrgPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryOrgPulldownMenu(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取菜单权限下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryPermissionPulldownMenu")
    @ApiOperation(value = "获取菜单权限下拉菜单,或者根据条件查询" , notes = "获取菜单权限下拉菜单,或者根据条件查询")
    @LoggerManage(description = "获取菜单权限下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryPermissionPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryPermissionPulldownMenu(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取菜单权限下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryDepartmentPulldownMenu")
    @ApiOperation(value = "获取部门下拉菜单,或者根据条件查询" , notes = "获取部门下拉菜单,或者根据条件查询")
    @LoggerManage(description = "获取部门下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryDepartmentPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryDepartmentPulldownMenu(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取菜单权限下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryDepartmentPulldownMenuByGrade")
    @ApiOperation(value = "根据等级获取部门下拉菜单" , notes = "根据等级获取部门下拉菜单")
    @LoggerManage(description = "根据等级获取部门下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryDepartmentPulldownMenuByGrade(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryDepartmentPulldownMenuByGrade(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取角色下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryRolePulldownMenu")
    @ApiOperation(value = "获取角色下拉菜单,或者根据条件查询" , notes = "获取角色下拉菜单,或者根据条件查询")
    @LoggerManage(description = "获取角色下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryRolePulldownMenu(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryRolePulldownMenu(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取用户下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryUserPulldownMenu")
    @ApiOperation(value = "查询用户下拉菜单,或者根据条件查询" , notes = "查询用户下拉菜单,或者根据条件查询")
    @LoggerManage(description = "查询用户下拉菜单")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryUserPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuReqBean> requestBeanModel){
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryUserPulldownMenu(requestBeanModel);
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 查询供应商名称下拉菜单
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.utils.List<java.lang.String>
     **/
    @PostMapping("/queryInputSupplierName")
    @ApiOperation(value = "查询供应商名称下拉菜单" , notes = "查询供应商名称下拉菜单")
    @LoggerManage(description = "查询供应商名称下拉菜单")
    public ResponseBeanModel<List<SingleParam>> queryInputSupplierName(@RequestBody RequestBeanModel<SingleParam> requestBeanModel){
        List<SingleParam> orderNumList = this.pulldownMenuService.queryInputSupplierName(requestBeanModel);
        return new ResponseBeanModel<>(orderNumList);
    }


    /**
     * @Author 陈龙
     * @Description 查询字典表数据
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.utils.List<java.lang.String>
     **/
    @PostMapping("/queryDictItemList")
    @ApiOperation(value = "查询字典表数据(订单状态:order_status, 采购状态:purchase_status , 裁剪状态:tailoring_status , 物料分类:materiel_type)" , notes = "查询字典表数据")
    @LoggerManage(description = "查询字典表数据")
    public ResponseBeanModel<List<DictItem>> queryDictItemList(@RequestBody  RequestBeanModel<DictItem> requestBeanModel){
        List<DictItem> dictItemList = this.pulldownMenuService.queryDictItemList(requestBeanModel);
        return new ResponseBeanModel<>(dictItemList);
    }

    /**
     * @Author 陈龙
     * @Description 查询所有菜单包括对应的所有子菜单
     * @Date 18:26 2019/8/19
     * @Param []
     * @return com.cl.comm.model.ResponseBeanModel<java.utils.List<com.cl.bean.res.SysPermissionResBean>>
     **/
    @PostMapping("/queryPermissionAll")
    @ApiOperation(value = "查询所有菜单包括对应的所有子菜单" , notes = "查询所有菜单包括对应的所有子菜单")
    @LoggerManage(description = "查询所有菜单包括对应的所有子菜单")
    public ResponseBeanModel<List<SysPermissionResBean>> queryPermissionAll(@RequestBody RequestBeanModel<SingleParam> requestBeanModel){
        List<SysPermissionResBean> sysPermissionResBeanList = this.pulldownMenuService.queryPermissionAll(requestBeanModel);
        return new ResponseBeanModel<>(sysPermissionResBeanList);
    }
}

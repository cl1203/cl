package com.cl.service;

import com.cl.bean.req.SysPermissionReqBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName ISysPermissionService
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 15:02
 * @Version 1.0
 **/
public interface ISysPermissionService {

    /**
     * @Author 陈龙
     * @Description 获取菜单列表
     * @Date 15:04 2019/8/14
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.SysPermissionResBean>
     **/
    PageInfo<SysPermissionResBean> querySysPermissionList(RequestBeanModel<SysPermissionReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 新增菜单
     * @Date 15:05 2019/8/14
     * @Param [reqBeanModel]
     * @return void
     **/
    void insertSysPermission(RequestBeanModel<SysPermissionReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改菜单信息
     * @Date 15:06 2019/8/14
     * @Param [reqBeanModel]
     * @return void
     **/
    void updateSysPermission(RequestBeanModel<SysPermissionReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 删除菜单
     * @Date 15:06 2019/8/14
     * @Param [reqBeanModel]
     * @return void
     **/
    void deleteSysPermission(RequestBeanModel<List<SingleParam>> reqBeanModel);
}

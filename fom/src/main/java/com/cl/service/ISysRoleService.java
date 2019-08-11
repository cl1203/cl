package com.cl.service;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName ISysRoleService
 * @Description 权限--角色 service
 * @Author 陈龙
 * @Date 2019/8/6 19:44
 * @Version 1.0
 **/
public interface ISysRoleService {

    /**
     * @Author 陈龙
     * @Description 查询角色列表
     * @Date 19:48 2019/8/6
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.SysRoleResBean>
     **/
    PageInfo<SysRoleResBean> querySysRoleList(RequestBeanModel<SysRoleReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 新增角色
     * @Date 20:02 2019/8/6
     * @Param [reqBeanModel]
     * @return void
     **/
    void insertSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改角色
     * @Date 20:05 2019/8/6
     * @Param [reqBeanModel]
     * @return void
     **/
    void updateSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 删除角色
     * @Date 20:05 2019/8/6
     * @Param [reqBeanModel]
     * @return void
     **/
    void deleteSysRole(RequestBeanModel<List<SingleParam>> reqBeanModel);

}

package com.cl.service;


import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName ISysOrgService
 * @Description 权限--组织 service
 * @Author 陈龙
 * @Date 2019/7/31 17:06
 * @Version 1.0
 **/
public interface ISysOrgService {

    /**
     * @Author 陈龙
     * @Description 查询权限组织
     * @Date 17:14 2019/7/31
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.SysOrgResBean>
     **/
    PageInfo<SysOrgResBean> querySysOrgList(RequestBeanModel<SysOrgReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 新增权限组织
     * @Date 17:10 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    void insertSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 删除权限组织
     * @Date 17:11 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    void deleteSysOrg(RequestBeanModel<List<SingleParam>> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改权限组织
     * @Date 17:11 2019/7/31
     * @Param [reqBeanModel]
     * @return void
     **/
    void updateSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel);
}

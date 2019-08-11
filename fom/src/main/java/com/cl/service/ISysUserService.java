package com.cl.service;

import com.cl.bean.req.SysUserReqBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName ISysUserService
 * @Description 权限--用户service
 * @Author 陈龙
 * @Date 2019/8/11 18:38
 * @Version 1.0
 **/
public interface ISysUserService {

    /**
     * 查询用户列表
     * @param reqBeanModel
     * @return
     */
    PageInfo<SysUserResBean> querySysUserList(RequestBeanModel<SysUserReqBean> reqBeanModel);

    /**
     * 新增用户
     * @param reqBeanModel
     */
    void insertSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel);

    /**
     * 修改用户
     * @param reqBeanModel
     */
    void updateSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel);

    /**
     * 删除用户
     * @param reqBeanModel
     */
    void deleteSysUser(RequestBeanModel<List<SingleParam>> reqBeanModel);
}

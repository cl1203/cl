package com.cl.service.impl;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.service.ISysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName SysRoleServiceImpl
 * @Description 权限角色实现类
 * @Author 陈龙
 * @Date 2019/8/6 20:07
 * @Version 1.0
 **/
@Service
@Transactional
public class SysRoleServiceImpl implements ISysRoleService {
    @Override
    public PageInfo<SysRoleResBean> querySysRoleList(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        return null;
    }

    @Override
    public void insertSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {

    }

    @Override
    public void updateSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {

    }

    @Override
    public void deleteSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {

    }
}

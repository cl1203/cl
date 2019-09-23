package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName LoginResBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/16 14:46
 * @Version 1.0
 **/
public class LoginResBean implements Serializable{

    private static final long serialVersionUID = 5988040630360408496L;

    @ApiModelProperty(value = "用户对象 里面有角色List")
    private SysUserResBean sysUserResBean;

    @ApiModelProperty(value = "权限list")
    private List<SysPermissionResBean> sysPermissionResBeanList;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SysUserResBean getSysUserResBean() {
        return sysUserResBean;
    }

    public void setSysUserResBean(SysUserResBean sysUserResBean) {
        this.sysUserResBean = sysUserResBean;
    }

    public List<SysPermissionResBean> getSysPermissionResBeanList() {
        return sysPermissionResBeanList;
    }

    public void setSysPermissionResBeanList(List<SysPermissionResBean> sysPermissionResBeanList) {
        this.sysPermissionResBeanList = sysPermissionResBeanList;
    }
}

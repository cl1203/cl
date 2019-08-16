package com.cl.bean.res;

import java.io.Serializable;

/**
 * @ClassName LoginResBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/16 14:46
 * @Version 1.0
 **/
public class LoginResBean implements Serializable{

    private static final long serialVersionUID = 5988040630360408496L;

    private SysUserResBean sysUserResBean;

    public SysUserResBean getSysUserResBean() {
        return sysUserResBean;
    }

    public void setSysUserResBean(SysUserResBean sysUserResBean) {
        this.sysUserResBean = sysUserResBean;
    }
}

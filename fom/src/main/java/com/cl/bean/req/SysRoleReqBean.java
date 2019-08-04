package com.cl.bean.req;

import com.cl.entity.SysRoleEntity;

import java.io.Serializable;

/**
 * @ClassName SysRoleReqBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/3 13:26
 * @Version 1.0
 **/
public class SysRoleReqBean extends SysRoleEntity implements Serializable {

    private static final long serialVersionUID = 7562528986132781657L;

    private Integer PageNum;

    private Integer PageSize;


}

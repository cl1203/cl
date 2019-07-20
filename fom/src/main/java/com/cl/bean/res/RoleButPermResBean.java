package com.cl.bean.res;

import java.io.Serializable;

/**
 * @ClassName RoleButPermResBean
 * @Description 按钮权限resBean
 * @Author 陈龙
 * @Date 2019/7/20 12:02
 * @Version 1.0
 **/
public class RoleButPermResBean implements Serializable{

    private static final long serialVersionUID = -8361089874924912813L;

    /**
     * 权限id
     */
    private Long id;

    /**
     * 权限编码
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;
}

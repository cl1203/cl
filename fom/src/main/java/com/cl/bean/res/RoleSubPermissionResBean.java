package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RoleSubPermissionResBean
 * @Description 角色子菜单resBean
 * @Author 陈龙
 * @Date 2019/7/20 10:59
 * @Version 1.0
 **/
public class RoleSubPermissionResBean implements Serializable{

    private static final long serialVersionUID = 743749771817378460L;

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

    /**
     * 权限类型 0：未知 1：菜单 2：按钮 3：数据
     */
    private Byte permissionType;

    /**
     * 跳转目标页面
     */
    private String targetPage;

    /**
     * 按钮权限list
     */
    private List<RoleButPermResBean> roleButPermResBeanList;
}

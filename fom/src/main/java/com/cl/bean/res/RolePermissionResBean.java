package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName RolePermissionResBean
 * @Description 角色菜单权限resBean
 * @Author 陈龙
 * @Date 2019/7/20 10:53
 * @Version 1.0
 **/
public class RolePermissionResBean implements Serializable{

    private static final long serialVersionUID = 6296522665089757505L;

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
     * 权限图标样式
     */
    private String permissionClass;

    /**
     * 父ID
     */
    private Long parentId;

    /**
     * 跳转目标页面
     */
    private String targetPage;

    /**
     *  子菜单list
     */
    private List<RoleSubPermissionResBean> roleSubPermissionResBeanList;
}

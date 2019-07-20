package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserRoleResBean
 * @Description 用户角色resBean
 * @Author 陈龙
 * @Date 2019/7/20 10:48
 * @Version 1.0
 **/
public class UserRoleResBean implements Serializable {

    private static final long serialVersionUID = 5813520931310114875L;

    /**
     * 角色id
     */
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色菜单权限list
      */
    private List<RolePermissionResBean> rolePermissionResBeanList;

}

package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName LoginResBean
 * @Description 登录resBean
 * @Author 陈龙
 * @Date 2019/7/20 10:40
 * @Version 1.0
 **/
public class LoginResBean implements Serializable {

    private static final long serialVersionUID = 5988040630360408496L;

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 跳转URL
     */
    private String url;

    /**
     * 用户角色list
     */
    private List<UserRoleResBean> userRoleResBeanList;
}

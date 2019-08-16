package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName LoginReqBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/16 14:46
 * @Version 1.0
 **/
public class LoginReqBean implements Serializable{

    private static final long serialVersionUID = 2656091810695021437L;

    @NotBlank(message = "用户名不能为空!")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotBlank(message = "密码不能为空!")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "新密码")
    private String newPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}

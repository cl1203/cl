package com.cl.comm.model;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * @ClassName RequestBeanModel
 * @Description 标准请求体
 * @Author 陈龙
 * @Date 2019/6/26 10:45
 * @Version 1.0
 **/
public class RequestBeanModel<T> implements Serializable {

    private static final long serialVersionUID = 3391700099430900035L;

    private String token;

    private String userId;

    private String username;

    private String sign;

    private String time;

    @Valid
    private T reqData;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        if (null != this.userId) {
            return userId;
        }
        if (null == this.token || 0 == this.token.length() || !this.token.contains("_")) {
            this.token = "111_xxxxx";
        }
        String[] tokenInfo = this.token.split("_");
        if (tokenInfo.length != 2) {
            return null;
        }
        this.userId = tokenInfo[0];
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public T getReqData() {
        return reqData;
    }

    public void setReqData(T reqData) {
        this.reqData = reqData;
    }
}

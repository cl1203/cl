package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysUserResBean
 * @Description 用户resbean
 * @Author 陈龙
 * @Date 2019/8/10 10:54
 * @Version 1.0
 **/
public class SysUserResBean implements Serializable{

    private static final long serialVersionUID = -2163029023109001108L;

    /**
     * 主键，自增长
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 组织ID
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;

    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String orgName;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String mobile;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    @ApiModelProperty(value = "最后修改人")
    private String lastUpdateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }
}

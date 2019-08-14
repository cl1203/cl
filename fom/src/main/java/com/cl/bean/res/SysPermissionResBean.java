package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysPermissionResBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/10 23:18
 * @Version 1.0
 **/
public class SysPermissionResBean implements Serializable{

    private static final long serialVersionUID = 4525840830629877837L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "")
    private Long id;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String name;

    /**
     * 权限类型 0：未知 1：菜单 2：按钮 3：数据
     */
    @ApiModelProperty(value = "")
    private Byte permissionType;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "")
    private Long parentId;

    /**
     * 权限url（备用）
     */
    @ApiModelProperty(value = "")
    private String url;

    /**
     * 排列序号
     */
    @ApiModelProperty(value = "")
    private Byte sortNo;

    /**
     * 跳转目标页面
     */
    @ApiModelProperty(value = "")
    private String targetPage;

    /**
     * 备注
     */
    @ApiModelProperty(value = "")
    private String remarks;


    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "")
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    @ApiModelProperty(value = "")
    private String lastUpdateUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Byte permissionType) {
        this.permissionType = permissionType;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Byte getSortNo() {
        return sortNo;
    }

    public void setSortNo(Byte sortNo) {
        this.sortNo = sortNo;
    }

    public String getTargetPage() {
        return targetPage;
    }

    public void setTargetPage(String targetPage) {
        this.targetPage = targetPage;
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

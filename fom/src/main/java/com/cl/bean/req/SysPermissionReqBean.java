package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName SysPermissionReqBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 11:20
 * @Version 1.0
 **/
public class SysPermissionReqBean implements Serializable {

    private static final long serialVersionUID = 3318642110026901958L;

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
    @ApiModelProperty(value = "权限类型 0：未知 1：菜单 2：按钮 3：数据")
    private Byte permissionType;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 排列序号
     */
    @ApiModelProperty(value = "排列序号")
    private Byte sortNo;

    /**
     * 跳转目标页面
     */
    @ApiModelProperty(value = "跳转目标页面")
    private String targetPage;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 每页数量
     */
    @NotNull(message = "每页查询数量大小不能为空!")
    private Integer pageSize;

    /**
     * 页码
     */
    @NotNull(message = "页码大小不能为空!")
    private Integer pageNum;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

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
}

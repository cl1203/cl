package com.cl.bean.req;

import com.cl.entity.SysRoleEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName SysRoleReqBean
 * @Description 权限--角色 reqBean
 * @Author 陈龙
 * @Date 2019/8/3 13:26
 * @Version 1.0
 **/
public class SysRoleReqBean implements Serializable {

    private static final long serialVersionUID = 7562528986132781657L;

    /**
     * 角色ID
     */
    @ApiModelProperty(value = "角色ID")
    private Long id;

    /**
     * 角色名
     */
    @ApiModelProperty(value = "角色名")
    private String name;

    /**
     * 组织ID
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;

    /**
     * 父ID
     */
    @ApiModelProperty(value = "父ID")
    private Long parentId;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remark;

    /**
     * 菜单权限id
     */
    @ApiModelProperty(value = "菜单权限id")
    private List<Long> permissionIdList;
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

    public List<Long> getPermissionIdList() {
        return permissionIdList;
    }

    public void setPermissionIdList(List<Long> permissionIdList) {
        this.permissionIdList = permissionIdList;
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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

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
}

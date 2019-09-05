package com.cl.bean.res;

import com.cl.entity.SysPermissionEntity;
import com.cl.entity.SysRoleEntity;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysRoleResBean
 * @Description 角色resBean
 * @Author 陈龙
 * @Date 2019/8/3 13:20
 * @Version 1.0
 **/
public class SysRoleResBean implements Serializable{

    private static final long serialVersionUID = 7200408200970628328L;

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
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remark;

    /**
     * 最后修改人
     */
    @ApiModelProperty(value = "最后修改人")
    private String lastUpdateUser;

    /**
     * 最后修改时间
     */
    @ApiModelProperty(value = "最后修改时间")
    private Date lastUpdateTime;

    /**
     * 此角色绑定的所有用户
     */
    @ApiModelProperty(value = "此角色绑定的所有用户")
    private List<SysUserResBean> userList;

    /**
     * 此角色绑定的所有菜单权限
     */
    @ApiModelProperty(value = "此角色绑定的所有菜单权限")
    private List<SysPermissionResBean> permissionList;

    public List<SysPermissionResBean> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermissionResBean> permissionList) {
        this.permissionList = permissionList;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public List<SysUserResBean> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUserResBean> userList) {
        this.userList = userList;
    }
}
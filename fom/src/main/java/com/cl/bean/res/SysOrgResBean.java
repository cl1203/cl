package com.cl.bean.res;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysOrgResBean
 * @Description 权限--组织 resBean
 * @Author 陈龙
 * @Date 2019/7/31 16:49
 * @Version 1.0
 **/
public class SysOrgResBean implements Serializable{

    private static final long serialVersionUID = -4733766501068436675L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 组织名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    private String lastUpdateUser;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

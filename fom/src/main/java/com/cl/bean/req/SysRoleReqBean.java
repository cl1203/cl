package com.cl.bean.req;

import com.cl.entity.SysRoleEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName SysRoleReqBean
 * @Description 权限--角色 reqBean
 * @Author 陈龙
 * @Date 2019/8/3 13:26
 * @Version 1.0
 **/
public class SysRoleReqBean extends SysRoleEntity implements Serializable {

    private static final long serialVersionUID = 7562528986132781657L;

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
}

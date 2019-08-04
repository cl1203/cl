package com.cl.bean.req;

import com.cl.entity.SysOrgEntity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName SysOrgReqBean
 * @Description 权限--组织 reqBean
 * @Author 陈龙
 * @Date 2019/7/31 16:57
 * @Version 1.0
 **/
public class SysOrgReqBean  implements Serializable {

    private static final long serialVersionUID = -5007817614951638577L;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}

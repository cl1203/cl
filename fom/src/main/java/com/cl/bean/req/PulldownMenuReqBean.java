package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName PulldownMenuReqBean
 * @Description 下拉菜单reqBean
 * @Author 陈龙
 * @Date 2019/7/20 18:56
 * @Version 1.0
 **/
public class PulldownMenuReqBean implements Serializable{

    private static final long serialVersionUID = 1893533479485531945L;

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 真实名称
     */
    @ApiModelProperty(value = "真实名称")
    private String realName;

    /**
     * 组织id
     */
    @ApiModelProperty(value = "组织id")
    private Long orgId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}

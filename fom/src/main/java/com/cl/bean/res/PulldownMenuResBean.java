package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @ClassName PulldownMenuResBean
 * @Description 下拉菜单resBean
 * @Author 陈龙
 * @Date 2019/7/20 18:56
 * @Version 1.0
 **/
public class PulldownMenuResBean implements Serializable{

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
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
}

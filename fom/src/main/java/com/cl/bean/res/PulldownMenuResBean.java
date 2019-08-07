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
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

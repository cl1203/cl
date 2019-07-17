package com.cl.comm.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;


import io.swagger.annotations.ApiModelProperty;

/**
 * 单参数请求
 * @author xujun
 *
 */
public class SingleParam implements Serializable {

	private static final long serialVersionUID = -3204559071039754063L;
	
	@ApiModelProperty(value = "参数,含义跟具体业务相关", required = true)
    @NotNull(message = "参数不能为空")
    private String param;

    public SingleParam() {
    }

    public SingleParam(String param) {
        this.param = param;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

}

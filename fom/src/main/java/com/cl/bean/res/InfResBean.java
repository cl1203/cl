package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

public class InfResBean implements Serializable {

	private static final long serialVersionUID = 7578846924840806529L;

	private Integer code;
	
	private List<OrderResBean> info;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public List<OrderResBean> getInfo() {
		return info;
	}

	public void setInfo(List<OrderResBean> info) {
		this.info = info;
	}
	
}

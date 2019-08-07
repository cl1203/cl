package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StockReqBean implements Serializable {

	private static final long serialVersionUID = -2802523055119658649L;

	@ApiModelProperty(value = "sku")
	private String sku;
	
	/**
	 * 每页数量
	 */
	private Integer pageSize;

	/**
	 * 页码
	 */
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
}

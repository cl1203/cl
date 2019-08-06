package com.cl.bean.req;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class StockReqBean implements Serializable {

	private static final long serialVersionUID = -2802523055119658649L;

	private String sku;
	
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
}

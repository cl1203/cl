package com.cl.bean.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

public class StockReqBean implements Serializable {

	private static final long serialVersionUID = -2802523055119658649L;

	@ApiModelProperty(value = "orderNo")
	private String orderNo;
	
	@ApiModelProperty(value = "SKU")
	private String sku;
	
	@ApiModelProperty(value = "物料SKU")
	private String materialSku;
	
	@ApiModelProperty(value = "库存数")
	private Integer stock;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "每页条数")
	private Integer pageSize;

	@ApiModelProperty(value = "页数")
	private Integer pageNum;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMaterialSku() {
		return materialSku;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setMaterialSku(String materialSku) {
		this.materialSku = materialSku;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

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

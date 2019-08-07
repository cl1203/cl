package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StockResBean implements Serializable {

	private static final long serialVersionUID = 2474199723343891189L;

	private Long id;

    /**
     * SKU编号
     */
    @ApiModelProperty(value = "SKU编号")
    private String sku;

    /**
     * 采购单编码
     */
	@ApiModelProperty(value = "采购单编码")
    private String purchaseCode;

    /**
     * 库存数量
     */
	@ApiModelProperty(value = "库存数量")
    private Integer stock;

    /**
     * 状态 1:正常 0:删除
     */
	@ApiModelProperty(value = "状态 1:正常 0:删除")
    private Byte status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}

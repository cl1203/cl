package com.cl.bean.res;

import java.io.Serializable;

public class MaterialResBean implements Serializable {

	private static final long serialVersionUID = 6541433230121746427L;

    /**
     * 物料SKU
     */
    private String materielSku;

    /**
     * 库存数量
     */
    private Integer stock;
    
    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商编号
     */
    private String supplierCode;

    /**
     * 供应商色号
     */
    private String supplierColorNumber;
    
    /**
     * 物料项目
     */
    private String purchaseType;
    
    /**
     * 物料分类
     */
    private String materielType;

    /**
     * 物料名称
     */
    private String materielName;

    /**
     * 物料颜色
     */
    private String materielColor;

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public String getMaterielType() {
		return materielType;
	}

	public void setMaterielType(String materielType) {
		this.materielType = materielType;
	}

	public String getMaterielSku() {
		return materielSku;
	}

	public void setMaterielSku(String materielSku) {
		this.materielSku = materielSku;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierColorNumber() {
		return supplierColorNumber;
	}

	public void setSupplierColorNumber(String supplierColorNumber) {
		this.supplierColorNumber = supplierColorNumber;
	}

	public String getMaterielName() {
		return materielName;
	}

	public void setMaterielName(String materielName) {
		this.materielName = materielName;
	}

	public String getMaterielColor() {
		return materielColor;
	}

	public void setMaterielColor(String materielColor) {
		this.materielColor = materielColor;
	}
	
}

package com.cl.bean.res;

import java.io.Serializable;
import java.math.BigDecimal;

public class PurchaseBean implements Serializable {

	private static final long serialVersionUID = 2110979186417637700L;
	
	private String purchaseCode;                   //采购单号

	private String materialColor;                  //物料颜色
	
	private String materialName;                   //物料名称
	
	private String materialSku;                    //物料SKU
	
	private String materialType;                   //物料分类
	
	private BigDecimal price;                      //单价
	
	private BigDecimal simpleUse;                  //单件用量
	
	private BigDecimal singleAmountKg;             //单件用量，以公斤为单位
	
	private String supplierAddr;                   //供应商地址
	
	private String supplierCode;                   //供应商编号
	
	private String supplierColorNum;               //供应商色号
	
	private BigDecimal supplierLoss;               //供应商损耗
	
	private String supplierName;                   //供应商名称
	
	private String supplierPhone;                  //供应商电话
	
	private BigDecimal weight;                     //克重
	
	private BigDecimal width;                      //幅宽

	public String getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getMaterialColor() {
		return materialColor;
	}

	public void setMaterialColor(String materialColor) {
		this.materialColor = materialColor;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getMaterialSku() {
		return materialSku;
	}

	public void setMaterialSku(String materialSku) {
		this.materialSku = materialSku;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSimpleUse() {
		return simpleUse;
	}

	public void setSimpleUse(BigDecimal simpleUse) {
		this.simpleUse = simpleUse;
	}

	public BigDecimal getSingleAmountKg() {
		return singleAmountKg;
	}

	public void setSingleAmountKg(BigDecimal singleAmountKg) {
		this.singleAmountKg = singleAmountKg;
	}

	public String getSupplierAddr() {
		return supplierAddr;
	}

	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierColorNum() {
		return supplierColorNum;
	}

	public void setSupplierColorNum(String supplierColorNum) {
		this.supplierColorNum = supplierColorNum;
	}

	public BigDecimal getSupplierLoss() {
		return supplierLoss;
	}

	public void setSupplierLoss(BigDecimal supplierLoss) {
		this.supplierLoss = supplierLoss;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}
	
}

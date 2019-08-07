package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SecondProcessBean implements Serializable {

	private static final long serialVersionUID = 7469496620362606383L;

	@ApiModelProperty(value = "工艺名称")
	private String processName;                    //工艺名称
	@ApiModelProperty(value = "单件用量")
	private String simpleUse;                      //单件用量
	@ApiModelProperty(value = "供应商名称")
	private String supplierName;                   //供应商名称
	@ApiModelProperty(value = "单价")
	private BigDecimal unitPrice;                      //单价

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getSimpleUse() {
		return simpleUse;
	}

	public void setSimpleUse(String simpleUse) {
		this.simpleUse = simpleUse;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	
}

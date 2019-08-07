package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OrderQuantityBean implements Serializable {

	private static final long serialVersionUID = -7852771076701459629L;

	@ApiModelProperty(value = "订单件数")
	private int quantity;                    //订单件数
	@ApiModelProperty(value = "尺码")
	private String sizeName;                 //尺码

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	
}

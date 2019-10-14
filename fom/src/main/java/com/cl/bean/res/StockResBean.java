package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

public class StockResBean implements Serializable {

	private static final long serialVersionUID = 2474199723343891189L;

	private String orderNo;
	
    /**
     * SKU编号
     */
    private String sku;
    
    /**
     * 订单图片URL
     */
    private String orderImgUrl;

    /**
     * 物料集合
     */
    private List<MaterialResBean> materiaList;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<MaterialResBean> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<MaterialResBean> materiaList) {
		this.materiaList = materiaList;
	}

	public String getOrderImgUrl() {
		return orderImgUrl;
	}

	public void setOrderImgUrl(String orderImgUrl) {
		this.orderImgUrl = orderImgUrl;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

}

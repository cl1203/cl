package com.cl.bean.res;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单  resBean
 * @author xujun
 *
 */
public class OrderManageResBean implements Serializable {

	private static final long serialVersionUID = -7868156153209586150L;
	
	/**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    private Byte orderStatus;

    /**
     * 订单件数
     */
    private Integer orderQuantity;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 订单图片URL
     */
    private String orderImgUrl;

    /**
     * SKU
     */
    private String sku;

    /**
     * 生产方
     */
    private String producer;

    /**
     * 剩余时间
     */
    private String surplusTime;

    /**
     * 二次工艺
     */
    private String secondaryProcess;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getSurplusTime() {
		return surplusTime;
	}

	public void setSurplusTime(String surplusTime) {
		this.surplusTime = surplusTime;
	}

	public String getSecondaryProcess() {
		return secondaryProcess;
	}

	public void setSecondaryProcess(String secondaryProcess) {
		this.secondaryProcess = secondaryProcess;
	}
	
}

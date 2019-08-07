package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	@ApiModelProperty(value = "主键ID")
	private Long id;

	/**
	 * 订单编号
	 */
	@ApiModelProperty(value = "订单编号")
	private String orderNo;

	/**
	 * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
	 */
	@ApiModelProperty(value = "订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪")
	private Byte orderStatus;

	/**
	 * 订单状态名称
	 */
	@ApiModelProperty(value = "订单状态名称")
	private String orderStatusName;

	/**
	 * 订单件数
	 */
	@ApiModelProperty(value = "订单件数")
	private Integer orderQuantity;

	/**
	 * 下单时间
	 */
	@ApiModelProperty(value = "下单时间")
	private Date orderTime;

	/**
	 * 订单图片URL
	 */
	@ApiModelProperty(value = "订单图片URL")
	private String orderImgUrl;

	/**
	 * SKU
	 */
	@ApiModelProperty(value = "SKU")
	private String sku;

	/**
	 * 是否首单: 0 :不是 1:是
	 */
	@ApiModelProperty(value = "否首单: 0 :不是 1:是")
	private Byte isFirst;

	/**
	 * 指定生产方组织ID(不为空时以此生产方为准)
	 */
	@ApiModelProperty(value = "指定生产方组织ID(不为空时以此生产方为准)")
	private Long producerOrgId;

	/**
	 * 生产方
	 */
	@ApiModelProperty(value = "生产方")
	private String producer;

	/**
	 * 剩余时间
	 */
	@ApiModelProperty(value = "剩余时间")
	private String surplusTime;

    /**
     * 二次工艺
     */
	@ApiModelProperty(value = "二次工艺")
    private List<SecondaryProcessResBean> secondaryProcessResBeanList;

	@ApiModelProperty(value = "下单数量")
	private List<OrderQuantityResBean> orderQuantityResBeanList;

	public Long getId() {
		return id;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public Byte getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Byte isFirst) {
		this.isFirst = isFirst;
	}

	public Long getProducerOrgId() {
		return producerOrgId;
	}

	public void setProducerOrgId(Long producerOrgId) {
		this.producerOrgId = producerOrgId;
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

	public List<SecondaryProcessResBean> getSecondaryProcessResBeanList() {
		return secondaryProcessResBeanList;
	}

	public void setSecondaryProcessResBeanList(List<SecondaryProcessResBean> secondaryProcessResBeanList) {
		this.secondaryProcessResBeanList = secondaryProcessResBeanList;
	}

	public List<OrderQuantityResBean> getOrderQuantityResBeanList() {
		return orderQuantityResBeanList;
	}

	public void setOrderQuantityResBeanList(List<OrderQuantityResBean> orderQuantityResBeanList) {
		this.orderQuantityResBeanList = orderQuantityResBeanList;
	}
}

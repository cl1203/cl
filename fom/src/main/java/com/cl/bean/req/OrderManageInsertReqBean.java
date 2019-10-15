package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

public class OrderManageInsertReqBean implements Serializable {

    private static final long serialVersionUID = -3631052824465276050L;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    @NotBlank(message = "订单编号不能为空!")
    private String orderNo;

    /**
     * 订单件数
     */
    @ApiModelProperty(value = "订单件数")
    @NotBlank(message = "订单件数不能为空!")
    private String orderQuantity;

    /**
     * 订单类型
     */
    @ApiModelProperty(value = "订单类型")

    private String orderType;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    @NotBlank(message = "下单时间不能为空!")
    private String orderTime;

    /**
     * 订单图片URL
     */
    @ApiModelProperty(value = "订单图片URL")
    @NotBlank(message = "图片不能为空!")
    private String orderImgUrl;

    /**
     * SKU
     */
    @ApiModelProperty(value = "SKU")
    @NotBlank(message = "sku不能为空!")
    private String sku;

    /**
     * 是否首单: 0 :不是 1:是
     */
    @ApiModelProperty(value = "是否首单: 0 :不是 1:是")
    @NotBlank(message = "是否收单不能为空!")
    private String isFirst;

    /**
     * 生产方
     */
    @ApiModelProperty(value = "生产方")
    @NotBlank(message = "生产方不能为空!")
    private String producer;

    /**
     * 剩余时间
     */
    @ApiModelProperty(value = "剩余时间")
    @NotBlank(message = "剩余时间不能为空!")
    private String surplusTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 二次工艺
     */
    @ApiModelProperty(value = "二次工艺")
    private List<SecondaryProcessReqBean> secondaryProcessReqBeanList;

    @ApiModelProperty(value = "下单数量")
    private List<OrderQuantityReqBean> orderQuantityReqBeanList;

    @ApiModelProperty(value = "采购单")
    @NotEmpty(message = "至少存在一条采购单")
    @Valid
    private List<PurchaseInsertReqBean> purchaseInsertReqBeanList;

    public List<PurchaseInsertReqBean> getPurchaseInsertReqBeanList() {
        return purchaseInsertReqBeanList;
    }

    public void setPurchaseInsertReqBeanList(List<PurchaseInsertReqBean> purchaseInsertReqBeanList) {
        this.purchaseInsertReqBeanList = purchaseInsertReqBeanList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
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

    public String getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(String isFirst) {
        this.isFirst = isFirst;
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

    public List<SecondaryProcessReqBean> getSecondaryProcessReqBeanList() {
        return secondaryProcessReqBeanList;
    }

    public void setSecondaryProcessReqBeanList(List<SecondaryProcessReqBean> secondaryProcessReqBeanList) {
        this.secondaryProcessReqBeanList = secondaryProcessReqBeanList;
    }

    public List<OrderQuantityReqBean> getOrderQuantityReqBeanList() {
        return orderQuantityReqBeanList;
    }

    public void setOrderQuantityReqBeanList(List<OrderQuantityReqBean> orderQuantityReqBeanList) {
        this.orderQuantityReqBeanList = orderQuantityReqBeanList;
    }
}

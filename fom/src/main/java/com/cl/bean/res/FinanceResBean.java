package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinanceResBean implements Serializable {

    private static final long serialVersionUID = -2996082034146370844L;

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
     * 总件数 , 用户录入
     */
    @ApiModelProperty(value = "总件数 , 用户录入")
    private Integer quantityTotal;

    /**
     * 工序:平车价格
     */
    @ApiModelProperty(value = "平车单价")
    private BigDecimal flatcarPrice;

    /**
     * 工序: 冚车单价
     */
    @ApiModelProperty(value = "冚车单价")
    private BigDecimal cartPrice;

    /**
     * 工序:打边单价
     */
    @ApiModelProperty(value = "打边单价")
    private BigDecimal edgersPrice;

    /**
     * 工序:大烫单价
     */
    @ApiModelProperty(value = "大烫单价")
    private BigDecimal greatIroningPrice;

    /**
     * 工序:查货单价
     */
    @ApiModelProperty(value = "查货单价")
    private BigDecimal checkGoodsPrice;

    /**
     * 工序:剪线单价
     */
    @ApiModelProperty(value = "剪线单价")
    private BigDecimal trimmingPrice;

    /**
     * 工序:包装单价
     */
    @ApiModelProperty(value = "包装单价")
    private BigDecimal packagingPrice;

    /**
     * 返工单价
     */
    @ApiModelProperty(value = "返工单价")
    private BigDecimal reworkPrice;

    /**
     * 工序: 其他 单价
     */
    @ApiModelProperty(value = "其他 单价")
    private BigDecimal otherPrice;

    /**
     * 状态 0:已结算 1:未结算
     */
    @ApiModelProperty(value = "0:已结算 1:未结算")
    private Byte status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;
    /**
     * sku
     */
    @ApiModelProperty(value = "sku")
    private String sku;

    /**
     * 采购总价
     */
    @ApiModelProperty(value = "采购总价")
    private BigDecimal purchaseTotalPrice;

    /**
     * 采购总价
     */
    @ApiModelProperty(value = "裁剪总价")
    private BigDecimal tailorTotalPrice;

    /**
     * 工序总价
     */
    @ApiModelProperty(value = "工序总价")
    private BigDecimal workingTotalPrice;

    /**
     * 总价
     */
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;

    public BigDecimal getPurchaseTotalPrice() {
        return purchaseTotalPrice;
    }

    public void setPurchaseTotalPrice(BigDecimal purchaseTotalPrice) {
        this.purchaseTotalPrice = purchaseTotalPrice;
    }

    public BigDecimal getTailorTotalPrice() {
        return tailorTotalPrice;
    }

    public void setTailorTotalPrice(BigDecimal tailorTotalPrice) {
        this.tailorTotalPrice = tailorTotalPrice;
    }

    public BigDecimal getWorkingTotalPrice() {
        return workingTotalPrice;
    }

    public void setWorkingTotalPrice(BigDecimal workingTotalPrice) {
        this.workingTotalPrice = workingTotalPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getId() {
        return id;
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

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public BigDecimal getFlatcarPrice() {
        return flatcarPrice;
    }

    public void setFlatcarPrice(BigDecimal flatcarPrice) {
        this.flatcarPrice = flatcarPrice;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public BigDecimal getEdgersPrice() {
        return edgersPrice;
    }

    public void setEdgersPrice(BigDecimal edgersPrice) {
        this.edgersPrice = edgersPrice;
    }

    public BigDecimal getGreatIroningPrice() {
        return greatIroningPrice;
    }

    public void setGreatIroningPrice(BigDecimal greatIroningPrice) {
        this.greatIroningPrice = greatIroningPrice;
    }

    public BigDecimal getCheckGoodsPrice() {
        return checkGoodsPrice;
    }

    public void setCheckGoodsPrice(BigDecimal checkGoodsPrice) {
        this.checkGoodsPrice = checkGoodsPrice;
    }

    public BigDecimal getTrimmingPrice() {
        return trimmingPrice;
    }

    public void setTrimmingPrice(BigDecimal trimmingPrice) {
        this.trimmingPrice = trimmingPrice;
    }

    public BigDecimal getPackagingPrice() {
        return packagingPrice;
    }

    public void setPackagingPrice(BigDecimal packagingPrice) {
        this.packagingPrice = packagingPrice;
    }

    public BigDecimal getReworkPrice() {
        return reworkPrice;
    }

    public void setReworkPrice(BigDecimal reworkPrice) {
        this.reworkPrice = reworkPrice;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

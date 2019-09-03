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
    @ApiModelProperty(value = "平车价格")
    private BigDecimal flatcarPrice;

    /**
     * 工序: 平车员工
     */
    @ApiModelProperty(value = "平车员工")
    private String flatcarUser;

    /**
     * 工序: 冚车单价
     */
    @ApiModelProperty(value = "冚车单价")
    private BigDecimal cartPrice;

    /**
     * 工序:冚车员工
     */
    @ApiModelProperty(value = "冚车员工")
    private String cartUser;

    /**
     * 工序:打边单价
     */
    @ApiModelProperty(value = "打边单价")
    private BigDecimal edgersPrice;

    /**
     * 工序:打边员工
     */
    @ApiModelProperty(value = "打边员工")
    private String edgersUser;

    /**
     * 工序:大烫单价
     */
    @ApiModelProperty(value = "大烫单价")
    private BigDecimal greatIroningPrice;

    /**
     * 工序: 大烫员工
     */
    @ApiModelProperty(value = "大烫员工")
    private String greatIroningUser;

    /**
     * 工序:查货单价
     */
    @ApiModelProperty(value = "查货单价")
    private BigDecimal checkGoodsPrice;

    /**
     * 工序:查货员工
     */
    @ApiModelProperty(value = "查货员工")
    private String checkGoodsUser;

    /**
     * 工序:剪线单价
     */
    @ApiModelProperty(value = "剪线单价")
    private BigDecimal trimmingPrice;

    /**
     * 工序:剪线员工
     */
    @ApiModelProperty(value = "剪线员工")
    private String trimmingUser;

    /**
     * 工序:包装单价
     */
    @ApiModelProperty(value = "包装单价")
    private BigDecimal packagingPrice;

    /**
     * 工序:包装员工
     */
    @ApiModelProperty(value = "包装员工")
    private String packagingUser;

    /**
     * 返工单价
     */
    @ApiModelProperty(value = "返工单价")
    private BigDecimal reworkPrice;

    /**
     * 工序:返工员工
     */
    @ApiModelProperty(value = "返工员工")
    private String reworkUser;

    /**
     * 工序: 其他 单价
     */
    @ApiModelProperty(value = "其他 单价")
    private BigDecimal otherPrice;

    /**
     * 工序:其他 员工
     */
    @ApiModelProperty(value = "其他 员工")
    private String otherUser;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getFlatcarUser() {
        return flatcarUser;
    }

    public void setFlatcarUser(String flatcarUser) {
        this.flatcarUser = flatcarUser;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public String getCartUser() {
        return cartUser;
    }

    public void setCartUser(String cartUser) {
        this.cartUser = cartUser;
    }

    public BigDecimal getEdgersPrice() {
        return edgersPrice;
    }

    public void setEdgersPrice(BigDecimal edgersPrice) {
        this.edgersPrice = edgersPrice;
    }

    public String getEdgersUser() {
        return edgersUser;
    }

    public void setEdgersUser(String edgersUser) {
        this.edgersUser = edgersUser;
    }

    public BigDecimal getGreatIroningPrice() {
        return greatIroningPrice;
    }

    public void setGreatIroningPrice(BigDecimal greatIroningPrice) {
        this.greatIroningPrice = greatIroningPrice;
    }

    public String getGreatIroningUser() {
        return greatIroningUser;
    }

    public void setGreatIroningUser(String greatIroningUser) {
        this.greatIroningUser = greatIroningUser;
    }

    public BigDecimal getCheckGoodsPrice() {
        return checkGoodsPrice;
    }

    public void setCheckGoodsPrice(BigDecimal checkGoodsPrice) {
        this.checkGoodsPrice = checkGoodsPrice;
    }

    public String getCheckGoodsUser() {
        return checkGoodsUser;
    }

    public void setCheckGoodsUser(String checkGoodsUser) {
        this.checkGoodsUser = checkGoodsUser;
    }

    public BigDecimal getTrimmingPrice() {
        return trimmingPrice;
    }

    public void setTrimmingPrice(BigDecimal trimmingPrice) {
        this.trimmingPrice = trimmingPrice;
    }

    public String getTrimmingUser() {
        return trimmingUser;
    }

    public void setTrimmingUser(String trimmingUser) {
        this.trimmingUser = trimmingUser;
    }

    public BigDecimal getPackagingPrice() {
        return packagingPrice;
    }

    public void setPackagingPrice(BigDecimal packagingPrice) {
        this.packagingPrice = packagingPrice;
    }

    public String getPackagingUser() {
        return packagingUser;
    }

    public void setPackagingUser(String packagingUser) {
        this.packagingUser = packagingUser;
    }

    public BigDecimal getReworkPrice() {
        return reworkPrice;
    }

    public void setReworkPrice(BigDecimal reworkPrice) {
        this.reworkPrice = reworkPrice;
    }

    public String getReworkUser() {
        return reworkUser;
    }

    public void setReworkUser(String reworkUser) {
        this.reworkUser = reworkUser;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
    }
}

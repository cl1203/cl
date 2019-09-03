package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FinanceReqBean implements Serializable {

    private static final long serialVersionUID = 7420288340423331632L;

    /**
     * 状态 0:已结算 1:未结算
     */
    @ApiModelProperty(value = "状态 0:已结算 1:未结算")
    private Byte status;

    /**
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String orgName;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 每页数量
     */
    @NotNull(message = "每页查询数量大小不能为空!")
    private Integer pageSize;

    /**
     * 页码
     */
    @NotNull(message = "页码大小不能为空!")
    private Integer pageNum;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 总件数 , 用户录入
     */
    @ApiModelProperty(value = "总件数 , 用户录入")
    private String quantityTotal;

    /**
     * 工序:平车价格
     */
    @ApiModelProperty(value = "平车价格")
    private String flatcarPrice;

    /**
     * 工序: 平车员工
     */
    @ApiModelProperty(value = "平车员工")
    private String flatcarUser;

    /**
     * 工序: 冚车单价
     */
    @ApiModelProperty(value = "冚车单价")
    private String cartPrice;

    /**
     * 工序:冚车员工
     */
    @ApiModelProperty(value = "冚车员工")
    private String cartUser;

    /**
     * 工序:打边单价
     */
    @ApiModelProperty(value = "打边单价")
    private String edgersPrice;

    /**
     * 工序:打边员工
     */
    @ApiModelProperty(value = "打边员工")
    private String edgersUser;

    /**
     * 工序:大烫单价
     */
    @ApiModelProperty(value = "大烫单价")
    private String greatIroningPrice;

    /**
     * 工序: 大烫员工
     */
    @ApiModelProperty(value = "大烫员工")
    private String greatIroningUser;

    /**
     * 工序:查货单价
     */
    @ApiModelProperty(value = "查货单价")
    private String checkGoodsPrice;

    /**
     * 工序:查货员工
     */
    @ApiModelProperty(value = "查货员工")
    private String checkGoodsUser;

    /**
     * 工序:剪线单价
     */
    @ApiModelProperty(value = "剪线单价")
    private String trimmingPrice;

    /**
     * 工序:剪线员工
     */
    @ApiModelProperty(value = "剪线员工")
    private String trimmingUser;

    /**
     * 工序:包装单价
     */
    @ApiModelProperty(value = "包装单价")
    private String packagingPrice;

    /**
     * 工序:包装员工
     */
    @ApiModelProperty(value = "包装员工")
    private String packagingUser;

    /**
     * 返工单价
     */
    @ApiModelProperty(value = "返工单价")
    private String reworkPrice;

    /**
     * 工序:返工员工
     */
    @ApiModelProperty(value = "返工员工")
    private String reworkUser;

    /**
     * 工序: 其他 单价
     */
    @ApiModelProperty(value = "其他 单价")
    private String otherPrice;

    /**
     * 工序:其他 员工
     */
    @ApiModelProperty(value = "其他 员工")
    private String otherUser;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(String quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public String getFlatcarPrice() {
        return flatcarPrice;
    }

    public void setFlatcarPrice(String flatcarPrice) {
        this.flatcarPrice = flatcarPrice;
    }

    public String getFlatcarUser() {
        return flatcarUser;
    }

    public void setFlatcarUser(String flatcarUser) {
        this.flatcarUser = flatcarUser;
    }

    public String getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(String cartPrice) {
        this.cartPrice = cartPrice;
    }

    public String getCartUser() {
        return cartUser;
    }

    public void setCartUser(String cartUser) {
        this.cartUser = cartUser;
    }

    public String getEdgersPrice() {
        return edgersPrice;
    }

    public void setEdgersPrice(String edgersPrice) {
        this.edgersPrice = edgersPrice;
    }

    public String getEdgersUser() {
        return edgersUser;
    }

    public void setEdgersUser(String edgersUser) {
        this.edgersUser = edgersUser;
    }

    public String getGreatIroningPrice() {
        return greatIroningPrice;
    }

    public void setGreatIroningPrice(String greatIroningPrice) {
        this.greatIroningPrice = greatIroningPrice;
    }

    public String getGreatIroningUser() {
        return greatIroningUser;
    }

    public void setGreatIroningUser(String greatIroningUser) {
        this.greatIroningUser = greatIroningUser;
    }

    public String getCheckGoodsPrice() {
        return checkGoodsPrice;
    }

    public void setCheckGoodsPrice(String checkGoodsPrice) {
        this.checkGoodsPrice = checkGoodsPrice;
    }

    public String getCheckGoodsUser() {
        return checkGoodsUser;
    }

    public void setCheckGoodsUser(String checkGoodsUser) {
        this.checkGoodsUser = checkGoodsUser;
    }

    public String getTrimmingPrice() {
        return trimmingPrice;
    }

    public void setTrimmingPrice(String trimmingPrice) {
        this.trimmingPrice = trimmingPrice;
    }

    public String getTrimmingUser() {
        return trimmingUser;
    }

    public void setTrimmingUser(String trimmingUser) {
        this.trimmingUser = trimmingUser;
    }

    public String getPackagingPrice() {
        return packagingPrice;
    }

    public void setPackagingPrice(String packagingPrice) {
        this.packagingPrice = packagingPrice;
    }

    public String getPackagingUser() {
        return packagingUser;
    }

    public void setPackagingUser(String packagingUser) {
        this.packagingUser = packagingUser;
    }

    public String getReworkPrice() {
        return reworkPrice;
    }

    public void setReworkPrice(String reworkPrice) {
        this.reworkPrice = reworkPrice;
    }

    public String getReworkUser() {
        return reworkUser;
    }

    public void setReworkUser(String reworkUser) {
        this.reworkUser = reworkUser;
    }

    public String getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(String otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
    }
}

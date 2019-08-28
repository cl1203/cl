package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName TailorReqBean
 * @Description 裁剪请求bean
 * @Author 陈龙
 * @Date 2019/7/29 14:06
 * @Version 1.0
 **/
public class TailorReqBean implements Serializable{

    private static final long serialVersionUID = 5300707040646814369L;

    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单时间")
    private String orderTime;

    /**
     * 状态 0:已删除 1:戴裁剪 2:已裁剪
     */
    @ApiModelProperty(value = "状态 0:已删除 1:戴裁剪 2:已裁剪" )
    private String tailorStatus;

    /**
     * SKU
     */
    @ApiModelProperty(value = "sku")
    private String sku;

    /**
     * 生产方
     */
    @ApiModelProperty(value = "生产方")
    private String producer;


    /**
     * 裁剪小组
     */
    @ApiModelProperty(value = "裁剪小组")
    private String tailorName;

    /**
     * 实裁数量
     */
    @ApiModelProperty(value = "实裁数量")
    private String actualCutQuantity;

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
     * 实采数量
     */
    @ApiModelProperty(value = "实采数量")
    private String actualPickQuantity;

    /**
     * 单件用量，以公斤为单位
     */
    @ApiModelProperty(value = "单位用量,以公斤为单位")
    private String singleAmountKg;

    /**
     * 物料分类
     */
    @ApiModelProperty(value = "物料分类")
    private String materielTypeCode;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private String monovalent;

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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getTailorStatus() {
        return tailorStatus;
    }

    public void setTailorStatus(String tailorStatus) {
        this.tailorStatus = tailorStatus;
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

    public String getTailorName() {
        return tailorName;
    }

    public void setTailorName(String tailorName) {
        this.tailorName = tailorName;
    }

    public String getActualCutQuantity() {
        return actualCutQuantity;
    }

    public void setActualCutQuantity(String actualCutQuantity) {
        this.actualCutQuantity = actualCutQuantity;
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

    public String getActualPickQuantity() {
        return actualPickQuantity;
    }

    public void setActualPickQuantity(String actualPickQuantity) {
        this.actualPickQuantity = actualPickQuantity;
    }

    public String getSingleAmountKg() {
        return singleAmountKg;
    }

    public void setSingleAmountKg(String singleAmountKg) {
        this.singleAmountKg = singleAmountKg;
    }

    public String getMaterielTypeCode() {
        return materielTypeCode;
    }

    public void setMaterielTypeCode(String materielTypeCode) {
        this.materielTypeCode = materielTypeCode;
    }

    public String getMonovalent() {
        return monovalent;
    }

    public void setMonovalent(String monovalent) {
        this.monovalent = monovalent;
    }
}

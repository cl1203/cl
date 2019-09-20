package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName PurchaseResBean
 * @Description 采购resBean
 * @Author 陈龙
 * @Date 2019/7/22 11:36
 * @Version 1.0
 **/
public class PurchaseResBean implements Serializable {

    private static final long serialVersionUID = 6877830978132944886L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;

    /**
     * 采购单号
     */
    @ApiModelProperty(value = "采购单号")
    private String purchaseNo;
    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 采购单状态1:待采购 2:采购中 0:已删除
     */
    @ApiModelProperty(value = "采购单状态1:待采购 2:采购中 0:已删除")
    private Byte purchaseStatus;

    /**
     * 订单状态名称
     */
    @ApiModelProperty(value = "订单状态名称")
    private String purchaseStatusName;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    private String materielName;

    /**
     * 物料颜色
     */
    @ApiModelProperty(value = "物料颜色")
    private String materielColor;

    /**
     * 应采数量
     */
    @ApiModelProperty(value = "应采数量")
    private Integer answerPickQuantity;

    /**
     * 实采数量
     */
    @ApiModelProperty(value = "实采数量")
    private Integer actualPickQuantity;

    /**
     * 应采单价
     */
    @ApiModelProperty(value = "应采单价")
    private BigDecimal answerPickMonovalent;

    /**
     * 应采总额
     */
    @ApiModelProperty(value = "应采总额")
    private BigDecimal answerPickTotal;

    /**
     * 实采单价
     */
    @ApiModelProperty(value = "实采单价")
    private BigDecimal actualPickMonovalent;

    /**
     * 实采总额
     */
    @ApiModelProperty(value = "实采总额")
    private BigDecimal actualPickTotal;

    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    /**
     * 采购耗时
     */
    @ApiModelProperty(value = "采购耗时")
    private String consumingTime;

    /**
     * 物料分类
     */
    @ApiModelProperty(value = "物料分类")
    private String purchaseType;

    /**
     * 采购日期 (录入实采日期)
     */
    @ApiModelProperty(value = "录入实采日期")
    private String purchaseTime;

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Byte getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Byte purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getPurchaseStatusName() {
        return purchaseStatusName;
    }

    public void setPurchaseStatusName(String purchaseStatusName) {
        this.purchaseStatusName = purchaseStatusName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }


    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getMaterielColor() {
        return materielColor;
    }

    public void setMaterielColor(String materielColor) {
        this.materielColor = materielColor;
    }

    public Integer getAnswerPickQuantity() {
        return answerPickQuantity;
    }

    public void setAnswerPickQuantity(Integer answerPickQuantity) {
        this.answerPickQuantity = answerPickQuantity;
    }

    public Integer getActualPickQuantity() {
        return actualPickQuantity;
    }

    public void setActualPickQuantity(Integer actualPickQuantity) {
        this.actualPickQuantity = actualPickQuantity;
    }

    public BigDecimal getAnswerPickMonovalent() {
        return answerPickMonovalent;
    }

    public void setAnswerPickMonovalent(BigDecimal answerPickMonovalent) {
        this.answerPickMonovalent = answerPickMonovalent;
    }

    public BigDecimal getAnswerPickTotal() {
        return answerPickTotal;
    }

    public void setAnswerPickTotal(BigDecimal answerPickTotal) {
        this.answerPickTotal = answerPickTotal;
    }

    public BigDecimal getActualPickMonovalent() {
        return actualPickMonovalent;
    }

    public void setActualPickMonovalent(BigDecimal actualPickMonovalent) {
        this.actualPickMonovalent = actualPickMonovalent;
    }

    public BigDecimal getActualPickTotal() {
        return actualPickTotal;
    }

    public void setActualPickTotal(BigDecimal actualPickTotal) {
        this.actualPickTotal = actualPickTotal;
    }


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(String consumingTime) {
        this.consumingTime = consumingTime;
    }
}

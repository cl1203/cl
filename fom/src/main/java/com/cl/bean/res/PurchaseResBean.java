package com.cl.bean.res;

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
    private Long id;

    /**
     * 订单表ID
     */
    private Long orderId;

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 订单编号
     */
    private String orderNumber;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    private Byte orderStatus;

    /**
     * 物料名称
     */
    private String materielName;

    /**
     * 物料颜色
     */
    private String materielColor;

    /**
     * 应采数量
     */
    private Integer answerPickQuantity;

    /**
     * 实采数量
     */
    private Integer actualPickQuantity;

    /**
     * 应采单价
     */
    private BigDecimal answerPickMonovalent;

    /**
     * 应采总额
     */
    private BigDecimal answerPickTotal;

    /**
     * 实采单价
     */
    private BigDecimal actualPickMonovalent;

    /**
     * 实采总额
     */
    private BigDecimal actualPickTotal;

    /**
     * SKU
     */
    private String sku;

    /**
     * 二次工艺
     */
    private String secondaryProcess;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 采购耗时
     */
    private BigDecimal consumingTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSecondaryProcess() {
        return secondaryProcess;
    }

    public void setSecondaryProcess(String secondaryProcess) {
        this.secondaryProcess = secondaryProcess;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(BigDecimal consumingTime) {
        this.consumingTime = consumingTime;
    }
}

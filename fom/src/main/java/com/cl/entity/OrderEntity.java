package com.cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order
 * @author 
 */
public class OrderEntity implements Serializable {
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
     * SKU
     */
    private String sku;

    /**
     * 生产方
     */
    private String producer;

    /**
     * 二次工艺
     */
    private String secondaryProcess;

    /**
     * 物料名称
     */
    private String materielName;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 应采数量
     */
    private Integer answerPickQuantity;

    /**
     * 应采单价
     */
    private BigDecimal answerPickMonovalent;

    /**
     * 应采总额
     */
    private BigDecimal answerPickTotal;

    /**
     * 剩余时间
     */
    private String surplusTime;

    /**
     * 采购时间
     */
    private Integer purchaseTime;

    /**
     * 裁剪时间
     */
    private Integer tailoringTime;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 最后修改时间
     */
    private Date lastUpdateTime;

    /**
     * 最后修改人
     */
    private String lastUpdateUser;

    private static final long serialVersionUID = 1L;

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

    public String getSecondaryProcess() {
        return secondaryProcess;
    }

    public void setSecondaryProcess(String secondaryProcess) {
        this.secondaryProcess = secondaryProcess;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getAnswerPickQuantity() {
        return answerPickQuantity;
    }

    public void setAnswerPickQuantity(Integer answerPickQuantity) {
        this.answerPickQuantity = answerPickQuantity;
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

    public String getSurplusTime() {
        return surplusTime;
    }

    public void setSurplusTime(String surplusTime) {
        this.surplusTime = surplusTime;
    }

    public Integer getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Integer purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getTailoringTime() {
        return tailoringTime;
    }

    public void setTailoringTime(Integer tailoringTime) {
        this.tailoringTime = tailoringTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderEntity other = (OrderEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getOrderQuantity() == null ? other.getOrderQuantity() == null : this.getOrderQuantity().equals(other.getOrderQuantity()))
            && (this.getOrderTime() == null ? other.getOrderTime() == null : this.getOrderTime().equals(other.getOrderTime()))
            && (this.getSku() == null ? other.getSku() == null : this.getSku().equals(other.getSku()))
            && (this.getProducer() == null ? other.getProducer() == null : this.getProducer().equals(other.getProducer()))
            && (this.getSecondaryProcess() == null ? other.getSecondaryProcess() == null : this.getSecondaryProcess().equals(other.getSecondaryProcess()))
            && (this.getMaterielName() == null ? other.getMaterielName() == null : this.getMaterielName().equals(other.getMaterielName()))
            && (this.getSupplierName() == null ? other.getSupplierName() == null : this.getSupplierName().equals(other.getSupplierName()))
            && (this.getAnswerPickQuantity() == null ? other.getAnswerPickQuantity() == null : this.getAnswerPickQuantity().equals(other.getAnswerPickQuantity()))
            && (this.getAnswerPickMonovalent() == null ? other.getAnswerPickMonovalent() == null : this.getAnswerPickMonovalent().equals(other.getAnswerPickMonovalent()))
            && (this.getAnswerPickTotal() == null ? other.getAnswerPickTotal() == null : this.getAnswerPickTotal().equals(other.getAnswerPickTotal()))
            && (this.getSurplusTime() == null ? other.getSurplusTime() == null : this.getSurplusTime().equals(other.getSurplusTime()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
            && (this.getTailoringTime() == null ? other.getTailoringTime() == null : this.getTailoringTime().equals(other.getTailoringTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getOrderQuantity() == null) ? 0 : getOrderQuantity().hashCode());
        result = prime * result + ((getOrderTime() == null) ? 0 : getOrderTime().hashCode());
        result = prime * result + ((getSku() == null) ? 0 : getSku().hashCode());
        result = prime * result + ((getProducer() == null) ? 0 : getProducer().hashCode());
        result = prime * result + ((getSecondaryProcess() == null) ? 0 : getSecondaryProcess().hashCode());
        result = prime * result + ((getMaterielName() == null) ? 0 : getMaterielName().hashCode());
        result = prime * result + ((getSupplierName() == null) ? 0 : getSupplierName().hashCode());
        result = prime * result + ((getAnswerPickQuantity() == null) ? 0 : getAnswerPickQuantity().hashCode());
        result = prime * result + ((getAnswerPickMonovalent() == null) ? 0 : getAnswerPickMonovalent().hashCode());
        result = prime * result + ((getAnswerPickTotal() == null) ? 0 : getAnswerPickTotal().hashCode());
        result = prime * result + ((getSurplusTime() == null) ? 0 : getSurplusTime().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
        result = prime * result + ((getTailoringTime() == null) ? 0 : getTailoringTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNumber=").append(orderNumber);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", orderQuantity=").append(orderQuantity);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", sku=").append(sku);
        sb.append(", producer=").append(producer);
        sb.append(", secondaryProcess=").append(secondaryProcess);
        sb.append(", materielName=").append(materielName);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", answerPickQuantity=").append(answerPickQuantity);
        sb.append(", answerPickMonovalent=").append(answerPickMonovalent);
        sb.append(", answerPickTotal=").append(answerPickTotal);
        sb.append(", surplusTime=").append(surplusTime);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", tailoringTime=").append(tailoringTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
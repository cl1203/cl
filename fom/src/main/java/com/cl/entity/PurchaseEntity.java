package com.cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * purchase
 * @author 
 */
public class PurchaseEntity implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 采购单号
     */
    private String purchaseNo;

    /**
     * 采购日期 (录入实采时期)
     */
    private Date purchaseTime;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 供应商编号
     */
    private String supplierCode;

    /**
     * 供应商色号
     */
    private String supplierColorNumber;

    /**
     * 采购状态0:已删除 1: 待采购 2: 采购中  3: 已完成 
     */
    private Byte purchaseStatus;

    /**
     * 物料sku
     */
    private String materielSku;

    /**
     * 物料分类
     */
    private String materielType;

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
     * 应采单价
     */
    private BigDecimal answerPickMonovalent;

    /**
     * 应采总额
     */
    private BigDecimal answerPickTotal;

    /**
     * 实采数量
     */
    private Integer actualPickQuantity;

    /**
     * 实采单价
     */
    private BigDecimal actualPickMonovalent;

    /**
     * 实采总额
     */
    private BigDecimal actualPickTotal;

    /**
     * 采购耗时
     */
    private BigDecimal consumingTime;

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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getSupplierColorNumber() {
        return supplierColorNumber;
    }

    public void setSupplierColorNumber(String supplierColorNumber) {
        this.supplierColorNumber = supplierColorNumber;
    }

    public Byte getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Byte purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getMaterielSku() {
        return materielSku;
    }

    public void setMaterielSku(String materielSku) {
        this.materielSku = materielSku;
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType;
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

    public Integer getActualPickQuantity() {
        return actualPickQuantity;
    }

    public void setActualPickQuantity(Integer actualPickQuantity) {
        this.actualPickQuantity = actualPickQuantity;
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

    public BigDecimal getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(BigDecimal consumingTime) {
        this.consumingTime = consumingTime;
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
        PurchaseEntity other = (PurchaseEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getPurchaseNo() == null ? other.getPurchaseNo() == null : this.getPurchaseNo().equals(other.getPurchaseNo()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
            && (this.getSupplierName() == null ? other.getSupplierName() == null : this.getSupplierName().equals(other.getSupplierName()))
            && (this.getSupplierCode() == null ? other.getSupplierCode() == null : this.getSupplierCode().equals(other.getSupplierCode()))
            && (this.getSupplierColorNumber() == null ? other.getSupplierColorNumber() == null : this.getSupplierColorNumber().equals(other.getSupplierColorNumber()))
            && (this.getPurchaseStatus() == null ? other.getPurchaseStatus() == null : this.getPurchaseStatus().equals(other.getPurchaseStatus()))
            && (this.getMaterielSku() == null ? other.getMaterielSku() == null : this.getMaterielSku().equals(other.getMaterielSku()))
            && (this.getMaterielType() == null ? other.getMaterielType() == null : this.getMaterielType().equals(other.getMaterielType()))
            && (this.getMaterielName() == null ? other.getMaterielName() == null : this.getMaterielName().equals(other.getMaterielName()))
            && (this.getMaterielColor() == null ? other.getMaterielColor() == null : this.getMaterielColor().equals(other.getMaterielColor()))
            && (this.getAnswerPickQuantity() == null ? other.getAnswerPickQuantity() == null : this.getAnswerPickQuantity().equals(other.getAnswerPickQuantity()))
            && (this.getAnswerPickMonovalent() == null ? other.getAnswerPickMonovalent() == null : this.getAnswerPickMonovalent().equals(other.getAnswerPickMonovalent()))
            && (this.getAnswerPickTotal() == null ? other.getAnswerPickTotal() == null : this.getAnswerPickTotal().equals(other.getAnswerPickTotal()))
            && (this.getActualPickQuantity() == null ? other.getActualPickQuantity() == null : this.getActualPickQuantity().equals(other.getActualPickQuantity()))
            && (this.getActualPickMonovalent() == null ? other.getActualPickMonovalent() == null : this.getActualPickMonovalent().equals(other.getActualPickMonovalent()))
            && (this.getActualPickTotal() == null ? other.getActualPickTotal() == null : this.getActualPickTotal().equals(other.getActualPickTotal()))
            && (this.getConsumingTime() == null ? other.getConsumingTime() == null : this.getConsumingTime().equals(other.getConsumingTime()))
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
        result = prime * result + ((getOrderNo() == null) ? 0 : getOrderNo().hashCode());
        result = prime * result + ((getPurchaseNo() == null) ? 0 : getPurchaseNo().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
        result = prime * result + ((getSupplierName() == null) ? 0 : getSupplierName().hashCode());
        result = prime * result + ((getSupplierCode() == null) ? 0 : getSupplierCode().hashCode());
        result = prime * result + ((getSupplierColorNumber() == null) ? 0 : getSupplierColorNumber().hashCode());
        result = prime * result + ((getPurchaseStatus() == null) ? 0 : getPurchaseStatus().hashCode());
        result = prime * result + ((getMaterielSku() == null) ? 0 : getMaterielSku().hashCode());
        result = prime * result + ((getMaterielType() == null) ? 0 : getMaterielType().hashCode());
        result = prime * result + ((getMaterielName() == null) ? 0 : getMaterielName().hashCode());
        result = prime * result + ((getMaterielColor() == null) ? 0 : getMaterielColor().hashCode());
        result = prime * result + ((getAnswerPickQuantity() == null) ? 0 : getAnswerPickQuantity().hashCode());
        result = prime * result + ((getAnswerPickMonovalent() == null) ? 0 : getAnswerPickMonovalent().hashCode());
        result = prime * result + ((getAnswerPickTotal() == null) ? 0 : getAnswerPickTotal().hashCode());
        result = prime * result + ((getActualPickQuantity() == null) ? 0 : getActualPickQuantity().hashCode());
        result = prime * result + ((getActualPickMonovalent() == null) ? 0 : getActualPickMonovalent().hashCode());
        result = prime * result + ((getActualPickTotal() == null) ? 0 : getActualPickTotal().hashCode());
        result = prime * result + ((getConsumingTime() == null) ? 0 : getConsumingTime().hashCode());
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
        sb.append(", orderNo=").append(orderNo);
        sb.append(", purchaseNo=").append(purchaseNo);
        sb.append(", purchaseTime=").append(purchaseTime);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", supplierCode=").append(supplierCode);
        sb.append(", supplierColorNumber=").append(supplierColorNumber);
        sb.append(", purchaseStatus=").append(purchaseStatus);
        sb.append(", materielSku=").append(materielSku);
        sb.append(", materielType=").append(materielType);
        sb.append(", materielName=").append(materielName);
        sb.append(", materielColor=").append(materielColor);
        sb.append(", answerPickQuantity=").append(answerPickQuantity);
        sb.append(", answerPickMonovalent=").append(answerPickMonovalent);
        sb.append(", answerPickTotal=").append(answerPickTotal);
        sb.append(", actualPickQuantity=").append(actualPickQuantity);
        sb.append(", actualPickMonovalent=").append(actualPickMonovalent);
        sb.append(", actualPickTotal=").append(actualPickTotal);
        sb.append(", consumingTime=").append(consumingTime);
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
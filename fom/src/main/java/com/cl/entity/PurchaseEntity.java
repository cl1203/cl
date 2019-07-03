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
     * 订单表ID
     */
    private Long orderId;

    /**
     * 采购单号
     */
    private String purchaseNumber;

    /**
     * 采购日期 (录入实采时期)
     */
    private Date purchaseTime;

    /**
     * 实采数量
     */
    private Integer actualPickQuantity;

    /**
     * 应采单价
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

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
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
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getPurchaseNumber() == null ? other.getPurchaseNumber() == null : this.getPurchaseNumber().equals(other.getPurchaseNumber()))
            && (this.getPurchaseTime() == null ? other.getPurchaseTime() == null : this.getPurchaseTime().equals(other.getPurchaseTime()))
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
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getPurchaseNumber() == null) ? 0 : getPurchaseNumber().hashCode());
        result = prime * result + ((getPurchaseTime() == null) ? 0 : getPurchaseTime().hashCode());
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
        sb.append(", orderId=").append(orderId);
        sb.append(", purchaseNumber=").append(purchaseNumber);
        sb.append(", purchaseTime=").append(purchaseTime);
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
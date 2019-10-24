package com.cl.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * abnormal
 * @author 
 */
public class AbnormalEntity implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    private String purchaseNo;

    /**
     * 异常类型 1:采购异常 2:裁剪异常
     */
    private Byte abnormalType;

    /**
     * 审批状态 0:未审批 1: 已审批 
     */
    private Byte isApproval;

    /**
     * 是否超期异常
     */
    private Byte isExceed;

    /**
     * 异常备注
     */
    private String abnormalRemarks;

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

    public Byte getAbnormalType() {
        return abnormalType;
    }

    public void setAbnormalType(Byte abnormalType) {
        this.abnormalType = abnormalType;
    }

    public Byte getIsApproval() {
        return isApproval;
    }

    public void setIsApproval(Byte isApproval) {
        this.isApproval = isApproval;
    }

    public Byte getIsExceed() {
        return isExceed;
    }

    public void setIsExceed(Byte isExceed) {
        this.isExceed = isExceed;
    }

    public String getAbnormalRemarks() {
        return abnormalRemarks;
    }

    public void setAbnormalRemarks(String abnormalRemarks) {
        this.abnormalRemarks = abnormalRemarks;
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
        AbnormalEntity other = (AbnormalEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getPurchaseNo() == null ? other.getPurchaseNo() == null : this.getPurchaseNo().equals(other.getPurchaseNo()))
            && (this.getAbnormalType() == null ? other.getAbnormalType() == null : this.getAbnormalType().equals(other.getAbnormalType()))
            && (this.getIsApproval() == null ? other.getIsApproval() == null : this.getIsApproval().equals(other.getIsApproval()))
            && (this.getIsExceed() == null ? other.getIsExceed() == null : this.getIsExceed().equals(other.getIsExceed()))
            && (this.getAbnormalRemarks() == null ? other.getAbnormalRemarks() == null : this.getAbnormalRemarks().equals(other.getAbnormalRemarks()))
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
        result = prime * result + ((getAbnormalType() == null) ? 0 : getAbnormalType().hashCode());
        result = prime * result + ((getIsApproval() == null) ? 0 : getIsApproval().hashCode());
        result = prime * result + ((getIsExceed() == null) ? 0 : getIsExceed().hashCode());
        result = prime * result + ((getAbnormalRemarks() == null) ? 0 : getAbnormalRemarks().hashCode());
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
        sb.append(", abnormalType=").append(abnormalType);
        sb.append(", isApproval=").append(isApproval);
        sb.append(", isExceed=").append(isExceed);
        sb.append(", abnormalRemarks=").append(abnormalRemarks);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
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
     * 订单表ID
     */
    private Long orderId;

    /**
     * 异常类型 1:采购异常 2:裁剪异常
     */
    private Byte abnormalType;

    /**
     * 审批状态 0:未审批 1: 已审批 
     */
    private Byte isApproval;

    /**
     * 异常备注
     */
    private String abnormalRemarks;

    /**
     * 状态 0:禁用 1:可用 2:删除
     */
    private Byte status;

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

    public String getAbnormalRemarks() {
        return abnormalRemarks;
    }

    public void setAbnormalRemarks(String abnormalRemarks) {
        this.abnormalRemarks = abnormalRemarks;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getAbnormalType() == null ? other.getAbnormalType() == null : this.getAbnormalType().equals(other.getAbnormalType()))
            && (this.getIsApproval() == null ? other.getIsApproval() == null : this.getIsApproval().equals(other.getIsApproval()))
            && (this.getAbnormalRemarks() == null ? other.getAbnormalRemarks() == null : this.getAbnormalRemarks().equals(other.getAbnormalRemarks()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getAbnormalType() == null) ? 0 : getAbnormalType().hashCode());
        result = prime * result + ((getIsApproval() == null) ? 0 : getIsApproval().hashCode());
        result = prime * result + ((getAbnormalRemarks() == null) ? 0 : getAbnormalRemarks().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", abnormalType=").append(abnormalType);
        sb.append(", isApproval=").append(isApproval);
        sb.append(", abnormalRemarks=").append(abnormalRemarks);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateUser=").append(lastUpdateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
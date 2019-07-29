package com.cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * tailor
 * @author 
 */
public class TailorEntity implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 裁剪员工ID
     */
    private Long tailorUserId;

    /**
     * 应裁数量
     */
    private Integer answerCutQuantity;

    /**
     * 实裁数量
     */
    private Integer actualCutQuantity;

    /**
     * 单价
     */
    private BigDecimal monovalent;

    /**
     * 裁剪耗时
     */
    private BigDecimal consumingTime;

    /**
     * 状态 0:已删除 1:戴裁剪 2:已裁剪
     */
    private Byte tailoStatus;

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

    public Long getTailorUserId() {
        return tailorUserId;
    }

    public void setTailorUserId(Long tailorUserId) {
        this.tailorUserId = tailorUserId;
    }

    public Integer getAnswerCutQuantity() {
        return answerCutQuantity;
    }

    public void setAnswerCutQuantity(Integer answerCutQuantity) {
        this.answerCutQuantity = answerCutQuantity;
    }

    public Integer getActualCutQuantity() {
        return actualCutQuantity;
    }

    public void setActualCutQuantity(Integer actualCutQuantity) {
        this.actualCutQuantity = actualCutQuantity;
    }

    public BigDecimal getMonovalent() {
        return monovalent;
    }

    public void setMonovalent(BigDecimal monovalent) {
        this.monovalent = monovalent;
    }

    public BigDecimal getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(BigDecimal consumingTime) {
        this.consumingTime = consumingTime;
    }

    public Byte getTailoStatus() {
        return tailoStatus;
    }

    public void setTailoStatus(Byte tailoStatus) {
        this.tailoStatus = tailoStatus;
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
        TailorEntity other = (TailorEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getTailorUserId() == null ? other.getTailorUserId() == null : this.getTailorUserId().equals(other.getTailorUserId()))
            && (this.getAnswerCutQuantity() == null ? other.getAnswerCutQuantity() == null : this.getAnswerCutQuantity().equals(other.getAnswerCutQuantity()))
            && (this.getActualCutQuantity() == null ? other.getActualCutQuantity() == null : this.getActualCutQuantity().equals(other.getActualCutQuantity()))
            && (this.getMonovalent() == null ? other.getMonovalent() == null : this.getMonovalent().equals(other.getMonovalent()))
            && (this.getConsumingTime() == null ? other.getConsumingTime() == null : this.getConsumingTime().equals(other.getConsumingTime()))
            && (this.getTailoStatus() == null ? other.getTailoStatus() == null : this.getTailoStatus().equals(other.getTailoStatus()))
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
        result = prime * result + ((getTailorUserId() == null) ? 0 : getTailorUserId().hashCode());
        result = prime * result + ((getAnswerCutQuantity() == null) ? 0 : getAnswerCutQuantity().hashCode());
        result = prime * result + ((getActualCutQuantity() == null) ? 0 : getActualCutQuantity().hashCode());
        result = prime * result + ((getMonovalent() == null) ? 0 : getMonovalent().hashCode());
        result = prime * result + ((getConsumingTime() == null) ? 0 : getConsumingTime().hashCode());
        result = prime * result + ((getTailoStatus() == null) ? 0 : getTailoStatus().hashCode());
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
        sb.append(", tailorUserId=").append(tailorUserId);
        sb.append(", answerCutQuantity=").append(answerCutQuantity);
        sb.append(", actualCutQuantity=").append(actualCutQuantity);
        sb.append(", monovalent=").append(monovalent);
        sb.append(", consumingTime=").append(consumingTime);
        sb.append(", tailoStatus=").append(tailoStatus);
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
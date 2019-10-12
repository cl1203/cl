package com.cl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * finance
 * @author 
 */
public class FinanceEntity implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 总件数 , 用户录入
     */
    private Integer quantityTotal;

    /**
     * 工序:平车价格
     */
    private BigDecimal flatcarPrice;

    /**
     * 工序: 冚车单价
     */
    private BigDecimal cartPrice;

    /**
     * 工序:打边单价
     */
    private BigDecimal edgersPrice;

    /**
     * 工序:大烫单价
     */
    private BigDecimal greatIroningPrice;

    /**
     * 工序:查货单价
     */
    private BigDecimal checkGoodsPrice;

    /**
     * 工序:剪线单价
     */
    private BigDecimal trimmingPrice;

    /**
     * 工序:包装单价
     */
    private BigDecimal packagingPrice;

    /**
     * 返工单价
     */
    private BigDecimal reworkPrice;

    /**
     * 工序: 其他 单价
     */
    private BigDecimal otherPrice;

    /**
     * 状态0:已结算 1:未结算  
     */
    private Byte status;

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

    public Integer getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(Integer quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public BigDecimal getFlatcarPrice() {
        return flatcarPrice;
    }

    public void setFlatcarPrice(BigDecimal flatcarPrice) {
        this.flatcarPrice = flatcarPrice;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public BigDecimal getEdgersPrice() {
        return edgersPrice;
    }

    public void setEdgersPrice(BigDecimal edgersPrice) {
        this.edgersPrice = edgersPrice;
    }

    public BigDecimal getGreatIroningPrice() {
        return greatIroningPrice;
    }

    public void setGreatIroningPrice(BigDecimal greatIroningPrice) {
        this.greatIroningPrice = greatIroningPrice;
    }

    public BigDecimal getCheckGoodsPrice() {
        return checkGoodsPrice;
    }

    public void setCheckGoodsPrice(BigDecimal checkGoodsPrice) {
        this.checkGoodsPrice = checkGoodsPrice;
    }

    public BigDecimal getTrimmingPrice() {
        return trimmingPrice;
    }

    public void setTrimmingPrice(BigDecimal trimmingPrice) {
        this.trimmingPrice = trimmingPrice;
    }

    public BigDecimal getPackagingPrice() {
        return packagingPrice;
    }

    public void setPackagingPrice(BigDecimal packagingPrice) {
        this.packagingPrice = packagingPrice;
    }

    public BigDecimal getReworkPrice() {
        return reworkPrice;
    }

    public void setReworkPrice(BigDecimal reworkPrice) {
        this.reworkPrice = reworkPrice;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
        FinanceEntity other = (FinanceEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderNo() == null ? other.getOrderNo() == null : this.getOrderNo().equals(other.getOrderNo()))
            && (this.getQuantityTotal() == null ? other.getQuantityTotal() == null : this.getQuantityTotal().equals(other.getQuantityTotal()))
            && (this.getFlatcarPrice() == null ? other.getFlatcarPrice() == null : this.getFlatcarPrice().equals(other.getFlatcarPrice()))
            && (this.getCartPrice() == null ? other.getCartPrice() == null : this.getCartPrice().equals(other.getCartPrice()))
            && (this.getEdgersPrice() == null ? other.getEdgersPrice() == null : this.getEdgersPrice().equals(other.getEdgersPrice()))
            && (this.getGreatIroningPrice() == null ? other.getGreatIroningPrice() == null : this.getGreatIroningPrice().equals(other.getGreatIroningPrice()))
            && (this.getCheckGoodsPrice() == null ? other.getCheckGoodsPrice() == null : this.getCheckGoodsPrice().equals(other.getCheckGoodsPrice()))
            && (this.getTrimmingPrice() == null ? other.getTrimmingPrice() == null : this.getTrimmingPrice().equals(other.getTrimmingPrice()))
            && (this.getPackagingPrice() == null ? other.getPackagingPrice() == null : this.getPackagingPrice().equals(other.getPackagingPrice()))
            && (this.getReworkPrice() == null ? other.getReworkPrice() == null : this.getReworkPrice().equals(other.getReworkPrice()))
            && (this.getOtherPrice() == null ? other.getOtherPrice() == null : this.getOtherPrice().equals(other.getOtherPrice()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
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
        result = prime * result + ((getQuantityTotal() == null) ? 0 : getQuantityTotal().hashCode());
        result = prime * result + ((getFlatcarPrice() == null) ? 0 : getFlatcarPrice().hashCode());
        result = prime * result + ((getCartPrice() == null) ? 0 : getCartPrice().hashCode());
        result = prime * result + ((getEdgersPrice() == null) ? 0 : getEdgersPrice().hashCode());
        result = prime * result + ((getGreatIroningPrice() == null) ? 0 : getGreatIroningPrice().hashCode());
        result = prime * result + ((getCheckGoodsPrice() == null) ? 0 : getCheckGoodsPrice().hashCode());
        result = prime * result + ((getTrimmingPrice() == null) ? 0 : getTrimmingPrice().hashCode());
        result = prime * result + ((getPackagingPrice() == null) ? 0 : getPackagingPrice().hashCode());
        result = prime * result + ((getReworkPrice() == null) ? 0 : getReworkPrice().hashCode());
        result = prime * result + ((getOtherPrice() == null) ? 0 : getOtherPrice().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", quantityTotal=").append(quantityTotal);
        sb.append(", flatcarPrice=").append(flatcarPrice);
        sb.append(", cartPrice=").append(cartPrice);
        sb.append(", edgersPrice=").append(edgersPrice);
        sb.append(", greatIroningPrice=").append(greatIroningPrice);
        sb.append(", checkGoodsPrice=").append(checkGoodsPrice);
        sb.append(", trimmingPrice=").append(trimmingPrice);
        sb.append(", packagingPrice=").append(packagingPrice);
        sb.append(", reworkPrice=").append(reworkPrice);
        sb.append(", otherPrice=").append(otherPrice);
        sb.append(", status=").append(status);
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
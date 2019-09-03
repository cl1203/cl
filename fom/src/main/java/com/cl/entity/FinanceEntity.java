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
     * 工序: 平车员工
     */
    private String flatcarUser;

    /**
     * 工序: 冚车单价
     */
    private BigDecimal cartPrice;

    /**
     * 工序:冚车员工
     */
    private String cartUser;

    /**
     * 工序:打边单价
     */
    private BigDecimal edgersPrice;

    /**
     * 工序:打边员工
     */
    private String edgersUser;

    /**
     * 工序:大烫单价
     */
    private BigDecimal greatIroningPrice;

    /**
     * 工序: 大烫员工
     */
    private String greatIroningUser;

    /**
     * 工序:查货单价
     */
    private BigDecimal checkGoodsPrice;

    /**
     * 工序:查货员工
     */
    private String checkGoodsUser;

    /**
     * 工序:剪线单价
     */
    private BigDecimal trimmingPrice;

    /**
     * 工序:剪线员工
     */
    private String trimmingUser;

    /**
     * 工序:包装单价
     */
    private BigDecimal packagingPrice;

    /**
     * 工序:包装员工
     */
    private String packagingUser;

    /**
     * 返工单价
     */
    private BigDecimal reworkPrice;

    /**
     * 工序:返工员工
     */
    private String reworkUser;

    /**
     * 工序: 其他 单价
     */
    private BigDecimal otherPrice;

    /**
     * 工序:其他 员工
     */
    private String otherUser;

    /**
     * 状态 0:已结算 1:未结算
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

    public String getFlatcarUser() {
        return flatcarUser;
    }

    public void setFlatcarUser(String flatcarUser) {
        this.flatcarUser = flatcarUser;
    }

    public BigDecimal getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(BigDecimal cartPrice) {
        this.cartPrice = cartPrice;
    }

    public String getCartUser() {
        return cartUser;
    }

    public void setCartUser(String cartUser) {
        this.cartUser = cartUser;
    }

    public BigDecimal getEdgersPrice() {
        return edgersPrice;
    }

    public void setEdgersPrice(BigDecimal edgersPrice) {
        this.edgersPrice = edgersPrice;
    }

    public String getEdgersUser() {
        return edgersUser;
    }

    public void setEdgersUser(String edgersUser) {
        this.edgersUser = edgersUser;
    }

    public BigDecimal getGreatIroningPrice() {
        return greatIroningPrice;
    }

    public void setGreatIroningPrice(BigDecimal greatIroningPrice) {
        this.greatIroningPrice = greatIroningPrice;
    }

    public String getGreatIroningUser() {
        return greatIroningUser;
    }

    public void setGreatIroningUser(String greatIroningUser) {
        this.greatIroningUser = greatIroningUser;
    }

    public BigDecimal getCheckGoodsPrice() {
        return checkGoodsPrice;
    }

    public void setCheckGoodsPrice(BigDecimal checkGoodsPrice) {
        this.checkGoodsPrice = checkGoodsPrice;
    }

    public String getCheckGoodsUser() {
        return checkGoodsUser;
    }

    public void setCheckGoodsUser(String checkGoodsUser) {
        this.checkGoodsUser = checkGoodsUser;
    }

    public BigDecimal getTrimmingPrice() {
        return trimmingPrice;
    }

    public void setTrimmingPrice(BigDecimal trimmingPrice) {
        this.trimmingPrice = trimmingPrice;
    }

    public String getTrimmingUser() {
        return trimmingUser;
    }

    public void setTrimmingUser(String trimmingUser) {
        this.trimmingUser = trimmingUser;
    }

    public BigDecimal getPackagingPrice() {
        return packagingPrice;
    }

    public void setPackagingPrice(BigDecimal packagingPrice) {
        this.packagingPrice = packagingPrice;
    }

    public String getPackagingUser() {
        return packagingUser;
    }

    public void setPackagingUser(String packagingUser) {
        this.packagingUser = packagingUser;
    }

    public BigDecimal getReworkPrice() {
        return reworkPrice;
    }

    public void setReworkPrice(BigDecimal reworkPrice) {
        this.reworkPrice = reworkPrice;
    }

    public String getReworkUser() {
        return reworkUser;
    }

    public void setReworkUser(String reworkUser) {
        this.reworkUser = reworkUser;
    }

    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(String otherUser) {
        this.otherUser = otherUser;
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
            && (this.getFlatcarUser() == null ? other.getFlatcarUser() == null : this.getFlatcarUser().equals(other.getFlatcarUser()))
            && (this.getCartPrice() == null ? other.getCartPrice() == null : this.getCartPrice().equals(other.getCartPrice()))
            && (this.getCartUser() == null ? other.getCartUser() == null : this.getCartUser().equals(other.getCartUser()))
            && (this.getEdgersPrice() == null ? other.getEdgersPrice() == null : this.getEdgersPrice().equals(other.getEdgersPrice()))
            && (this.getEdgersUser() == null ? other.getEdgersUser() == null : this.getEdgersUser().equals(other.getEdgersUser()))
            && (this.getGreatIroningPrice() == null ? other.getGreatIroningPrice() == null : this.getGreatIroningPrice().equals(other.getGreatIroningPrice()))
            && (this.getGreatIroningUser() == null ? other.getGreatIroningUser() == null : this.getGreatIroningUser().equals(other.getGreatIroningUser()))
            && (this.getCheckGoodsPrice() == null ? other.getCheckGoodsPrice() == null : this.getCheckGoodsPrice().equals(other.getCheckGoodsPrice()))
            && (this.getCheckGoodsUser() == null ? other.getCheckGoodsUser() == null : this.getCheckGoodsUser().equals(other.getCheckGoodsUser()))
            && (this.getTrimmingPrice() == null ? other.getTrimmingPrice() == null : this.getTrimmingPrice().equals(other.getTrimmingPrice()))
            && (this.getTrimmingUser() == null ? other.getTrimmingUser() == null : this.getTrimmingUser().equals(other.getTrimmingUser()))
            && (this.getPackagingPrice() == null ? other.getPackagingPrice() == null : this.getPackagingPrice().equals(other.getPackagingPrice()))
            && (this.getPackagingUser() == null ? other.getPackagingUser() == null : this.getPackagingUser().equals(other.getPackagingUser()))
            && (this.getReworkPrice() == null ? other.getReworkPrice() == null : this.getReworkPrice().equals(other.getReworkPrice()))
            && (this.getReworkUser() == null ? other.getReworkUser() == null : this.getReworkUser().equals(other.getReworkUser()))
            && (this.getOtherPrice() == null ? other.getOtherPrice() == null : this.getOtherPrice().equals(other.getOtherPrice()))
            && (this.getOtherUser() == null ? other.getOtherUser() == null : this.getOtherUser().equals(other.getOtherUser()))
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
        result = prime * result + ((getFlatcarUser() == null) ? 0 : getFlatcarUser().hashCode());
        result = prime * result + ((getCartPrice() == null) ? 0 : getCartPrice().hashCode());
        result = prime * result + ((getCartUser() == null) ? 0 : getCartUser().hashCode());
        result = prime * result + ((getEdgersPrice() == null) ? 0 : getEdgersPrice().hashCode());
        result = prime * result + ((getEdgersUser() == null) ? 0 : getEdgersUser().hashCode());
        result = prime * result + ((getGreatIroningPrice() == null) ? 0 : getGreatIroningPrice().hashCode());
        result = prime * result + ((getGreatIroningUser() == null) ? 0 : getGreatIroningUser().hashCode());
        result = prime * result + ((getCheckGoodsPrice() == null) ? 0 : getCheckGoodsPrice().hashCode());
        result = prime * result + ((getCheckGoodsUser() == null) ? 0 : getCheckGoodsUser().hashCode());
        result = prime * result + ((getTrimmingPrice() == null) ? 0 : getTrimmingPrice().hashCode());
        result = prime * result + ((getTrimmingUser() == null) ? 0 : getTrimmingUser().hashCode());
        result = prime * result + ((getPackagingPrice() == null) ? 0 : getPackagingPrice().hashCode());
        result = prime * result + ((getPackagingUser() == null) ? 0 : getPackagingUser().hashCode());
        result = prime * result + ((getReworkPrice() == null) ? 0 : getReworkPrice().hashCode());
        result = prime * result + ((getReworkUser() == null) ? 0 : getReworkUser().hashCode());
        result = prime * result + ((getOtherPrice() == null) ? 0 : getOtherPrice().hashCode());
        result = prime * result + ((getOtherUser() == null) ? 0 : getOtherUser().hashCode());
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
        sb.append(", flatcarUser=").append(flatcarUser);
        sb.append(", cartPrice=").append(cartPrice);
        sb.append(", cartUser=").append(cartUser);
        sb.append(", edgersPrice=").append(edgersPrice);
        sb.append(", edgersUser=").append(edgersUser);
        sb.append(", greatIroningPrice=").append(greatIroningPrice);
        sb.append(", greatIroningUser=").append(greatIroningUser);
        sb.append(", checkGoodsPrice=").append(checkGoodsPrice);
        sb.append(", checkGoodsUser=").append(checkGoodsUser);
        sb.append(", trimmingPrice=").append(trimmingPrice);
        sb.append(", trimmingUser=").append(trimmingUser);
        sb.append(", packagingPrice=").append(packagingPrice);
        sb.append(", packagingUser=").append(packagingUser);
        sb.append(", reworkPrice=").append(reworkPrice);
        sb.append(", reworkUser=").append(reworkUser);
        sb.append(", otherPrice=").append(otherPrice);
        sb.append(", otherUser=").append(otherUser);
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
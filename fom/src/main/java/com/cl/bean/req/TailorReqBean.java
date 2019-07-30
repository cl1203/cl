package com.cl.bean.req;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName TailorReqBean
 * @Description 裁剪请求bean
 * @Author 陈龙
 * @Date 2019/7/29 14:06
 * @Version 1.0
 **/
public class TailorReqBean implements Serializable{

    private static final long serialVersionUID = 5300707040646814369L;

    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 下单时间
     */
    private String orderTime;

    /**
     * 状态 0:已删除 1:戴裁剪 2:已裁剪
     */
    private String tailorStatus;

    /**
     * SKU
     */
    private String sku;

    /**
     * 生产方
     */
    private String producer;

    /**
     * 指定生产方组织ID(不为空时以此生产方为准)
     */
    private Long producerOrgId;

    /**
     * 裁剪员工
     */
    private Long tailorUserNameId;

    /**
     * 每页数量
     */
    @NotNull(message = "每页查询数量大小不能为空!")
    private Integer pageSize;

    /**
     * 页码
     */
    @NotNull(message = "页码大小不能为空!")
    private Integer pageNum;

    /**
     * 实采数量
     */
    private String actualPickQuantity;

    /**
     * 单件用量，以公斤为单位
     */
    private BigDecimal singleAmountKg;

    /**
     * 物料分类
     */
    private String materielTypeCode;

    /**
     * 单价
     */
    private BigDecimal monovalent;

    public Long getProducerOrgId() {
        return producerOrgId;
    }

    public void setProducerOrgId(Long producerOrgId) {
        this.producerOrgId = producerOrgId;
    }

    public BigDecimal getMonovalent() {
        return monovalent;
    }

    public void setMonovalent(BigDecimal monovalent) {
        this.monovalent = monovalent;
    }

    public String getMaterielTypeCode() {
        return materielTypeCode;
    }

    public void setMaterielTypeCode(String materielTypeCode) {
        this.materielTypeCode = materielTypeCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActualPickQuantity() {
        return actualPickQuantity;
    }

    public void setActualPickQuantity(String actualPickQuantity) {
        this.actualPickQuantity = actualPickQuantity;
    }

    public BigDecimal getSingleAmountKg() {
        return singleAmountKg;
    }

    public void setSingleAmountKg(BigDecimal singleAmountKg) {
        this.singleAmountKg = singleAmountKg;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getTailorStatus() {
        return tailorStatus;
    }

    public void setTailorStatus(String tailorStatus) {
        this.tailorStatus = tailorStatus;
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTailorUserNameId() {
        return tailorUserNameId;
    }

    public void setTailorUserNameId(Long tailorUserNameId) {
        this.tailorUserNameId = tailorUserNameId;
    }
}

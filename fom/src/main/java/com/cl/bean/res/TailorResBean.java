package com.cl.bean.res;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName TailorResBean
 * @Description 裁剪返回bean
 * @Author 陈龙
 * @Date 2019/7/29 15:25
 * @Version 1.0
 **/
public class TailorResBean implements Serializable{

    private static final long serialVersionUID = 2883338235759487920L;

    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * SKU
     */
    @ApiModelProperty(value = "SKU")
    private String sku;

    /**
     * 状态code 0:已删除 1:戴裁剪 2:已裁剪
     */
    @ApiModelProperty(value = "状态code 0:已删除 1:戴裁剪 2:已裁剪")
    private Byte tailorStatusCode;

    /**
     * 裁剪状态
     */
    @ApiModelProperty(value = "裁剪状态")
    private String tailorStatus;
    /**
     * 生产方
     */
    @ApiModelProperty(value = "生产方")
    private String producer;

    /**
     * 指定生产方组织ID(不为空时以此生产方为准)
     */
    @ApiModelProperty(value = "指定生产方组织ID(不为空时以此生产方为准)")
    private Long producerOrgId;

    /**
     * 裁剪员工
     */
    @ApiModelProperty(value = "裁剪员工")
    private String tailorUserName;

    /**
     * 应裁数量
     */
    @ApiModelProperty(value = "应裁数量")
    private Integer answerCutQuantity;

    /**
     * 实裁数量
     */
    @ApiModelProperty(value = "实裁数量")
    private Integer actualCutQuantity;

    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    private BigDecimal monovalent;

    /**
     * 裁剪耗时
     */
    @ApiModelProperty(value = "裁剪耗时")
    private BigDecimal consumingTime;

    /**
     * 二次工艺
     */
    @ApiModelProperty(value = "二次工艺")
    private List<SecondaryProcessResBean> secondaryProcessResBeanList;

    public Long getProducerOrgId() {
        return producerOrgId;
    }

    public void setProducerOrgId(Long producerOrgId) {
        this.producerOrgId = producerOrgId;
    }

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Byte getTailorStatusCode() {
        return tailorStatusCode;
    }

    public void setTailorStatusCode(Byte tailorStatusCode) {
        this.tailorStatusCode = tailorStatusCode;
    }

    public String getTailorStatus() {
        return tailorStatus;
    }

    public void setTailorStatus(String tailorStatus) {
        this.tailorStatus = tailorStatus;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getTailorUserName() {
        return tailorUserName;
    }

    public void setTailorUserName(String tailorUserName) {
        this.tailorUserName = tailorUserName;
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

    public List<SecondaryProcessResBean> getSecondaryProcessResBeanList() {
        return secondaryProcessResBeanList;
    }

    public void setSecondaryProcessResBeanList(List<SecondaryProcessResBean> secondaryProcessResBeanList) {
        this.secondaryProcessResBeanList = secondaryProcessResBeanList;
    }
}

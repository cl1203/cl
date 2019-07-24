package com.cl.bean.res;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName SecondaryProcessResBean
 * @Description 二次工艺resBean
 * @Author 陈龙
 * @Date 2019/7/24 13:53
 * @Version 1.0
 **/
public class SecondaryProcessResBean implements Serializable {

    private static final long serialVersionUID = -6746099408067045609L;

    /**
     * ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 工艺名称
     */
    private String processName;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 价格
     */
    private BigDecimal unitPrice;

    /**
     * 单位用量
     */
    private String simpleUse;

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

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSimpleUse() {
        return simpleUse;
    }

    public void setSimpleUse(String simpleUse) {
        this.simpleUse = simpleUse;
    }
}

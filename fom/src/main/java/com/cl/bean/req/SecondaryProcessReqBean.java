package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class SecondaryProcessReqBean implements Serializable {

    private static final long serialVersionUID = -4343556978751174575L;

    /**
     * 工艺名称
     */
    @ApiModelProperty(value = "工艺名称")
    private String processName;

    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    private String supplierName;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private String unitPrice;

    /**
     * 单位用量
     */
    @ApiModelProperty(value = "单位用量")
    private String simpleUse;

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

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getSimpleUse() {
        return simpleUse;
    }

    public void setSimpleUse(String simpleUse) {
        this.simpleUse = simpleUse;
    }
}

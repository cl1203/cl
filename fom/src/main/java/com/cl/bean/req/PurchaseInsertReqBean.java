package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class PurchaseInsertReqBean implements Serializable {

    private static final long serialVersionUID = -3879223209105328049L;

    /**
     * 采购单号
     */
    @ApiModelProperty(value = "采购单号")
    @NotBlank(message = "采购单号不能为空!")
    private String purchaseNo;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    @NotBlank(message = "物料名称不能为空!")
    private String materielName;

    /**
     * 物料颜色
     */
    @ApiModelProperty(value = "物料颜色")
    @NotBlank(message = "物料颜色不能为空!")
    private String materielColor;

    /**
     * 物料分类
     */
    @ApiModelProperty(value = "物料分类")
    @NotBlank(message = "物料分类不能为空!")
    private String purchaseType;

    /**
     * 单件用量
     */
    @ApiModelProperty(value = "单件用量")
    @NotBlank(message = "单件用量不能为空!")
    @Pattern(regexp = "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}" , message = "实采数量规则:整数位最多10位,小数位最多2位!")
    private String simpleUse;

    /**
     * 应采单价
     */
    @ApiModelProperty(value = "应采单价")
    @NotBlank(message = "应采单价不能为空!")
    @Pattern(regexp = "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}" , message = "实采单价规则:整数位最多10位,小数位最多2位!")
    private String answerPickMonovalent;

    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称")
    @NotBlank(message = "供应商名称不能为空!")
    private String supplierName;

    /**
     * 物料sku
     */
    @ApiModelProperty(value = "物料sku")
    @NotBlank(message = "物料sku不能为空!")
    private String materielSku;

    public String getMaterielSku() {
        return materielSku;
    }

    public void setMaterielSku(String materielSku) {
        this.materielSku = materielSku;
    }

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getMaterielName() {
        return materielName;
    }

    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    public String getMaterielColor() {
        return materielColor;
    }

    public void setMaterielColor(String materielColor) {
        this.materielColor = materielColor;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getSimpleUse() {
        return simpleUse;
    }

    public void setSimpleUse(String simpleUse) {
        this.simpleUse = simpleUse;
    }

    public String getAnswerPickMonovalent() {
        return answerPickMonovalent;
    }

    public void setAnswerPickMonovalent(String answerPickMonovalent) {
        this.answerPickMonovalent = answerPickMonovalent;
    }


    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}

package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName PurchaseReqBean
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/22 16:38
 * @Version 1.0
 **/
public class PurchaseReqBean implements Serializable {

    private static final long serialVersionUID = 4258978832555303240L;

    /**
     * 采购单号
     */
    @ApiModelProperty(value = "采购单号")
    private String purchaseNo;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    @ApiModelProperty(value = "订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪")
    private String purchaseStatus;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单起始日期")
    private String startDate;

    /**
     * 下单时间
     */
    @ApiModelProperty(value = "下单结束日期")
    private String endDate;

    /**
     * 采购日期 (录入实采日期)
     */
    @ApiModelProperty(value = "录入实采日期")
    private String purchaseTime;

    /**
     * 物料分类
     */
    @ApiModelProperty(value = "物料分类")
    private String materielType;

    /**
     * 供应商名称
     */
    @ApiModelProperty
    private String supplierName;

    /**
     * ID
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    /**
     * 实采数量
     */
    @ApiModelProperty(value = "实采数量")
    private String actualPickQuantity;

    /**
     * 实采单价
     */
    @ApiModelProperty(value = "实采单价")
    private String actualPickMonovalent;

    /**
     * 实采总额
     */
    @ApiModelProperty(value = "实采总额")
    private String actualPickTotal;


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
     * 组织名称
     */
    @ApiModelProperty(value = "组织名称")
    private String orgName;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public String getPurchaseNo() {
        return purchaseNo;
    }

    public void setPurchaseNo(String purchaseNo) {
        this.purchaseNo = purchaseNo;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getMaterielType() {
        return materielType;
    }

    public void setMaterielType(String materielType) {
        this.materielType = materielType;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public String getActualPickMonovalent() {
        return actualPickMonovalent;
    }

    public void setActualPickMonovalent(String actualPickMonovalent) {
        this.actualPickMonovalent = actualPickMonovalent;
    }

    public String getActualPickTotal() {
        return actualPickTotal;
    }

    public void setActualPickTotal(String actualPickTotal) {
        this.actualPickTotal = actualPickTotal;
    }

}

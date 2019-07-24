package com.cl.bean.req;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

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
    private String purchaseNo;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    private String purchaseStatus;

    /**
     * 采购日期 (录入实采时期)
     */
    private String purchaseTime;

    /**
     * 物料分类
     */
    private String materielType;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * ID
     */
    @NotNull(message = "请选择一条数据进行修改!")
    private Long id;

    /**
     * 实采数量
     */
    private String actualPickQuantity;

    /**
     * 实采单价
     */
    private String actualPickMonovalent;

    /**
     * 实采总额
     */
    private String actualPickTotal;

    /**
     * 采购耗时
     */
    private String consumingTime;

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

    public String getConsumingTime() {
        return consumingTime;
    }

    public void setConsumingTime(String consumingTime) {
        this.consumingTime = consumingTime;
    }
}

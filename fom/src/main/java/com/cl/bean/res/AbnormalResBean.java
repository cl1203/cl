package com.cl.bean.res;

import java.io.Serializable;
import java.math.BigDecimal;

public class AbnormalResBean implements Serializable {

	private static final long serialVersionUID = -7756634071781571910L;

	private String orderNo;                                 //订单号
	
	private String sku;                                     //SKU
	
	private String purchaseNo;                              //采购单编号
	
	private String materialColor;                           //物料颜色
	
	private BigDecimal answerPickMonovalent;                //应采单价
	
	private BigDecimal actualPickMonovalent;                //实采单价
	
	private Byte isApproval;                                //0:未审批 1: 已审批 
	
	private Integer answerCutQuantity;                      //应裁数
	
	private Integer actualCutQuantity;                      //实裁数
	
	private String tailorName;                             //裁剪人
	
	private String remark;                                  //备注

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Byte getIsApproval() {
		return isApproval;
	}

	public void setIsApproval(Byte isApproval) {
		this.isApproval = isApproval;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getMaterialColor() {
		return materialColor;
	}

	public void setMaterialColor(String materialColor) {
		this.materialColor = materialColor;
	}

	public BigDecimal getAnswerPickMonovalent() {
		return answerPickMonovalent;
	}

	public void setAnswerPickMonovalent(BigDecimal answerPickMonovalent) {
		this.answerPickMonovalent = answerPickMonovalent;
	}

	public BigDecimal getActualPickMonovalent() {
		return actualPickMonovalent;
	}

	public void setActualPickMonovalent(BigDecimal actualPickMonovalent) {
		this.actualPickMonovalent = actualPickMonovalent;
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

	public String getTailorName() {
		return tailorName;
	}

	public void setTailorName(String tailorName) {
		this.tailorName = tailorName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

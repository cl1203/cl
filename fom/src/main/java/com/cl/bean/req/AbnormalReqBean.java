package com.cl.bean.req;

import java.io.Serializable;

public class AbnormalReqBean implements Serializable {

	private static final long serialVersionUID = 6561475849819140222L;

	private String orderNo;                          //订单号
	
	private String purchaseNo;                       //采购单号
	
	private Byte queryType;                          //查询类型 1:查询采购异常 2:查询裁剪异常
	
	private Byte approvalStatus;                     //审批状态 0:未审批 1:审批
	
	private String remark;                           //备注
	
	private Integer pageNum;

	private Integer pageSize;
	
	private Integer offset;
	
	private Integer limit;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Byte getQueryType() {
		return queryType;
	}

	public void setQueryType(Byte queryType) {
		this.queryType = queryType;
	}

	public Byte getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(Byte approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
}

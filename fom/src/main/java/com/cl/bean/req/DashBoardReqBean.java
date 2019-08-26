package com.cl.bean.req;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class DashBoardReqBean implements Serializable {

	private static final long serialVersionUID = 2274018417274330897L;

	@ApiModelProperty(value = "订单编号")
	private String orderNo;                   //订单编号

	@ApiModelProperty(value = "生产方")
	private String producer;                  //生产方
	
	@ApiModelProperty(value = "生产方组织ID")
	private Long producerOrgId;               //生产方组织ID
	
	@ApiModelProperty(value = "状态 1:采购 2:裁剪")
	private Byte status;                      //状态 1:采购 2:裁剪
	
	@ApiModelProperty(value = "开始日期")
	private String startDate;                 //开始日期
	
	@ApiModelProperty(value = "结束日期")
	private String endDate;                   //结束日期

	@ApiModelProperty(value = "状态列表")
	private List<Byte> statusList;            //状态列表
	
	@ApiModelProperty(value = "每页查询条数")
	private Integer pageSize;                 //每页查询条数

	@ApiModelProperty(value = "页数")
	private Integer pageNum;                  //页数
	
	@ApiModelProperty(value = "订单备注")
	private String remark;                    //订单备注
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

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

	public Long getProducerOrgId() {
		return producerOrgId;
	}

	public void setProducerOrgId(Long producerOrgId) {
		this.producerOrgId = producerOrgId;
	}

	public List<Byte> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Byte> statusList) {
		this.statusList = statusList;
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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}
	
}

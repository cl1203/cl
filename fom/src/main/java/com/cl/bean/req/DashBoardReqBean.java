package com.cl.bean.req;

import java.io.Serializable;
import java.util.List;

public class DashBoardReqBean implements Serializable {

	private static final long serialVersionUID = 2274018417274330897L;

	private String producer;                  //生产方
	
	private Long producerOrgId;               //生产方组织ID
	
	private Byte status;                      //状态 1:采购 2:裁剪
	
	private String startDate;                 //开始日期
	
	private String endDate;                   //结束日期

	private List<Byte> statusList;            //状态列表
	
	private Integer pageSize;                 //每页查询条数

	private Integer pageNum;                  //页数
	
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

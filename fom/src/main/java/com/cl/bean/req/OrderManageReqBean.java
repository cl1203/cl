package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单  reqBean
 * @author xujun
 *
 */
public class OrderManageReqBean implements Serializable{

	private static final long serialVersionUID = -4724511412507249707L;

	 /**
     * 订单编号
     */
     @ApiModelProperty(value = "订单号")
	 private String orderNo;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
	@ApiModelProperty(value = "订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪")
    private List<Byte> orderStatusList;

	 /**
	 * 生产方
	 */
	@ApiModelProperty(value = "生产方")
	private String producer;

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
     * SKU
     */
    @ApiModelProperty(value = "sku")
    private String sku;

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

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public List<Byte> getOrderStatusList() {
		return orderStatusList;
	}

	public void setOrderStatusList(List<Byte> orderStatusList) {
		this.orderStatusList = orderStatusList;
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

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
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
}

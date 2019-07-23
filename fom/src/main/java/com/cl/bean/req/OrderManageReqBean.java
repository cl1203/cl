package com.cl.bean.req;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

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
    private String orderNumber;

    /**
     * 订单状态1:待采购 2:采购中 3:待裁剪 4:已裁剪
     */
    private String orderStatus;
    
    /**
     * 下单时间
     */
    private String orderTime;
    
    /**
     * SKU
     */
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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

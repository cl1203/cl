package com.cl.bean.req;

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
    private Byte orderStatus;
    
    /**
     * 下单时间
     */
    private Date orderTime;
    
    /**
     * SKU
     */
    private String sku;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
    
    
}

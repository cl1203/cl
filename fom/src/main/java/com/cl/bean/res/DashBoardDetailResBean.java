package com.cl.bean.res;

import java.io.Serializable;

public class DashBoardDetailResBean implements Serializable {

	private static final long serialVersionUID = 7743887686318708203L;

	private String orderNo;                            //订单编号
	
	private String sku;                                //SKU编号
	
	private Integer tailorQuantity;                    //裁剪数量
	
	private String orderDate;                          //下单日期
	
	private Integer deliveryDay;                       //剩余或超期天数
	
	private Integer deliveryHour;                      //剩余或超期小时数
	
	private Byte isExceed;                             //是否超期
	
	private String remark;                             //备注

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Integer getTailorQuantity() {
		return tailorQuantity;
	}

	public void setTailorQuantity(Integer tailorQuantity) {
		this.tailorQuantity = tailorQuantity;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getDeliveryDay() {
		return deliveryDay;
	}

	public void setDeliveryDay(Integer deliveryDay) {
		this.deliveryDay = deliveryDay;
	}

	public Integer getDeliveryHour() {
		return deliveryHour;
	}

	public void setDeliveryHour(Integer deliveryHour) {
		this.deliveryHour = deliveryHour;
	}

	public Byte getIsExceed() {
		return isExceed;
	}

	public void setIsExceed(Byte isExceed) {
		this.isExceed = isExceed;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

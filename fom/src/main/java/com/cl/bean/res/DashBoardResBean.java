package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

public class DashBoardResBean implements Serializable {

	private static final long serialVersionUID = -7130745986626062388L;

	private String date;                                //日期
	
	private String dayOfWeek;                           //星期
	
	private Integer orderQuantity;                      //订单数量
	
	private Integer tailorQuantity;                     //裁剪数量
	
	private List<DashBoardDetailResBean> detail;        //面板明细内容

	public List<DashBoardDetailResBean> getDetail() {
		return detail;
	}

	public void setDetail(List<DashBoardDetailResBean> detail) {
		this.detail = detail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getTailorQuantity() {
		return tailorQuantity;
	}

	public void setTailorQuantity(Integer tailorQuantity) {
		this.tailorQuantity = tailorQuantity;
	}
	
}

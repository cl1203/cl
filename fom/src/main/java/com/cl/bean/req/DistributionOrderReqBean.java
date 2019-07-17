package com.cl.bean.req;

import java.io.Serializable;
import java.util.List;

/**
 * 分单 reqBean
 * @author xujun
 *
 */
public class DistributionOrderReqBean implements Serializable {

	private static final long serialVersionUID = -747107573684171590L;
	
	/**
	 * 订单ID list
	 */
	private List<Long> orderIdList;

	private Long orgId;

	public List<Long> getOrderIdList() {
		return orderIdList;
	}

	public void setOrderIdList(List<Long> orderIdList) {
		this.orderIdList = orderIdList;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	
}

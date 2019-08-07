package com.cl.bean.req;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
	@NotEmpty(message = "请最少选择一条订单数据!")
	@ApiModelProperty(value = "订单ID集合")
	private List<Long> orderIdList;

	/**
	 * 组织ID
	 */
	@NotNull(message = "请选择一个生产方!")
	@ApiModelProperty(value = "组织ID")
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

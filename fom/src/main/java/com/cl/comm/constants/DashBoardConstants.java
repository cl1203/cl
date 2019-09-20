package com.cl.comm.constants;

public class DashBoardConstants {

	//请求参数状态：采购
	public static final Byte REQ_STATUS_PURCHASE = 1;
	
	//请求参数状态：裁剪
	public static final Byte REQ_STATUS_TAILOR = 2;
	
	//超期
	public static final Byte IS_EXCEED = 1;
	
	//未超期
	public static final Byte IS_NOT_EXCEED = 0;
	
	public static final String TODAY = "今天";
	
	public static final Integer REMARK_MAX_LENGTH = 128;
	
	//已审批
	public static final Byte REQ_IS_APPROVAL = 1;
	
	//未审批
	public static final Byte REQ_IS_NOT_APPROVAL = 0;
	
	//查询采购单异常
	public static final Byte QUERY_PURCHASE = 1;
	
	//查询裁减异常
	public static final Byte QUERY_TAILOR = 2;
	
	//默认订单数量
	public static final Integer DEFAULT_ORDER_QUANTITY = 0;
	
	//默认裁剪数量
	public static final Integer DEFAULT_TAILOR_QUANTITY = 0;
}

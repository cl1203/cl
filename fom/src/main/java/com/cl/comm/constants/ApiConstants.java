package com.cl.comm.constants;

public class ApiConstants {

	//订单状态：待采购
	public static final Byte ORDER_STATUS_WAIT_PURCHASE = 1;
	
	//订单状态：采购中
	public static final Byte ORDER_STATUS_PURCHASING = 2;
	
	//订单状态：待裁剪
	public static final Byte ORDER_STATUS_WAIT_TAILOR = 3;
	
	//采购状态：待采购
	public static final Byte PURCHASE_STATUS_WAITING_PURCHASE = 1;
	
	public static final String DATE_REG = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$";

    public static final String DATETIME_REG = "^((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[13579][26])00))-02-29))\\s+([0-1]?[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$";

    public static final Integer ZERO = 0;
    
    public static final String INF_IS_FIRST = "首";
    
    public static final String API_USER = "SYSTEM_INTERFACE";
    
    public static final Byte INTERFACE_SAVE_SUCCESS = 1;
    
    public static final Byte INTERFACE_SAVE_FAILED = 0;
    
    public static final String PULL_ORDER_TIME_CODE = "pull_order_time";
    
    public static final Integer DEFAULT_STOCK = 0;
    
    public static final Integer DEFAULT_PAGE_NUM = 1;
    
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    
    public static final Integer DEFAULT_OFFSET = 0;
    
    public static final Integer PAGE_SIZE_ONE = 1;
}

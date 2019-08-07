package com.cl.comm.model;

public enum Status {

	//1开头的是公用的错误信息
	INSERT_FAILED(10000, "insert failed"),
    UPDATE_FAILED(10001, "update failed"),
    NOT_VALID_PARAMS(10002, "Not Valid Params"),
    
	//2开头的是外部接口的错误信息
	EXISTS_ORDER_QUANTITY(20001,"exists order quantity"),
	EXISTS_PURCHASE(20002,"exists order quantity"),
	NOT_EXISTS_STOCK(20003,"库存不存在！"),
	DUPLICATE_STOCK(20004,"库存重复！");
	
	private Integer code;
    private String errMsg;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
    
	private Status(Integer code,String errMsg) {
		this.code = code;
		this.errMsg = errMsg;
	}
}

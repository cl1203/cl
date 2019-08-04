package com.cl.comm.model;

public enum Status {

	INSERT_FAILED(10000, "insert failed"),
    UPDATE_FAILED(10001, "update failed"),
    NOT_VALID_PARAMS(40005, "Not Valid Params");
    
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

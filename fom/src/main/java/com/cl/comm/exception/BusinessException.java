package com.cl.comm.exception;

import org.springframework.http.HttpStatus;

import com.cl.comm.model.ResponseBeanModel;
import com.cl.comm.model.Status;

/**
 * @ClassName BusinessException
 * @Description 业务异常类
 * 遇见异常在Service层抛出即可，Controller层无需捕获。
 * 可以被全局异常处理器OmExceptionHandler捕获。
 * 同时把code，message自动包装进基础响应体{@link ResponseBeanModel}返回给前台
 * Spring事务管理默认根据{@link RuntimeException}回滚，因此Transactional注解属性无需写 rollbackFor 也会触发事务回滚
 * @Author 陈龙
 * @Date 2019/6/26 10:15
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 6548667761484428792L;
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 基础构造器，使用Spring内置的{@link HttpStatus}作为参数。
     *
     * @param httpStatus httpStatus
     */
    public BusinessException(HttpStatus httpStatus) {
        super(httpStatus.getReasonPhrase());
        this.code = httpStatus.value();
    }
    
    public BusinessException(Status status) {
    	super(status.getErrMsg());
        this.code = status.getCode();
	}

    public BusinessException(String message){
        super(message);
    }

    /**
     * 当{@link HttpStatus}都无法覆盖业务需求时，使用自定义的code和messge
     *
     * @param code    错误码
     * @param message 提示语
     */
    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

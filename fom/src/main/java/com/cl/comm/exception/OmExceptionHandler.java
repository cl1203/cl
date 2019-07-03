package com.cl.comm.exception;

import com.cl.comm.model.ResponseBeanModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @ClassName OmExceptionHandler
 * @Description 全局异常捕获类
 * @Author 陈龙
 * @Date 2019/6/28 14:41
 * @Version 1.0
 **/
@ControllerAdvice
public class OmExceptionHandler implements ApplicationContextAware {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseBeanModel<Void> errorApiHandler(HttpServletResponse response, Exception e) {
        e.printStackTrace();
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            if(null != businessException.getCode()){
                return new ResponseBeanModel<>(businessException.getCode() , businessException.getMessage());
            }
            return new ResponseBeanModel<>(INTERNAL_SERVER_ERROR.value() , businessException.getMessage());
        }
        if (e instanceof BindException) {
            response.setStatus(BAD_REQUEST.value());
            return getResponse(((BindException) e).getBindingResult());
        }
        if (e instanceof MethodArgumentNotValidException) {
            response.setStatus(BAD_REQUEST.value());
            return getResponse(((MethodArgumentNotValidException) e).getBindingResult());
        }
        return new ResponseBeanModel<>(INTERNAL_SERVER_ERROR.value(),  e.getMessage());
    }

    private ResponseBeanModel<Void> getResponse(BindingResult result) {
        List<FieldError> errors = result.getFieldErrors();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < errors.size() - 1; i++) {
            stringBuilder.append(errors.get(i).getDefaultMessage()).append(" ");
        }
        stringBuilder.append(errors.get(errors.size() - 1).getDefaultMessage());
        return new ResponseBeanModel<>(BAD_REQUEST.value(), stringBuilder.toString());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
}

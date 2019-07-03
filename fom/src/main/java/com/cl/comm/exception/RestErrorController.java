package com.cl.comm.exception;

import com.cl.comm.model.ResponseBeanModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常处理器
 * @Author 陈龙
 * @Date 2019/6/26 10:49
 * @Version 1.0
 **/
@RestController
public class RestErrorController implements ErrorController {
    private static final String ERROR_PATH = "/error";
    private final ErrorAttributes errorAttributes;

    @Autowired
    public RestErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(ERROR_PATH)
    public ResponseBeanModel<Void> handleError(HttpServletRequest request, HttpServletResponse response) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String, Object> errorAttributes = this.errorAttributes.getErrorAttributes(webRequest, false);
        HttpStatus status = getStatus(request);
        response.setStatus(status.value());
        Object error = errorAttributes.get("error");
        if (error != null && !"None".equals(error.toString())) {
            return new ResponseBeanModel<>(status.value(), error.toString());
        }
        return new ResponseBeanModel<>(status.value(), String.valueOf(errorAttributes.getOrDefault("message", "error")));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return INTERNAL_SERVER_ERROR;
        }
        try {
            return HttpStatus.valueOf(statusCode);
        } catch (Exception e) {
            return INTERNAL_SERVER_ERROR;
        }
    }
}

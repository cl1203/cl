package com.cl.aop;

import com.alibaba.fastjson.JSON;
import com.cl.comm.constants.CommonConstants;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.model.RequestBeanModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName LoggerAdvice
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 20:21
 * @Version 1.0
 * 在类上使用 @Component 注解 把切面类加入到IOC容器中
 * 使用@Aspect注解将一个java类定义为切面类
 * 使用@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
 * 使用@Before在切入点开始处切入内容
 * 使用@After在切入点结尾处切入内容
 * 使用@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
 * 使用@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 * 使用@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 * 使用ThreadLocal对象来记录请求处理的时间（直接在使用基本类型会有同步问题，所以我们可以引入ThreadLocal对象）
 **/
@Aspect
@Component
public class LoggerAdvice {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoggerAdvice.class);
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    private void getReqBean(JoinPoint joinPoint){
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        RequestBeanModel requestBeanModel = new RequestBeanModel();
        if(obj.length > DictionaryConstants.ALL_BUSINESS_ZERO){
            for(Object object : obj){
                requestBeanModel = (RequestBeanModel) object;
            }
            LOGGER.info("登录用户为: " + requestBeanModel.getUsername());
        }

    }

    @Before("within(com.cl..*) && @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        this.getReqBean(joinPoint);
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        LOGGER.info("执行--" + loggerManage.description() + "--开始");
        LOGGER.info("请求Url:" + request.getRequestURL().toString());
        startTime.set(System.currentTimeMillis());
        LOGGER.info("方法名为:[{}]", joinPoint.getSignature().toString());
        LOGGER.info("传入参数为:\n{}",parseParames(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "within(com.cl..*) && @annotation(loggerManage)", returning = "result")
    public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage, Object result) {
        this.getReqBean(joinPoint);
        LOGGER.info("执行--" + loggerManage.description() + "--结束");
        LOGGER.debug("执行结果为:\n{}", JSON.toJSONString(result, CommonConstants.FEATURES));
        LOGGER.info("执行时间--" + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(pointcut = "within(com.cl..*) && @annotation(loggerManage)", throwing = "e")
    public void addAfterThrowingLogger(JoinPoint joinPoint, LoggerManage loggerManage, Exception e) {
        this.getReqBean(joinPoint);
        LOGGER.error("执行:[{}]发生异常:{}", loggerManage.description(), e.getMessage());
    }

    private String parseParames(Object[] parames) {
        if (null == parames || parames.length <= 0) {
            return "";
        }
        StringBuffer param = new StringBuffer("参数--");
        for (Object obj : parames) {
            String va = ToStringBuilder.reflectionToString(obj);
            param.append(va).append("  ");
        }
        return param.toString();
    }
}

package com.cl.aop;

import com.alibaba.fastjson.JSON;
import com.cl.comm.constants.CommonConstants;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName LoggerAdvice
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 20:21
 * @Version 1.0
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

    @Before("within(com.cl..*) && @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        LOGGER.info("执行--" + loggerManage.description() + "--开始");
        startTime.set(System.currentTimeMillis());
        LOGGER.info("方法名为:[{}]", joinPoint.getSignature().toString());
        LOGGER.info("传入参数为:\n{}",parseParames(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "within(com.cl..*) && @annotation(loggerManage)", returning = "result")
    public void addAfterReturningLogger(LoggerManage loggerManage, Object result) {
        LOGGER.info("执行--" + loggerManage.description() + "--结束");
        LOGGER.debug("执行结果为:\n{}", JSON.toJSONString(result, CommonConstants.FEATURES));
        LOGGER.info("执行时间--" + (System.currentTimeMillis() - startTime.get()));
    }

    @AfterThrowing(pointcut = "within(com.cl..*) && @annotation(loggerManage)", throwing = "e")
    public void addAfterThrowingLogger(LoggerManage loggerManage, Exception e) {
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

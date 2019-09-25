package com.cl.aop;

import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.TokenInfo;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysUserEntity;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
public class TokenAdvice {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(TokenAdvice.class);

    @Resource
    private SysUserMapper sysUserMapper;

    //不需要登录就可以访问的路径(比如:登录等)
    private String[] includeUrls = new String[]{
            "/fom/user/login"
    };

    @Before("within(com.cl.controller.*)")
    public void addBeforeLogger(JoinPoint joinPoint){
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        RequestBeanModel requestBeanModel = new RequestBeanModel();
        if(obj.length > DictionaryConstants.ALL_BUSINESS_ZERO){
            for(Object object : obj){
                requestBeanModel = (RequestBeanModel) object;
            }
            LOGGER.info("登录用户为: " + requestBeanModel.getUsername());
        }
        String url = request.getRequestURL().toString();
        int i = this.getIndex(url);
        url = url.substring(i);
        //是否需要过滤
        boolean needFilter = isNeedFilter(url);
        if (!needFilter
                //|| url.startsWith("/fom/webjars/")
                ) { //不需要过滤直接传给下一个过滤器
        } else {
            String userName = requestBeanModel.getUsername();
            if(StringUtils.isBlank(userName)){
                throw new BusinessException(DictionaryConstants.failCode,"userName为空, 请求失败!");
            }
            //获取当前令牌
            String token = requestBeanModel.getToken();
            if(StringUtils.isBlank(token)){
                throw new BusinessException(DictionaryConstants.failCode,"token为空, 请求失败!");
            }
            //当前用户id
            String userId = requestBeanModel.getUserId();
            if(StringUtils.isBlank(userId)){
                throw new BusinessException(DictionaryConstants.failCode,"userId为空, 请求失败!");
            }else{
                String userIdRegexp = "^[1-9][0-9]{0,8}$";
                if(match(userIdRegexp , userId)) {
                    throw new BusinessException("userId规则: 必须是整数在0-999999999之间! ");
                }
                SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(userId));
                if(null == sysUserEntity){
                    throw new BusinessException(DictionaryConstants.failCode,"userId对应的用户不存在, 请求失败!");
                }
            }
            LOGGER.info("token === {}",token);
            //如果token无效
            if (!checkToken(userId)){
                throw new BusinessException(DictionaryConstants.failCode,"token无效, 登陆失败!");
            }else{
                // 用户登录唯一检验
                LOGGER.info("current_userId === {}",userId);
                TokenInfo tokenInfo = DictionaryConstants.currentLoginTokenMap.get(userId);
                if (!token.equals(tokenInfo.getToken())){
                    throw new BusinessException(DictionaryConstants.failCode,"用户在其他地方登陆,请重新登录!");
                }
            }
        }
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return !matcher.matches();
    }

    /**
     * @Author: xxxxx
     * @Description: 是否需要过滤
     * @Date: 2018-03-12 13:20:54
     * @param url
     */
    public boolean isNeedFilter(String url) {
        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(url)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验当前token是否有效
     * @param userId
     * @return
     */
    private boolean checkToken(String userId){
        TokenInfo tokenInfo = DictionaryConstants.currentLoginTokenMap.get(userId);
        if(null == tokenInfo){
            throw new BusinessException(DictionaryConstants.failCode,"请求异常,请重新登录!");
        }
        long tokenTime = tokenInfo.getDate();
        if ((System.currentTimeMillis() - tokenTime) > DictionaryConstants.loginUserfulTime){
            throw new BusinessException(DictionaryConstants.failCode,"登录超时,请重新登录!");
        }
        //检验通过 , 更新时间
        tokenInfo.setDate(System.currentTimeMillis());
        return true;
    }


    public int getIndex(String url) {
        //这里是获取"/"符号第三次出现的下标
        Matcher slashMatcher = Pattern.compile("/").matcher(url);
        int i = 3;
        int mIdx = 0;
        while (slashMatcher.find()) {
            mIdx++;
            //当"/"符号第三次出现的位置
            if (mIdx == i) {
                break;
            }
        }
        return slashMatcher.start();
    }
}

package com.cl.service.impl;

import com.cl.bean.req.LoginReqBean;
import com.cl.bean.res.LoginResBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.model.TokenInfo;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysUserEntity;
import com.cl.entity.SysUserEntityExample;
import com.cl.service.ILoginService;
import com.cl.service.IPulldownMenuService;
import com.cl.utils.MD5Util;
import com.cl.utils.UUIDUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录实现类
 * @Author 陈龙
 * @Date 2019/7/20 21:02
 * @Version 1.0
 **/
@Service
@Transactional
public class LoginServiceImpl implements ILoginService{

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private IObjectTransformer<SysUserEntity , SysUserResBean> sysUserTransform;

    @Override
    public LoginResBean login(RequestBeanModel<LoginReqBean> reqBeanModel) {
        LoginResBean loginResBean = new LoginResBean();
        LoginReqBean loginReqBean = reqBeanModel.getReqData();
        List<SysUserEntity> sysUserEntityList = this.checkUser(loginReqBean);

        SysUserEntity sysUserEntity = sysUserEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
        SysUserResBean sysUserResBean = this.sysUserTransform.transform(sysUserEntity);
        List<SysPermissionResBean> sysPermissionResBeanList = this.sysUserMapper.selectPermissionListByUserId(sysUserEntity.getId());
        this.pulldownMenuService.queryPermissionByParentId(sysPermissionResBeanList);
        loginResBean.setSysUserResBean(sysUserResBean);
        loginResBean.setSysPermissionResBeanList(sysPermissionResBeanList);
        String token = UUIDUtil.getUUID();
        // token存入缓存中
        String userId = sysUserEntity.getId().toString();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setDate(System.currentTimeMillis());
        tokenInfo.setToken(token);
        DictionaryConstants.currentLoginTokenMap.put(userId,tokenInfo);
        loginResBean.setToken(token);
        return loginResBean;
    }

    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void updatePassword(RequestBeanModel<LoginReqBean> reqBeanModel) {
        LoginReqBean loginReqBean = reqBeanModel.getReqData();
        List<SysUserEntity> sysUserEntityList = this.checkUser(loginReqBean);
        String newPassword = loginReqBean.getNewPassword();
        Assert.hasText(newPassword , "新密码不能为空!");
        /*int j = newPassword.length();
        if(!(newPassword.length() >= DictionaryConstants.PASSWORD_MIN && newPassword.length() <= DictionaryConstants.PASSWORD_MAX)){
            throw new BusinessException("新密码长度必须在8-20之间!");
        }*/
        boolean flag = this.pulldownMenuService.checkBlankSpace(newPassword);
        Assert.isTrue(flag , "新密码不能包含空格!");
        String regex = "^[a-z0-9A-Z]+$";
        if(!match(regex , loginReqBean.getNewPassword())) {
            throw new BusinessException("密码格式规则: 必须只能包含数字和字母! ");
        }
        newPassword = MD5Util.getInstance().encryptBySalt(newPassword);
        SysUserEntity sysUserEntity = sysUserEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
        sysUserEntity.setPassword(newPassword);
        Integer i = this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "修改密码失败!");
    }

    /**
     * 验证用户的用户名和密码
     * @param loginReqBean
     * @return
     */
    private List<SysUserEntity> checkUser(LoginReqBean loginReqBean){
        String userName = loginReqBean.getUserName();
        String password = loginReqBean.getPassword();
        SysUserEntityExample sysUserEntityExample = new SysUserEntityExample();
        SysUserEntityExample.Criteria criteria = sysUserEntityExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<SysUserEntity> sysUserEntityList = this.sysUserMapper.selectByExample(sysUserEntityExample);
        Assert.notEmpty(sysUserEntityList , "该用户名不存在!");
        SysUserEntity sysUserEntity = sysUserEntityList.get(DictionaryConstants.ALL_BUSINESS_ZERO);
        String pwdInDb = sysUserEntity.getPassword();
        password = MD5Util.getInstance().encryptBySalt(password);
        boolean flag = password.equals(pwdInDb);
        Assert.isTrue(flag , "用户名和密码不匹配!");
        return  sysUserEntityList;
    }
}

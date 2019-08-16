package com.cl.service;

import com.cl.bean.req.LoginReqBean;
import com.cl.bean.res.LoginResBean;
import com.cl.comm.model.RequestBeanModel;

/**
 * @ClassName ILoginService
 * @Description 登录 修改密码等接口service
 * @Author 陈龙
 * @Date 2019/7/17 15:16
 * @Version 1.0
 **/
public interface ILoginService {

    /**
     * @Author 陈龙
     * @Description 登录
     * @Date 14:50 2019/8/16
     * @Param [reqBeanModel]
     * @return com.cl.bean.res.LoginResBean
     **/
    LoginResBean login(RequestBeanModel<LoginReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改密码
     * @Date 14:50 2019/8/16
     * @Param [reqBeanModel]
     * @return void
     **/
    void updatePassword(RequestBeanModel<LoginReqBean> reqBeanModel);

}

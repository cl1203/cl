package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.LoginReqBean;
import com.cl.bean.res.LoginResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName LoginController
 * @Description 登录 修改密码等接口
 * @Author 陈龙
 * @Date 2019/7/17 14:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(description = "登录,修改密码等接口")
public class LoginController {

    @Resource
    private ILoginService loginService;

    /**
     * @Author 陈龙
     * @Description 登录
     * @Date 14:50 2019/8/16
     * @Param [reqBeanModel]
     * @return com.cl.bean.res.LoginResBean
     **/
    @PostMapping("/login")
    @ApiOperation(value = "登录" , notes = "用户登录")
    @LoggerManage(description = "用户登录")
    public ResponseBeanModel<LoginResBean> login(@RequestBody @Valid RequestBeanModel<LoginReqBean> reqBeanModel){
        LoginResBean loginResBean = this.loginService.login(reqBeanModel);
        return new ResponseBeanModel<>(loginResBean);
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码" , notes = "用户修改密码!")
    @LoggerManage(description = "用户修改密码")
    public ResponseBeanModel<Void> updatePassword(@RequestBody @Valid RequestBeanModel<LoginReqBean> reqBeanModel){
        this.loginService.updatePassword(reqBeanModel);
        return new ResponseBeanModel<>("修改密码成功!");
    }

}

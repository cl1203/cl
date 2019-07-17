package com.cl.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

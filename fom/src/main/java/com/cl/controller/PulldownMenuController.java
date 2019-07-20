package com.cl.controller;

import com.cl.bean.req.DistributionOrderReqBean;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IPulldownMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PulldownMenuController
 * @Description 所有下拉菜单controller
 * @Author 陈龙
 * @Date 2019/7/20 18:49
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pulldown")
@CrossOrigin
@Api(description = "所有下拉菜单接口文档")
public class PulldownMenuController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private IPulldownMenuService pulldownMenuService;

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单
     * @Date 20:13 2019/7/20
     * @Param []
     * @return com.cl.comm.model.ResponseBeanModel<java.util.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryOrgPulldownMenu")
    @ApiOperation(value = "查询组织下拉菜单" , notes = "查询所有组织名称和ID")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryOrgPulldownMenu(){
        LOGGER.info("PulldownMenuController------queryOrgPulldownMenu  start......" );
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryOrgPulldownMenu();
        LOGGER.info("PulldownMenuController------queryOrgPulldownMenu  end......" );
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }


}

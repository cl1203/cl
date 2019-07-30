package com.cl.controller;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.ITailorService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName TailorController
 * @Description 裁剪controller
 * @Author 陈龙
 * @Date 2019/7/29 20:48
 * @Version 1.0
 **/
@RestController
@RequestMapping("/tailor")
@CrossOrigin
@Api(description = "裁剪接口文档")
public class TailorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TailorController.class);

    @Resource
    private ITailorService iTailorService;

    /**
     * @Author 陈龙
     * @Description 查询裁剪列表
     * @Date 21:00 2019/7/29
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.TailorResBean>
     **/
    @PostMapping("/queryTailorList")
    @ApiOperation(value = "查询裁剪列表" , notes = "查询裁剪列表")
    public ResponseBeanModel<PageInfo<TailorResBean>> queryTailorList(@RequestBody @Valid RequestBeanModel<TailorReqBean> reqBeanModel){
        LOGGER.info("TailorController------queryTailorList  start......" );
        PageInfo<TailorResBean> tailorResBeanPageInfo = this.iTailorService.queryTailorList(reqBeanModel);
        LOGGER.info("TailorController------queryTailorList  end......" );
        return new ResponseBeanModel<>(tailorResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 修改裁剪数据
     * @Date 21:12 2019/7/29
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/updateTailor")
    @ApiOperation(value = "修改裁剪数据" , notes = "修改裁剪数据")
    public ResponseBeanModel<Void> updateTailor(@RequestBody @Valid RequestBeanModel<TailorReqBean> reqBeanModel){
        LOGGER.info("TailorController------updateTailor  start......" );
        this.iTailorService.updateTailor(reqBeanModel);
        LOGGER.info("TailorController------updateTailor  end......" );
        return new ResponseBeanModel<>("修改成功!");
    }

}

package com.cl.controller;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IPurchaseService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @ClassName PurchaseController
 * @Description 采购controller
 * @Author 陈龙
 * @Date 2019/7/24 9:56
 * @Version 1.0
 **/
@RestController
@RequestMapping("/purchase")
@CrossOrigin
@Api(description = "采购接口文档")
public class PurchaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseController.class);

    @Resource
    private IPurchaseService iPurchaseService;

    /**
     * @Author 陈龙
     * @Description 采购列表查询
     * @Date 15:20 2019/7/24
     * @Param [reqBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<com.github.pagehelper.PageInfo<com.cl.bean.res.PurchaseResBean>>
     **/
    @PostMapping("/queryPurchaseList")
    @ApiOperation(value = "查询采购列表" , notes = "查询采购列表")
    public ResponseBeanModel<PageInfo<PurchaseResBean>> queryPurchaseList(@RequestBody @Valid RequestBeanModel<PurchaseReqBean> reqBeanModel){
        LOGGER.info("PurchaseController------queryPurchaseList  start......" );
        PageInfo<PurchaseResBean> purchaseResBeanPageInfo = this.iPurchaseService.queryPurchaseList(reqBeanModel);
        LOGGER.info("PurchaseController------queryPurchaseList  end......" );
        return new ResponseBeanModel<>(purchaseResBeanPageInfo);
    }

    /**
     * @Author 陈龙
     * @Description 修改采购单
     * @Date 15:15 2019/7/24
     * @Param [reqBeanModel]
     * @return void
     **/
    @PostMapping("/updatePurchase")
    @ApiOperation(value = "修改采购单" , notes = "修改采购单")
    public ResponseBeanModel<Void> updatePurchase(@RequestBody RequestBeanModel<PurchaseReqBean> reqBeanModel){
        LOGGER.info("PurchaseController------updatePurchase  start......" );
        this.iPurchaseService.updatePurchase(reqBeanModel);
        LOGGER.info("PurchaseController------updatePurchase  end......" );
        return new ResponseBeanModel<>("修改成功!");
    }


}

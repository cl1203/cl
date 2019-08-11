package com.cl.controller;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IPurchaseService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "查询采购列表" , notes = "根据条件查询采购列表")
    public ResponseBeanModel<PageInfo<PurchaseResBean>> queryPurchaseList(@RequestBody @Valid RequestBeanModel<PurchaseReqBean> reqBeanModel){
        PageInfo<PurchaseResBean> purchaseResBeanPageInfo = this.iPurchaseService.queryPurchaseList(reqBeanModel);
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
    @ApiOperation(value = "修改采购单" , notes = "根据条件修改采购单")
    public ResponseBeanModel<Void> updatePurchase(@RequestBody RequestBeanModel<PurchaseReqBean> reqBeanModel){
        this.iPurchaseService.updatePurchase(reqBeanModel);
        return new ResponseBeanModel<>("修改采购单成功!");
    }


}

package com.cl.controller;

import com.cl.bean.res.DictItem;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(PulldownMenuController.class);

    @Resource
    private IPulldownMenuService pulldownMenuService;

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单 或者根据条件查询
     * @Date 20:13 2019/7/20
     * @Param []
     * @return com.cl.comm.model.ResponseBeanModel<java.util.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryOrgPulldownMenu")
    @ApiOperation(value = "查询组织下拉菜单,或者根据条件查询" , notes = "查询所有组织下拉菜单,或者根据条件查询")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryOrgPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuResBean> requestBeanModel){
        LOGGER.info("PulldownMenuController------queryOrgPulldownMenu  start......" );
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryOrgPulldownMenu(requestBeanModel);
        LOGGER.info("PulldownMenuController------queryOrgPulldownMenu  end......" );
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 获取用户下拉菜单 或者根据条件查询
     * @Date 0:03 2019/7/30
     * @Param [requestBeanModel]
     * @return com.cl.comm.model.ResponseBeanModel<java.util.List<com.cl.bean.res.PulldownMenuResBean>>
     **/
    @PostMapping("/queryUserPulldownMenu")
    @ApiOperation(value = "查询用户下拉菜单,或者根据条件查询" , notes = "查询用户下拉菜单,或者根据条件查询")
    public ResponseBeanModel<List<PulldownMenuResBean>> queryUserPulldownMenu(@RequestBody RequestBeanModel<PulldownMenuResBean> requestBeanModel){
        LOGGER.info("PulldownMenuController------queryUserPulldownMenu  start......" );
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuService.queryUserPulldownMenu(requestBeanModel);
        LOGGER.info("PulldownMenuController------queryUserPulldownMenu  end......" );
        return new ResponseBeanModel<>(pulldownMenuResBeanList);
    }

    /**
     * @Author 陈龙
     * @Description 输入订单号的模糊查询
     * @Date 12:03 2019/7/22
     * @Param [orderNum]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/queryInputByOrderNumer")
    @ApiOperation(value = "查询订单号下拉菜单" , notes = "查询订单号下拉菜单")
    public ResponseBeanModel<List<String>> queryInputByOrderNumer(){
        LOGGER.info("PulldownMenuController------queryInputByOrderNumer  start......" );
        List<String> orderNumList = this.pulldownMenuService.queryInputByOrderNumer();
        LOGGER.info("PulldownMenuController------queryInputByOrderNumer  end......" );
        return new ResponseBeanModel<>(orderNumList);
    }

    /**
     * @Author 陈龙
     * @Description 输入sku的模糊查询
     * @Date 12:04 2019/7/22
     * @Param [sku]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/queryInputBySku")
    @ApiOperation(value = "查询SKU下拉菜单" , notes = "查询SKU下拉菜单")
    public ResponseBeanModel<List<String>> queryInputBySku(){
        LOGGER.info("PulldownMenuController------queryInputBySku  start......" );
        List<String> orderNumList = this.pulldownMenuService.queryInputBySku();
        LOGGER.info("PulldownMenuController------queryInputBySku  end......" );
        return new ResponseBeanModel<>(orderNumList);
    }

    /**
     * @Author 陈龙
     * @Description 查询采购单号下拉菜单
     * @Date 12:04 2019/7/22
     * @Param [PurchaseNumber]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/queryInputByPurchaseNumber")
    @ApiOperation(value = "查询采购单号下拉菜单" , notes = "查询采购单号下拉菜单")
    public ResponseBeanModel<List<String>> queryInputByPurchaseNumber(){
        LOGGER.info("PulldownMenuController------queryInputByPurchaseNumber  start......" );
        List<String> orderNumList = this.pulldownMenuService.queryInputByPurchaseNumber();
        LOGGER.info("PulldownMenuController------queryInputByPurchaseNumber  end......" );
        return new ResponseBeanModel<>(orderNumList);
    }

    /**
     * @Author 陈龙
     * @Description 查询供应商名称下拉菜单
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/queryInputSupplierName")
    @ApiOperation(value = "查询供应商名称下拉菜单" , notes = "查询供应商名称下拉菜单")
    public ResponseBeanModel<List<String>> queryInputSupplierName(){
        LOGGER.info("PulldownMenuController------queryInputSupplierName  start......" );
        List<String> orderNumList = this.pulldownMenuService.queryInputSupplierName();
        LOGGER.info("PulldownMenuController------queryInputSupplierName  end......" );
        return new ResponseBeanModel<>(orderNumList);
    }


    /**
     * @Author 陈龙
     * @Description 查询字典表数据
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/queryDictItemList")
    @ApiOperation(value = "查询字典表数据(订单状态:order_status, 采购状态:purchase_status , 裁剪状态:tailoring_status , 物料分类:materiel_type)" , notes = "查询字典表数据")
    public ResponseBeanModel<List<DictItem>> queryDictItemList(@RequestBody  RequestBeanModel<DictItem> requestBeanModel){
        LOGGER.info("PulldownMenuController------queryDictItemList  start......" );
        List<DictItem> dictItemList = this.pulldownMenuService.queryDictItemList(requestBeanModel);
        LOGGER.info("PulldownMenuController------queryDictItemList  end......" );
        return new ResponseBeanModel<>(dictItemList);
    }
}

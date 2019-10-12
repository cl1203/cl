package com.cl.controller;

import com.cl.aop.LoggerManage;
import com.cl.bean.req.FinanceReqBean;
import com.cl.bean.res.FinanceResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.ResponseBeanModel;
import com.cl.service.IFinanceService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/finance")
@CrossOrigin
@Api(description = "财务管理接口文档")
public class FinanceController {

    @Resource
    private IFinanceService financeService;

    @PostMapping("/queryFinanceList")
    @ApiOperation(value = "查询财务列表" , notes = "根据条件查询列表")
    @LoggerManage(description = "查询财务列表")
    public ResponseBeanModel<PageInfo<FinanceResBean>> queryFinanceList(@RequestBody @Valid RequestBeanModel<FinanceReqBean> reqBeanModel){
        PageInfo<FinanceResBean> financeResBeanPageInfo = this.financeService.queryFinanceList(reqBeanModel);
        return new ResponseBeanModel<>(financeResBeanPageInfo);
    }

    /*@PostMapping("/insertFinance")
    @ApiOperation(value = "新增财务数据" , notes = "新增财务数据")
    @LoggerManage(description = "新增财务数据")
    public ResponseBeanModel<Void> insertFinance(@RequestBody RequestBeanModel<FinanceReqBean> reqBeanModel){
        this.financeService.insertFinance(reqBeanModel);
        return new ResponseBeanModel<>("新增财务数据成功!");
    }*/

    @PostMapping("/updateFinance")
    @ApiOperation(value = "编辑财务数据" , notes = "编辑财务数据")
    @LoggerManage(description = "编辑财务数据")
    public ResponseBeanModel<Void> updateFinance(@RequestBody RequestBeanModel<FinanceReqBean> reqBeanModel){
        this.financeService.updateFinance(reqBeanModel);
        return new ResponseBeanModel<>("修改财务数据成功!");
    }

    /**
     * @Author 陈龙
     * @Description 导出
     * @Date 21:12 2019/7/29
     * @Param [reqBeanModel]
     * @return void
     **/
    @GetMapping("/exportFinance")
    @ApiOperation(value = "导出裁剪财务数据" , notes = "根据条件导出财务数据")
    public void exportFinance(HttpServletResponse response , FinanceReqBean financeReqBean , @RequestParam String userId)throws IOException {
        this.financeService.exportFinance(response ,financeReqBean , userId);
    }
}

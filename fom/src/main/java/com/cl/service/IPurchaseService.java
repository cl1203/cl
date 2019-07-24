package com.cl.service;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.model.RequestBeanModel;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName IPurchaseService
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/7/24 15:12
 * @Version 1.0
 **/
public interface IPurchaseService  {

    /**
     * @Author 陈龙
     * @Description 采购列表查询
     * @Date 15:15 2019/7/24
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.PurchaseResBean>
     **/
    PageInfo<PurchaseResBean> queryPurchaseList(RequestBeanModel<PurchaseReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改采购单
     * @Date 15:15 2019/7/24
     * @Param [reqBeanModel]
     * @return void
     **/
    void updatePurchase(RequestBeanModel<PurchaseReqBean> reqBeanModel);
}

package com.cl.service;

import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;

import java.util.List;

/**
 * @ClassName IPulldownMenuService
 * @Description 获取下拉菜单service
 * @Author 陈龙
 * @Date 2019/7/20 18:53
 * @Version 1.0
 **/
public interface IPulldownMenuService {

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单 或者根据条件查询
     * @Date 20:14 2019/7/20
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryOrgPulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel);

    /**
     *  获取用户下拉菜单 或者根据条件查询
     * @param requestBeanModel
     * @return
     */
    List<PulldownMenuResBean> queryUserPulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel);

    /**
     * @Author 陈龙
     * @Description 订单号的下拉菜单
     * @Date 12:03 2019/7/22
     * @Param [orderNum]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputByOrderNumer();

    /**
     * @Author 陈龙
     * @Description sku的下拉菜单
     * @Date 12:04 2019/7/22
     * @Param [sku]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputBySku();

    /**
     * @Author 陈龙
     * @Description 采购单号的下拉菜单
     * @Date 12:04 2019/7/22
     * @Param [PurchaseNumber]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputByPurchaseNumber();

    /**
     * @Author 陈龙
     * @Description 供应商名称的下拉菜单
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputSupplierName();

    /**
     * @Author 陈龙
     * @Description 字典表数据查询
     * @Date 15:56 2019/7/24
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    List<DictItem> queryDictItemList(RequestBeanModel<DictItem> requestBeanModel);
}

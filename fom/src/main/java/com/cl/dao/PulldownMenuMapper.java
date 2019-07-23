package com.cl.dao;

import com.cl.bean.res.PulldownMenuResBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName PulldownMenuMapper
 * @Description 获取下拉菜单dao
 * @Author 陈龙
 * @Date 2019/7/20 19:16
 * @Version 1.0
 **/
@Repository
public interface PulldownMenuMapper {

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单
     * @Date 14:16 2019/7/22
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryOrgPulldownMenu();

    /**
     * @Author 陈龙
     * @Description 查询订单编号下拉菜单
     * @Date 14:17 2019/7/22
     * @Param [orderNum]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputByOrderNumer();

    /**
     * @Author 陈龙
     * @Description 查询SKU下拉菜单
     * @Date 14:18 2019/7/22
     * @Param [sku]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputBySku();

    /**
     * @Author 陈龙
     * @Description 查询采购单号下拉菜单
     * @Date 14:20 2019/7/22
     * @Param [purchaseNumber]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputByPurchaseNumber();

    /**
     * @Author 陈龙
     * @Description 查询供应商名称下拉菜单
     * @Date 14:20 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputSupplierName();
}

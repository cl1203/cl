package com.cl.dao;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * PurchaseMapper继承基类
 */
@Repository
public interface PurchaseMapper extends MyBatisBaseDao<PurchaseEntity, Long, PurchaseEntityExample> {

    /**
     * 查询采购列表
     * @param purchaseReqBean
     * @return
     */
    List<PurchaseEntity> selectPurchaseList(PurchaseReqBean purchaseReqBean);

    /**
     * 查询不同状态的采购单数量
     * @param orderNo
     * @return
     */
    Integer selectPurchaseNumByOrderNo(@Param("orderNo") String orderNo ,@Param("isAll") Byte isAll );


    /**
     * 修改订单对应的所有采购单状态
     * @param orderNo
     * @return
     */
    Integer updatePurchaseStatusByOrderNo(String orderNo);

    /**
     * 根据订单号查询下单时间
     * @param orderNo
     * @return
     */
    OrderManageEntity selectOrder(String orderNo);

    /**
     * 根据订单号查询物料分类为面料的采购单
      * @param orderNo
     * @return
     */
    PurchaseEntity selectPurchaseListByOrderNo(String orderNo);

    /**
     * 根据sku查询最近一次的裁剪数据
     * @param sku
     * @return
     */
    BigDecimal selectTailorBySku(String sku);
}
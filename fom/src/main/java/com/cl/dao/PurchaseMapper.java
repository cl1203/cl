package com.cl.dao;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.PurchaseEntity;
import com.cl.entity.PurchaseEntityExample;
import com.cl.entity.TailorEntity;
import com.cl.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
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

    default PageInfo<PurchaseEntity> selectPurchasePageInfo(PurchaseReqBean purchaseReqBean){
        Page<PurchaseEntity> page = PageHelper.startPage(purchaseReqBean.getPageNum() , purchaseReqBean.getPageSize() , "last_update_time DESC");
        PurchaseEntityExample purchaseEntityExample = new PurchaseEntityExample();
        PurchaseEntityExample.Criteria criteria = purchaseEntityExample.createCriteria();
        List<Byte> statusList = new ArrayList<>();
        statusList.add(DictionaryConstants.ORDER_STATUS_WAIT_PURCHASE);
        statusList.add(DictionaryConstants.ORDER_STATUS_ALREADY_PURCHASE);
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseNo())){
            criteria.andPurchaseNoEqualTo(purchaseReqBean.getPurchaseNo());
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseStatus())){
            criteria.andPurchaseStatusEqualTo(Byte.valueOf(purchaseReqBean.getPurchaseStatus()));
        }else{
            criteria.andPurchaseStatusIn(statusList);
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseTime())){
            criteria.andPurchaseTimeEqualTo(DateUtils.getDateToString(purchaseReqBean.getPurchaseTime() , DateUtils.DATESHOWFORMAT));
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getMaterielType())){
            criteria.andMaterielTypeCodeEqualTo(purchaseReqBean.getMaterielType());
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getSupplierName())){
            criteria.andSupplierNameEqualTo(purchaseReqBean.getSupplierName());
        }
        List<PurchaseEntity> purchaseEntityList = this.selectByExample(purchaseEntityExample);
        PageInfo<PurchaseEntity> pageInfo = new PageInfo<>(page);
        pageInfo.setList(purchaseEntityList);
        return pageInfo;
    }

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
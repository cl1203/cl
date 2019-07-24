package com.cl.dao;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.entity.PurchaseEntity;
import com.cl.entity.PurchaseEntityExample;
import com.cl.util.DateUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

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
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseNo())){
            criteria.andPurchaseNoEqualTo(purchaseReqBean.getPurchaseNo());
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseStatus())){
            criteria.andPurchaseStatusEqualTo(Byte.valueOf(purchaseReqBean.getPurchaseStatus()));
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getPurchaseTime())){
            criteria.andPurchaseTimeEqualTo(DateUtils.getDateToString(purchaseReqBean.getPurchaseTime() , DateUtils.DATESHOWFORMAT));
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getMaterielType())){
            criteria.andMaterielTypeEqualTo(purchaseReqBean.getMaterielType());
        }
        if(StringUtils.isNotBlank(purchaseReqBean.getSupplierName())){
            criteria.andSupplierNameEqualTo(purchaseReqBean.getSupplierName());
        }
        List<PurchaseEntity> purchaseEntityList = this.selectByExample(purchaseEntityExample);
        PageInfo<PurchaseEntity> pageInfo = new PageInfo<>(page);
        pageInfo.setList(purchaseEntityList);
        return pageInfo;
    }
}
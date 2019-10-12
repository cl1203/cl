package com.cl.transform;

import com.cl.bean.res.FinanceResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.PurchaseMapper;
import com.cl.dao.TailorMapper;
import com.cl.entity.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class FinanceTransform extends AbstractObjectTransformer<FinanceEntity, FinanceResBean> {
    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private TailorMapper tailorMapper;

    @Override
    public FinanceResBean transform(FinanceEntity financeEntity) {
        if(null == financeEntity){
            return null;
        }
        FinanceResBean financeResBean = new FinanceResBean();
        financeResBean.setId(financeEntity.getId());
        financeResBean.setOrderNo(financeEntity.getOrderNo());
        financeResBean.setQuantityTotal(financeEntity.getQuantityTotal());
        financeResBean.setFlatcarPrice(financeEntity.getFlatcarPrice());
        financeResBean.setCartPrice(financeEntity.getCartPrice());
        financeResBean.setEdgersPrice(financeEntity.getEdgersPrice());
        financeResBean.setGreatIroningPrice(financeEntity.getGreatIroningPrice());
        financeResBean.setCheckGoodsPrice(financeEntity.getCheckGoodsPrice());
        financeResBean.setTrimmingPrice(financeEntity.getTrimmingPrice());
        financeResBean.setPackagingPrice(financeEntity.getPackagingPrice());
        financeResBean.setReworkPrice(financeEntity.getReworkPrice());
        financeResBean.setOtherPrice(financeEntity.getOtherPrice());
        financeResBean.setStatus(financeEntity.getStatus());
        financeResBean.setRemarks(financeEntity.getRemarks());
        //根据订单编号获取对应的订单对象
        OrderManageEntity orderManageEntity = this.purchaseMapper.selectOrder(financeEntity.getOrderNo());
        Assert.notNull(orderManageEntity , "订单信息不存在!请联系系统管理员!");
        financeResBean.setImgUrl(orderManageEntity.getOrderImgUrl());
        financeResBean.setSku(orderManageEntity.getSku());
        //采购总价
        PurchaseEntityExample purchaseEntityExample = new PurchaseEntityExample();
        PurchaseEntityExample.Criteria criteriaPurchase = purchaseEntityExample.createCriteria();
        criteriaPurchase.andOrderNoEqualTo(orderManageEntity.getOrderNo());
        List<PurchaseEntity> purchaseEntityList = this.purchaseMapper.selectByExample(purchaseEntityExample);
        BigDecimal purchaseTotalPrice = new BigDecimal(DictionaryConstants.ALL_BUSINESS_ZERO);
        if(CollectionUtils.isNotEmpty(purchaseEntityList)){
            for(PurchaseEntity purchaseEntity : purchaseEntityList){
                if(null != purchaseEntity.getActualPickMonovalent()){
                    purchaseTotalPrice = purchaseTotalPrice.add(purchaseEntity.getActualPickMonovalent());
                }
            }
            if(purchaseTotalPrice.equals(DictionaryConstants.ALL_BUSINESS_ZERO)){
                financeResBean.setPurchaseTotalPrice(null);
            }else{
                financeResBean.setPurchaseTotalPrice(purchaseTotalPrice);
            }
        }else{
            throw new BusinessException("订单号: " + orderManageEntity.getOrderNo() + "没有对应的采购单信息!");
        }
        //裁剪总价
        TailorEntityExample tailorEntityExample = new TailorEntityExample();
        TailorEntityExample.Criteria criteriaTailor = tailorEntityExample.createCriteria();
        criteriaTailor.andOrderNoEqualTo(orderManageEntity.getOrderNo());
        List<TailorEntity> tailorEntityList = this.tailorMapper.selectByExample(tailorEntityExample);
        BigDecimal tailorTotalPrice = new BigDecimal(DictionaryConstants.ALL_BUSINESS_ZERO);
        if(CollectionUtils.isNotEmpty(tailorEntityList)){
            for(TailorEntity tailorEntity : tailorEntityList){
                if(null != tailorEntity.getMonovalent()){
                    tailorTotalPrice = tailorTotalPrice.add(tailorEntity.getMonovalent());
                }
            }
            if(tailorTotalPrice.equals(DictionaryConstants.ALL_BUSINESS_ZERO)){
                financeResBean.setTailorTotalPrice(null);
            }else{
                financeResBean.setTailorTotalPrice(tailorTotalPrice);
            }
        }else{
            throw new BusinessException("订单号: " + orderManageEntity.getOrderNo() + "没有对应的裁剪信息!");
        }
        //工序总价
        BigDecimal workingTotalPrice = new BigDecimal(DictionaryConstants.ALL_BUSINESS_ZERO);
        if(null != financeEntity.getFlatcarPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getFlatcarPrice());
        }
        if(null != financeEntity.getCartPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getCartPrice());
        }
        if(null != financeEntity.getEdgersPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getEdgersPrice());
        }
        if(null != financeEntity.getGreatIroningPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getGreatIroningPrice());
        }
        if(null != financeEntity.getCheckGoodsPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getCheckGoodsPrice());
        }
        if(null != financeEntity.getTrimmingPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getTrimmingPrice());
        }
        if(null != financeEntity.getPackagingPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getPackagingPrice());
        }
        if(null != financeEntity.getReworkPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getReworkPrice());
        }
        if(null != financeEntity.getOtherPrice()){
            workingTotalPrice = workingTotalPrice.add(financeEntity.getOtherPrice());
        }
        if(workingTotalPrice.equals(DictionaryConstants.ALL_BUSINESS_ZERO)){
            financeResBean.setWorkingTotalPrice(null);
        }else{
            financeResBean.setWorkingTotalPrice(workingTotalPrice);
        }
        //总价
        BigDecimal totalPrice = new BigDecimal(DictionaryConstants.ALL_BUSINESS_ZERO);
        totalPrice = purchaseTotalPrice.add(tailorTotalPrice).add(workingTotalPrice);
        if(totalPrice.equals(DictionaryConstants.ALL_BUSINESS_ZERO)){
            financeResBean.setTotalPrice(null);
        }else{
            financeResBean.setTotalPrice(totalPrice);
        }
        return financeResBean;
    }
}

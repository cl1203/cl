package com.cl.transform;

import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.PurchaseEntity;
import org.springframework.stereotype.Service;

/**
 * @ClassName PurchaseTransform
 * @Description 采购entity转resBean
 * @Author 陈龙
 * @Date 2019/7/24 17:11
 * @Version 1.0
 **/
@Service
public class PurchaseTransform extends AbstractObjectTransformer<PurchaseEntity , PurchaseResBean> {

    @Override
    public PurchaseResBean transform(PurchaseEntity purchaseEntity) {
        if(null == purchaseEntity){
            return null;
        }
        PurchaseResBean purchaseResBean = new PurchaseResBean();
        purchaseResBean.setId(purchaseEntity.getId());//id
        purchaseResBean.setPurchaseNo(purchaseEntity.getPurchaseNo());//采购单号
        purchaseResBean.setOrderNo(purchaseEntity.getOrderNo());//订单号
        if(null != purchaseEntity.getPurchaseStatus()){//采购单状态
            switch(purchaseEntity.getPurchaseStatus()){
                case 1:
                    purchaseResBean.setPurchaseStatusName("待采购");
                    break;
                case 2:
                    purchaseResBean.setPurchaseStatusName("采购中");
                    break;
            }
        }
        purchaseResBean.setMaterielName(purchaseEntity.getMaterielName());//物料名称
        purchaseResBean.setMaterielColor(purchaseEntity.getMaterielColor());//物料颜色
        if(null != purchaseEntity.getAnswerPickQuantity()){//应采数量
            purchaseResBean.setAnswerPickQuantity(purchaseEntity.getAnswerPickQuantity());
        }
        if(null != purchaseEntity.getActualPickQuantity()){//实采数量
            purchaseResBean.setActualPickQuantity(purchaseEntity.getActualPickQuantity());
        }
        if(null != purchaseEntity.getAnswerPickMonovalent()){//应采单价
            purchaseResBean.setActualPickMonovalent(purchaseEntity.getAnswerPickMonovalent());
        }
        if(null != purchaseEntity.getAnswerPickTotal()){//应采总额
            purchaseResBean.setAnswerPickTotal(purchaseEntity.getAnswerPickTotal());
        }
        if(null != purchaseEntity.getActualPickMonovalent()){//实采单价
            purchaseResBean.setActualPickMonovalent(purchaseEntity.getActualPickMonovalent());
        }
        if(null != purchaseEntity.getActualPickTotal()){//实采总额
            purchaseResBean.setActualPickTotal(purchaseEntity.getActualPickTotal());
        }
        purchaseResBean.setSupplierName(purchaseEntity.getSupplierName());//供应商名称
        if(null != purchaseEntity.getConsumingTime()){
            purchaseResBean.setConsumingTime(String.valueOf(purchaseEntity.getConsumingTime()));//耗时
        }
        return purchaseResBean;
    }
}

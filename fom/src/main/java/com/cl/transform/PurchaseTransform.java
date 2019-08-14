package com.cl.transform;

import com.cl.bean.res.DictItem;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.PurchaseEntity;
import com.cl.service.IPulldownMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PurchaseTransform
 * @Description 采购entity转resBean
 * @Author 陈龙
 * @Date 2019/7/24 17:11
 * @Version 1.0
 **/
@Service
public class PurchaseTransform extends AbstractObjectTransformer<PurchaseEntity , PurchaseResBean> {

    @Resource
    private IPulldownMenuService iPulldownMenuService;

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
            RequestBeanModel requestBeanModel = new RequestBeanModel();
            DictItem dictItem = new DictItem();
            dictItem.setType("purchase_status");
            dictItem.setCode(String.valueOf(purchaseEntity.getPurchaseStatus()));
            requestBeanModel.setReqData(dictItem);
            List<DictItem> dictItemList = this.iPulldownMenuService.queryDictItemList(requestBeanModel);
            dictItem = dictItemList.get(0);
            purchaseResBean.setPurchaseStatusName(dictItem.getValue());
        }
        purchaseResBean.setMaterielName(purchaseEntity.getMaterielName());//物料名称
        purchaseResBean.setMaterielColor(purchaseEntity.getMaterielColor());//物料颜色
        purchaseResBean.setAnswerPickQuantity(purchaseEntity.getAnswerPickQuantity());
        purchaseResBean.setActualPickQuantity(purchaseEntity.getActualPickQuantity());
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

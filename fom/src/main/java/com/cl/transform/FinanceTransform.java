package com.cl.transform;

import com.cl.bean.res.FinanceResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.FinanceEntity;
import org.springframework.stereotype.Service;

@Service
public class FinanceTransform extends AbstractObjectTransformer<FinanceEntity, FinanceResBean> {
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
        financeResBean.setFlatcarUser(financeEntity.getFlatcarUser());
        financeResBean.setCartPrice(financeEntity.getCartPrice());
        financeResBean.setCartUser(financeEntity.getCartUser());
        financeResBean.setEdgersPrice(financeEntity.getEdgersPrice());
        financeResBean.setEdgersUser(financeEntity.getEdgersUser());
        financeResBean.setGreatIroningPrice(financeEntity.getGreatIroningPrice());
        financeResBean.setGreatIroningUser(financeEntity.getGreatIroningUser());
        financeResBean.setCheckGoodsPrice(financeEntity.getCheckGoodsPrice());
        financeResBean.setCheckGoodsUser(financeEntity.getCheckGoodsUser());
        financeResBean.setTrimmingPrice(financeEntity.getTrimmingPrice());
        financeResBean.setTrimmingUser(financeEntity.getTrimmingUser());
        financeResBean.setPackagingPrice(financeEntity.getPackagingPrice());
        financeResBean.setPackagingUser(financeEntity.getPackagingUser());
        financeResBean.setReworkPrice(financeEntity.getReworkPrice());
        financeResBean.setReworkUser(financeEntity.getReworkUser());
        financeResBean.setOtherPrice(financeEntity.getOtherPrice());
        financeResBean.setOtherUser(financeEntity.getOtherUser());
        financeResBean.setStatus(financeEntity.getStatus());
        financeResBean.setRemarks(financeEntity.getRemarks());
        return financeResBean;
    }
}

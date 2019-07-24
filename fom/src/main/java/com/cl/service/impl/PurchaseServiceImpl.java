package com.cl.service.impl;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.PurchaseMapper;
import com.cl.entity.PurchaseEntity;
import com.cl.service.IPurchaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PurchaseServiceImpl
 * @Description 采购实现类
 * @Author 陈龙
 * @Date 2019/7/24 15:16
 * @Version 1.0
 **/
@Service
@Transactional
public class PurchaseServiceImpl implements IPurchaseService {

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private IObjectTransformer<PurchaseEntity , PurchaseResBean> purchaseTransformer;

    @Override
    public PageInfo<PurchaseResBean> queryPurchaseList(RequestBeanModel<PurchaseReqBean> reqBeanModel) {
        PurchaseReqBean purchaseReqBean = reqBeanModel.getReqData();
        //分页查询
        PageInfo<PurchaseEntity> purchaseEntityPageInfo = this.purchaseMapper.selectPurchasePageInfo(purchaseReqBean);
        //entity转resBean
        PageInfo<PurchaseResBean> purchaseResBeanPageInfo = this.purchaseTransformer.transform(purchaseEntityPageInfo);
        return purchaseResBeanPageInfo;
    }

    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void updatePurchase(RequestBeanModel<PurchaseReqBean> reqBeanModel) {
        PurchaseReqBean purchaseReqBean = reqBeanModel.getReqData();

        if(null != purchaseReqBean.getActualPickQuantity()){
            String actualPickQuantityRegexp = "^[1-9][0-9]{0,8}$";
            if(!match(actualPickQuantityRegexp , purchaseReqBean.getActualPickQuantity())) {
                throw new BusinessException("实采数量格式规则: 必须是整数在0-999999999之间! ");
            }
        }
        if(null != purchaseReqBean.getActualPickMonovalent()){
            String actualPickMonovalentRegexp = "(^[+]{0,1}(0|([1-9]\\d{0,7}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(!match(actualPickMonovalentRegexp , purchaseReqBean.getActualPickMonovalent())) {
                throw new BusinessException("实采单价规则:整数位最多8位,小数位最多2位! ");
            }
        }
        if(null != purchaseReqBean.getActualPickTotal()){
            String actualPickTotalRegexp = "(^[+]{0,1}(0|([1-9]\\d{0,7}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(!match(actualPickTotalRegexp , purchaseReqBean.getActualPickTotal())) {
                throw new BusinessException("实采总额规则:整数位最多8位,小数位最多2位! ");
            }
        }
        //录入实采数量时 校验时候存在采购日期 如果没有 就是当前录入时间

    }
}

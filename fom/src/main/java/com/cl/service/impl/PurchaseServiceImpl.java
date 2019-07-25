package com.cl.service.impl;

import com.cl.bean.req.PurchaseReqBean;
import com.cl.bean.res.PurchaseResBean;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.PurchaseMapper;
import com.cl.entity.PurchaseEntity;
import com.cl.service.IPurchaseService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
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
        //校验修改的参数
        PurchaseEntity purchaseEntity = this.checkParameter(purchaseReqBean);
        //录入实采数量时 校验是否存在采购日期 如果没有 就是当前录入时间
        if(null != purchaseReqBean.getActualPickQuantity()){
            PurchaseEntity purchaseEntityById = this.purchaseMapper.selectByPrimaryKey(purchaseReqBean.getId());
            Assert.notNull(purchaseEntityById , "未找到对应的采购数据!");
            if(null == purchaseEntityById.getPurchaseTime()){
                purchaseEntity.setPurchaseTime(new Date());
            }
        }
        //修改采购表
        int i = this.purchaseMapper.updateByPrimaryKeySelective(purchaseEntity);
        Assert.isTrue(i == 1 , "修改采购数据失败!");
        //此订单号对应的待采购和采购中的所有采购单数量 1:查询待采购和采购中所有采购单  0:查询采购中的所有采购单
        Integer purchaseNum = this.purchaseMapper.selectPurchaseNumByOrderNo(purchaseReqBean.getOrderNo() , (byte)1);
        //此订单号对应的采购中的所有采购单数量
        Integer purchaseNumIng = this.purchaseMapper.selectPurchaseNumByOrderNo(purchaseReqBean.getOrderNo() , (byte)0);
        if(purchaseNum == purchaseNumIng){
            int j = this.purchaseMapper.updatePurchaseStatusByOrderNo(purchaseReqBean.getOrderNo());
            Assert.isTrue(j > 0 , "修改采购单状态失败!");
        }
    }

    /**
     *  校验 编辑时带过来的参数并转换成entity
     * @param purchaseReqBean
     */
    private PurchaseEntity checkParameter(PurchaseReqBean purchaseReqBean){
        PurchaseEntity purchaseEntity = new PurchaseEntity();
        Assert.notNull(purchaseReqBean.getId() , "请选择一条数据,ID不能为空!");
        Assert.hasText(purchaseReqBean.getOrderNo() , "订单号不能为空!");
        if(null != purchaseReqBean.getActualPickQuantity()){
            String actualPickQuantityRegexp = "^[1-9][0-9]{0,8}$";
            if(!match(actualPickQuantityRegexp , purchaseReqBean.getActualPickQuantity())) {
                throw new BusinessException("实采数量格式规则: 必须是整数在0-999999999之间! ");
            }
            purchaseEntity.setActualPickQuantity(Integer.valueOf(purchaseReqBean.getActualPickQuantity()));
        }
        if(null != purchaseReqBean.getActualPickMonovalent()){
            String actualPickMonovalentRegexp = "(^[+]{0,1}(0|([1-9]\\d{0,7}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(!match(actualPickMonovalentRegexp , purchaseReqBean.getActualPickMonovalent())) {
                throw new BusinessException("实采单价规则:整数位最多8位,小数位最多2位! ");
            }
            purchaseEntity.setActualPickMonovalent(new BigDecimal(purchaseReqBean.getActualPickMonovalent()).setScale(2 , RoundingMode.HALF_UP));
        }
        if(null != purchaseReqBean.getActualPickTotal()){
            String actualPickTotalRegexp = "(^[+]{0,1}(0|([1-9]\\d{0,7}))(\\.\\d{1,2}){0,1}$){0,1}";
            if(!match(actualPickTotalRegexp , purchaseReqBean.getActualPickTotal())) {
                throw new BusinessException("实采总额规则:整数位最多8位,小数位最多2位! ");
            }
            purchaseEntity.setActualPickTotal(new BigDecimal(purchaseReqBean.getActualPickTotal()).setScale(2 , RoundingMode.HALF_UP));
        }
        purchaseEntity.setConsumingTime(purchaseReqBean.getConsumingTime());
        purchaseEntity.setPurchaseStatus((byte) 2);
        purchaseEntity.setOrderNo(purchaseReqBean.getOrderNo());
        purchaseEntity.setId(purchaseReqBean.getId());
        return purchaseEntity;
    }
}

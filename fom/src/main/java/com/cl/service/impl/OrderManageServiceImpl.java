package com.cl.service.impl;

import com.cl.bean.req.*;
import com.cl.bean.res.OrderManageResBean;
import com.cl.bean.res.OrderQuantityResBean;
import com.cl.bean.res.SecondaryProcessResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.*;
import com.cl.entity.*;
import com.cl.service.IOrderManageService;
import com.cl.service.IPulldownMenuService;
import com.cl.util.DateUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.cl.comm.constants.DictionaryConstants.ADMIN_ORG_ID;

/**
 * @ClassName OrderManageServiceImpl
 * @Description 订单管理业务实现类
 * @Author 陈龙
 * @Date 2019/7/20 17:32
 * @Version 1.0
 **/
@Service
@Transactional
public class OrderManageServiceImpl implements IOrderManageService {

    @Resource
    private OrderManageMapper orderManageMapper;

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private IObjectTransformer<OrderManageEntity , OrderManageResBean> orderManageTransformer;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SecondaryProcessMapper secondaryProcessMapper;

    @Resource
    private OrderQuantityMapper orderQuantityMapper;

    @Resource
    private PurchaseMapper purchaseMapper;

    @Resource
    private StockMapper stockMapper;

    @Override
    public PageInfo<OrderManageResBean> queryOrderList(RequestBeanModel<OrderManageReqBean> reqBeanModel) {
        OrderManageReqBean orderManageReqBean = reqBeanModel.getReqData();
        if(orderManageReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || orderManageReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        SysOrgEntity sysOrgEntity = null;
        if(!Long.valueOf(ADMIN_ORG_ID).equals(orgId)){
            sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
        }
        //分页查询
        PageInfo<OrderManageEntity> orderManageEntityPageInfo = this.orderManageMapper.selectOrderManagePageInfo(orderManageReqBean , sysOrgEntity);
        //entity转resBean
        PageInfo<OrderManageResBean> orderManageResBeanPageInfo = this.orderManageTransformer.transform(orderManageEntityPageInfo);
        List<OrderManageResBean> orderManageResBeanList = orderManageResBeanPageInfo.getList();
        if(CollectionUtils.isNotEmpty(orderManageResBeanList)){
            orderManageResBeanList.forEach(orderManageResBean -> {
                //根据订单号查询下单数量信息
                List<OrderQuantityResBean> orderQuantityResBeanList = this.orderManageMapper.selectOrderQuantityByOrderNo(orderManageResBean.getOrderNo());
                orderManageResBean.setOrderQuantityResBeanList(orderQuantityResBeanList);
                //根据订单号查询二次工艺信息
                List<SecondaryProcessResBean> secondaryProcessResBeanList = this.orderManageMapper.selectSecondaryProcessByOrderNo(orderManageResBean.getOrderNo());
                orderManageResBean.setSecondaryProcessResBeanList(secondaryProcessResBeanList);
            });
        }
        orderManageResBeanPageInfo.setList(orderManageResBeanList);
        return orderManageResBeanPageInfo;
    }

    @Override
    public void distributionOrder(RequestBeanModel<DistributionOrderReqBean> reqBeanModel) {
        //根据用户id查询对应的组织
        Long orgIdByUserId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!orgIdByUserId.equals(Long.valueOf(ADMIN_ORG_ID))){
            throw new BusinessException("只有系统管理员用户才能重新分单");
        }
        OrderManageEntity orderManageEntity = new OrderManageEntity();
        List<Long> orderIdList = reqBeanModel.getReqData().getOrderIdList();
        Long orgId = reqBeanModel.getReqData().getOrgId();
        SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
        Assert.notNull(sysOrgEntity , "生产方不存在!");
        Assert.isTrue(sysOrgEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "生产方已被删除!");
        orderManageEntity.setProducer(sysOrgEntity.getName());
        orderManageEntity.setLastUpdateTime(new Date());
        orderManageEntity.setLastUpdateUser(reqBeanModel.getUsername());
        for(Long orderId : orderIdList){
            OrderManageEntity orderManageEntityByOrderId = this.orderManageMapper.selectByPrimaryKey(orderId);
            Assert.notNull(orderManageEntityByOrderId , "订单数据错误!");
            orderManageEntity.setId(orderId);
            int i = this.orderManageMapper.updateByPrimaryKeySelective(orderManageEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "分单失败!");
        }
    }

    @Override
    public String queryProducer(RequestBeanModel<SingleParam> reqBeanModel) {
        String orderId = reqBeanModel.getReqData().getParam();
        Assert.hasText(orderId , "请选择一条记录!");
        OrderManageEntity orderManageEntity = this.orderManageMapper.selectProducer(Long.valueOf(orderId));
        if(null == orderManageEntity){
            return null;
        }
        return orderManageEntity.getProducer();
    }

    @Override
    public void insertOrder(RequestBeanModel<OrderManageInsertReqBean> reqBeanModel) {
        OrderManageInsertReqBean orderManageInsertReqBean = reqBeanModel.getReqData();
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!Long.valueOf(ADMIN_ORG_ID).equals(orgId)){
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
        }
        //校验参数
        this.checkParameter(orderManageInsertReqBean);
        //新增订单
        this.insertOrderManage(orderManageInsertReqBean , reqBeanModel.getUserId());
        //新增二次工艺
        List<SecondaryProcessReqBean> secondaryProcessReqBeanList = orderManageInsertReqBean.getSecondaryProcessReqBeanList();
        if(CollectionUtils.isNotEmpty(secondaryProcessReqBeanList)){
            this.insertSecondaryProcess(secondaryProcessReqBeanList , orderManageInsertReqBean.getOrderNo() , reqBeanModel.getUserId());
        }
        //新增下单数量详情
        List<OrderQuantityReqBean> orderQuantityReqBeanList = orderManageInsertReqBean.getOrderQuantityReqBeanList();
        if(CollectionUtils.isNotEmpty(orderQuantityReqBeanList)){
            this.insertOrderQuantity(orderQuantityReqBeanList , orderManageInsertReqBean.getOrderNo() , reqBeanModel.getUserId());
        }
        //新增采购单
        List<PurchaseInsertReqBean> purchaseInsertReqBeanList = orderManageInsertReqBean.getPurchaseInsertReqBeanList();
        this.insertPurchase(purchaseInsertReqBeanList , orderManageInsertReqBean.getOrderNo() , reqBeanModel.getUserId() , orderManageInsertReqBean.getSku() , orderManageInsertReqBean.getOrderQuantity());
    }

    private void insertPurchase(List<PurchaseInsertReqBean> purchaseInsertReqBeanList , String orderNo , String userId , String sku , String orderQuantity){
        for(PurchaseInsertReqBean purchaseInsertReqBean : purchaseInsertReqBeanList){
            PurchaseEntityExample purchaseEntityExample = new PurchaseEntityExample();
            PurchaseEntityExample.Criteria criteria = purchaseEntityExample.createCriteria();
            criteria.andPurchaseNoEqualTo(purchaseInsertReqBean.getPurchaseNo());
            List<PurchaseEntity> purchaseEntityList = this.purchaseMapper.selectByExample(purchaseEntityExample);
            if(purchaseEntityList.size() >DictionaryConstants.ALL_BUSINESS_ZERO){
                throw new BusinessException("采购单号已经存在 , 请修改!");
            }
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setPurchaseNo(purchaseInsertReqBean.getPurchaseNo());
            purchaseEntity.setOrderNo(orderNo);
            purchaseEntity.setPurchaseType(purchaseInsertReqBean.getPurchaseType());
            purchaseEntity.setMaterielName(purchaseInsertReqBean.getMaterielName());
            purchaseEntity.setMaterielColor(purchaseInsertReqBean.getMaterielColor());
            purchaseEntity.setSimpleUse(new BigDecimal(purchaseInsertReqBean.getSimpleUse()));
            purchaseEntity.setAnswerPickMonovalent(new BigDecimal(purchaseInsertReqBean.getAnswerPickMonovalent()));
            BigDecimal answerPickQuantity = new BigDecimal(purchaseInsertReqBean.getSimpleUse()).multiply(new BigDecimal(orderQuantity)).setScale(DictionaryConstants.ALL_BUSINESS_ZERO , BigDecimal.ROUND_HALF_UP);
            purchaseEntity.setAnswerPickQuantity(answerPickQuantity);
            purchaseEntity.setAnswerPickTotal(answerPickQuantity.multiply(new BigDecimal(purchaseInsertReqBean.getAnswerPickMonovalent())).setScale(DictionaryConstants.PERMISSION_TYPE_TWO , BigDecimal.ROUND_HALF_UP));
            purchaseEntity.setSupplierName(purchaseInsertReqBean.getSupplierName());
            purchaseEntity.setMaterielSku(purchaseInsertReqBean.getMaterielSku());
            purchaseEntity.setCreateUser(userId);
            purchaseEntity.setLastUpdateUser(userId);
            int i = this.purchaseMapper.insertSelective(purchaseEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "生成采购单失败!");
            //根据订单号和物料sku初始化库存
            StockEntity stockEntity = new StockEntity();
            stockEntity.setOrderNo(orderNo);
            stockEntity.setSku(sku);
            stockEntity.setMaterialSku(purchaseInsertReqBean.getMaterielSku());
            stockEntity.setCreateUser(userId);
            stockEntity.setLastUpdateUser(userId);
            int  j = this.stockMapper.insertSelective(stockEntity);
            Assert.isTrue( j == DictionaryConstants.ADMIN_ORG_ID , "初始化库存失败!");
        }
    }

    /**
     * 新增下单数量详情
     * @param orderQuantityReqBeanList
     * @param orderNo
     * @param userId
     */
    private void insertOrderQuantity(List<OrderQuantityReqBean> orderQuantityReqBeanList , String orderNo , String userId){
        for(OrderQuantityReqBean orderQuantityReqBean : orderQuantityReqBeanList){
            OrderQuantityEntity orderQuantityEntity = new OrderQuantityEntity();
            orderQuantityEntity.setOrderNo(orderNo);
            orderQuantityEntity.setSizeName(orderQuantityReqBean.getSizeName());
            if(StringUtils.isNotBlank(orderQuantityReqBean.getQuantity())){
                orderQuantityEntity.setQuantity(Integer.valueOf(orderQuantityReqBean.getQuantity()));
            }
            orderQuantityEntity.setCreateUser(userId);
            orderQuantityEntity.setLastUpdateUser(userId);
            int i = this.orderQuantityMapper.insertSelective(orderQuantityEntity);
            Assert.isTrue(i ==DictionaryConstants.ALL_BUSINESS_ONE , "新增下单数量详情失败!");
        }
    }

    /**
     * 新增二次工艺
     * @param secondaryProcessReqBeanList
     */
    private void insertSecondaryProcess(List<SecondaryProcessReqBean> secondaryProcessReqBeanList , String orderNo , String userId){
        for(SecondaryProcessReqBean secondaryProcessReqBean : secondaryProcessReqBeanList){
            SecondaryProcessEntity secondaryProcessEntity = new SecondaryProcessEntity();
            secondaryProcessEntity.setOrderNo(orderNo);
            secondaryProcessEntity.setProcessName(secondaryProcessReqBean.getProcessName());
            secondaryProcessEntity.setSupplierName(secondaryProcessReqBean.getSupplierName());
            if(StringUtils.isNotBlank(secondaryProcessReqBean.getUnitPrice())){
                secondaryProcessEntity.setUnitPrice(new BigDecimal(secondaryProcessReqBean.getUnitPrice()));
            }
            secondaryProcessEntity.setSimpleUse(secondaryProcessReqBean.getSimpleUse());
            secondaryProcessEntity.setCreateUser(userId);
            secondaryProcessEntity.setLastUpdateUser(userId);
            int i = this.secondaryProcessMapper.insertSelective(secondaryProcessEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "新增二次工艺失败!");
        }
    }

    /**
     * 新增订单
     * @param orderManageInsertReqBean
     * @param userId
     */
    private void insertOrderManage(OrderManageInsertReqBean orderManageInsertReqBean , String userId){
        OrderManageEntity orderManageEntity = new OrderManageEntity();
        orderManageEntity.setOrderNo(orderManageInsertReqBean.getOrderNo());//订单编号
        orderManageEntity.setOrderQuantity(Integer.valueOf(orderManageInsertReqBean.getOrderQuantity()));//下单件数
        orderManageEntity.setOrderType(orderManageInsertReqBean.getOrderType());//订单类型
        orderManageEntity.setOrderTime(DateUtils.getDateToString(orderManageInsertReqBean.getOrderTime() , DateUtils.DATESHOWFORMAT));//下单时间
        orderManageEntity.setOrderImgUrl(orderManageInsertReqBean.getOrderImgUrl());//订单图片
        orderManageEntity.setSku(orderManageInsertReqBean.getSku());//sku
        orderManageEntity.setIsFirst(Byte.valueOf(orderManageInsertReqBean.getIsFirst()));//是否首单
        orderManageEntity.setProducer(orderManageInsertReqBean.getProducer());//生产方
        orderManageEntity.setSurplusTime(orderManageInsertReqBean.getSurplusTime());//剩余时间
        orderManageEntity.setOrderStatus(DictionaryConstants.AVAILABLE);//订单状态 默认待采购
        orderManageEntity.setRemarks(orderManageInsertReqBean.getRemarks());//备注
        orderManageEntity.setCreateUser(userId);
        orderManageEntity.setLastUpdateUser(userId);
        int i = this.orderManageMapper.insertSelective(orderManageEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "新增订单失败!");
    }

    /**
     * 参数校验
     * @param orderManageInsertReqBean
     */
    private void checkParameter(OrderManageInsertReqBean orderManageInsertReqBean){
        OrderManageEntityExample orderManageEntityExample = new OrderManageEntityExample();
        OrderManageEntityExample.Criteria orderCriteria = orderManageEntityExample.createCriteria();
        orderCriteria.andOrderNoEqualTo(orderManageInsertReqBean.getOrderNo());
        List<OrderManageEntity> orderManageEntityList = this.orderManageMapper.selectByExample(orderManageEntityExample);
        if(orderManageEntityList.size() > DictionaryConstants.ALL_BUSINESS_ZERO){
            throw new BusinessException("订单号已经存在,请修改!");
        }
        String orderQuantity = orderManageInsertReqBean.getOrderQuantity();//订单件数
        String orderQuantityRegexp = "^[1-9][0-9]{0,8}$";
        if(match(orderQuantityRegexp , orderQuantity)) {
            throw new BusinessException("订单件数格式规则: 必须是整数在0-999999999之间! ");
        }
        String orderType = orderManageInsertReqBean.getOrderType();//订单类型
        if(!(DictionaryConstants.ORDER_TPYE_FOB.equalsIgnoreCase(orderType) || DictionaryConstants.ORDER_TPYE_CMT.equalsIgnoreCase(orderType))){
            throw new BusinessException("订单类型不存在, 只包括新CMT和FOB两种类型!");
        }
        String isFirst = orderManageInsertReqBean.getIsFirst();
        if(!(isFirst.equalsIgnoreCase(DictionaryConstants.ALL_BUSINESS_ZERO.toString()) || isFirst.equalsIgnoreCase(DictionaryConstants.ALL_BUSINESS_ONE.toString()))) {
            throw new BusinessException("1:代表是首单 , 0:代表不是首单 , 请勿传其他值!");
        }
        String producer = orderManageInsertReqBean.getProducer();
        SysOrgEntityExample sysOrgEntityExample = new SysOrgEntityExample();
        SysOrgEntityExample.Criteria criteria = sysOrgEntityExample.createCriteria();
        criteria.andNameEqualTo(producer);
        List<SysOrgEntity> sysOrgEntityList = this.sysOrgMapper.selectByExample(sysOrgEntityExample);
        Assert.notEmpty(sysOrgEntityList , "生产方不存在, 请核对后重新输入!");
        List<SecondaryProcessReqBean> secondaryProcessReqBeanList = orderManageInsertReqBean.getSecondaryProcessReqBeanList();
        if(CollectionUtils.isNotEmpty(secondaryProcessReqBeanList)){
            for(SecondaryProcessReqBean secondaryProcessReqBean : secondaryProcessReqBeanList){
                String unitPrice = secondaryProcessReqBean.getUnitPrice();
                if(StringUtils.isNotBlank(unitPrice)){
                    String unitPriceRegexp =  "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}";
                    if(match(unitPriceRegexp ,unitPrice)){
                        throw new BusinessException("价格规则:整数位最多10位,小数位最多2位! ");
                    }
                }
            }
        }
        List<OrderQuantityReqBean> orderQuantityReqBeanList = orderManageInsertReqBean.getOrderQuantityReqBeanList();
        if(CollectionUtils.isNotEmpty(orderQuantityReqBeanList)){
            for(OrderQuantityReqBean orderQuantityReqBean : orderQuantityReqBeanList){
                String quantity = orderQuantityReqBean.getQuantity();
                if(match(orderQuantityRegexp , quantity)) {
                    throw new BusinessException("数量格式规则: 必须是整数在0-999999999之间! ");
                }
            }
        }
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
        return !matcher.matches();
    }
}

package com.cl.service.impl;

import com.cl.bean.req.FinanceReqBean;
import com.cl.bean.res.FinanceResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.FinanceMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.FinanceEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.service.IFinanceService;
import com.cl.service.IPulldownMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

@Service
@Transactional
public class FinanceServiceImpl implements IFinanceService {

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private FinanceMapper financeMapper;

    @Resource
    private IObjectTransformer<FinanceEntity , FinanceResBean> financeTransformer;

    @Override
    public PageInfo<FinanceResBean> queryFinanceList(RequestBeanModel<FinanceReqBean> reqBeanModel) {
        FinanceReqBean financeReqBean = reqBeanModel.getReqData();
        if(financeReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || financeReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(!orgId.equals(Long.valueOf(DictionaryConstants.ADMIN_ORG_ID))){
            SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(orgId);
            Assert.notNull(sysOrgEntity , "用户ID对应的组织信息不存在!");
            financeReqBean.setOrgName(sysOrgEntity.getName());
        }
        PageHelper.startPage(financeReqBean.getPageNum() , financeReqBean.getPageSize() , "f.last_update_time desc");
        List<FinanceEntity> financeEntityList = this.financeMapper.selectFinanceList(financeReqBean);
        List<FinanceResBean> financeResBeanList = this.financeTransformer.transform(financeEntityList);
        return new PageInfo<>(financeResBeanList);
    }

    @Override
    public void insertFinance(FinanceEntity financeEntity) {
        String orderNo = financeEntity.getOrderNo();
        Assert.hasText(orderNo , "订单号不能为空!");
        int i = this.financeMapper.insertSelective(financeEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "新增财务数据失败!");
    }

    @Override
    public void updateFinance(RequestBeanModel<FinanceReqBean> reqBeanModel) {
        FinanceReqBean financeReqBean = reqBeanModel.getReqData();
        //校验修改参数
        FinanceEntity financeEntity = this.checkFinanceReqBean(financeReqBean);
        financeEntity.setLastUpdateUser(reqBeanModel.getUserId());
        financeEntity.setLastUpdateTime(new Date());
        int i = this.financeMapper.updateByPrimaryKeySelective(financeEntity);
        Assert.isTrue(i==DictionaryConstants.ALL_BUSINESS_ONE , "修改财务数据失败!");
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

    /**
     * 校验修改财务请求体
     * @param financeReqBean
     */
    private FinanceEntity checkFinanceReqBean(FinanceReqBean financeReqBean){
        FinanceEntity financeEntity = new FinanceEntity();
        Assert.notNull(financeReqBean.getId() , "请选择一条数据, 主键id不能为空!");
        financeEntity.setId(financeReqBean.getId());
        if(StringUtils.isNotBlank(financeReqBean.getQuantityTotal())){//总件数
            String actualCutQuantityRegexp = "^[1-9][0-9]{0,8}$";
            if(match(actualCutQuantityRegexp , financeReqBean.getQuantityTotal())) {
                throw new BusinessException("总数量格式规则: 必须是整数在0-999999999之间! ");
            }
            financeEntity.setQuantityTotal(Integer.valueOf(financeReqBean.getQuantityTotal()));
        }
        String regexp =  "(^[+]{0,1}(0|([1-9]\\d{0,9}))(\\.\\d{1,2}){0,1}$){0,1}";
        if(StringUtils.isNotBlank(financeReqBean.getFlatcarPrice())){//平车单价
            if(match(regexp ,financeReqBean.getFlatcarPrice())){
                throw new BusinessException("平车单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setFlatcarPrice(new BigDecimal(financeReqBean.getFlatcarPrice()));
        }
        financeEntity.setFlatcarUser(financeReqBean.getFlatcarUser());//平车员工
        if(StringUtils.isNotBlank(financeReqBean.getCartPrice())){//冚车单价
            if(match(regexp ,financeReqBean.getCartPrice())){
                throw new BusinessException("冚车单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setCartPrice(new BigDecimal(financeReqBean.getCartPrice()));
        }
        financeEntity.setCartUser(financeReqBean.getCartUser());//冚车员工
        if(StringUtils.isNotBlank(financeReqBean.getEdgersPrice())){//打边单价
            if(match(regexp ,financeReqBean.getEdgersPrice())){
                throw new BusinessException("打边单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setEdgersPrice(new BigDecimal(financeReqBean.getEdgersPrice()));
        }
        financeEntity.setEdgersUser(financeReqBean.getEdgersUser());//打边员工
        if(StringUtils.isNotBlank(financeReqBean.getGreatIroningPrice())){//大烫单价
            if(match(regexp ,financeReqBean.getGreatIroningPrice())){
                throw new BusinessException("大烫单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setGreatIroningPrice(new BigDecimal(financeReqBean.getGreatIroningPrice()));
        }
        financeEntity.setGreatIroningUser(financeReqBean.getGreatIroningUser());//大烫员工
        if(StringUtils.isNotBlank(financeReqBean.getCheckGoodsPrice())){//查货单价
            if(match(regexp ,financeReqBean.getCheckGoodsPrice())){
                throw new BusinessException("查货单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setCheckGoodsPrice(new BigDecimal(financeReqBean.getCheckGoodsPrice()));
        }
        financeEntity.setCheckGoodsUser(financeReqBean.getCheckGoodsUser());//查货员工
        if(StringUtils.isNotBlank(financeReqBean.getTrimmingPrice())){//剪线单价
            if(match(regexp ,financeReqBean.getTrimmingPrice())){
                throw new BusinessException("剪线单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setTrimmingPrice(new BigDecimal(financeReqBean.getTrimmingPrice()));
        }
        financeEntity.setTrimmingUser(financeReqBean.getTrimmingUser());//剪线员工
        if(StringUtils.isNotBlank(financeReqBean.getPackagingPrice())){//包装单价
            if(match(regexp ,financeReqBean.getPackagingPrice())){
                throw new BusinessException("包装单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setPackagingPrice(new BigDecimal(financeReqBean.getPackagingPrice()));
        }
        financeEntity.setPackagingUser(financeReqBean.getPackagingUser());//包装员工
        if(StringUtils.isNotBlank(financeReqBean.getReworkPrice())){//包装单价
            if(match(regexp ,financeReqBean.getReworkPrice())){
                throw new BusinessException("包装单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setReworkPrice(new BigDecimal(financeReqBean.getReworkPrice()));
        }
        financeEntity.setReworkUser(financeReqBean.getReworkUser());//包装员工
        if(StringUtils.isNotBlank(financeReqBean.getOtherPrice())){//其他单价
            if(match(regexp ,financeReqBean.getOtherPrice())){
                throw new BusinessException("其他单价规则:整数位最多10位,小数位最多2位! ");
            }
            financeEntity.setOtherPrice(new BigDecimal(financeReqBean.getOtherPrice()));
        }
        financeEntity.setOtherUser(financeReqBean.getOtherUser());//其他员工
        financeEntity.setStatus(financeReqBean.getStatus());
        financeEntity.setRemarks(financeReqBean.getRemarks());
        return financeEntity;
    }
}

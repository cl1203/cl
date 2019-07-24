package com.cl.service.impl;

import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.dao.PulldownMenuMapper;
import com.cl.service.IPulldownMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName PulldownMenuServiceImpl
 * @Description 获取下拉菜单 实现类
 * @Author 陈龙
 * @Date 2019/7/20 19:11
 * @Version 1.0
 **/
@Service
@Transactional
public class PulldownMenuServiceImpl implements IPulldownMenuService{

    @Resource
    private PulldownMenuMapper pulldownMenuMapper;

    @Override
    public List<PulldownMenuResBean> queryOrgPulldownMenu() {
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu();
        return pulldownMenuResBeanList;
    }

    @Override
    public List<String> queryInputByOrderNumer() {
        List<String> orderNumberList = this.pulldownMenuMapper.queryInputByOrderNumer();
        return orderNumberList;
    }

    @Override
    public List<String> queryInputBySku() {
        List<String> skuList = this.pulldownMenuMapper.queryInputBySku();
        return skuList;
    }

    @Override
    public List<String> queryInputByPurchaseNumber() {
        List<String> purchaseNumberList = this.pulldownMenuMapper.queryInputByPurchaseNumber();
        return purchaseNumberList;
    }

    @Override
    public List<String> queryInputSupplierName() {
        List<String> supplierNameList = this.pulldownMenuMapper.queryInputSupplierName();
        return supplierNameList;
    }

    @Override
    public List<DictItem> queryDictItemList(RequestBeanModel<DictItem> requestBeanModel) {
        DictItem dictItem = requestBeanModel.getReqData();
        List<DictItem> dictItemList = this.pulldownMenuMapper.queryDictItemList(dictItem);
        return dictItemList;
    }
}

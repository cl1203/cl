package com.cl.service.impl;

import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.dao.PulldownMenuMapper;
import com.cl.service.IPulldownMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<PulldownMenuResBean> queryOrgPulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel) {
        PulldownMenuResBean pulldownMenuResBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuResBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryUserPulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel) {
        PulldownMenuResBean pulldownMenuResBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryUserPulldownMenu(pulldownMenuResBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryPermissionPulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel) {
        PulldownMenuResBean pulldownMenuResBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryPermissionPulldownMenu(pulldownMenuResBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryRolePulldownMenu(RequestBeanModel<PulldownMenuResBean> requestBeanModel) {
        PulldownMenuResBean pulldownMenuResBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryRolePulldownMenu(pulldownMenuResBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<SingleParam> queryInputSupplierName() {
        List<SingleParam> supplierNameList = this.pulldownMenuMapper.queryInputSupplierName();
        return supplierNameList;
    }

    @Override
    public List<DictItem> queryDictItemList(RequestBeanModel<DictItem> requestBeanModel) {
        DictItem dictItem = requestBeanModel.getReqData();
        List<DictItem> dictItemList = this.pulldownMenuMapper.queryDictItemList(dictItem);
        return dictItemList;
    }
}

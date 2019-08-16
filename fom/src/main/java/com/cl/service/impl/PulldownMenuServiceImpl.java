package com.cl.service.impl;

import com.cl.bean.req.PulldownMenuReqBean;
import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.dao.PulldownMenuMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysUserEntity;
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

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<PulldownMenuResBean> queryOrgPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuReqBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryUserPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        Long orgId = this.selectOrgIdByUserId(Long.valueOf(requestBeanModel.getUserId()));
        pulldownMenuReqBean.setOrgId(orgId);
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryUserPulldownMenu(pulldownMenuReqBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryPermissionPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryPermissionPulldownMenu(pulldownMenuReqBean);
        return pulldownMenuResBeanList;
    }

    @Override
    public List<PulldownMenuResBean> queryRolePulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        Long orgId = this.selectOrgIdByUserId(Long.valueOf(requestBeanModel.getUserId()));
        pulldownMenuReqBean.setOrgId(orgId);
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryRolePulldownMenu(pulldownMenuReqBean);
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

    @Override
    public Long selectOrgIdByUserId(Long userId) {
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(userId);
        Assert.notNull(sysUserEntity , "用户不存在!");
        Long orgId = sysUserEntity.getOrgId();
        Assert.notNull(orgId , "用户未绑定组织!");
        return orgId;
    }

    @Override
    public boolean checkBlankSpace(String str) {
        int i = str.indexOf(" ");
        if(i==-1)return true;
        return false;
    }
}

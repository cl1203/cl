package com.cl.service.impl;

import com.cl.bean.req.PulldownMenuReqBean;
import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.PulldownMenuMapper;
import com.cl.dao.SysPermissionMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysPermissionEntity;
import com.cl.entity.SysPermissionEntityExample;
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

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private IObjectTransformer<SysPermissionEntity , SysPermissionResBean> sysPermissionTransform;

    @Override
    public List<PulldownMenuResBean> queryOrgPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        return this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuReqBean);
    }

    @Override
    public List<PulldownMenuResBean> queryUserPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        Long orgId = this.selectOrgIdByUserId(Long.valueOf(requestBeanModel.getUserId()));
        pulldownMenuReqBean.setOrgId(orgId);
        return this.pulldownMenuMapper.queryUserPulldownMenu(pulldownMenuReqBean);
    }

    @Override
    public List<PulldownMenuResBean> queryPermissionPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        return this.pulldownMenuMapper.queryPermissionPulldownMenu(pulldownMenuReqBean);
    }

    @Override
    public List<PulldownMenuResBean> queryDepartmentPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        return this.pulldownMenuMapper.queryDepartmentPulldownMenu(pulldownMenuReqBean);
    }

    @Override
    public List<PulldownMenuResBean> queryDepartmentPulldownMenuByGrade(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        Assert.notNull(pulldownMenuReqBean.getGrade() , "部门等级不能为空!");
        pulldownMenuReqBean.setGrade((byte) (pulldownMenuReqBean.getGrade() - DictionaryConstants.AVAILABLE));
        return this.pulldownMenuMapper.queryDepartmentPulldownMenuByGrade(pulldownMenuReqBean);
    }

    @Override
    public List<PulldownMenuResBean> queryRolePulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel) {
        PulldownMenuReqBean pulldownMenuReqBean = requestBeanModel.getReqData();
        return this.pulldownMenuMapper.queryRolePulldownMenu(pulldownMenuReqBean);
    }

    @Override
    public List<SingleParam> queryInputSupplierName() {
        return this.pulldownMenuMapper.queryInputSupplierName();
    }

    @Override
    public List<DictItem> queryDictItemList(RequestBeanModel<DictItem> requestBeanModel) {
        DictItem dictItem = requestBeanModel.getReqData();
        return this.pulldownMenuMapper.queryDictItemList(dictItem);
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
        return i == -1;
    }

    @Override
    public void queryPermissionByParentId(List<SysPermissionResBean> sysPermissionResBeanList) {
        for(SysPermissionResBean sysPermissionResBean : sysPermissionResBeanList){
            SysPermissionEntityExample sysPermissionEntityExample = new SysPermissionEntityExample();
            SysPermissionEntityExample.Criteria criteria = sysPermissionEntityExample.createCriteria();
            criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
            criteria.andParentIdEqualTo(sysPermissionResBean.getId());
            List<SysPermissionEntity> sysPermissionEntityList = this.sysPermissionMapper.selectByExample(sysPermissionEntityExample);
            List<SysPermissionResBean> sysPermissionResBeanListByParentId = this.sysPermissionTransform.transform(sysPermissionEntityList);
            sysPermissionResBean.setSysPermissionResBeanList(sysPermissionResBeanListByParentId);
        }
    }

    @Override
    public List<SysPermissionResBean> queryPermissionAll() {
        SysPermissionEntityExample sysPermissionEntityExample = new SysPermissionEntityExample();
        SysPermissionEntityExample.Criteria criteria = sysPermissionEntityExample.createCriteria();
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        criteria.andParentIdEqualTo(Long.valueOf(DictionaryConstants.ALL_BUSINESS_ZERO));
        List<SysPermissionEntity> sysPermissionEntityList = this.sysPermissionMapper.selectByExample(sysPermissionEntityExample);
        List<SysPermissionResBean> sysPermissionResBeanList = this.sysPermissionTransform.transform(sysPermissionEntityList);
        this.queryPermissionByParentId(sysPermissionResBeanList);
        return sysPermissionResBeanList;
    }
}

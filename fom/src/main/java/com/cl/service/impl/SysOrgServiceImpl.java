package com.cl.service.impl;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.SysOrgEntity;
import com.cl.service.ISysOrgService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysOrgServiceImpl
 * @Description 权限--组织  实现类
 * @Author 陈龙
 * @Date 2019/7/31 17:20
 * @Version 1.0
 **/
@Service
@Transactional
public class SysOrgServiceImpl implements ISysOrgService {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private IObjectTransformer<SysOrgEntity , SysOrgResBean> sysOrgTransformer;

    @Override
    public PageInfo<SysOrgResBean> querySysOrgList(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        if(sysOrgReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysOrgReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //分页查询
        PageInfo<SysOrgEntity> sysOrgEntityPageInfo = this.sysOrgMapper.selectSysOrgPageInfo(sysOrgReqBean);
        //entity转resBean
        PageInfo<SysOrgResBean> sysOrgResBeanPageInfo = this.sysOrgTransformer.transform(sysOrgEntityPageInfo);
        return sysOrgResBeanPageInfo;
    }

    @Override
    public void insertSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        Assert.hasText(sysOrgReqBean.getName() , "组织名称不能为空!");
        SysOrgEntity sysOrgEntity = new SysOrgEntity();
        sysOrgEntity.setName(sysOrgReqBean.getName());
        sysOrgEntity.setCreateUser(reqBeanModel.getUsername());
        sysOrgEntity.setLastUpdateUser(reqBeanModel.getUsername());
        if(StringUtils.isNotBlank(sysOrgReqBean.getRemarks())){
            sysOrgEntity.setRemarks(sysOrgReqBean.getRemarks());
        }
        int i = this.sysOrgMapper.insertSelective(sysOrgEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "新增组织失败!");
    }

    @Override
    public void deleteSysOrg(RequestBeanModel<List<Long>> reqBeanModel) {

    }

    @Override
    public void updateSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {

    }
}

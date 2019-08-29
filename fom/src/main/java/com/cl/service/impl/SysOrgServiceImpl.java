package com.cl.service.impl;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.*;
import com.cl.entity.*;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ISysOrgService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
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
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

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
        return this.sysOrgTransformer.transform(sysOrgEntityPageInfo);
    }

    @Override
    public void insertSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgEntity sysOrgEntity = this.checkOrgReqBean(reqBeanModel);
        sysOrgEntity.setCreateUser(reqBeanModel.getUserId());
        int i = this.sysOrgMapper.insertSelective(sysOrgEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "新增组织失败!");
    }

    /**
     * 校验组织reqBean 并转换entity
     * @param reqBeanModel
     * @return
     */
    private SysOrgEntity checkOrgReqBean(RequestBeanModel<SysOrgReqBean> reqBeanModel){
        SysOrgEntity sysOrgEntity = new SysOrgEntity();
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        Assert.hasText(sysOrgReqBean.getName() , "组织名称不能为空!");
        Assert.isTrue(sysOrgReqBean.getName().length() <= 20 ,"组织名太长,请修改!");
        boolean flag = this.pulldownMenuService.checkBlankSpace(sysOrgReqBean.getName());
        Assert.isTrue(flag , "组织名不能包含空格!");
        //查询组织名称是否存在
        SysOrgEntityExample sysOrgEntityExample = new SysOrgEntityExample();
        SysOrgEntityExample.Criteria criteria = sysOrgEntityExample.createCriteria();
        criteria.andNameEqualTo(sysOrgReqBean.getName());
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        if(null != sysOrgReqBean.getId()){
            criteria.andIdNotEqualTo(sysOrgReqBean.getId());
        }
        List<SysOrgEntity> sysOrgEntityList = this.sysOrgMapper.selectByExample(sysOrgEntityExample);
        Assert.isTrue(sysOrgEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "组织名已经存在!");
        sysOrgEntity.setName(sysOrgReqBean.getName());
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysOrgEntity.setLastUpdateUser(sysUserEntity.getRealName());
        sysOrgEntity.setRemarks(sysOrgReqBean.getRemarks());
        return sysOrgEntity;
    }

    @Override
    public void deleteSysOrg(RequestBeanModel<List<SingleParam>> reqBeanModel) {
        List<SingleParam> orgIdList = reqBeanModel.getReqData();
        Assert.notEmpty(orgIdList , "请选择需要删除的数据,组织ID不能为空!");
        SysOrgEntity sysOrgEntity = new SysOrgEntity();
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysOrgEntity.setStatus(DictionaryConstants.DETELE);
        sysOrgEntity.setLastUpdateTime(new Date());
        sysOrgEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        orgIdList.forEach(singleParam -> {
            Long orgId = Long.valueOf(singleParam.getParam());
            //删除组织
            sysOrgEntity.setId(orgId);
            int i = this.sysOrgMapper.updateByPrimaryKeySelective(sysOrgEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE ,"删除组织失败!");
            //根据组织ID查询绑定的所有角色
            List<SysRoleEntity> sysRoleEntityList = this.selectRoleByOrgId(orgId);
            if(CollectionUtils.isNotEmpty(sysRoleEntityList)){
                //根据id删除所有角色  并删除该组织下所有角色和所有用户的关系表 删除角色绑定的菜单权限关系表
                this.deleteRoleAndUserRoleByOrgId(sysRoleEntityList , reqBeanModel);
            }
            //根据组织ID删除对应的所有用户
            this.deleteUserByOrgId(orgId , reqBeanModel);
        });
    }

    /**
     * 查询组织id对应的所有角色
     * @param orgId
     * @return
     */
    private List<SysRoleEntity> selectRoleByOrgId(Long orgId){
        SysRoleEntityExample sysRoleEntityExample = new SysRoleEntityExample();
        SysRoleEntityExample.Criteria criteria = sysRoleEntityExample.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        return this.sysRoleMapper.selectByExample(sysRoleEntityExample);
    }

    /**
     * 根据id删除所有角色  并删除该组织下所有角色和所有用户的关系表
     * @param
     */
    private void deleteRoleAndUserRoleByOrgId(List<SysRoleEntity> sysRoleEntityList , RequestBeanModel<List<SingleParam>> reqBeanModel){
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setStatus(DictionaryConstants.DETELE);
        sysUserRoleEntity.setLastUpdateUser(reqBeanModel.getUserId());
        sysUserRoleEntity.setLastUpdateTime(new Date());
        SysUserRoleEntityExample sysUserRoleEntityExample = new SysUserRoleEntityExample();
        SysUserRoleEntityExample.Criteria criteriaByUserRole = sysUserRoleEntityExample.createCriteria();

        SysRolePermissionEntity sysRolePermissionEntity = new SysRolePermissionEntity();
        sysRolePermissionEntity.setStatus(DictionaryConstants.DETELE);
        sysUserRoleEntity.setLastUpdateUser(reqBeanModel.getUserId());
        sysUserRoleEntity.setLastUpdateTime(new Date());
        SysRolePermissionEntityExample sysRolePermissionEntityExample = new SysRolePermissionEntityExample();
        SysRolePermissionEntityExample.Criteria criteriaByRolePermission = sysRolePermissionEntityExample.createCriteria();
        sysRoleEntityList.forEach(sysRoleEntity -> {
            sysRoleEntity.setStatus(DictionaryConstants.DETELE);
            this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleEntity);
            criteriaByUserRole.andRoleIdEqualTo(sysRoleEntity.getId());
            this.sysUserRoleMapper.updateByExampleSelective(sysUserRoleEntity , sysUserRoleEntityExample);
            criteriaByRolePermission.andRoleIdEqualTo(sysRoleEntity.getId());
            this.sysRolePermissionMapper.updateByExampleSelective(sysRolePermissionEntity , sysRolePermissionEntityExample);
        });
    }

    /**
     * 根据组织ID删除对应的所有用户
     * @param orgId
     */
    private void deleteUserByOrgId(Long orgId , RequestBeanModel<List<SingleParam>> reqBeanModel){
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setStatus(DictionaryConstants.DETELE);
        sysUserEntity.setLastUpdateTime(new Date());
        sysUserEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        SysUserEntityExample sysUserEntityExample = new SysUserEntityExample();
        SysUserEntityExample.Criteria criteria = sysUserEntityExample.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        this.sysUserMapper.updateByExampleSelective(sysUserEntity , sysUserEntityExample);
    }

    @Override
    public void updateSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        Assert.notNull(sysOrgReqBean.getId() , "请选择一条数据,ID不能为空!");
        SysOrgEntity sysOrgEntity = this.checkOrgReqBean(reqBeanModel);
        sysOrgEntity.setId(sysOrgReqBean.getId());
        sysOrgEntity.setLastUpdateTime(new Date());
        int i = this.sysOrgMapper.updateByPrimaryKeySelective(sysOrgEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改失败!");
    }
}

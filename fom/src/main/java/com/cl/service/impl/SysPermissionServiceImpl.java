package com.cl.service.impl;

import com.cl.bean.req.SysPermissionReqBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysPermissionMapper;
import com.cl.dao.SysRolePermissionMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.*;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ISysPermissionService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysPermissionServiceImpl
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 16:09
 * @Version 1.0
 **/
@Service
@Transactional
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private IObjectTransformer<SysPermissionEntity , SysPermissionResBean> sysPermissionTransform;


    @Override
    public PageInfo<SysPermissionResBean> querySysPermissionList(RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        SysPermissionReqBean sysPermissionReqBean = reqBeanModel.getReqData();
        if(sysPermissionReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysPermissionReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        PageInfo<SysPermissionEntity> sysPermissionEntityPageInfo = this.sysPermissionMapper.selectSysPermissionPageInfo(sysPermissionReqBean);
        return this.sysPermissionTransform.transform(sysPermissionEntityPageInfo);
    }

    @Override
    public void insertSysPermission(RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        //校验入参 并转换成entity
        SysPermissionEntity sysPermissionEntity = this.checkSysPermissionReqBean(reqBeanModel);
        sysPermissionEntity.setCreateUser(reqBeanModel.getUserId());
        Integer i = this.sysPermissionMapper.insertSelective(sysPermissionEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "新增菜单失败!");
    }

    /**
     * 校验入参 并转换成entity
     * @param reqBeanModel
     * @return
     */
    private SysPermissionEntity checkSysPermissionReqBean(RequestBeanModel<SysPermissionReqBean> reqBeanModel){
        SysPermissionEntity sysPermissionEntity = new SysPermissionEntity();
        SysPermissionReqBean sysPermissionReqBean = reqBeanModel.getReqData();
        String name = sysPermissionReqBean.getName();
        Assert.hasText(name , "菜单名称不能为空");
        Assert.isTrue(name.length() <= 20 ,"菜单名太长,请修改!");
        boolean flag = this.pulldownMenuService.checkBlankSpace(name);
        Assert.isTrue(flag , "菜单名不能包含空格!");
        SysPermissionEntityExample sysPermissionEntityExample = new SysPermissionEntityExample();
        SysPermissionEntityExample.Criteria criteria = sysPermissionEntityExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        if(null != sysPermissionReqBean.getId()){
            criteria.andIdNotEqualTo(sysPermissionReqBean.getId());
        }
        List<SysPermissionEntity> sysPermissionEntityList = this.sysPermissionMapper.selectByExample(sysPermissionEntityExample);
        Assert.isTrue(sysPermissionEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "名称已经存在!");
        SysPermissionEntityExample sysPermissionEntityExampleBySortNo = new SysPermissionEntityExample();
        SysPermissionEntityExample.Criteria criteriaBySortNo = sysPermissionEntityExampleBySortNo.createCriteria();
        Byte permissionType = sysPermissionReqBean.getPermissionType();
        Assert.notNull(permissionType , "权限类型不能为空!");
        if(!permissionType.equals(DictionaryConstants.PERMISSION_TYPE_ZERO) && permissionType != DictionaryConstants.PERMISSION_TYPE_ONE && permissionType != DictionaryConstants.PERMISSION_TYPE_TWO && permissionType != DictionaryConstants.PERMISSION_TYPE_THREE ){
            throw new BusinessException("权限类型不存在!");
        }
        Byte sortNo = sysPermissionReqBean.getSortNo();
        Assert.notNull(sortNo , "排列序号不能为空!");
        Long parentId = sysPermissionReqBean.getParentId();
        Assert.notNull(parentId ,"父ID不能为空!");
        if(!(Long.valueOf(DictionaryConstants.ALL_BUSINESS_ZERO).equals(parentId))){
            //根据父ID查询是否是一级菜单
            SysPermissionEntity sysPermissionEntityById = this.sysPermissionMapper.selectByPrimaryKey(parentId);
            Assert.notNull(sysPermissionEntityById , "上级菜单不存在!");
            if(!(Long.valueOf(DictionaryConstants.ALL_BUSINESS_ZERO).equals(sysPermissionEntityById.getParentId()))){
                throw new BusinessException("上级菜单只能是一级菜单!");
            }
        }else{
            sysPermissionEntity.setPermissionClass(sysPermissionReqBean.getPermissionClass());
        }
        criteriaBySortNo.andSortNoEqualTo(sortNo);
        criteriaBySortNo.andPermissionTypeEqualTo(permissionType);
        criteriaBySortNo.andParentIdEqualTo(parentId);
        sysPermissionEntity.setParentId(parentId);
        if(null != sysPermissionReqBean.getId()){
            criteriaBySortNo.andIdNotEqualTo(sysPermissionReqBean.getId());
        }
        List<SysPermissionEntity> sysPermissionEntityListBySortNo = this.sysPermissionMapper.selectByExample(sysPermissionEntityExampleBySortNo);
        Assert.isTrue(sysPermissionEntityListBySortNo.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "同样的权限类型,同样的权限等级已经存在此排序号!");
        sysPermissionEntity.setName(name);
        sysPermissionEntity.setPermissionType(permissionType);
        sysPermissionEntity.setSortNo(sortNo);
        sysPermissionEntity.setTargetPage(sysPermissionReqBean.getTargetPage());
        sysPermissionEntity.setRemarks(sysPermissionReqBean.getRemarks());
        sysPermissionEntity.setPermissionClass(sysPermissionReqBean.getPermissionClass());
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysPermissionEntity.setLastUpdateUser(sysUserEntity.getRealName());
        return sysPermissionEntity;
    }

    @Override
    public void updateSysPermission(RequestBeanModel<SysPermissionReqBean> reqBeanModel) {
        Long id = reqBeanModel.getReqData().getId();
        Assert.notNull(id , "请选择一条数据,ID不能为空!");
        //校验入参 并转换成entity
        SysPermissionEntity sysPermissionEntity = this.checkSysPermissionReqBean(reqBeanModel);
        sysPermissionEntity.setLastUpdateTime(new Date());
        sysPermissionEntity.setId(id);
        Integer i = this.sysPermissionMapper.updateByPrimaryKeySelective(sysPermissionEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "修改菜单失败!");
    }

    @Override
    public void deleteSysPermission(RequestBeanModel<List<SingleParam>> reqBeanModel) {
        List<SingleParam> singleParamList = reqBeanModel.getReqData();
        Assert.notEmpty(singleParamList , "请至少选择一条数据!");
        SysPermissionEntity sysPermissionEntity = new SysPermissionEntity();
        sysPermissionEntity.setStatus(DictionaryConstants.DETELE);
        sysPermissionEntity.setLastUpdateTime(new Date());
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysPermissionEntity.setLastUpdateUser(sysUserEntityByid.getRealName());

        SysRolePermissionEntity sysRolePermissionEntity = new SysRolePermissionEntity();
        sysRolePermissionEntity.setStatus(DictionaryConstants.DETELE);
        sysRolePermissionEntity.setLastUpdateTime(new Date());
        sysRolePermissionEntity.setLastUpdateUser(reqBeanModel.getUserId());
        SysRolePermissionEntityExample sysRolePermissionEntityExample = new SysRolePermissionEntityExample();
        SysRolePermissionEntityExample.Criteria criteria = sysRolePermissionEntityExample.createCriteria();
        criteria.andLastUpdateTimeEqualTo(new Date());
        singleParamList.forEach(singleParam -> {
            Long id = Long.valueOf(singleParam.getParam());
            sysPermissionEntity.setId(id);
            Integer i = this.sysPermissionMapper.updateByPrimaryKeySelective(sysPermissionEntity);
            Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "删除数据失败!");
            criteria.andPermissionIdEqualTo(id);
            this.sysRolePermissionMapper.updateByExample(sysRolePermissionEntity , sysRolePermissionEntityExample);
        });
    }
}

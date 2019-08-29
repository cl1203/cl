package com.cl.service.impl;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.*;
import com.cl.entity.*;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ISysRoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysRoleServiceImpl
 * @Description 权限角色实现类
 * @Author 陈龙
 * @Date 2019/8/6 20:07
 * @Version 1.0
 **/
@Service
@Transactional
public class SysRoleServiceImpl implements ISysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private IObjectTransformer<SysRoleEntity , SysRoleResBean> sysRoleTransform;

    @Override
    public PageInfo<SysRoleResBean> querySysRoleList(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        SysRoleReqBean sysRoleReqBean = reqBeanModel.getReqData();
        if(sysRoleReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysRoleReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        PageInfo<SysRoleEntity> pageInfo = this.sysRoleMapper.selectSysRolePageInfo(sysRoleReqBean , orgId);
        return this.sysRoleTransform.transform(pageInfo);
    }

    @Override
    public void insertSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        //入参校验  并转换为entity
        SysRoleEntity sysRoleEntity = this.checkRoleReqBean(reqBeanModel , orgId);
        sysRoleEntity.setCreateUser(reqBeanModel.getUserId());
        sysRoleEntity.setOrgId(orgId);
        Integer i = this.sysRoleMapper.insertSelective(sysRoleEntity);
        Assert.isTrue(i == 1 , "新增角色失败!");
        //新增角色和菜单权限关系表数据
        this.insertSysRoelPermission(sysRoleEntity.getId() , reqBeanModel);
    }

    /**
     * 新增角色和菜单权限关系表数据
     * @param roleId 角色id
     * @param reqBeanModel 请求对象
     */
    private void insertSysRoelPermission(Long roleId , RequestBeanModel<SysRoleReqBean> reqBeanModel){
        List<Long> permissionIdList = reqBeanModel.getReqData().getPermissionIdList();
        Assert.notEmpty(permissionIdList , "请选择需要绑定的菜单权限!");
        SysRolePermissionEntity sysRolePermissionEntity = new SysRolePermissionEntity();
        sysRolePermissionEntity.setRoleId(roleId);
        sysRolePermissionEntity.setCreateUser(reqBeanModel.getUserId());
        sysRolePermissionEntity.setLastUpdateUser(reqBeanModel.getUserId());
        permissionIdList.forEach(permissionId ->{
            SysPermissionEntity sysPermissionEntity = this.sysPermissionMapper.selectByPrimaryKey(permissionId);
            if(null != sysPermissionEntity && sysPermissionEntity.getStatus().equals(DictionaryConstants.AVAILABLE)){
                sysRolePermissionEntity.setPermissionId(permissionId);
                Integer i = this.sysRolePermissionMapper.insertSelective(sysRolePermissionEntity);
                Assert.isTrue(i == 1 , "新增角色和菜单权限关系表失败! 菜单id: " + permissionId);
            }else{
                throw new BusinessException("菜单id: " + permissionId + ",对应的菜单不存在 , 或者已被删除, 请重新选择!");
            }
        });
    }

    /**
     * 校验reqBean 并转换entity
     * @param reqBeanModel 请求对象
     * @param orgId 组织id
     * @return
     */
    private SysRoleEntity checkRoleReqBean(RequestBeanModel<SysRoleReqBean> reqBeanModel , Long orgId ){
        SysRoleReqBean sysRoleReqBean = reqBeanModel.getReqData();
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        String roleName = sysRoleReqBean.getName();
        Assert.hasText(roleName , "角色名不能为空!");
        Assert.isTrue(roleName.length() <= 20 ,"角色名太长,请修改!");
        boolean flag = this.pulldownMenuService.checkBlankSpace(roleName);
        Assert.isTrue(flag , "角色名不能包含空格!");
        //根据ID和角色名称查询是否存在  如果id为空 代表为新增校验 否则为修改校验
        SysRoleEntityExample sysRoleEntityExample = new SysRoleEntityExample();
        SysRoleEntityExample.Criteria criteria = sysRoleEntityExample.createCriteria();
        criteria.andNameEqualTo(roleName);
        if(null != sysRoleReqBean.getId()){
            criteria.andIdNotEqualTo(sysRoleReqBean.getId());
        }
        criteria.andOrgIdEqualTo(orgId);
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        List<SysRoleEntity> sysRoleEntityList = this.sysRoleMapper.selectByExample(sysRoleEntityExample);
        Assert.isTrue(sysRoleEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "该组织下已有相同角色名,请修改!");
        //查询上级角色是否存在
        if(null != sysRoleReqBean.getParentId() && !(Long.valueOf(DictionaryConstants.ALL_BUSINESS_ZERO).equals(sysRoleEntity.getParentId()))){
            SysRoleEntity sysRoleEntityByParentId = this.sysRoleMapper.selectByPrimaryKey(sysRoleReqBean.getParentId());
            Assert.notNull(sysRoleEntityByParentId , "上级角色不存在,请重新选择!");
            Assert.isTrue(sysRoleEntityByParentId.getStatus().equals(DictionaryConstants.AVAILABLE), "上级角色不存在,请重新选择!");
            sysRoleEntity.setParentId(sysRoleReqBean.getParentId());
        }
        sysRoleEntity.setName(roleName);
        sysRoleEntity.setRemark(sysRoleReqBean.getRemark());
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysRoleEntity.setLastUpdateUser(sysUserEntity.getRealName());
        return sysRoleEntity;
    }

    @Override
    public void updateSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        Long id = reqBeanModel.getReqData().getId();
        Assert.notNull(id , "请选择一条数据,主键ID不能为空!");
        SysRoleEntity sysRoleEntity = this.sysRoleMapper.selectByPrimaryKey(id);
        Assert.notNull(sysRoleEntity , "此id对应的数据不存在!");
        Assert.isTrue(sysRoleEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "此id对应的数据已被删除!");
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        //入参校验  并转换为entity
        sysRoleEntity = this.checkRoleReqBean(reqBeanModel , orgId);
        sysRoleEntity.setLastUpdateTime(new Date());
        sysRoleEntity.setId(id);
        Integer i = this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "修改角色失败!");
        //删除角色绑定的权限
        SysRolePermissionEntityExample sysRolePermissionEntityExample = new SysRolePermissionEntityExample();
        SysRolePermissionEntityExample.Criteria criteria = sysRolePermissionEntityExample.createCriteria();
        criteria.andRoleIdEqualTo(id);
        this.sysRolePermissionMapper.deleteByExample(sysRolePermissionEntityExample);
        //新增角色和菜单权限关系表数据
        this.insertSysRoelPermission(sysRoleEntity.getId() , reqBeanModel);
    }

    @Override
    public void deleteSysRole(RequestBeanModel<List<SingleParam>> reqBeanModel) {
        List<SingleParam> roleIdList = reqBeanModel.getReqData();
        Assert.isTrue(roleIdList.size() > DictionaryConstants.ALL_BUSINESS_ZERO , "至少选择一条需要删除的数据!");
        //删除角色数据  删除角色和用户关系数据 删除角色和菜单权限数据
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        sysRoleEntity.setStatus(DictionaryConstants.DETELE);
        sysRoleEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        sysRoleEntity.setLastUpdateTime(new Date());

        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setStatus(DictionaryConstants.DETELE);
        sysUserRoleEntity.setLastUpdateUser(reqBeanModel.getUserId());
        sysUserRoleEntity.setLastUpdateTime(new Date());
        SysUserRoleEntityExample sysUserRoleEntityExample = new SysUserRoleEntityExample();
        SysUserRoleEntityExample.Criteria criteriaByUserRole = sysUserRoleEntityExample.createCriteria();

        SysRolePermissionEntity sysRolePermissionEntity = new SysRolePermissionEntity();
        sysRolePermissionEntity.setStatus(DictionaryConstants.DETELE);
        sysRolePermissionEntity.setLastUpdateUser(reqBeanModel.getUserId());
        sysRolePermissionEntity.setLastUpdateTime(new Date());
        SysRolePermissionEntityExample sysRolePermissionEntityExample = new SysRolePermissionEntityExample();
        SysRolePermissionEntityExample.Criteria criteriaByRolePermission = sysRolePermissionEntityExample.createCriteria();

        roleIdList.forEach(singleParam ->{
            sysRoleEntity.setId(Long.valueOf(singleParam.getParam()));
            Integer i = this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleEntity);
            Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "删除角色数据失败!");
            criteriaByUserRole.andRoleIdEqualTo(sysRoleEntity.getId());
            this.sysUserRoleMapper.updateByExampleSelective(sysUserRoleEntity , sysUserRoleEntityExample);
            criteriaByRolePermission.andRoleIdEqualTo(sysRoleEntity.getId());
            this.sysRolePermissionMapper.updateByExampleSelective(sysRolePermissionEntity , sysRolePermissionEntityExample);
        });
    }
}

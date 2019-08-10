package com.cl.service.impl;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysRoleMapper;
import com.cl.dao.SysRolePermissionMapper;
import com.cl.entity.SysRoleEntity;
import com.cl.entity.SysRoleEntityExample;
import com.cl.entity.SysRolePermissionEntity;
import com.cl.service.ISysRoleService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
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
    private IObjectTransformer<SysRoleEntity , SysRoleResBean> sysRoleTransform;

    @Override
    public PageInfo<SysRoleResBean> querySysRoleList(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        SysRoleReqBean sysRoleReqBean = reqBeanModel.getReqData();
        if(sysRoleReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysRoleReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        PageInfo<SysRoleEntity> pageInfo = this.sysRoleMapper.selectSysRolePageInfo(sysRoleReqBean);
        PageInfo<SysRoleResBean> roleResBeanPageInfo = this.sysRoleTransform.transform(pageInfo);
        return roleResBeanPageInfo;
    }

    @Override
    public void insertSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {
        //根据用户id查询对应的组织
        Long orgId = selectOrgIdByUserId(reqBeanModel.getUserId());
        //入参校验  并转换为entity
        SysRoleEntity sysRoleEntity = this.checkRoleReqBean(reqBeanModel , orgId);
        sysRoleEntity.setCreateUser(reqBeanModel.getUsername());
        sysRoleEntity.setOrgId(orgId);
        Integer i = this.sysRoleMapper.insertSelective(sysRoleEntity);
        Assert.isTrue(i == 1 , "新增角色失败!");
        //新增角色和菜单权限关系表数据
        this.insertSysRoelPermission(sysRoleEntity.getId() , reqBeanModel);
    }

    /**
     * 新增角色和菜单权限关系表数据
     */
    private void insertSysRoelPermission(Long roleId , RequestBeanModel<SysRoleReqBean> reqBeanModel){
        List<Long> permissionIdList = reqBeanModel.getReqData().getPermissionIdList();
        Assert.notEmpty(permissionIdList , "请选择菜单权限!");
        SysRolePermissionEntity sysRolePermissionEntity = new SysRolePermissionEntity();
        sysRolePermissionEntity.setRoleId(roleId);
        permissionIdList.forEach(permissionId ->{
            SysRolePermissionEntity sysRolePermissionEntityById = this.sysRolePermissionMapper.selectByPrimaryKey(permissionId);
            if(null != sysRolePermissionEntityById && sysRolePermissionEntityById.getStatus() == DictionaryConstants.AVAILABLE){
                sysRolePermissionEntity.setPermissionId(permissionId);
            }else{
                throw new BusinessException("菜单id: " + permissionId + "不存在 , 或者已被删除, 请重新选择!");
            }
        });
        sysRolePermissionEntity.setCreateUser(reqBeanModel.getUserId());
        sysRolePermissionEntity.setLastUpdateUser(reqBeanModel.getUserId());
        int i = this.sysRolePermissionMapper.insertSelective(sysRolePermissionEntity);
        Assert.isTrue(i == 1 , "新增角色和菜单权限关系表失败!");
    }

    /**
     * 根据用户id查询对应的组织
     * @param userId
     * @return
     */
    private Long selectOrgIdByUserId(String userId){
        List<Long> orgIdList = this.sysRoleMapper.selectOrgIdByUserId(Long.valueOf(userId));
        Assert.isTrue(orgIdList.size() > 0 , "用户未绑定组织!");
        Long orgId = orgIdList.get(0);
        return orgId;
    }


    /**
     * 校验reqBean
     * @param
     */
    private SysRoleEntity checkRoleReqBean(RequestBeanModel<SysRoleReqBean> reqBeanModel , Long orgId ){
        SysRoleReqBean sysRoleReqBean = reqBeanModel.getReqData();
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        String roleName = sysRoleReqBean.getName();
        Assert.hasText(roleName , "角色名不能为空!");
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
        Assert.isTrue(sysRoleEntityList.size() == 0 , "该组织下已有相同角色名,请修改!");
        //查询上级角色是否存在
        if(null != sysRoleReqBean.getParentId()){
            SysRoleEntity sysRoleEntityByParentId = this.sysRoleMapper.selectByPrimaryKey(sysRoleReqBean.getParentId());
            Assert.notNull(sysRoleEntityByParentId , "上级角色不存在,请重新选择!");
            Assert.isTrue(sysRoleEntityByParentId.getStatus() == DictionaryConstants.AVAILABLE , "上级角色不存在,请重新选择!");
            sysRoleEntity.setParentId(sysRoleReqBean.getParentId());
        }
        sysRoleEntity.setName(roleName);
        if(StringUtils.isNotBlank(sysRoleReqBean.getRemark())){
            sysRoleEntity.setRemark(sysRoleReqBean.getRemark());
        }
        sysRoleEntity.setLastUpdateUser(reqBeanModel.getUsername());
        return sysRoleEntity;
    }

    @Override
    public void updateSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {

    }

    @Override
    public void deleteSysRole(RequestBeanModel<SysRoleReqBean> reqBeanModel) {

    }
}

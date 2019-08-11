package com.cl.dao;

import com.cl.bean.req.SysRoleReqBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysRoleEntity;
import com.cl.entity.SysRoleEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysRoleMapper继承基类
 */
@Repository
public interface SysRoleMapper extends MyBatisBaseDao<SysRoleEntity, Long, SysRoleEntityExample> {

    default PageInfo<SysRoleEntity> selectSysRolePageInfo(SysRoleReqBean sysRoleReqBean){
        Page<SysRoleEntity> page = PageHelper.startPage(sysRoleReqBean.getPageNum() , sysRoleReqBean.getPageSize() , "last_update_time DESC");
        SysRoleEntityExample sysRoleEntityExample = new SysRoleEntityExample();
        SysRoleEntityExample.Criteria criteria = sysRoleEntityExample.createCriteria();
        if(null != sysRoleReqBean.getId()){
            criteria.andIdEqualTo(sysRoleReqBean.getId());
        }
        if(null != sysRoleReqBean.getOrgId()){
            criteria.andOrgIdEqualTo((sysRoleReqBean.getOrgId()));
        }
        criteria.andStatusEqualTo(Byte.valueOf(DictionaryConstants.ALL_BUSINESS_ONE + ""));
        List<SysRoleEntity> sysRoleEntityList = this.selectByExample(sysRoleEntityExample);
        PageInfo<SysRoleEntity> pageInfo = new PageInfo<>(page);
        pageInfo.setList(sysRoleEntityList);
        return pageInfo;
    }

    /**
     * 根据 角色ID查询用户信息
     * @param roleId
     * @return
     */
    List<SysUserResBean> selectUserByRoleId(Long roleId);

    /**
     * 根据角色ID查询菜单权限
     * @param roleId
     * @return
     */
    List<SysPermissionResBean> selectPermissionByRoleId(Long roleId);


    /**
     * 根据用户id查询对应的组织
     * @param userId
     * @return
     */
    List<Long> selectOrgIdByUserId(Long userId);

    /**
     * 根据角色id删除角色权限关系表
     * @param roleId
     * @return
     */
    Integer updateRolePermission(Long roleId);

    /**
     * 根据角色id删除角色用户关系表
     * @param roleId
     * @return
     */
    Integer updateUserRole(Long roleId);
}
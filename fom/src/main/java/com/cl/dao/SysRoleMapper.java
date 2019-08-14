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
import org.apache.commons.lang3.StringUtils;
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
        if(StringUtils.isNotBlank(sysRoleReqBean.getName())){
            criteria.andNameEqualTo(sysRoleReqBean.getName());
        }
        if(!sysRoleReqBean.getOrgId().equals(Long.valueOf(DictionaryConstants.ADMIN_ORG_ID))){
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

}
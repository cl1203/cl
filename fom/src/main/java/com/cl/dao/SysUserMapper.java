package com.cl.dao;

import com.cl.bean.req.SysUserReqBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysUserEntity;
import com.cl.entity.SysUserEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserMapper extends MyBatisBaseDao<SysUserEntity, Long, SysUserEntityExample> {

    default PageInfo<SysUserEntity> selectSysUserPageInfo(SysUserReqBean sysUserReqBean){
        Page<SysUserEntity> page = PageHelper.startPage(sysUserReqBean.getPageNum() , sysUserReqBean.getPageSize() , "last_update_time DESC");
        SysUserEntityExample sysUserEntityExample = new SysUserEntityExample();
        SysUserEntityExample.Criteria criteria = sysUserEntityExample.createCriteria();
        if(StringUtils.isNotBlank(sysUserReqBean.getUserName())){
            criteria.andUserNameEqualTo(sysUserReqBean.getUserName());
        }
        if(StringUtils.isNotBlank(sysUserReqBean.getRealName())){
            criteria.andRealNameEqualTo(sysUserReqBean.getRealName());
        }
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        if(sysUserReqBean.getOrgId() != Long.valueOf(DictionaryConstants.ADMIN_ORG_ID)){
            criteria.andOrgIdEqualTo((sysUserReqBean.getOrgId()));
        }
        List<SysUserEntity> sysUserEntityList = this.selectByExample(sysUserEntityExample);
        PageInfo<SysUserEntity> sysUserEntityPageInfo = new PageInfo<>(page);
        sysUserEntityPageInfo.setList(sysUserEntityList);
        return sysUserEntityPageInfo;
    }

    /**
     * 根据userid查询所属角色
     * @param userId
     * @return
     */
    List<SysRoleResBean> selectRoleByUserId(Long userId);

    /**
     * 根据用户id查询对应的角色绑定的所有权限
     * @param userId
     * @return
     */
    List<SysPermissionResBean> selectPermissionListByUserId(Long userId);
}
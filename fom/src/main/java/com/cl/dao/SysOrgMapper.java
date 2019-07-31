package com.cl.dao;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysOrgEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysOrgMapper继承基类
 */
@Repository
public interface SysOrgMapper extends MyBatisBaseDao<SysOrgEntity, Long, SysOrgEntityExample> {

    default PageInfo<SysOrgEntity> selectSysOrgPageInfo(SysOrgReqBean sysOrgReqBean){
        Page<SysOrgEntity> page = PageHelper.startPage(sysOrgReqBean.getPageNum() , sysOrgReqBean.getPageSize() , "last_update_time DESC");
        SysOrgEntityExample sysOrgEntityExample = new SysOrgEntityExample();
        SysOrgEntityExample.Criteria criteria = sysOrgEntityExample.createCriteria();
        if(StringUtils.isNotBlank(sysOrgReqBean.getName())){
            criteria.andNameEqualTo(sysOrgReqBean.getName());
        }
        List<SysOrgEntity> sysOrgEntityList = this.selectByExample(sysOrgEntityExample);
        PageInfo<SysOrgEntity> sysOrgEntityPageInfo = new PageInfo<>(page);
        sysOrgEntityPageInfo.setList(sysOrgEntityList);
        return sysOrgEntityPageInfo;
    }

    /**
     * 根据组织ID查询所有角色
     * @param orgId
     * @return
     */
    List<Long> selectRoleIdListByOrgId(Long orgId);

    /**
     * 根据角色ID查询所有用户
     * @param roleIdList
     * @return
     */
    List<Long> selectUserIdListByRoleId(@Param("roleIdList")List<Long> roleIdList);

    /**
     * 删除角色用户关系表
     * @param roleIdList
     * @return
     */
    int deleteUserRole(@Param("roleIdList")List<Long> roleIdList);

    SysOrgEntity selectSysOrgByIdAndName(SysOrgReqBean sysOrgReqBean);
}
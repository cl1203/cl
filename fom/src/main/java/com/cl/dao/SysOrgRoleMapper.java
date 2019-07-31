package com.cl.dao;

import com.cl.entity.SysOrgRoleEntity;
import com.cl.entity.SysOrgRoleEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysOrgRoleMapper继承基类
 */
@Repository
public interface SysOrgRoleMapper extends MyBatisBaseDao<SysOrgRoleEntity, Long, SysOrgRoleEntityExample> {
}
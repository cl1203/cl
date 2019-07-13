package com.cl.dao;

import com.cl.entity.SysUserRoleEntity;
import com.cl.entity.SysUserRoleEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserRoleMapper继承基类
 */
@Repository
public interface SysUserRoleMapper extends MyBatisBaseDao<SysUserRoleEntity, Long, SysUserRoleEntityExample> {
}
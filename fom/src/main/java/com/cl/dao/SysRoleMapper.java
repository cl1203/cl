package com.cl.dao;

import com.cl.entity.SysRoleEntity;
import com.cl.entity.SysRoleEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysRoleMapper继承基类
 */
@Repository
public interface SysRoleMapper extends MyBatisBaseDao<SysRoleEntity, Long, SysRoleEntityExample> {
}
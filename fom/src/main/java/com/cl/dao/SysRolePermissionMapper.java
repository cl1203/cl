package com.cl.dao;

import com.cl.entity.SysRolePermissionEntity;
import com.cl.entity.SysRolePermissionEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysRolePermissionMapper继承基类
 */
@Repository
public interface SysRolePermissionMapper extends MyBatisBaseDao<SysRolePermissionEntity, Long, SysRolePermissionEntityExample> {
}
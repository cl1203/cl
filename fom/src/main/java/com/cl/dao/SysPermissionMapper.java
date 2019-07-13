package com.cl.dao;

import com.cl.entity.SysPermissionEntity;
import com.cl.entity.SysPermissionEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysPermissionMapper继承基类
 */
@Repository
public interface SysPermissionMapper extends MyBatisBaseDao<SysPermissionEntity, Long, SysPermissionEntityExample> {
}
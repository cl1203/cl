package com.cl.dao;

import com.cl.entity.SysUserEntity;
import com.cl.entity.SysUserEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserMapper extends MyBatisBaseDao<SysUserEntity, Long, SysUserEntityExample> {
}
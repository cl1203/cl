package com.cl.dao;

import com.cl.entity.SysUserOrgEntity;
import com.cl.entity.SysUserOrgEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysUserOrgMapper继承基类
 */
@Repository
public interface SysUserOrgMapper extends MyBatisBaseDao<SysUserOrgEntity, Long, SysUserOrgEntityExample> {
}
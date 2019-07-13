package com.cl.dao;

import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysOrgEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysOrgMapper继承基类
 */
@Repository
public interface SysOrgMapper extends MyBatisBaseDao<SysOrgEntity, Long, SysOrgEntityExample> {
}
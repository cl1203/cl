package com.cl.dao;

import com.cl.entity.SysCodeEntity;
import com.cl.entity.SysCodeEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysCodeMapper继承基类
 */
@Repository
public interface SysCodeMapper extends MyBatisBaseDao<SysCodeEntity, Long, SysCodeEntityExample> {
}
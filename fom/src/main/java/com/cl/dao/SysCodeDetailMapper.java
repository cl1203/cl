package com.cl.dao;

import com.cl.entity.SysCodeDetailEntity;
import com.cl.entity.SysCodeDetailEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysCodeDetailMapper继承基类
 */
@Repository
public interface SysCodeDetailMapper extends MyBatisBaseDao<SysCodeDetailEntity, Long, SysCodeDetailEntityExample> {
}
package com.cl.dao;

import com.cl.entity.SecondaryProcessEntity;
import com.cl.entity.SecondaryProcessEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SecondaryProcessMapper继承基类
 */
@Repository
public interface SecondaryProcessMapper extends MyBatisBaseDao<SecondaryProcessEntity, Long, SecondaryProcessEntityExample> {
}
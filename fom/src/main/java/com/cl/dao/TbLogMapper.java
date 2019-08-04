package com.cl.dao;

import com.cl.entity.TbLogEntity;
import com.cl.entity.TbLogEntityExample;
import org.springframework.stereotype.Repository;

/**
 * TbLogMapper继承基类
 */
@Repository
public interface TbLogMapper extends MyBatisBaseDao<TbLogEntity, Integer, TbLogEntityExample> {
}
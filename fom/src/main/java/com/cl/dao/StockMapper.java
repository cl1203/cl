package com.cl.dao;

import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;
import org.springframework.stereotype.Repository;

/**
 * StockMapper继承基类
 */
@Repository
public interface StockMapper extends MyBatisBaseDao<StockEntity, Long, StockEntityExample> {
}
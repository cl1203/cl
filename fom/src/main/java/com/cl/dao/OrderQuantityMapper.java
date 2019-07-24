package com.cl.dao;

import com.cl.entity.OrderQuantityEntity;
import com.cl.entity.OrderQuantityEntityExample;
import org.springframework.stereotype.Repository;

/**
 * OrderQuantityMapper继承基类
 */
@Repository
public interface OrderQuantityMapper extends MyBatisBaseDao<OrderQuantityEntity, Long, OrderQuantityEntityExample> {
}
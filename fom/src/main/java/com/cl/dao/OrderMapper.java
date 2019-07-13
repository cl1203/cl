package com.cl.dao;

import com.cl.entity.OrderEntity;
import com.cl.entity.OrderEntityExample;
import org.springframework.stereotype.Repository;

/**
 * OrderMapper继承基类
 */
@Repository
public interface OrderMapper extends MyBatisBaseDao<OrderEntity, Long, OrderEntityExample> {
}
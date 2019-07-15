package com.cl.dao;

import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderManageEntityExample;
import org.springframework.stereotype.Repository;

/**
 * OrderManageMapper继承基类
 */
@Repository
public interface OrderManageMapper extends MyBatisBaseDao<OrderManageEntity, Long, OrderManageEntityExample> {
}
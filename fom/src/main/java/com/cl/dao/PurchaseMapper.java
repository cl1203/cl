package com.cl.dao;

import com.cl.entity.PurchaseEntity;
import com.cl.entity.PurchaseEntityExample;
import org.springframework.stereotype.Repository;

/**
 * PurchaseMapper继承基类
 */
@Repository
public interface PurchaseMapper extends MyBatisBaseDao<PurchaseEntity, Long, PurchaseEntityExample> {
}
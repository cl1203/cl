package com.cl.dao;

import com.cl.entity.PurchaseManageEntity;
import com.cl.entity.PurchaseManageEntityExample;
import org.springframework.stereotype.Repository;

/**
 * PurchaseManageMapper继承基类
 */
@Repository
public interface PurchaseManageMapper extends MyBatisBaseDao<PurchaseManageEntity, Long, PurchaseManageEntityExample> {
}
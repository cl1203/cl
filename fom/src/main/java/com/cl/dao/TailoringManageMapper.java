package com.cl.dao;

import com.cl.entity.TailoringManageEntity;
import com.cl.entity.TailoringManageEntityExample;
import org.springframework.stereotype.Repository;

/**
 * TailoringManageMapper继承基类
 */
@Repository
public interface TailoringManageMapper extends MyBatisBaseDao<TailoringManageEntity, Long, TailoringManageEntityExample> {
}
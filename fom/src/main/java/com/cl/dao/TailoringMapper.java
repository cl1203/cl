package com.cl.dao;

import com.cl.entity.TailoringEntity;
import com.cl.entity.TailoringEntityExample;
import org.springframework.stereotype.Repository;

/**
 * TailoringMapper继承基类
 */
@Repository
public interface TailoringMapper extends MyBatisBaseDao<TailoringEntity, Long, TailoringEntityExample> {
}
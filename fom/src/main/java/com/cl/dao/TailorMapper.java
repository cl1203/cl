package com.cl.dao;

import com.cl.entity.TailorEntity;
import com.cl.entity.TailorEntityExample;
import org.springframework.stereotype.Repository;

/**
 * TailorMapper继承基类
 */
@Repository
public interface TailorMapper extends MyBatisBaseDao<TailorEntity, Long, TailorEntityExample> {
}
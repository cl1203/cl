package com.cl.dao;

import com.cl.entity.AbnormalEntity;
import com.cl.entity.AbnormalEntityExample;
import org.springframework.stereotype.Repository;

/**
 * AbnormalMapper继承基类
 */
@Repository
public interface AbnormalMapper extends MyBatisBaseDao<AbnormalEntity, Long, AbnormalEntityExample> {
}
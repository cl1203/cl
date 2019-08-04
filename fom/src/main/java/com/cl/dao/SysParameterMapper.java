package com.cl.dao;

import com.cl.entity.SysParameterEntity;
import com.cl.entity.SysParameterEntityExample;
import org.springframework.stereotype.Repository;

/**
 * SysParameterMapper继承基类
 */
@Repository
public interface SysParameterMapper extends MyBatisBaseDao<SysParameterEntity, Long, SysParameterEntityExample> {
}
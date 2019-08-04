package com.cl.dao;

import com.cl.entity.TbLog;

public interface TbLogMapper {
    int insert(TbLog record);

	int insertSelective(TbLog record);

}
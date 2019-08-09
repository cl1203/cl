package com.cl.dao;

import com.cl.bean.res.StockResBean;
import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * StockMapper继承基类
 */
@Repository
public interface StockMapper extends MyBatisBaseDao<StockEntity, Long, StockEntityExample> {

	List<StockResBean> selectByOrderNoList(List<String> skuList);

	List<String> selectOrderNoByParams(Map<String, Object> params);
}
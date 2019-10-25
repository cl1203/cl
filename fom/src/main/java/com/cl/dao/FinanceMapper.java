package com.cl.dao;

import com.cl.bean.req.FinanceReqBean;
import com.cl.entity.FinanceEntity;
import com.cl.entity.FinanceEntityExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * FinanceMapper继承基类
 */
@Repository
public interface FinanceMapper extends MyBatisBaseDao<FinanceEntity, Long, FinanceEntityExample> {

    List<FinanceEntity> selectFinanceList(FinanceReqBean financeReqBean);

    Long selectFinanceListTotal(FinanceReqBean financeReqBean);
}
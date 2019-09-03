package com.cl.dao;

import com.cl.bean.req.AbnormalReqBean;
import com.cl.bean.res.AbnormalResBean;
import com.cl.entity.AbnormalEntity;
import com.cl.entity.AbnormalEntityExample;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * AbnormalMapper继承基类
 */
@Repository
public interface AbnormalMapper extends MyBatisBaseDao<AbnormalEntity, Long, AbnormalEntityExample> {

	List<AbnormalResBean> selectAbnormalPurchaseList(AbnormalReqBean reqBean);

	List<AbnormalResBean> selectAbnormalTailorList(AbnormalReqBean reqBean);
}
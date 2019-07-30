package com.cl.dao;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.TailorResBean;
import com.cl.entity.TailorEntity;
import com.cl.entity.TailorEntityExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TailorMapper继承基类
 */
@Repository
public interface TailorMapper extends MyBatisBaseDao<TailorEntity, Long, TailorEntityExample> {

    /**
     *  查询裁剪列表
     * @param tailorReqBean
     * @return
     */
    List<TailorResBean> queryTailorList(TailorReqBean tailorReqBean);
}
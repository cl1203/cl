package com.cl.service;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.entity.TailorEntity;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName ITailorService
 * @Description 裁剪service
 * @Author 陈龙
 * @Date 2019/7/29 15:45
 * @Version 1.0
 **/
public interface ITailorService {

    /**
     * @Author 陈龙
     * @Description 查询裁剪列表
     * @Date 21:00 2019/7/29
     * @Param [reqBeanModel]
     * @return com.github.pagehelper.PageInfo<com.cl.bean.res.TailorResBean>
     **/
    PageInfo<TailorResBean> queryTailorList(RequestBeanModel<TailorReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 修改裁剪数据
     * @Date 21:12 2019/7/29
     * @Param [reqBeanModel]
     * @return void
     **/
    void updateTailor(RequestBeanModel<TailorReqBean> reqBeanModel);

    /**
     * @Author 陈龙
     * @Description 新增裁剪数据
     * @Date 21:15 2019/7/29
     * @Param [reqBeanModel]
     * @return void
     **/
    void insertTailor(TailorEntity tailorEntity);
}

package com.cl.service.impl;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.service.ITailorService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TailorServiceImpl
 * @Description 裁剪业务实现类
 * @Author 陈龙
 * @Date 2019/7/29 16:39
 * @Version 1.0
 **/
@Service
@Transactional
public class TailorServiceImpl implements ITailorService {
    @Override
    public PageInfo<TailorResBean> queryTailorList(RequestBeanModel<TailorReqBean> reqBeanModel) {
        return null;
    }

    @Override
    public void updateTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {

    }

    @Override
    public void insertTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {

    }
}

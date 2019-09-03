package com.cl.service;

import com.cl.bean.req.FinanceReqBean;
import com.cl.bean.res.FinanceResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.entity.FinanceEntity;
import com.github.pagehelper.PageInfo;

public interface IFinanceService {

    /**
     * 查询财务列表
     * @param reqBeanModel
     * @return
     */
    PageInfo<FinanceResBean> queryFinanceList(RequestBeanModel<FinanceReqBean> reqBeanModel);

    /**
     * 已裁剪后新增财务数据
     * @param financeEntity
     */
    void insertFinance(FinanceEntity financeEntity);

    /**
     * 编辑财务数据
     * @param reqBeanModel
     */
    void updateFinance(RequestBeanModel<FinanceReqBean> reqBeanModel);

}

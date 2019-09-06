package com.cl.service;

import com.cl.bean.req.SysDepartmentReqBean;
import com.cl.bean.res.SysDepartmentResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ISysDepartmentService {

    /**
     * 查询部门列表
     * @param reqBeanModel
     * @return
     */
    PageInfo<SysDepartmentResBean> querySysDepartmentList(RequestBeanModel<SysDepartmentReqBean> reqBeanModel);

    /**
     * 新增部门数据
     * @param reqBeanModel
     */
    void insertSysDepartment(RequestBeanModel<SysDepartmentReqBean> reqBeanModel);

    /**
     * 修改部门数据
     * @param reqBeanModel
     */
    void updateSysDepartment(RequestBeanModel<SysDepartmentReqBean> reqBeanModel);

    /**
     * 删除部门数据
     * @param reqBeanModel
     */
    void deleteSysDepartment(RequestBeanModel<List<SingleParam>> reqBeanModel);
}

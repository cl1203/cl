package com.cl.dao;

import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName PulldownMenuMapper
 * @Description 获取下拉菜单dao
 * @Author 陈龙
 * @Date 2019/7/20 19:16
 * @Version 1.0
 **/
@Repository
public interface PulldownMenuMapper {

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单 或者根据条件查询
     * @Date 14:16 2019/7/22
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryOrgPulldownMenu(PulldownMenuResBean pulldownMenuResBean);

    /**
     * @Author 陈龙
     * @Description 获取用户下拉菜单 或者根据条件查询
     * @Date 14:16 2019/7/22
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryUserPulldownMenu(PulldownMenuResBean pulldownMenuResBean);


    /**
     * @Author 陈龙
     * @Description 查询供应商名称下拉菜单
     * @Date 14:20 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    List<String> queryInputSupplierName();

    /**
     * @Author 陈龙
     * @Description 字典数据查询
     * @Date 14:20 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    List<DictItem> queryDictItemList(DictItem dictItem);
}

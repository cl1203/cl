package com.cl.service;

import com.cl.bean.res.PulldownMenuResBean;

import java.util.List;

/**
 * @ClassName IPulldownMenuService
 * @Description 获取下拉菜单service
 * @Author 陈龙
 * @Date 2019/7/20 18:53
 * @Version 1.0
 **/
public interface IPulldownMenuService {

    /**
     * @Author 陈龙
     * @Description 获取组织下拉菜单
     * @Date 20:14 2019/7/20
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryOrgPulldownMenu();
}

package com.cl.service;

import com.cl.bean.req.PulldownMenuReqBean;
import com.cl.bean.res.DictItem;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;

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
     * @Description 获取组织下拉菜单 或者根据条件查询
     * @Date 20:14 2019/7/20
     * @Param []
     * @return java.util.List<com.cl.bean.res.PulldownMenuResBean>
     **/
    List<PulldownMenuResBean> queryOrgPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel);

    /**
     *  获取用户下拉菜单 或者根据条件查询
     * @param requestBeanModel
     * @return
     */
    List<PulldownMenuResBean> queryUserPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel);

    /**
     * 获取菜单权限下拉菜单 或者根据条件查询
     * @param requestBeanModel
     * @return
     */
    List<PulldownMenuResBean> queryPermissionPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel);

    /**
     * 获部门下拉菜单 或者根据条件查询
     * @param requestBeanModel
     * @return
     */
    List<PulldownMenuResBean> queryDepartmentPulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel);

    /**
     * 获取角色下拉菜单 或者根据条件查询
     * @param requestBeanModel
     * @return
     */
    List<PulldownMenuResBean> queryRolePulldownMenu(RequestBeanModel<PulldownMenuReqBean> requestBeanModel);
    /**
     * @Author 陈龙
     * @Description 供应商名称的下拉菜单
     * @Date 12:10 2019/7/22
     * @Param [supplierName]
     * @return java.util.List<java.lang.String>
     **/
    List<SingleParam> queryInputSupplierName();

    /**
     * @Author 陈龙
     * @Description 字典表数据查询
     * @Date 15:56 2019/7/24
     * @Param []
     * @return java.util.List<java.lang.String>
     **/
    List<DictItem> queryDictItemList(RequestBeanModel<DictItem> requestBeanModel);

    /**
     * 根据用户id查询组织ID
     * @param userId
     * @return
     */
    Long selectOrgIdByUserId(Long userId);

    /**
     * 校验字符串是否包含了空格
     * @param str
     * @return
     */
    boolean checkBlankSpace(String str);

    /**
     * 给菜单list按父id查询对应的所有子菜单
     * @param sysPermissionResBeanList
     */
    void queryPermissionByParentId(List<SysPermissionResBean> sysPermissionResBeanList);

    /**
     * 查询所有菜单包括对应的所有子菜单
     * @return
     */
    List<SysPermissionResBean> queryPermissionAll();
}

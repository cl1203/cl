package com.cl.dao;

import com.cl.bean.req.SysUserReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysUserEntity;
import com.cl.entity.SysUserEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysUserMapper继承基类
 */
@Repository
public interface SysUserMapper extends MyBatisBaseDao<SysUserEntity, Long, SysUserEntityExample> {

    /**
     * 查询用户列表
     * @param sysUserReqBean
     * @return
     */
    List<SysUserResBean> selectSysUserList(SysUserReqBean sysUserReqBean);

    /**
     * 根据userid查询所属角色
     * @param userId
     * @return
     */
    List<SysRoleResBean> selectRoleByUserId(Long userId);
}
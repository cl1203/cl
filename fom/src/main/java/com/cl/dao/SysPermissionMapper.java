package com.cl.dao;

import com.cl.bean.req.SysPermissionReqBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysPermissionEntity;
import com.cl.entity.SysPermissionEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysPermissionMapper继承基类
 */
@Repository
public interface SysPermissionMapper extends MyBatisBaseDao<SysPermissionEntity, Long, SysPermissionEntityExample> {

    default PageInfo<SysPermissionEntity> selectSysPermissionPageInfo(SysPermissionReqBean sysPermissionReqBean){
        Page<SysPermissionEntity> page = PageHelper.startPage(sysPermissionReqBean.getPageNum() , sysPermissionReqBean.getPageSize() , "last_update_time DESC");
        SysPermissionEntityExample sysPermissionEntityExample = new SysPermissionEntityExample();
        SysPermissionEntityExample.Criteria criteria = sysPermissionEntityExample.createCriteria();
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        if(StringUtils.isNotBlank(sysPermissionReqBean.getName())){
            criteria.andNameEqualTo(sysPermissionReqBean.getName());
        }
        List<SysPermissionEntity> sysPermissionEntityList = this.selectByExample(sysPermissionEntityExample);
        PageInfo<SysPermissionEntity> sysPermissionEntityPageInfo = new PageInfo<>(page);
        sysPermissionEntityPageInfo.setList(sysPermissionEntityList);
        return sysPermissionEntityPageInfo;
    }

}
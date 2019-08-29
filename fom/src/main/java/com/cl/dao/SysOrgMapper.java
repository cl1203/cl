package com.cl.dao;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysOrgEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysOrgMapper继承基类
 */
@Repository
public interface SysOrgMapper extends MyBatisBaseDao<SysOrgEntity, Long, SysOrgEntityExample> {

    default PageInfo<SysOrgEntity> selectSysOrgPageInfo(SysOrgReqBean sysOrgReqBean){
        Page<SysOrgEntity> page = PageHelper.startPage(sysOrgReqBean.getPageNum() , sysOrgReqBean.getPageSize() , "last_update_time DESC");
        SysOrgEntityExample sysOrgEntityExample = new SysOrgEntityExample();
        SysOrgEntityExample.Criteria criteria = sysOrgEntityExample.createCriteria();
        if(StringUtils.isNotBlank(sysOrgReqBean.getName())){
            criteria.andNameEqualTo(sysOrgReqBean.getName());
        }
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        List<SysOrgEntity> sysOrgEntityList = this.selectByExample(sysOrgEntityExample);
        PageInfo<SysOrgEntity> sysOrgEntityPageInfo = new PageInfo<>(page);
        sysOrgEntityPageInfo.setList(sysOrgEntityList);
        return sysOrgEntityPageInfo;
    }

}
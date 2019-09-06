package com.cl.dao;

import com.cl.bean.req.SysDepartmentReqBean;
import com.cl.bean.req.SysRoleReqBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.entity.SysDepartmentEntity;
import com.cl.entity.SysDepartmentEntityExample;
import com.cl.entity.SysRoleEntity;
import com.cl.entity.SysRoleEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SysDepartmentMapper继承基类
 */
@Repository
public interface SysDepartmentMapper extends MyBatisBaseDao<SysDepartmentEntity, Long, SysDepartmentEntityExample> {

    default PageInfo<SysDepartmentEntity> selectSysRolePageInfo(SysDepartmentReqBean sysDepartmentReqBean){
        Page<SysDepartmentEntity> page = PageHelper.startPage(sysDepartmentReqBean.getPageNum() , sysDepartmentReqBean.getPageSize() , "last_update_time DESC");
        SysDepartmentEntityExample sysDepartmentEntityExample = new SysDepartmentEntityExample();
        SysDepartmentEntityExample.Criteria criteria = sysDepartmentEntityExample.createCriteria();
        if(StringUtils.isNotBlank(sysDepartmentReqBean.getName())){
            criteria.andNameEqualTo(sysDepartmentReqBean.getName());
        }
        if(null != sysDepartmentReqBean.getGrade()){
            criteria.andGradeEqualTo(sysDepartmentReqBean.getGrade());
        }
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        List<SysDepartmentEntity> sysDepartmentEntityList = this.selectByExample(sysDepartmentEntityExample);
        PageInfo<SysDepartmentEntity> pageInfo = new PageInfo<>(page);
        pageInfo.setList(sysDepartmentEntityList);
        return pageInfo;
    }
}
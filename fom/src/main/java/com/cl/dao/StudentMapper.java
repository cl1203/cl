package com.cl.dao;

import com.cl.bean.req.StudentReqBean;
import com.cl.comm.model.RequestBeanModel;
import com.cl.entity.StudentEntity;
import com.cl.entity.StudentEntityExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StudentMapper继承基类
 */
@Repository
public interface StudentMapper extends MyBatisBaseDao<StudentEntity, Long, StudentEntityExample> {
    default PageInfo<StudentEntity> selectStudentEntityPage(RequestBeanModel<StudentReqBean> requestBeanModel){
        StudentReqBean studentReqBean =requestBeanModel.getReqData();
        Page<StudentEntity> page = PageHelper.startPage(studentReqBean.getPageNum() ,studentReqBean.getPageSize() ,"id");
        StudentEntityExample studentEntityExample = new StudentEntityExample();
        StudentEntityExample.Criteria criteria = studentEntityExample.createCriteria();
        if(StringUtils.isNotBlank(studentReqBean.getName())) {
            criteria.andNameLike(studentReqBean.getName() + '%');
        }
        if(StringUtils.isNotBlank(studentReqBean.getAge())){
            criteria.andAgeEqualTo(Integer.valueOf(studentReqBean.getAge()));
        }
        if(StringUtils.isNotBlank(studentReqBean.getSex())){
            criteria.andSexEqualTo(studentReqBean.getSex());
        }
        //criteria.andStatusEqualTo(Byte.parseByte(studentReqBean.getStatus()));
        List<StudentEntity> studentEntityList = selectByExample(studentEntityExample);
        PageInfo<StudentEntity> studentEntityPageInfo = new PageInfo<>(page);
        studentEntityPageInfo.setList(studentEntityList);
        return studentEntityPageInfo;
    }

    int selectException(int a);
}
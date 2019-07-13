package com.cl.transform;

import com.cl.bean.res.StudentResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.StudentEntity;
import com.cl.util.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @ClassName StudentTransform
 * @Description student 转换器
 * @Author 陈龙
 * @Date 2019/6/24 14:58
 * @Version 1.0
 **/
@Service
public class StudentTransform extends AbstractObjectTransformer<StudentEntity, StudentResBean> {

    @Override
    public StudentResBean transform(StudentEntity studentEntity) {
        if(null == studentEntity){
            return null;
        }
        StudentResBean studentResBean = new StudentResBean();
        studentResBean.setId(studentEntity.getId());
        studentResBean.setName(studentEntity.getName());
        if(null != studentEntity.getAge()){
            studentResBean.setAge(String.valueOf(studentEntity.getAge()));
        }
        studentResBean.setSex(studentEntity.getSex());
        if(null != studentEntity.getStatus())
        studentResBean.setStatus(String.valueOf(studentEntity.getStatus()));
        studentResBean.setCreateTime(DateUtils.getDateString(studentEntity.getCreateTime() , DateUtils.DATESHOWFORMAT));
        return studentResBean;
    }

}

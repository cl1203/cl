package com.cl.transform;

import com.cl.bean.res.SysDepartmentResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.SysDepartmentEntity;
import org.springframework.stereotype.Service;

@Service
public class SysDepartmentTransform extends AbstractObjectTransformer<SysDepartmentEntity, SysDepartmentResBean> {
    @Override
    public SysDepartmentResBean transform(SysDepartmentEntity sysDepartmentEntity) {
        if(null == sysDepartmentEntity){
            return null;
        }
        SysDepartmentResBean sysDepartmentResBean = new SysDepartmentResBean();
        sysDepartmentResBean.setId(sysDepartmentEntity.getId());
        sysDepartmentResBean.setGrade(sysDepartmentEntity.getGrade());
        sysDepartmentResBean.setParentId(sysDepartmentEntity.getParentId());
        sysDepartmentResBean.setName(sysDepartmentEntity.getName());
        sysDepartmentResBean.setLastUpdateUser(sysDepartmentEntity.getLastUpdateUser());
        sysDepartmentResBean.setRemarks(sysDepartmentEntity.getRemarks());
        return sysDepartmentResBean;
    }
}

package com.cl.transform;

import com.cl.bean.res.SysDepartmentResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysDepartmentMapper;
import com.cl.entity.SysDepartmentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysDepartmentTransform extends AbstractObjectTransformer<SysDepartmentEntity, SysDepartmentResBean> {

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public SysDepartmentResBean transform(SysDepartmentEntity sysDepartmentEntity) {
        if(null == sysDepartmentEntity){
            return null;
        }
        SysDepartmentResBean sysDepartmentResBean = new SysDepartmentResBean();
        sysDepartmentResBean.setId(sysDepartmentEntity.getId());
        sysDepartmentResBean.setGrade(sysDepartmentEntity.getGrade());
        sysDepartmentResBean.setParentId(sysDepartmentEntity.getParentId());
        if(!sysDepartmentEntity.getParentId().equals(DictionaryConstants.ALL_BUSINESS_ZERO)){
            SysDepartmentEntity sysDepartmentEntityById = this.sysDepartmentMapper.selectByPrimaryKey(sysDepartmentEntity.getParentId());
            if(null != sysDepartmentEntityById){
                sysDepartmentResBean.setParentName(sysDepartmentEntityById.getName());
            }
        }
        sysDepartmentResBean.setName(sysDepartmentEntity.getName());
        sysDepartmentResBean.setLastUpdateUser(sysDepartmentEntity.getLastUpdateUser());
        sysDepartmentResBean.setRemarks(sysDepartmentEntity.getRemarks());
        return sysDepartmentResBean;
    }
}

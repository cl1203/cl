package com.cl.transform;

import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.entity.SysOrgEntity;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysOrgTransform
 * @Description 组织 entity转resBean
 * @Author 陈龙
 * @Date 2019/7/31 18:51
 * @Version 1.0
 **/
@Service
public class SysOrgTransform extends AbstractObjectTransformer<SysOrgEntity , SysOrgResBean> {
    @Override
    public SysOrgResBean transform(SysOrgEntity sysOrgEntity) {
        if (null == sysOrgEntity){
            return null;
        }
        SysOrgResBean sysOrgResBean = new SysOrgResBean();
        sysOrgResBean.setId(sysOrgEntity.getId());
        sysOrgResBean.setName(sysOrgEntity.getName());
        sysOrgResBean.setRemarks(sysOrgEntity.getRemarks());
        sysOrgResBean.setCreateUser(sysOrgEntity.getCreateUser());
        sysOrgResBean.setCreateTime(sysOrgEntity.getCreateTime());
        return sysOrgResBean;
    }
}

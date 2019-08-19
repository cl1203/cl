package com.cl.transform;

import com.cl.bean.res.SysPermissionResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysPermissionMapper;
import com.cl.entity.SysPermissionEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName SysPermissionTransform
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/14 16:32
 * @Version 1.0
 **/
@Service
public class SysPermissionTransform extends AbstractObjectTransformer<SysPermissionEntity, SysPermissionResBean> {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public SysPermissionResBean transform(SysPermissionEntity sysPermissionEntity) {
        if(null == sysPermissionEntity){
            return null;
        }
        SysPermissionResBean sysPermissionResBean = new SysPermissionResBean();
        sysPermissionResBean.setId(sysPermissionEntity.getId());
        sysPermissionResBean.setName(sysPermissionEntity.getName());
        sysPermissionResBean.setPermissionType(sysPermissionEntity.getPermissionType());
        if(!(Long.valueOf(DictionaryConstants.ALL_BUSINESS_ZERO).equals(sysPermissionEntity.getParentId()))){
            sysPermissionResBean.setParentId(sysPermissionEntity.getParentId());
            SysPermissionEntity sysPermissionEntityById = this.sysPermissionMapper.selectByPrimaryKey(sysPermissionEntity.getParentId());
            if(null != sysPermissionEntityById){
                sysPermissionResBean.setParentName(sysPermissionEntityById.getName());
            }
        }
        sysPermissionResBean.setUrl(sysPermissionEntity.getUrl());
        sysPermissionResBean.setSortNo(sysPermissionEntity.getSortNo());
        sysPermissionResBean.setTargetPage(sysPermissionEntity.getTargetPage());
        sysPermissionResBean.setPermissionClass(sysPermissionEntity.getPermissionClass());
        sysPermissionResBean.setRemarks(sysPermissionEntity.getRemarks());
        sysPermissionResBean.setLastUpdateUser(sysPermissionEntity.getLastUpdateUser());
        sysPermissionResBean.setLastUpdateTime(sysPermissionEntity.getLastUpdateTime());
        return sysPermissionResBean;
    }
}

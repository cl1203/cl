package com.cl.transform;

import com.cl.bean.res.SysRoleResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysDepartmentMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysDepartmentEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysUserEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysUserTransform
 * @Description TODO
 * @Author 陈龙
 * @Date 2019/8/12 18:34
 * @Version 1.0
 **/
@Service
public class SysUserTransform extends AbstractObjectTransformer<SysUserEntity, SysUserResBean> {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Override
    public SysUserResBean transform(SysUserEntity sysUserEntity) {
        if(null == sysUserEntity){
            return null;
        }
        SysUserResBean sysUserResBean = new SysUserResBean();
        sysUserResBean.setId(sysUserEntity.getId());
        sysUserResBean.setUserName(sysUserEntity.getUserName());
        sysUserResBean.setRealName(sysUserEntity.getRealName());
        sysUserResBean.setOrgId(sysUserEntity.getOrgId());
        SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectByPrimaryKey(sysUserEntity.getOrgId());
        if(null != sysOrgEntity){
            if(sysOrgEntity.getStatus().equals(DictionaryConstants.AVAILABLE)){
                sysUserResBean.setOrgName(sysOrgEntity.getName());
            }
        }
        sysUserResBean.setDepartmentId(sysUserEntity.getDepartmentId());
        SysDepartmentEntity sysDepartmentEntity = this.sysDepartmentMapper.selectByPrimaryKey(sysUserEntity.getDepartmentId());
        if(null != sysDepartmentEntity){
            if(sysDepartmentEntity.getStatus().equals(DictionaryConstants.AVAILABLE)){
                sysUserResBean.setDepartmentName(sysDepartmentEntity.getName());
            }
        }
        sysUserResBean.setMobile(sysUserEntity.getMobile());
        sysUserResBean.setRemarks(sysUserEntity.getRemarks());
        sysUserResBean.setLastUpdateTime(sysUserEntity.getLastUpdateTime());
        sysUserResBean.setLastUpdateUser(sysUserEntity.getLastUpdateUser());
        List<SysRoleResBean> sysRoleList = this.sysUserMapper.selectRoleByUserId(sysUserEntity.getId());
        sysUserResBean.setSysRoleList(sysRoleList);
        return sysUserResBean;
    }
}

package com.cl.transform;

import com.cl.bean.res.SysPermissionResBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.transformer.AbstractObjectTransformer;
import com.cl.dao.SysOrgMapper;
import com.cl.dao.SysRoleMapper;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysRoleEntity;
import com.cl.service.IPulldownMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysRoleTransform
 * @Description 角色entity转resBean
 * @Author 陈龙
 * @Date 2019/8/9 16:34
 * @Version 1.0
 **/
@Service
public class SysRoleTransform extends AbstractObjectTransformer<SysRoleEntity , SysRoleResBean>{

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Override
    public SysRoleResBean transform(SysRoleEntity sysRoleEntity) {
        if(null == sysRoleEntity){
            return null;
        }
        SysRoleResBean sysRoleResBean = new SysRoleResBean();
        sysRoleResBean.setId(sysRoleEntity.getId());
        sysRoleResBean.setName(sysRoleEntity.getName());
        sysRoleResBean.setRemark(sysRoleEntity.getRemark());
        sysRoleResBean.setLastUpdateUser(sysRoleEntity.getLastUpdateUser());
        sysRoleResBean.setLastUpdateTime(sysRoleEntity.getLastUpdateTime());
        //绑定的用户list
        List<SysUserResBean> sysUserResBeanList = this.sysRoleMapper.selectUserByRoleId(sysRoleEntity.getId());
        sysRoleResBean.setUserList(sysUserResBeanList);
        //绑定的菜单权限list
        List<SysPermissionResBean> sysPermissionResBeanList = this.sysRoleMapper.selectPermissionByRoleId(sysRoleEntity.getId());
        this.pulldownMenuService.queryPermissionByParentId(sysPermissionResBeanList);
        sysRoleResBean.setPermissionList(sysPermissionResBeanList);
        return sysRoleResBean;
    }
}

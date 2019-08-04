package com.cl.service.impl;

import com.cl.bean.req.SysOrgReqBean;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.SysOrgResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.PulldownMenuMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.dao.SysRoleMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysRoleEntity;
import com.cl.entity.SysUserEntity;
import com.cl.service.ISysOrgService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysOrgServiceImpl
 * @Description 权限--组织  实现类
 * @Author 陈龙
 * @Date 2019/7/31 17:20
 * @Version 1.0
 **/
@Service
@Transactional
public class SysOrgServiceImpl implements ISysOrgService {

    @Resource
    private SysOrgMapper sysOrgMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private PulldownMenuMapper pulldownMenuMapper;

    @Resource
    private IObjectTransformer<SysOrgEntity , SysOrgResBean> sysOrgTransformer;

    @Override
    public PageInfo<SysOrgResBean> querySysOrgList(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        if(sysOrgReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysOrgReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //分页查询
        PageInfo<SysOrgEntity> sysOrgEntityPageInfo = this.sysOrgMapper.selectSysOrgPageInfo(sysOrgReqBean);
        //entity转resBean
        PageInfo<SysOrgResBean> sysOrgResBeanPageInfo = this.sysOrgTransformer.transform(sysOrgEntityPageInfo);
        return sysOrgResBeanPageInfo;
    }

    @Override
    public void insertSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        Assert.hasText(sysOrgReqBean.getName() , "组织名称不能为空!");
        //查询组织名称是否存在
        PulldownMenuResBean pulldownMenuResBean = new PulldownMenuResBean();
        pulldownMenuResBean.setName(sysOrgReqBean.getName());
        List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuResBean);
        Assert.isTrue(pulldownMenuResBeanList.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "组织名已经存在!");
        SysOrgEntity sysOrgEntity = new SysOrgEntity();
        sysOrgEntity.setName(sysOrgReqBean.getName());
        sysOrgEntity.setCreateUser(reqBeanModel.getUsername());
        sysOrgEntity.setLastUpdateUser(reqBeanModel.getUsername());
        if(StringUtils.isNotBlank(sysOrgReqBean.getRemarks())){
            sysOrgEntity.setRemarks(sysOrgReqBean.getRemarks());
        }
        int i = this.sysOrgMapper.insertSelective(sysOrgEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE  , "新增组织失败!");
    }

    @Override
    public void deleteSysOrg(RequestBeanModel<List<Long>> reqBeanModel) {
        List<Long> orgIdList = reqBeanModel.getReqData();
        Assert.notEmpty(orgIdList , "请选择需要删除的数据,组织ID不能为空!");
        SysOrgEntity sysOrgEntity = new SysOrgEntity();
        SysRoleEntity sysRoleEntity = new SysRoleEntity();
        SysUserEntity sysUserEntity = new SysUserEntity();
        orgIdList.forEach(orgId -> {
            //删除组织
            sysOrgEntity.setId(orgId);
            sysOrgEntity.setStatus(DictionaryConstants.DETELE);
            int i = this.sysOrgMapper.updateByPrimaryKeySelective(sysOrgEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE ,"删除组织失败!");
            //查询组织绑定的所有角色的ID
            List<Long> roleIdList = this.sysOrgMapper.selectRoleIdListByOrgId(orgId);
            //查询角色绑定的所有用户ID
            List<Long> userIdList = this.sysOrgMapper.selectUserIdListByRoleId(roleIdList);
            //删除角色绑定的用户的关系表
            this.sysOrgMapper.deleteUserRole(roleIdList);
            //删除组织对应的角色
            roleIdList.forEach(roleId ->{
                sysRoleEntity.setId(roleId);
                sysRoleEntity.setStatus(DictionaryConstants.DETELE);
                this.sysRoleMapper.updateByPrimaryKeySelective(sysRoleEntity);
            });
            //删除角色绑定的用户
            userIdList.forEach(userId ->{
                sysUserEntity.setId(userId);
                sysUserEntity.setStatus(DictionaryConstants.DETELE);
                this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
            });
        });
    }

    @Override
    public void updateSysOrg(RequestBeanModel<SysOrgReqBean> reqBeanModel) {
        SysOrgReqBean sysOrgReqBean = reqBeanModel.getReqData();
        Assert.notNull(sysOrgReqBean.getId() , "请选择一条数据,ID不能为空!");
        Assert.hasText(sysOrgReqBean.getName() , "组织名称不能为空!");
        SysOrgEntity sysOrgEntity = this.sysOrgMapper.selectSysOrgByIdAndName(sysOrgReqBean);
        Assert.isNull(sysOrgEntity , "组织名已经存在!");
        sysOrgEntity.setId(sysOrgReqBean.getId());
        sysOrgEntity.setName(sysOrgReqBean.getName());
        sysOrgEntity.setRemarks(sysOrgReqBean.getRemarks());
        sysOrgEntity.setLastUpdateUser(reqBeanModel.getUsername());
        sysOrgEntity.setLastUpdateTime(new Date());
        int i = this.sysOrgMapper.updateByPrimaryKeySelective(sysOrgEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改失败!");
    }
}

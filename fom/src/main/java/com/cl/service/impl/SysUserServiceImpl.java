package com.cl.service.impl;

import com.cl.bean.req.SysUserReqBean;
import com.cl.bean.res.SysRoleResBean;
import com.cl.bean.res.SysUserResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysRoleMapper;
import com.cl.dao.SysUserMapper;
import com.cl.dao.SysUserRoleMapper;
import com.cl.entity.*;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName SysUserServiceImpl
 * @Description 用户管理实现类
 * @Author 陈龙
 * @Date 2019/8/11 18:43
 * @Version 1.0
 **/
@Service
@Transactional
public class SysUserServiceImpl implements ISysUserService {

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;

    @Resource
    private IObjectTransformer<SysUserEntity , SysUserResBean> sysUserTransform;

    @Override
    public PageInfo<SysUserResBean> querySysUserList(RequestBeanModel<SysUserReqBean> reqBeanModel) {
        SysUserReqBean sysUserReqBean = reqBeanModel.getReqData();
        if(sysUserReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysUserReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        if(Long.valueOf(DictionaryConstants.ADMIN_ORG_ID) == orgId){//如果是管理员
            if(null == sysUserReqBean.getOrgId()){//没选择组织
                //根据用户id查询对应的组织
                sysUserReqBean.setOrgId(orgId);//默认全部  否则查对应的组织
            }
        }else{
            sysUserReqBean.setOrgId(orgId);//如果不是管理员 根据登录用户判断组织
        }
        PageInfo<SysUserEntity> sysUserEntityPageInfo = this.sysUserMapper.selectSysUserPageInfo(sysUserReqBean);
        PageInfo<SysUserResBean> sysUserResBeanList = this.sysUserTransform.transform(sysUserEntityPageInfo);
        return sysUserResBeanList;
    }

    @Override
    public void insertSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel) {
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        //校验reqBean 并转entity
        SysUserEntity sysUserEntity = this.checkUserReqBean(reqBeanModel);
        sysUserEntity.setCreateUser(reqBeanModel.getUserId());
        sysUserEntity.setPassword(DictionaryConstants.PASS_WORD);
        sysUserEntity.setOrgId(orgId);
        Integer i = this.sysUserMapper.insertSelective(sysUserEntity);
        Assert.isTrue( i == DictionaryConstants.ALL_BUSINESS_ONE , "新增用户失败!");
        //绑定角色
        this.insertSysUserRole(sysUserEntity.getId() , reqBeanModel , orgId);
    }

    /**
     * 绑定角色
     * @param userId
     * @param reqBeanModel
     */
    public void insertSysUserRole(Long userId , RequestBeanModel<SysUserReqBean> reqBeanModel , Long orgId ){
        List<Long> roleIdList = reqBeanModel.getReqData().getRoleIdList();
        Assert.notEmpty(roleIdList , "请选择需要绑定的角色!");
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setUserId(userId);
        sysUserRoleEntity.setCreateUser(reqBeanModel.getUserId());
        sysUserRoleEntity.setLastUpdateUser(reqBeanModel.getUserId());
        roleIdList.forEach(roleId ->{
            SysRoleEntity sysRoleEntity = this.sysRoleMapper.selectByPrimaryKey(roleId);
            Assert.notNull(sysRoleEntity , "角色ID: \" + roleId + \",对应的角色不存在!");
            Assert.isTrue(sysRoleEntity.getStatus() == DictionaryConstants.AVAILABLE , "该角色已被删除!");
            Assert.isTrue(sysRoleEntity.getOrgId() == orgId , "该角色不属于该用户对应的组织!");
            sysUserRoleEntity.setRoleId(roleId);
            Integer i = this.sysUserRoleMapper.insertSelective(sysUserRoleEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "绑定角色失败! roleId: " + roleId);
        });
    }


    /**
     * 校验请求参数并转换entity
     * @param reqBeanModel
     * @return
     */
    private SysUserEntity checkUserReqBean(RequestBeanModel<SysUserReqBean> reqBeanModel){
        SysUserReqBean sysUserReqBean = reqBeanModel.getReqData();
        SysUserEntity sysUserEntity = new SysUserEntity();
        Assert.hasText(sysUserReqBean.getUserName() , "用户名不能为空!");
        SysUserEntityExample sysUserEntityExample = new SysUserEntityExample();
        SysUserEntityExample.Criteria criteria = sysUserEntityExample.createCriteria();
        criteria.andUserNameEqualTo(sysUserReqBean.getUserName());
        if(null != sysUserReqBean.getId()){
            criteria.andIdNotEqualTo(sysUserReqBean.getId());
        }
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        List<SysUserEntity> sysUserEntityList = this.sysUserMapper.selectByExample(sysUserEntityExample);
        Assert.isTrue(sysUserEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO ,"用户名已经存在,请修改!");
        sysUserEntity.setUserName(sysUserReqBean.getUserName());
        sysUserEntity.setRealName(sysUserReqBean.getRealName());
        sysUserEntity.setMobile(sysUserReqBean.getMobile());
        sysUserEntity.setRemarks(sysUserReqBean.getRemarks());
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysUserEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        return sysUserEntity;
    }

    @Override
    public void updateSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel) {
        Long id = reqBeanModel.getReqData().getId();
        Assert.notNull(id , "请选择一条数据,主键ID不能为空!");
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(id);
        Assert.notNull(sysUserEntity , "此id对应的数据不存在!");
        Assert.isTrue(sysUserEntity.getStatus() == DictionaryConstants.AVAILABLE , "此id对应的数据已被删除!");
        //根据用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        //校验reqBean 并转entity
        sysUserEntity = this.checkUserReqBean(reqBeanModel);
        sysUserEntity.setLastUpdateTime(new Date());
        sysUserEntity.setId(id);
        Integer i = this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
        Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "修改用户失败!");
        //根据用户id删除用户角色关系表
        this.deleteUserRole(id);
        //绑定角色
        this.insertSysUserRole(sysUserEntity.getId() , reqBeanModel , orgId);
    }

    /**
     * 根据用户id删除用户角色关系表
     * @param userId
     */
    private void deleteUserRole(Long userId){
        //删除用户绑定的角色关系表数据
        SysUserRoleEntityExample sysUserRoleEntityExample = new SysUserRoleEntityExample();
        SysUserRoleEntityExample.Criteria criteria = sysUserRoleEntityExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        this.sysUserRoleMapper.deleteByExample(sysUserRoleEntityExample);
    }


    @Override
    public void deleteSysUser(RequestBeanModel<List<SingleParam>> reqBeanModel) {
        List<SingleParam> userIdList = reqBeanModel.getReqData();
        Assert.isTrue(userIdList.size() > DictionaryConstants.ALL_BUSINESS_ZERO , "至少选择一条需要删除的数据!");
        //删除用户 删除用户和角色关系表
        SysUserEntity sysUserEntity = new SysUserEntity();
        sysUserEntity.setStatus(DictionaryConstants.DETELE);
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysUserEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        sysUserEntity.setLastUpdateTime(new Date());
        userIdList.forEach(singleParam ->{
            sysUserEntity.setId(Long.valueOf(singleParam.getParam()));
            Integer i = this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
            Assert.isTrue(i == DictionaryConstants.ALL_BUSINESS_ONE , "删除用户数据失败!");
            //根据用户id删除用户角色关系表
            this.deleteUserRole(Long.valueOf(singleParam.getParam()));
        });
    }
}
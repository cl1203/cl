package com.cl.service.impl;

import com.cl.bean.req.SysUserReqBean;
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
import com.cl.utils.MD5Util;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        PageInfo<SysUserEntity> sysUserEntityPageInfo = this.sysUserMapper.selectSysUserPageInfo(sysUserReqBean , orgId);
        return this.sysUserTransform.transform(sysUserEntityPageInfo);
    }

    @Override
    public void insertSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel) {
        //根据登录用户id查询对应的组织
        Long orgId = this.pulldownMenuService.selectOrgIdByUserId(Long.valueOf(reqBeanModel.getUserId()));
        //校验reqBean 并转entity
        SysUserEntity sysUserEntity = this.checkUserReqBean(reqBeanModel);
        String password = null;
        password = MD5Util.getInstance().encrypt(DictionaryConstants.PASS_WORD);
        password = MD5Util.getInstance().encryptBySalt(password);
        sysUserEntity.setPassword(password);
        if(null != reqBeanModel.getReqData().getOrgId()){
            sysUserEntity.setOrgId(reqBeanModel.getReqData().getOrgId());
        }else{
            sysUserEntity.setOrgId(orgId);
        }
        sysUserEntity.setCreateUser(reqBeanModel.getUserId());
        Integer i = this.sysUserMapper.insertSelective(sysUserEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "新增用户失败! 用户名: " + sysUserEntity.getUserName());
        //绑定角色
        this.insertSysUserRole(sysUserEntity.getId() , reqBeanModel);
    }

    /**
     * 绑定角色
     * @param userId
     * @param reqBeanModel
     */
    private void insertSysUserRole(Long userId, RequestBeanModel<SysUserReqBean> reqBeanModel){
        List<Long> roleIdList = reqBeanModel.getReqData().getRoleIdList();
        Assert.notEmpty(roleIdList , "请选择需要绑定的角色!");
        SysUserRoleEntity sysUserRoleEntity = new SysUserRoleEntity();
        sysUserRoleEntity.setUserId(userId);
        sysUserRoleEntity.setCreateUser(reqBeanModel.getUserId());
        sysUserRoleEntity.setLastUpdateUser(reqBeanModel.getUserId());
        roleIdList.forEach(roleId ->{
            SysRoleEntity sysRoleEntity = this.sysRoleMapper.selectByPrimaryKey(roleId);
            Assert.notNull(sysRoleEntity , "角色ID: \" + roleId + \",对应的角色不存在! 角色名: " + sysRoleEntity.getName());
            Assert.isTrue(sysRoleEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "该角色已被删除! 角色名: " + sysRoleEntity.getName());
            sysUserRoleEntity.setRoleId(roleId);
            Integer i = this.sysUserRoleMapper.insertSelective(sysUserRoleEntity);
            Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "绑定角色失败! userId: " + userId);
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
        String userName = sysUserReqBean.getUserName();
        Assert.hasText(userName , "用户名不能为空!");
        if(userName.length() < 3 || userName.length() > 15){
            throw new BusinessException("用户名长度应该在3-15位之间,请修改!");
        }
        boolean flag = this.pulldownMenuService.checkBlankSpace(sysUserReqBean.getUserName());
        Assert.isTrue(flag , "用户名不能包含空格!");
        String regex = "^[a-z0-9A-Z]+$";
        if(!match(regex , sysUserReqBean.getUserName())) {
            throw new BusinessException("用户名格式规则: 必须只能包含数字和字母! ");
        }
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
        Assert.hasText(sysUserReqBean.getRealName() , "用户真实姓名不能为空!");
        sysUserEntity.setRealName(sysUserReqBean.getRealName());
        Assert.notNull(sysUserReqBean.getDepartmentId() , "请选择部门, 用户所属部门不能为空!");
        sysUserEntity.setDepartmentId(sysUserReqBean.getDepartmentId());
        if(StringUtils.isNotBlank(sysUserReqBean.getMobile())){
            String mobileRegex = "^1(3|4|5|7|8)\\d{9}$";
            if(!match(mobileRegex , sysUserReqBean.getMobile())) {
                throw new BusinessException("手机号码不符合规则,请修改! ");
            }
            sysUserEntity.setMobile(sysUserReqBean.getMobile());
        }
        sysUserEntity.setRemarks(sysUserReqBean.getRemarks());
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysUserEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        return sysUserEntity;
    }

    /**
     * @param regex
     * 正则表达式字符串
     * @param str
     * 要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    @Override
    public void updateSysUser(RequestBeanModel<SysUserReqBean> reqBeanModel) {
        Long id = reqBeanModel.getReqData().getId();
        Assert.notNull(id , "请选择一条数据,主键ID不能为空!");
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(id);
        Assert.notNull(sysUserEntity , "此id对应的数据不存在! userId : " + id);
        Assert.isTrue(sysUserEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "此id对应的数据已被删除! userId : " + id);
        //校验reqBean 并转entity
        sysUserEntity = this.checkUserReqBean(reqBeanModel);
        sysUserEntity.setLastUpdateTime(new Date());
        sysUserEntity.setId(id);
        Integer i = this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "修改用户失败! 用户名: " + sysUserEntity.getUserName());
        //根据用户id删除用户角色关系表
        this.deleteUserRole(id);
        //绑定角色
        this.insertSysUserRole(sysUserEntity.getId() , reqBeanModel);
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
            Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "删除用户数据失败! id " + singleParam.getParam());
            //根据用户id删除用户角色关系表
            this.deleteUserRole(Long.valueOf(singleParam.getParam()));
        });
    }

    @Override
    public void updateSysUserPassword(RequestBeanModel<SingleParam> reqBeanModel) {
        SingleParam singleParam = reqBeanModel.getReqData();
        String userId = singleParam.getParam();
        Assert.hasText(userId , "用户ID不能为空,请选择需要重置的用户!");
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(userId));
        Assert.notNull(sysUserEntity , "用户id对应的用户不存在,错误数据!");
        String password = null;
        password = MD5Util.getInstance().encrypt(DictionaryConstants.PASS_WORD);
        password = MD5Util.getInstance().encryptBySalt(password);
        sysUserEntity.setPassword(password);
        Integer i = this.sysUserMapper.updateByPrimaryKeySelective(sysUserEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "虫子密码失败! id " + userId);
    }
}

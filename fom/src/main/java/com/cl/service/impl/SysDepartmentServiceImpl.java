package com.cl.service.impl;

import com.cl.bean.req.SysDepartmentReqBean;
import com.cl.bean.res.SysDepartmentResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.SingleParam;
import com.cl.comm.transformer.IObjectTransformer;
import com.cl.dao.SysDepartmentMapper;
import com.cl.dao.SysUserMapper;
import com.cl.entity.SysDepartmentEntity;
import com.cl.entity.SysDepartmentEntityExample;
import com.cl.entity.SysUserEntity;
import com.cl.service.IPulldownMenuService;
import com.cl.service.ISysDepartmentService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class SysDepartmentServiceImpl implements ISysDepartmentService {

    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    @Resource
    private IPulldownMenuService pulldownMenuService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private IObjectTransformer<SysDepartmentEntity , SysDepartmentResBean> sysDepartmentTransform;

    @Override
    public PageInfo<SysDepartmentResBean> querySysDepartmentList(RequestBeanModel<SysDepartmentReqBean> reqBeanModel) {
        SysDepartmentReqBean sysDepartmentReqBean = reqBeanModel.getReqData();
        if(sysDepartmentReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || sysDepartmentReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        PageInfo<SysDepartmentEntity> sysDepartmentEntityPageInfo = this.sysDepartmentMapper.selectSysRolePageInfo(sysDepartmentReqBean);
        PageInfo<SysDepartmentResBean> sysDepartmentResBeanPageInfo = this.sysDepartmentTransform.transform(sysDepartmentEntityPageInfo);
        return sysDepartmentResBeanPageInfo;
    }

    @Override
    public void insertSysDepartment(RequestBeanModel<SysDepartmentReqBean> reqBeanModel) {
        //校验请求参数
        SysDepartmentEntity sysDepartmentEntity = this.checkSysDepartmentReqBean(reqBeanModel);
        sysDepartmentEntity.setCreateUser(reqBeanModel.getUserId());
        Integer i = this.sysDepartmentMapper.insertSelective(sysDepartmentEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE) , "新增部门失败!");
    }

    /**
     * 校验请求对象
     * @param reqBeanModel
     * @return
     */
    private SysDepartmentEntity checkSysDepartmentReqBean(RequestBeanModel<SysDepartmentReqBean> reqBeanModel){
        SysDepartmentReqBean sysDepartmentReqBean = reqBeanModel.getReqData();
        SysDepartmentEntity sysDepartmentEntity = new SysDepartmentEntity();
        String name = sysDepartmentReqBean.getName();
        Assert.hasText(name , "部门名称不能为空!");
        Assert.isTrue(name.length() <= 20 ,"部门名称太长,请修改!");
        boolean flag = this.pulldownMenuService.checkBlankSpace(name);
        Assert.isTrue(flag , "角色名不能包含空格!");
        SysDepartmentEntityExample sysDepartmentEntityExample = new SysDepartmentEntityExample();
        SysDepartmentEntityExample.Criteria criteria = sysDepartmentEntityExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andStatusEqualTo(DictionaryConstants.AVAILABLE);
        if(null != sysDepartmentReqBean.getId()){
            criteria.andIdNotEqualTo(sysDepartmentReqBean.getId());
        }
        List<SysDepartmentEntity> sysDepartmentEntityList = this.sysDepartmentMapper.selectByExample(sysDepartmentEntityExample);
        Assert.isTrue(sysDepartmentEntityList.size() == DictionaryConstants.ALL_BUSINESS_ZERO , "角色名已经存在!");
        sysDepartmentEntity.setName(name);
        if(null != sysDepartmentReqBean.getParentId()){
            SysDepartmentEntity sysDepartmentEntityByParentId = this.sysDepartmentMapper.selectByPrimaryKey(sysDepartmentReqBean.getParentId());
            Assert.notNull(sysDepartmentEntityByParentId , "选择的上级部门不存在!");
            sysDepartmentEntity.setParentId(sysDepartmentReqBean.getParentId());
        }
        Assert.notNull(sysDepartmentReqBean.getGrade() , "部门等级不能为空!");
        sysDepartmentEntity.setGrade(sysDepartmentReqBean.getGrade());
        sysDepartmentEntity.setRemarks(sysDepartmentReqBean.getRemarks());
        SysUserEntity sysUserEntity = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        sysDepartmentEntity.setLastUpdateUser(sysUserEntity.getRealName());
        return sysDepartmentEntity;
    }

    @Override
    public void updateSysDepartment(RequestBeanModel<SysDepartmentReqBean> reqBeanModel) {
        Long id = reqBeanModel.getReqData().getId();
        Assert.notNull(id , "请选择一条数据,主键ID不能为空!");
        SysDepartmentEntity sysDepartmentEntity = this.sysDepartmentMapper.selectByPrimaryKey(id);
        Assert.notNull(sysDepartmentEntity , "此id对应的数据不存在!");
        Assert.isTrue(sysDepartmentEntity.getStatus().equals(DictionaryConstants.AVAILABLE), "此id对应的数据已被删除!");
        //校验请求参数
        sysDepartmentEntity = this.checkSysDepartmentReqBean(reqBeanModel);
        sysDepartmentEntity.setLastUpdateTime(new Date());
        sysDepartmentEntity.setId(id);
        Integer i = this.sysDepartmentMapper.updateByPrimaryKeySelective(sysDepartmentEntity);
        Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE) , "修改部门失败!");
    }

    @Override
    public void deleteSysDepartment(RequestBeanModel<List<SingleParam>> reqBeanModel) {
        List<SingleParam> singleParamList = reqBeanModel.getReqData();
        Assert.isTrue(singleParamList.size() > DictionaryConstants.ALL_BUSINESS_ZERO , "至少选择一条需要删除的数据!");
        SysUserEntity sysUserEntityByid = this.sysUserMapper.selectByPrimaryKey(Long.valueOf(reqBeanModel.getUserId()));
        SysDepartmentEntity sysDepartmentEntity = new SysDepartmentEntity();
        sysDepartmentEntity.setStatus(DictionaryConstants.DETELE);
        sysDepartmentEntity.setLastUpdateUser(sysUserEntityByid.getRealName());
        sysDepartmentEntity.setLastUpdateTime(new Date());
        singleParamList.forEach(singleParam ->{
            sysDepartmentEntity.setId(Long.valueOf(singleParam.getParam()));
            Integer i = this.sysDepartmentMapper.updateByPrimaryKeySelective(sysDepartmentEntity);
            Assert.isTrue(i.equals(DictionaryConstants.ALL_BUSINESS_ONE), "删除部门数据失败!");
        });
    }
}

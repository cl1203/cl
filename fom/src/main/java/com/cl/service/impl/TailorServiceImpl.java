package com.cl.service.impl;

import com.cl.bean.req.TailorReqBean;
import com.cl.bean.res.PulldownMenuResBean;
import com.cl.bean.res.TailorResBean;
import com.cl.comm.constants.DictionaryConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.dao.PulldownMenuMapper;
import com.cl.dao.TailorMapper;
import com.cl.service.ITailorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TailorServiceImpl
 * @Description 裁剪业务实现类
 * @Author 陈龙
 * @Date 2019/7/29 16:39
 * @Version 1.0
 **/
@Service
@Transactional
public class TailorServiceImpl implements ITailorService {

    @Resource
    private TailorMapper tailorMapper;

    @Resource
    private PulldownMenuMapper pulldownMenuMapper;

    @Override
    public PageInfo<TailorResBean> queryTailorList(RequestBeanModel<TailorReqBean> reqBeanModel) {
        TailorReqBean tailorReqBean = reqBeanModel.getReqData();
        if(tailorReqBean.getPageNum() < DictionaryConstants.ALL_BUSINESS_ONE || tailorReqBean.getPageSize() < DictionaryConstants.ALL_BUSINESS_ONE){
            throw new BusinessException("页码信息错误,请填入大于0的整数!");
        }
        //分页查询
        PageHelper.startPage(tailorReqBean.getPageNum() , tailorReqBean.getPageSize());
        PageHelper.orderBy("T.last_update_time");
        if(StringUtils.isNotBlank(tailorReqBean.getProducer())){
            PulldownMenuResBean pulldownMenuResBean = new PulldownMenuResBean();
            pulldownMenuResBean.setName(tailorReqBean.getProducer());
            List<PulldownMenuResBean> pulldownMenuResBeanList = this.pulldownMenuMapper.queryOrgPulldownMenu(pulldownMenuResBean);
            if(CollectionUtils.isNotEmpty(pulldownMenuResBeanList)){
                Long orgId = pulldownMenuResBeanList.get(0).getId();
                tailorReqBean.setProducerOrgId(orgId);
            }
        }
        List<TailorResBean> tailorResBeanList = this.tailorMapper.queryTailorList(tailorReqBean);
        return new PageInfo<>(tailorResBeanList);
    }

    @Override
    public void updateTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {

    }

    @Override
    public void insertTailor(RequestBeanModel<TailorReqBean> reqBeanModel) {

    }
}

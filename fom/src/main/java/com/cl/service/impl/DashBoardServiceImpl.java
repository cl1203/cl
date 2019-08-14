package com.cl.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl.bean.req.DashBoardReqBean;
import com.cl.bean.res.DashBoardDetailResBean;
import com.cl.bean.res.DashBoardResBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.comm.constants.DashBoardConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.Status;
import com.cl.config.CommonConfig;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysOrgEntityExample;
import com.cl.service.IDashBoardService;
import com.cl.util.DateUtils;
import com.github.pagehelper.PageInfo;

@Service("dashBoardService")
public class DashBoardServiceImpl implements IDashBoardService {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private CommonConfig config;
	
	@Override
	public PageInfo<DashBoardResBean> queryForecaseInfo(RequestBeanModel<DashBoardReqBean> reqBeanModel) {
		DashBoardReqBean reqBean = reqBeanModel.getReqData();
		validateParams(reqBean);
		List<DashBoardResBean> resBeanList = orderManageMapper.selectDashBoardByParams(reqBean);
		if(CollectionUtils.isEmpty(resBeanList)) {
			return new PageInfo<>(new ArrayList<DashBoardResBean>());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		for(DashBoardResBean bean : resBeanList) {
			String date = bean.getDate();
			bean.setDate(sdf.format(date));
			String week = DateUtils.dateToWeek(date);
			bean.setDayOfWeek(week);
			Map<String,Object> params = new HashMap<>();
			params.put("startDate", date + " 00:00:00");
			params.put("endDate", date + " 23:59:59");
	        params.put("offset", (reqBean.getPageNum() - 1) * reqBean.getPageSize() + 1);
	        params.put("limit", reqBean.getPageSize());
			List<DashBoardDetailResBean> detail = orderManageMapper.selectDashBoardDetailByParams(params);
			if(CollectionUtils.isNotEmpty(detail)) {
				processDetailDeliveryTime(detail);
				bean.setDetail(detail);
			}
		}
		PageInfo<DashBoardResBean> dashBoardResBeanPageInfo = new PageInfo<>(resBeanList);
		return dashBoardResBeanPageInfo;
	}
	
	private void processDetailDeliveryTime(List<DashBoardDetailResBean> detail) {
		
	}

	private void validateParams(DashBoardReqBean reqBean) {
    	if(reqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
    	if(reqBean.getStatus() == null) {
    		throw new BusinessException("查询类型不能为空！");
    	}
    	if(reqBean.getPageNum() == null || reqBean.getPageNum() < 1) {
    		reqBean.setPageNum(ApiConstants.DEFAULT_PAGE_NUM);
    	}
    	if(reqBean.getPageSize() == null || reqBean.getPageSize() < 1) {
    		reqBean.setPageSize(ApiConstants.DEFAULT_PAGE_SIZE);
    	}
    	//设置查询的起始时间，结束时间，默认查询过去5天的数据
    	Date now = new Date();
    	Calendar c = Calendar.getInstance();
    	c.setTime(now);
    	c.add(Calendar.DAY_OF_MONTH, -config.getDashBoardShowDay());
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	reqBean.setStartDate(sdf.format(c.getTime()));
    	reqBean.setEndDate(sdf.format(now));
    	//校验状态
    	List<Byte> statusList = new ArrayList<>();
		if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
			statusList.add(ApiConstants.ORDER_STATUS_WAIT_PURCHASE);
			statusList.add(ApiConstants.ORDER_STATUS_PURCHASING);
		}else if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_TAILOR) {
			statusList.add(ApiConstants.ORDER_STATUS_WAIT_TAILOR);
		}else {
			throw new BusinessException("参数状态非法！");
		}
		reqBean.setStatusList(statusList);
    	//校验组织名称是否存在
    	SysOrgEntityExample example = new SysOrgEntityExample();
		SysOrgEntityExample.Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(reqBean.getProducer());
		List<SysOrgEntity> orgList = sysOrgMapper.selectByExample(example);
		if(CollectionUtils.isNotEmpty(orgList)) {
			if(orgList.size() > 1) {
				throw new BusinessException("生产方：" + reqBean.getProducer() + "存在多条！");
			}
			reqBean.setProducerOrgId(orgList.get(0).getId());
		}
    }

}

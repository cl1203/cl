package com.cl.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cl.utils.DateUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cl.bean.req.AbnormalReqBean;
import com.cl.bean.req.DashBoardReqBean;
import com.cl.bean.res.AbnormalResBean;
import com.cl.bean.res.DashBoardDetailResBean;
import com.cl.bean.res.DashBoardResBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.comm.constants.DashBoardConstants;
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.RequestBeanModel;
import com.cl.comm.model.Status;
import com.cl.config.CommonConfig;
import com.cl.dao.AbnormalMapper;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.SysOrgMapper;
import com.cl.entity.AbnormalEntity;
import com.cl.entity.AbnormalEntityExample;
import com.cl.entity.AbnormalEntityExample.Criteria;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.SysOrgEntity;
import com.cl.entity.SysOrgEntityExample;
import com.cl.service.IDashBoardService;
import com.github.pagehelper.PageInfo;

@Service("dashBoardService")
public class DashBoardServiceImpl implements IDashBoardService {

	@Autowired
	private SysOrgMapper sysOrgMapper;
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private AbnormalMapper abnormalMapper;
	
	@Autowired
	private CommonConfig config;
	
	@Override
	public PageInfo<DashBoardResBean> queryForecastInfo(RequestBeanModel<DashBoardReqBean> reqBeanModel) throws Exception {
		DashBoardReqBean reqBean = reqBeanModel.getReqData();
		validateParams(reqBean);
		//初始化订单数据，数量为0
		List<DashBoardResBean> initResBeanList = init(reqBean);
		//数据库查询订单数据
		List<DashBoardResBean> resBeanList = orderManageMapper.selectDashBoardByParams(reqBean);
		if(CollectionUtils.isEmpty(resBeanList)) {
			return new PageInfo<>(initResBeanList);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String today = sdf.format(now);
		PageInfo<DashBoardResBean> dashBoardResBeanPageInfo = new PageInfo<>();
		Map<String,Object> mapBean = new HashMap<>();
		for(DashBoardResBean bean : resBeanList) {
			//计算表头显示时间
			String date = bean.getDate();
			if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
				bean.setDate(sdf.format(DateUtil.addDays(sdf.parse(date), config.getPurchaseDifference())));
			}else {
				bean.setDate(sdf.format(DateUtil.addDays(sdf.parse(date), config.getTailorDifference())));
			}
			//计算星期几
			if(bean.getDate().equals(today)) {
				bean.setDayOfWeek(DashBoardConstants.TODAY);
			}else {
				String week = DateUtil.dateToWeek(bean.getDate());
				bean.setDayOfWeek(week);
			}
			Map<String,Object> params = new HashMap<>();
			params.put("startDate", date + " 00:00:00");
			params.put("endDate", date + " 23:59:59");
			params.put("statusList", reqBean.getStatusList());
	        params.put("offset", (reqBean.getPageNum() - 1) * reqBean.getPageSize());
	        params.put("limit", reqBean.getPageSize());
			List<DashBoardDetailResBean> detail = orderManageMapper.selectDashBoardDetailByParams(params);
			if(CollectionUtils.isNotEmpty(detail)) {
				processDetailDeliveryTime(detail,reqBean,date);
				bean.setDetail(detail);
			}
			mapBean.put(bean.getDate(), bean);
		}
		for(DashBoardResBean bean : initResBeanList) {
			String date = bean.getDate();
			if(mapBean.get(date) != null) {
				BeanUtils.copyProperties(mapBean.get(date), bean);
			}
		}
		dashBoardResBeanPageInfo.setList(initResBeanList);
		return dashBoardResBeanPageInfo;
	}
	
	private List<DashBoardResBean> init(DashBoardReqBean reqBean) throws Exception  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String today = sdf.format(now);
		List<DashBoardResBean> initResBeanList = new ArrayList<>();
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		for(int i = 1; i <= config.getDashBoardShowDay(); i++) {
			DashBoardResBean bean = new DashBoardResBean();
			String date = "";
			if(i == 1) {
				date = sdf.format(now);
			}else {
				date = sdf.format(c.getTime());
			}
//			if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
//				bean.setDate(sdf.format(DateUtil.addDays(sdf.parse(date), config.getPurchaseDifference())));
//			}else {
//				bean.setDate(sdf.format(DateUtil.addDays(sdf.parse(date), config.getTailorDifference())));
//			}
			bean.setDate(date);
			if(bean.getDate().equals(today)) {
				bean.setDayOfWeek(DashBoardConstants.TODAY);
			}else {
				String week = DateUtil.dateToWeek(bean.getDate());
				bean.setDayOfWeek(week);
			}
			bean.setOrderQuantity(DashBoardConstants.DEFAULT_ORDER_QUANTITY);
			bean.setTailorQuantity(DashBoardConstants.DEFAULT_TAILOR_QUANTITY);
			initResBeanList.add(bean);
			c.add(Calendar.DAY_OF_MONTH, 1);
		}
		return initResBeanList;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateOrderRemark(RequestBeanModel<DashBoardReqBean> reqBeanModel) {
		DashBoardReqBean reqBean = reqBeanModel.getReqData();
		validateReqBean(reqBean);
		Map<String,Object> params = new HashMap<>();
		params.put("orderNo", reqBean.getOrderNo());
		List<OrderManageEntity> orderList = orderManageMapper.selectByParams(params);
		if(CollectionUtils.isEmpty(orderList)) {
			throw new BusinessException("订单号：" + reqBean.getOrderNo() + "不存在！");
		}
		if(orderList.size() > 1) {
			throw new BusinessException("订单号：" + reqBean.getOrderNo() + "存在多条重复！");
		}
		OrderManageEntity order = orderList.get(0);
		order.setRemarks(reqBean.getRemark());
		order.setLastUpdateTime(new Date());
		order.setLastUpdateUser(reqBeanModel.getUsername());
		orderManageMapper.updateByPrimaryKeySelective(order);
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateAbnormal(RequestBeanModel<AbnormalReqBean> reqBeanModel) {
		AbnormalReqBean reqBean = reqBeanModel.getReqData();
		validateUpdateAbnormalReqBean(reqBean);
		AbnormalEntity entity;
		AbnormalEntityExample example = new AbnormalEntityExample();
		Criteria criteria = example.createCriteria();
		criteria.andAbnormalTypeEqualTo(reqBean.getQueryType());
		criteria.andOrderNoEqualTo(reqBean.getOrderNo());
		if(reqBean.getQueryType().equals(DashBoardConstants.QUERY_PURCHASE)){
			criteria.andPurchaseNoEqualTo(reqBean.getPurchaseNo());
		}
		List<AbnormalEntity> entityList = abnormalMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(entityList)) {
			throw new BusinessException("orderNo:" + reqBean.getOrderNo() + ",purchaseNo:" + reqBean.getPurchaseNo() + "查询异常数据不存在！");
		}
		entity = entityList.get(0);
		entity.setAbnormalRemarks(reqBean.getRemark());
		entity.setIsApproval(reqBean.getApprovalStatus());
		entity.setLastUpdateUser(reqBeanModel.getUsername());
		entity.setLastUpdateTime(new Date());
		abnormalMapper.updateByPrimaryKeySelective(entity);
	}
	
	private void validateUpdateAbnormalReqBean(AbnormalReqBean reqBean) {
		if(reqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
		if(reqBean.getQueryType() == null) {
			throw new BusinessException("修改类型不能为空！");
		}
		if(!reqBean.getQueryType().equals(DashBoardConstants.QUERY_PURCHASE)
				&& !reqBean.getQueryType().equals(DashBoardConstants.QUERY_TAILOR)) {
			throw new BusinessException(Status.NOT_VALID_PARAMS);
		}
		if(StringUtils.isBlank(reqBean.getOrderNo())) {
			throw new BusinessException("订单号不能为空！");
		}
		if(reqBean.getQueryType().equals(DashBoardConstants.QUERY_PURCHASE)
				&& StringUtils.isBlank(reqBean.getPurchaseNo())){
			throw new BusinessException("采购单号不能为空！");
		}
	}

	private void validateReqBean(DashBoardReqBean reqBean) {
		if(reqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
		if(StringUtils.isBlank(reqBean.getOrderNo())) {
			throw new BusinessException("订单编号不能为空！");
		}
		if(StringUtils.isNotBlank(reqBean.getRemark()) && reqBean.getRemark().length() > DashBoardConstants.REMARK_MAX_LENGTH) {
			throw new BusinessException("备注最长不能超过128个字符！");
		}
	}

	private void processDetailDeliveryTime(List<DashBoardDetailResBean> detailList,DashBoardReqBean reqBean,String orderDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(DashBoardDetailResBean detail : detailList) {
			Calendar c = Calendar.getInstance();
			orderDate += " 00:00:00";
			c.setTime(sdf.parse(orderDate));
			long currentTime = System.currentTimeMillis();
			if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
				c.add(Calendar.DAY_OF_MONTH, config.getPurchaseDifference());
				long endTime = c.getTimeInMillis();
				long day = DateUtil.dayDifference(currentTime, endTime);
				long hour = DateUtil.hourDifference(currentTime, endTime);
				if(day < 0 || hour < 0) {
					detail.setIsExceed(DashBoardConstants.IS_EXCEED);
				}else {
					detail.setIsExceed(DashBoardConstants.IS_NOT_EXCEED);
				}
				detail.setDeliveryDay(Integer.valueOf(day + ""));
				detail.setDeliveryHour(Integer.valueOf(hour + ""));
			}
			if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_TAILOR) {
				Map<String,Object> params = new HashMap<>();
				params.put("orderNo", detail.getOrderNo());
				OrderManageEntity order = orderManageMapper.selectByParams(params).get(0);
				//下单当天起5天内未进入待裁剪则超期
				if(order.getOrderStatus() == ApiConstants.ORDER_STATUS_WAIT_PURCHASE
						|| order.getOrderStatus() == ApiConstants.ORDER_STATUS_PURCHASING) {
					c.add(Calendar.DAY_OF_MONTH, config.getPurchaseDifference());
				}else if(order.getOrderStatus() == ApiConstants.ORDER_STATUS_WAIT_TAILOR) {
					c.add(Calendar.DAY_OF_MONTH, config.getTailorDifference());
				}
				if(currentTime - c.getTimeInMillis() > 0) {
					detail.setIsExceed(DashBoardConstants.IS_EXCEED);
				}else {
					detail.setIsExceed(DashBoardConstants.IS_NOT_EXCEED);
				}
				long day = DateUtil.dayDifference(c.getTimeInMillis(), currentTime);
				long hour = DateUtil.hourDifference(c.getTimeInMillis(), currentTime);
				detail.setDeliveryDay(Integer.valueOf(day + ""));
				detail.setDeliveryHour(Integer.valueOf(hour + ""));
			}
			
		}
	}

	private void validateParams(DashBoardReqBean reqBean) throws ParseException {
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
    	Calendar c = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	//判断是否查询某一天的数据，还是查询默认天数的数据，默认查询过去5天的数据
    	if(StringUtils.isBlank(reqBean.getStartDate())) {
        	Date now = new Date();
        	c.setTime(now);
        	//计算列表订单的开始时间
        	if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
        		c.add(Calendar.DAY_OF_MONTH, -config.getDashBoardPurchaseDay());
        	}else {
        		c.add(Calendar.DAY_OF_MONTH, -config.getDashBoardTailorDay());
        	}
        	reqBean.setStartDate(sdf.format(c.getTime()));
        	//计算列表订单的结束时间
        	if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
        		c.add(Calendar.DAY_OF_MONTH, config.getDashBoardShowDay());
        	}else {
        		c.add(Calendar.DAY_OF_MONTH, config.getDashBoardShowDay());
        	}
        	reqBean.setEndDate(sdf.format(c.getTime()));
    	}else {
    		Pattern pattern = Pattern.compile(ApiConstants.DATE_REG);
    		Matcher matcher = pattern.matcher(reqBean.getStartDate());
    		if(!matcher.matches()) {
    			throw new BusinessException("查询日期不符合规则！");
    		}
    		c.setTime(sdf.parse(reqBean.getStartDate()));
    		
    		c.add(Calendar.DAY_OF_MONTH, 1);
    		reqBean.setEndDate(sdf.format(c.getTime()));
    	}
    	//校验状态
    	List<Byte> statusList = new ArrayList<>();
		if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_PURCHASE) {
			statusList.add(ApiConstants.ORDER_STATUS_WAIT_PURCHASE);
			statusList.add(ApiConstants.ORDER_STATUS_PURCHASING);
		}else if(reqBean.getStatus() == DashBoardConstants.REQ_STATUS_TAILOR) {
			statusList.add(ApiConstants.ORDER_STATUS_WAIT_PURCHASE);
			statusList.add(ApiConstants.ORDER_STATUS_PURCHASING);
			statusList.add(ApiConstants.ORDER_STATUS_WAIT_TAILOR);
		}else {
			throw new BusinessException("参数状态非法！");
		}
		reqBean.setStatusList(statusList);
		if(StringUtils.isNotBlank(reqBean.getProducer())) {
			//校验组织名称在系统中是否存在
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

	@Override
	public PageInfo<AbnormalResBean> queryAbnormalList(RequestBeanModel<AbnormalReqBean> reqBeanModel) {
		AbnormalReqBean reqBean = reqBeanModel.getReqData();
		validateReqBean(reqBean);
		List<AbnormalResBean> abnormalList;
		if(reqBean.getQueryType().equals(DashBoardConstants.QUERY_PURCHASE)){
			abnormalList = abnormalMapper.selectAbnormalPurchaseList(reqBean);
		}else {
			abnormalList = abnormalMapper.selectAbnormalTailorList(reqBean);
		}
		PageInfo<AbnormalResBean> resBean = new PageInfo<>(abnormalList);
		return resBean;
	}

	private void validateReqBean(AbnormalReqBean reqBean) {
		if(reqBean == null) {
    		throw new BusinessException(Status.NOT_VALID_PARAMS);
    	}
		if(reqBean.getQueryType() == null) {
			throw new BusinessException("查询类型不能为空！");
		}
		if(!reqBean.getQueryType().equals(DashBoardConstants.QUERY_PURCHASE)
				&& !reqBean.getQueryType().equals(DashBoardConstants.QUERY_TAILOR)) {
			throw new BusinessException(Status.NOT_VALID_PARAMS);
		}
		if(reqBean.getPageNum() == null || reqBean.getPageNum() < 1) {
			reqBean.setPageNum(ApiConstants.DEFAULT_PAGE_NUM);
		}
		if(reqBean.getPageSize() == null || reqBean.getPageSize() < 1) {
			reqBean.setPageSize(ApiConstants.DEFAULT_PAGE_SIZE);
		}
		int offset = (reqBean.getPageNum() - 1) * reqBean.getPageSize();
		reqBean.setOffset(offset);
		reqBean.setLimit(reqBean.getPageSize());
		if(reqBean.getApprovalStatus() != null && reqBean.getApprovalStatus() != DashBoardConstants.REQ_IS_APPROVAL
				&& reqBean.getApprovalStatus() != DashBoardConstants.REQ_IS_NOT_APPROVAL) {
			throw new BusinessException(Status.NOT_VALID_PARAMS);
		}
	}

}

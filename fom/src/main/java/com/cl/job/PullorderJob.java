package com.cl.job;

import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.cl.bean.res.InfResBean;
import com.cl.bean.res.OrderQuantityBean;
import com.cl.bean.res.OrderResBean;
import com.cl.bean.res.PurchaseBean;
import com.cl.bean.res.SecondProcessBean;
import com.cl.comm.constants.ApiConstants;
import com.cl.config.CommonConfig;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.OrderQuantityMapper;
import com.cl.dao.PurchaseMapper;
import com.cl.dao.SecondaryProcessMapper;
import com.cl.dao.TbLogMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderQuantityEntity;
import com.cl.entity.PurchaseEntity;
import com.cl.entity.SecondaryProcessEntity;
import com.cl.entity.TbLog;
import com.cl.util.HttpClientUtils;
import com.cl.util.RsaUtil;

@Component
@EnableScheduling
@Configurable
public class PullorderJob {

	private final Logger log = LoggerFactory.getLogger(PullorderJob.class);
	
	@Autowired
	private OrderManageMapper orderManageMapper;
	
	@Autowired
	private OrderQuantityMapper orderQuantityMapper;
	
	@Autowired
	private SecondaryProcessMapper secondaryProcessMapper;
	
	@Autowired
	private PurchaseMapper purchaseMapper;
	
	@Autowired
	private TbLogMapper tbLogMapper;
	
	@Autowired
	private CommonConfig config;
	
	@Scheduled(cron = "0 */3 * * * *")
	@Transactional(rollbackFor = Exception.class)
	public void pullOrder() throws Exception {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = c.getTime();
		String endTime = sdf.format(now);
		c.add(Calendar.MINUTE, -10);
		String startTime = sdf.format(c.getTime());
		Map<String,String> params = new HashMap<String, String>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		Map<String,String> headerParams = getHeaderParams(now);
		String result = HttpClientUtils.httpPostWithJSON(config.getUrlPrefix() + config.getUri(), params,headerParams);
		if(StringUtils.isBlank(result)) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			return;
		}
		InfResBean resBean = JSONObject.parseObject(result, InfResBean.class);
		if(resBean == null) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			return;
		}
		List<OrderResBean> orderList = resBean.getInfo();
		if(CollectionUtils.isEmpty(orderList)) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			return;
		}
		for(OrderResBean order : orderList) {
			//记录日志
			TbLog tbLog = generateLog(order,result,now);
			try {
				String errMsg = validateOrderData(order);
				if(StringUtils.isNotBlank(errMsg)) {
					tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_FAILED);
					tbLog.setErrMsg(errMsg);
					tbLogMapper.insertSelective(tbLog);
					return;
				}
				OrderManageEntity entity = convertFromOrder(order, now);
				if(entity == null) {
					continue;
				}
				orderManageMapper.insertSelective(entity);
				List<OrderQuantityBean> orderQuantityList = order.getOrderInfo();
				processOrderQuantity(orderQuantityList,entity.getOrderNo(),now);
				List<SecondProcessBean> secondProcessList = order.getSecondProcess();
				processSecondProcess(secondProcessList,entity.getOrderNo(),now);
				List<PurchaseBean> purchaseList = order.getPurchaseInfo();
				processPurchase(purchaseList,order,now);
			}catch (Exception e) {
				e.printStackTrace();
				tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_FAILED);
				tbLog.setErrMsg(e.getMessage());
			}
			tbLogMapper.insertSelective(tbLog);
		}
	}

	private TbLog generateLog(OrderResBean order, String result, Date now) {
		TbLog tbLog = new TbLog();
		tbLog.setOrderNo(order.getProduceOrderId());
		tbLog.setDescription(result);
		tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_SUCCESS);
		tbLog.setCreateUser(ApiConstants.API_USER);
		tbLog.setCreateTime(now);
		return tbLog;
	}

	private void processPurchase(List<PurchaseBean> purchaseList, OrderResBean order, Date now) {
		for(PurchaseBean pb : purchaseList) {
			PurchaseEntity entity = convertFromPurchaseBean(pb,order,now);
			purchaseMapper.insertSelective(entity);
		}
	}

	private PurchaseEntity convertFromPurchaseBean(PurchaseBean pb, OrderResBean order, Date now) {
		PurchaseEntity entity = new PurchaseEntity();
		entity.setOrderNo(order.getProduceOrderId());
		entity.setPurchaseNo(pb.getPurchaseCode());
		entity.setSupplierName(pb.getSupplierName());
		entity.setSupplierCode(pb.getSupplierCode());
		entity.setSupplierColorNumber(pb.getSupplierColorNum());
		entity.setPurchaseStatus(ApiConstants.PURCHASE_STATUS_WAITING_PURCHASE);
		entity.setMaterielSku(pb.getMaterialSku());
		entity.setMaterielTypeCode(pb.getMaterialType());
		entity.setMaterielName(pb.getMaterialName());
		entity.setMaterielColor(pb.getMaterialColor());
		//应采数量 = 单件用量 * 订单件数
		entity.setAnswerPickQuantity(Integer.valueOf(pb.getSimpleUse().multiply(BigDecimal.valueOf(Double.valueOf(order.getQuantity() + ""))).toString()));
		entity.setAnswerPickMonovalent(pb.getPrice());
//		entity.setAnswerPickTotal(answerPickTotal);
//		entity.setS
		entity.setCreateUser(ApiConstants.API_USER);
		entity.setCreateTime(now);
		entity.setLastUpdateUser(ApiConstants.API_USER);
		entity.setLastUpdateTime(now);
		return entity;
	}

	private void processSecondProcess(List<SecondProcessBean> secondProcessList, String orderNo, Date now) {
		for(SecondProcessBean sp : secondProcessList) {
			SecondaryProcessEntity entity = new SecondaryProcessEntity();
			BeanUtils.copyProperties(sp, entity);
			entity.setOrderNo(orderNo);
			entity.setCreateUser(ApiConstants.API_USER);
			entity.setCreateTime(now);
			entity.setLastUpdateUser(ApiConstants.API_USER);
			entity.setLastUpdateTime(now);
			secondaryProcessMapper.insertSelective(entity);
		}
	}

	private void processOrderQuantity(List<OrderQuantityBean> orderQuantityList,String orderNo,Date now) {
		for(OrderQuantityBean oq : orderQuantityList) {
			OrderQuantityEntity entity = new OrderQuantityEntity();
			BeanUtils.copyProperties(oq, entity);
			entity.setOrderNo(orderNo);
			entity.setCreateUser(ApiConstants.API_USER);
			entity.setCreateTime(now);
			entity.setLastUpdateUser(ApiConstants.API_USER);
			entity.setLastUpdateTime(now);
			orderQuantityMapper.insertSelective(entity);
		}
	}

	private String validateOrderData(OrderResBean order) {
		StringBuffer sb = new StringBuffer("");
		if(StringUtils.isBlank(order.getProduceOrderId())) {
			sb.append("订单号不能为空！");
		}
		if(StringUtils.isBlank(order.getAcceptOrderTime())) {
			sb.append("接单时间不能为空！");
		}
		Pattern pattern = Pattern.compile(ApiConstants.DATETIME_REG);
		Matcher matcher = pattern.matcher(order.getAcceptOrderTime());
		if(!matcher.matches()) {
			sb.append("接单时间不符合规则！");
		}
		if(StringUtils.isBlank(order.getPlaceOrderTime())) {
			sb.append("下单时间不能为空！");
		}
		matcher = pattern.matcher(order.getPlaceOrderTime());
		if(!matcher.matches()) {
			sb.append("下单时间不符合规则！");
		}
		if(StringUtils.isBlank(order.getDeliveryTime())) {
			sb.append("目标交期不能为空！");
		}
		pattern = Pattern.compile(ApiConstants.DATE_REG);
		matcher = pattern.matcher(order.getDeliveryTime());
		if(!matcher.matches()) {
			sb.append("目标交期不符合规则！");
		}
		if(StringUtils.isBlank(order.getPic())) {
			sb.append("订单图片不能为空！");
		}
		if(StringUtils.isBlank(order.getProducer())) {
			sb.append("生产方不能为空！");
		}
		if(order.getQuantity() <= ApiConstants.ZERO) {
			sb.append("数量必须大于0");
		}
		if(StringUtils.isBlank(order.getSku())) {
			sb.append("SKU不能为空！");
		}
		List<SecondProcessBean> secondProcessList = order.getSecondProcess();
		if(CollectionUtils.isEmpty(secondProcessList)) {
			sb.append("二次工艺列表不能为空！");
		}
		for(SecondProcessBean sp : secondProcessList) {
			String errMsg = validateSecondProcessBean(sp);
			if(StringUtils.isNotBlank(errMsg)) {
				sb.append(errMsg);
			}
		}
		List<OrderQuantityBean> orderQuantityList = order.getOrderInfo();
		if(CollectionUtils.isEmpty(orderQuantityList)) {
			sb.append("订单数量列表不能为空！");
		}
		for(OrderQuantityBean oq : orderQuantityList) {
			String errMsg = validateOrderQuantity(oq);
			if(StringUtils.isNotBlank(errMsg)) {
				sb.append(errMsg);
			}
		}
		List<PurchaseBean> purchaseList = order.getPurchaseInfo();
		if(CollectionUtils.isEmpty(purchaseList)) {
			sb.append("采购单列表不能为空！");
		}
		for(PurchaseBean pb : purchaseList) {
			String errMsg = validatePurchase(pb);
			if(StringUtils.isNotBlank(errMsg)) {
				sb.append(errMsg);
			}
		}
		return sb.toString();
	}

	private String validatePurchase(PurchaseBean pb) {
		StringBuffer sb = new StringBuffer("");
		if(StringUtils.isBlank(pb.getPurchaseCode())) {
			sb.append("采购单号不能为空！");
		}
		if(StringUtils.isBlank(pb.getMaterialSku())) {
			sb.append("物料SKU不能为空！");
		}
		if(StringUtils.isBlank(pb.getMaterialType())) {
			sb.append("物料分类不能为空！");
		}
		if(StringUtils.isBlank(pb.getMaterialName())) {
			sb.append("物料名称不能为空！");
		}
		if(StringUtils.isBlank(pb.getMaterialColor())) {
			sb.append("物料颜色不能为空！");
		}
		if(StringUtils.isBlank(pb.getSupplierName())) {
			sb.append("供应商名称不能为空！");
		}
		if(StringUtils.isBlank(pb.getSupplierCode())) {
			sb.append("供应商编码不能为空！");
		}
		if(StringUtils.isBlank(pb.getSupplierColorNum())) {
			sb.append("供应商色号不能为空！");
		}
		if(StringUtils.isBlank(pb.getSupplierAddr())) {
			sb.append("供应商地址不能为空！");
		}
		if(StringUtils.isBlank(pb.getSupplierPhone())) {
			sb.append("供应商电话不能为空！");
		}
		return sb.toString();
	}

	private String validateOrderQuantity(OrderQuantityBean oq) {
		StringBuffer sb = new StringBuffer("");
		if(StringUtils.isBlank(oq.getSizeName())) {
			sb.append("尺寸名称不能为空！");
		}
		if(oq.getQuantity() <= ApiConstants.ZERO) {
			sb.append("尺寸数量必须大于0！");
		}
		return sb.toString();
	}

	private String validateSecondProcessBean(SecondProcessBean sp) {
		StringBuffer sb = new StringBuffer("");
		if(StringUtils.isBlank(sp.getProcessName())) {
			sb.append("工艺名称不能为空！");
		}
		if(StringUtils.isBlank(sp.getSupplierName())) {
			sb.append("供应商名称不能为空！");
		}
		if(sp.getUnitPrice() == null || sp.getUnitPrice().compareTo(new BigDecimal(0)) <= ApiConstants.ZERO) {
			sb.append("单价必须大于0！");
		}
		return sb.toString();
	}

	private OrderManageEntity convertFromOrder(OrderResBean order,Date now) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		OrderManageEntity entity = new OrderManageEntity();
		entity.setOrderNo(order.getProduceOrderId());
		entity.setOrderQuantity(order.getQuantity());
		entity.setOrderTime(sdf.parse(order.getPlaceOrderTime()));
		entity.setOrderImgUrl(order.getPic());
		entity.setSku(order.getSku());
		entity.setIsFirst(order.getIsFirst().equals(ApiConstants.INF_IS_FIRST) ? Byte.valueOf("1") : Byte.valueOf("0"));
		entity.setProducer(order.getProducer());
		entity.setOrderStatus(ApiConstants.ORDER_STATUS_WAITING_PURCHASE);
		entity.setCreateUser(ApiConstants.API_USER);
		entity.setCreateTime(now);
		entity.setLastUpdateUser(ApiConstants.API_USER);
		entity.setLastUpdateTime(now);
		return entity;
	}

	private Map<String, String> getHeaderParams(Date now) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
		Map<String,String> headerParams = new HashMap<>();
		headerParams.put("appId", config.getAppId());
		headerParams.put("appSecure", config.getAppSecure());
		headerParams.put("timestamp", String.valueOf(now.getTime()));
		String content = config.getAppId() + "," + config.getAppSecure() + "," + config.getUri() + "," + now.getTime();
		String sign = RsaUtil.executeSignature(config.getPrivateKey(), content);
		headerParams.put("sign", sign);
		headerParams.put("uri", config.getUri());
		return headerParams;
	}
}

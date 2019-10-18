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
import com.cl.comm.exception.BusinessException;
import com.cl.comm.model.Status;
import com.cl.config.CommonConfig;
import com.cl.dao.OrderManageMapper;
import com.cl.dao.OrderQuantityMapper;
import com.cl.dao.PurchaseMapper;
import com.cl.dao.SecondaryProcessMapper;
import com.cl.dao.StockMapper;
import com.cl.dao.SysParameterMapper;
import com.cl.dao.TbLogMapper;
import com.cl.entity.OrderManageEntity;
import com.cl.entity.OrderQuantityEntity;
import com.cl.entity.OrderQuantityEntityExample;
import com.cl.entity.OrderQuantityEntityExample.Criteria;
import com.cl.entity.PurchaseEntity;
import com.cl.entity.PurchaseEntityExample;
import com.cl.entity.SecondaryProcessEntity;
import com.cl.entity.StockEntity;
import com.cl.entity.StockEntityExample;
import com.cl.entity.SysParameterEntity;
import com.cl.entity.SysParameterEntityExample;
import com.cl.entity.TbLogEntity;
import com.cl.utils.HttpClientUtil;
import com.cl.utils.RsaUtil;

@Component
@EnableScheduling
@Configurable
public class PullOrderJob {

	private final Logger log = LoggerFactory.getLogger(PullOrderJob.class);
	
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
	private SysParameterMapper sysParameterMapper;
	
	@Autowired
	private StockMapper stockMapper;
	
	@Autowired
	private CommonConfig config;
	
	@Scheduled(cron = "0 */10 * * * *")
	@Transactional(rollbackFor = Exception.class)
	public void pullOrder() throws Exception {
		SysParameterEntityExample example = new SysParameterEntityExample();
		SysParameterEntityExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(ApiConstants.PULL_ORDER_TIME_CODE);
		List<SysParameterEntity> sysParameterList = sysParameterMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(sysParameterList)) {
			log.info("pull_order_time时间戳不存在！");
			return;
		}
		if(sysParameterList.size() > 1) {
			log.info("pull_order_time时间戳重复！");
			return;
		}
		SysParameterEntity parameterEntity = sysParameterList.get(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(parameterEntity.getValue()));
		Date now = new Date();
		String endTime = parameterEntity.getValue();
		c.add(Calendar.MINUTE, -10);
		String startTime = sdf.format(c.getTime());
		Map<String,String> params = new HashMap<String, String>();
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		Map<String,String> headerParams = getHeaderParams(now);
		String result = HttpClientUtil.httpPostWithJSON(config.getUrlPrefix() + config.getUri(), params,headerParams);
		if(StringUtils.isBlank(result)) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			c.add(Calendar.MINUTE, 20);
			parameterEntity.setValue(sdf.format(c.getTime()));
			sysParameterMapper.updateByPrimaryKey(parameterEntity);
			return;
		}
		InfResBean resBean = JSONObject.parseObject(result, InfResBean.class);
		if(resBean == null) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			c.add(Calendar.MINUTE, 20);
			parameterEntity.setValue(sdf.format(c.getTime()));
			sysParameterMapper.updateByPrimaryKey(parameterEntity);
			return;
		}
		List<OrderResBean> orderList = resBean.getInfo();
		if(CollectionUtils.isEmpty(orderList)) {
			log.info("startTime:" + startTime + ",endTime:" + endTime + "无订单！");
			c.add(Calendar.MINUTE, 20);
			parameterEntity.setValue(sdf.format(c.getTime()));
			sysParameterMapper.updateByPrimaryKey(parameterEntity);
			return;
		}
		log.info("startTime:" + startTime + ",endTime:" + endTime);
		for(OrderResBean order : orderList) {
			//记录日志
			TbLogEntity tbLog = generateLog(order,result,now);
			String errMsg = validateOrderData(order);
			if(StringUtils.isNotBlank(errMsg)) {
				tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_FAILED);
				tbLog.setErrMsg(errMsg);
				tbLogMapper.insertSelective(tbLog);
				continue;
			}
			Map<String,Object> orderParams = new HashMap<>();
			orderParams.put("orderNo", order.getProduceOrderId());
			List<OrderManageEntity> existsOrderList = orderManageMapper.selectByParams(orderParams);
			if(CollectionUtils.isNotEmpty(existsOrderList)) {
				tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_FAILED);
				tbLog.setErrMsg("订单编号：" + order.getProduceOrderId() + "已存在");
				tbLogMapper.insertSelective(tbLog);
				continue;
			}
			OrderManageEntity entity = convertFromOrder(order, now);
			if(entity == null) {
				continue;
			}
			orderManageMapper.insertSelective(entity);
			List<OrderQuantityBean> orderQuantityList = order.getOrderInfo();
			processOrderQuantity(orderQuantityList,entity.getOrderNo(),now);
			List<SecondProcessBean> secondProcessList = order.getSecondProcess();
			if(CollectionUtils.isNotEmpty(secondProcessList)) {
				processSecondProcess(secondProcessList,entity.getOrderNo(),now);
			}
			List<PurchaseBean> purchaseList = order.getPurchaseInfo();
			processPurchase(purchaseList,order,now);
			tbLogMapper.insertSelective(tbLog);
		}
		c.add(Calendar.MINUTE, 20);
		parameterEntity.setValue(sdf.format(c.getTime()));
		sysParameterMapper.updateByPrimaryKey(parameterEntity);
	}

	private TbLogEntity generateLog(OrderResBean order, String result, Date now) {
		TbLogEntity tbLog = new TbLogEntity();
		tbLog.setOrderNo(order.getProduceOrderId());
		tbLog.setDescription(result);
		tbLog.setIsSuccess(ApiConstants.INTERFACE_SAVE_SUCCESS);
		tbLog.setCreateUser(ApiConstants.API_USER);
		tbLog.setCreateTime(now);
		return tbLog;
	}

	private void processPurchase(List<PurchaseBean> purchaseList, OrderResBean order, Date now) {
		for(PurchaseBean pb : purchaseList) {
			//新增采购单
			PurchaseEntityExample example = new PurchaseEntityExample();
			PurchaseEntityExample.Criteria criteria = example.createCriteria();
			criteria.andOrderNoEqualTo(order.getProduceOrderId());
			criteria.andPurchaseNoEqualTo(pb.getPurchaseCode());
			List<PurchaseEntity> existEntityList = purchaseMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(existEntityList)) {
				throw new BusinessException(Status.EXISTS_PURCHASE);
			}
			PurchaseEntity entity = convertFromPurchaseBean(pb,order,now);
			purchaseMapper.insertSelective(entity);
			
			//新增库存
			StockEntityExample stockExample = new StockEntityExample();
			StockEntityExample.Criteria stockCriteria = stockExample.createCriteria();
			stockCriteria.andOrderNoEqualTo(order.getProduceOrderId());
			stockCriteria.andSkuEqualTo(order.getSku());
			stockCriteria.andMaterialSkuEqualTo(pb.getMaterialSku());
			List<StockEntity> existsStock = stockMapper.selectByExample(stockExample);
			if(CollectionUtils.isNotEmpty(existsStock)) {
				continue;
			}
			StockEntity stock = new StockEntity();
			stock.setOrderNo(order.getProduceOrderId());
			stock.setSku(order.getSku());
			stock.setMaterialSku(pb.getMaterialSku());
			stock.setStock(ApiConstants.DEFAULT_STOCK);
			stock.setCreateUser(ApiConstants.API_USER);
			stock.setCreateTime(now);
			stock.setLastUpdateUser(ApiConstants.API_USER);
			stock.setLastUpdateTime(now);
			stockMapper.insertSelective(stock);
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
		entity.setMaterielType(pb.getMaterialType());
		entity.setPurchaseType(pb.getPurchaseType());
		entity.setMaterielName(pb.getMaterialName());
		entity.setMaterielColor(pb.getMaterialColor());
		//应采数量 = 单件用量 * 订单件数
		entity.setAnswerPickQuantity(pb.getSimpleUse().multiply(BigDecimal.valueOf(Double.valueOf(order.getQuantity() + ""))).setScale(0, BigDecimal.ROUND_HALF_UP));
		entity.setAnswerPickMonovalent(pb.getPrice());
		entity.setAnswerPickTotal(entity.getAnswerPickQuantity().multiply(entity.getAnswerPickMonovalent()));
		entity.setSimpleUse(pb.getSimpleUse());
		entity.setSingleAmountKg(pb.getSingleAmountKg());
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
			OrderQuantityEntityExample example = new OrderQuantityEntityExample();
			Criteria criteria = example.createCriteria();
			criteria.andOrderNoEqualTo(orderNo);
			criteria.andSizeNameEqualTo(oq.getSizeName());
			criteria.andQuantityEqualTo(oq.getQuantity());
			List<OrderQuantityEntity> existList = orderQuantityMapper.selectByExample(example);
			if(CollectionUtils.isNotEmpty(existList)) {
				throw new BusinessException(Status.EXISTS_ORDER_QUANTITY);
			}
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
		if(StringUtils.isBlank(order.getPlaceOrderTime())) {
			sb.append("下单时间不能为空！");
		}
		Pattern pattern = Pattern.compile(ApiConstants.DATETIME_REG);
		if(StringUtils.isNotBlank(order.getAcceptOrderTime())) {
			Matcher matcher = pattern.matcher(order.getAcceptOrderTime());
			if(!matcher.matches()) {
				sb.append("接单时间不符合规则！");
			}
		}
		if(StringUtils.isNotBlank(order.getPlaceOrderTime())) {
			Matcher matcher = pattern.matcher(order.getPlaceOrderTime());
			if(!matcher.matches()) {
				sb.append("下单时间不符合规则！");
			}
		}
		if(StringUtils.isBlank(order.getDeliveryTime())) {
			sb.append("目标交期不能为空！");
		}
		pattern = Pattern.compile(ApiConstants.DATE_REG);
		if(StringUtils.isNotBlank(order.getDeliveryTime())) {
			Matcher matcher = pattern.matcher(order.getDeliveryTime());
			if(!matcher.matches()) {
				sb.append("目标交期不符合规则！");
			}
		}
		if(StringUtils.isBlank(order.getPic())) {
			sb.append("订单图片不能为空！");
		}
		if(StringUtils.isBlank(order.getProducer())) {
			order.setProducer("欧丝丹");
		}
		if(order.getQuantity() <= ApiConstants.ZERO) {
			sb.append("数量必须大于0");
		}
		if(StringUtils.isBlank(order.getSku())) {
			sb.append("SKU不能为空！");
		}
		List<SecondProcessBean> secondProcessList = order.getSecondProcess();
		if(CollectionUtils.isNotEmpty(secondProcessList)) {
			for(SecondProcessBean sp : secondProcessList) {
				String errMsg = validateSecondProcessBean(sp);
				if(StringUtils.isNotBlank(errMsg)) {
					sb.append(errMsg);
				}
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
		entity.setSurplusTime(order.getDeliveryTime());
		entity.setOrderType(order.getOrderType());
		entity.setIsFirst(order.getIsFirst().equals(ApiConstants.INF_IS_FIRST) ? Byte.valueOf("1") : Byte.valueOf("0"));
		if(order.getProducer().indexOf("/") > 0) {
			String[] producerArr = order.getProducer().split("/");
			String producer = producerArr[0];
			entity.setProducer(producer);
		}else {
			entity.setProducer(order.getProducer());
		}
		entity.setOrderStatus(ApiConstants.ORDER_STATUS_WAIT_PURCHASE);
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

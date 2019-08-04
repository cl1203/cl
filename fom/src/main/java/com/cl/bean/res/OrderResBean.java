package com.cl.bean.res;

import java.io.Serializable;
import java.util.List;

public class OrderResBean implements Serializable {

	private static final long serialVersionUID = -1775321911472505404L;

	private String produceOrderId;
	
	private String acceptOrderTime;
	
	private String deliveryTime;
	
	private String designCode;
	
	private String isFirst;
	
	private String isUrgent;
	
	private String orderType;
	
	private String pic;
	
	private String placeOrderTime;
	
	private double processCostFee;
	
	private double processProfit;
	
	private String producer;
	
	private int quantity;
	
	private String refSku;
	
	private double scale;
	
	private String sku;
	
	private String status;
	
	private String stockType;
	
	private String weavingType;
	
	private List<SecondProcessBean> secondProcess;
	
	private List<OrderQuantityBean> orderInfo;
	
	private List<PurchaseBean> purchaseInfo;

	public String getProduceOrderId() {
		return produceOrderId;
	}

	public void setProduceOrderId(String produceOrderId) {
		this.produceOrderId = produceOrderId;
	}

	public String getAcceptOrderTime() {
		return acceptOrderTime;
	}

	public void setAcceptOrderTime(String acceptOrderTime) {
		this.acceptOrderTime = acceptOrderTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDesignCode() {
		return designCode;
	}

	public void setDesignCode(String designCode) {
		this.designCode = designCode;
	}

	public String getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(String isFirst) {
		this.isFirst = isFirst;
	}

	public String getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(String isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPlaceOrderTime() {
		return placeOrderTime;
	}

	public void setPlaceOrderTime(String placeOrderTime) {
		this.placeOrderTime = placeOrderTime;
	}

	public double getProcessCostFee() {
		return processCostFee;
	}

	public void setProcessCostFee(double processCostFee) {
		this.processCostFee = processCostFee;
	}

	public double getProcessProfit() {
		return processProfit;
	}

	public void setProcessProfit(double processProfit) {
		this.processProfit = processProfit;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRefSku() {
		return refSku;
	}

	public void setRefSku(String refSku) {
		this.refSku = refSku;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getWeavingType() {
		return weavingType;
	}

	public void setWeavingType(String weavingType) {
		this.weavingType = weavingType;
	}

	public List<SecondProcessBean> getSecondProcess() {
		return secondProcess;
	}

	public void setSecondProcess(List<SecondProcessBean> secondProcess) {
		this.secondProcess = secondProcess;
	}

	public List<OrderQuantityBean> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderQuantityBean> orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<PurchaseBean> getPurchaseInfo() {
		return purchaseInfo;
	}

	public void setPurchaseInfo(List<PurchaseBean> purchaseInfo) {
		this.purchaseInfo = purchaseInfo;
	}
	
}

package com.cl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonConfig {

	@Value("${interface.app.id}")
	private String appId;
	
	@Value("${interface.app.secure}")
	private String appSecure;
	
	@Value("${interface.private.key}")
	private String privateKey;
	
	@Value("${interface.app.uri}")
	private String uri;
	
	@Value("${interface.url.prefix}")
	private String urlPrefix;
	
	@Value("${dashboard.show.day}")
	private Integer dashBoardShowDay;
	
	@Value("${dashboard.purchase.difference}")
	private Integer purchaseDifference;
	
	@Value("${dashboard.tailor.difference}")
	private Integer tailorDifference;
	
	@Value("${dashboard.purchase.start_date}")
	private Integer purchaseStartDate;

	@Value("${dashboard.tailor.start_date}")
	private Integer tailorStartDate;
	
	public Integer getPurchaseStartDate() {
		return purchaseStartDate;
	}

	public void setPurchaseStartDate(Integer purchaseStartDate) {
		this.purchaseStartDate = purchaseStartDate;
	}

	public Integer getTailorStartDate() {
		return tailorStartDate;
	}

	public void setTailorStartDate(Integer tailorStartDate) {
		this.tailorStartDate = tailorStartDate;
	}

	public Integer getDashBoardShowDay() {
		return dashBoardShowDay;
	}

	public void setDashBoardShowDay(Integer dashBoardShowDay) {
		this.dashBoardShowDay = dashBoardShowDay;
	}

	public Integer getPurchaseDifference() {
		return purchaseDifference;
	}

	public void setPurchaseDifference(Integer purchaseDifference) {
		this.purchaseDifference = purchaseDifference;
	}

	public Integer getTailorDifference() {
		return tailorDifference;
	}

	public void setTailorDifference(Integer tailorDifference) {
		this.tailorDifference = tailorDifference;
	}

	public String getUrlPrefix() {
		return urlPrefix;
	}

	public void setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecure() {
		return appSecure;
	}

	public void setAppSecure(String appSecure) {
		this.appSecure = appSecure;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
}

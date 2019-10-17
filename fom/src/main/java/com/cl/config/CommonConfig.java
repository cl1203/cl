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
	
	@Value("${dashboard.purchase.show}")
	private Integer dashBoardPurchaseDay;
	
	@Value("${dashboard.tailor.show}")
	private Integer dashBoardTailorDay;
	
	@Value("${dashboard.purchase.difference}")
	private Integer purchaseDifference;
	
	@Value("${dashboard.tailor.difference}")
	private Integer tailorDifference;

	@Value("${ftp.address}")
	private String ftpIp;

	@Value("${ftp.port}")
	private Integer ftpPort;

	@Value("${ftp.username}")
	private String ftpUserName;

	@Value("${ftp.password}")
	private String ftpPassword;

	@Value("${ftp.imageBaseUrl}")
	private String ftpImgUrl;

	@Value("${ftp.bastPath}")
	private String ftpPosition;

	public String getFtpIp() {
		return ftpIp;
	}

	public void setFtpIp(String ftpIp) {
		this.ftpIp = ftpIp;
	}

	public Integer getFtpPort() {
		return ftpPort;
	}

	public void setFtpPort(Integer ftpPort) {
		this.ftpPort = ftpPort;
	}

	public String getFtpUserName() {
		return ftpUserName;
	}

	public void setFtpUserName(String ftpUserName) {
		this.ftpUserName = ftpUserName;
	}

	public String getFtpPassword() {
		return ftpPassword;
	}

	public void setFtpPassword(String ftpPassword) {
		this.ftpPassword = ftpPassword;
	}

	public String getFtpImgUrl() {
		return ftpImgUrl;
	}

	public void setFtpImgUrl(String ftpImgUrl) {
		this.ftpImgUrl = ftpImgUrl;
	}

	public String getFtpPosition() {
		return ftpPosition;
	}

	public void setFtpPosition(String ftpPosition) {
		this.ftpPosition = ftpPosition;
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

	public Integer getDashBoardPurchaseDay() {
		return dashBoardPurchaseDay;
	}

	public void setDashBoardPurchaseDay(Integer dashBoardPurchaseDay) {
		this.dashBoardPurchaseDay = dashBoardPurchaseDay;
	}

	public Integer getDashBoardTailorDay() {
		return dashBoardTailorDay;
	}

	public void setDashBoardTailorDay(Integer dashBoardTailorDay) {
		this.dashBoardTailorDay = dashBoardTailorDay;
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

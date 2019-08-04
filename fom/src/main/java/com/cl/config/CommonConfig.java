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

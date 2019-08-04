package com.cl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public final class HttpClientUtils {

	private static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	private final static boolean alwaysClose = true;
	
	public static String httpPostWithJSON(String url, Map<String, String> params,Map<String,String> headerParams) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        RequestConfig defaultRequestConfig = RequestConfig.custom()
        	    .setSocketTimeout(30000)
        	    .setConnectTimeout(30000)
        	    .setConnectionRequestTimeout(30000)
        	    .setStaleConnectionCheckEnabled(true)
        	    .build();
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(defaultRequestConfig).build();
//        CloseableHttpClient client = HttpClients.createDefault();
        String respContent = null;
        StringEntity entity = null;
        if(params != null) {
        	JSONObject jsonParam = new JSONObject();
        	for(String key : params.keySet()) {
        		jsonParam.put(key, params.get(key));
        	}
        	entity = new StringEntity(jsonParam.toString(),"utf-8"); 
        }else {
        	throw new Exception("参数不能为空！");
        }
        entity.setContentEncoding("UTF-8");    
        entity.setContentType("application/json");
//        String appId = "F0005mauBUF";
//		String appSecure = "nuX8Vj6ZcY";
//		String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEApJ5OxE1EpZVq9bz6BHzsbBEsgIv4Kmn1Ana5jDY3S4ClQvKM3I2eWPP5AlMGg7SsMH8890xjxS9hchGAk5T0jwIDAQABAkEAnV08HMlkewmX4uvQ8SNeenv8V7H1/M2nSsCl5RQazc/XGs4v1YZMgYohVGA/rI6ing7nLut9sMtzLK+VjOHzgQIhANF15Itiqy0eLMEMXnakT/K7nZFBWsYnU3vuKFynwUJBAiEAyTHLz1KS/jj3I4C9F0FYCTBbX/fzUj2HaMDJ7KcT4s8CIQCK/zL0lDuHqziDuxOMo6kyKPJ9C+OTD1HFMduy8Ne8gQIhAJ0uSguudyglWO5jpVaFtkF3hetzyqR1bVRpSVeZL/ABAiBh4S6+k9oInL9TXZcv6lH2pKeovA1zkN/bZZSlcDWEEg==";
//		Long timestamp = new Date().getTime();
//		String uri = "/platform/order/queryProduceOrderInfo";
//		String content = appId + "," + appSecure + "," + uri + "," + timestamp;
//		String sign = RsaUtil.executeSignature(privateKey, content);
        httpPost.setHeader("appId", headerParams.get("appId"));
        httpPost.setHeader("appSecure", headerParams.get("appSecure"));
        httpPost.setHeader("timestamp", headerParams.get("timestamp"));
        httpPost.setHeader("sign",headerParams.get("sign"));
        httpPost.setHeader("uri",headerParams.get("uri"));
        httpPost.setEntity(entity);
        HttpResponse resp = client.execute(httpPost);
        if(resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity he = resp.getEntity();
            respContent = EntityUtils.toString(he,"UTF-8");
        }
        return respContent;
    }
	
	
	/**
	 * 提交post请求
	 * @param url          请求路径
	 * @param params       请求参数 Map<String,String>
	 * @param contentType  请求参数类型
	 * @return String      获取内容的string
	 * @throws SignatureException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws IOException
	 */
	public static String sendPost(String url, Map<String, String> params,String contentType) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, SignatureException{
		if (url == null || StringUtils.equals("", url))return null;
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(alwaysClose));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		PostMethod post = new PostMethod(url);
		post.setRequestHeader("Connection", "close"); 
		post.setRequestHeader("Content-Type",contentType);
		try {
			if (params != null && params.size() > 0) {
				NameValuePair[] postData = new NameValuePair[params.size()];
				int i = 0;
				for (String key : params.keySet()) {
					postData[i] = new NameValuePair(key, params.get(key));
					i++;
				}
				post.addParameters(postData);
			}
		} catch (Exception e1) {
			log.warn("sendPost setParams warn url:["+url+"]");
			log.warn("sendPost setParams warn params:["+JSON.toJSONString(params)+"]");
			log.warn("sendPost setParams warn info:",e1);
			return null;
		}
		InputStream resStream = null;
		BufferedReader br = null;
		try {
			int status = client.executeMethod(post);
			if (status != HttpStatus.SC_OK){
				log.warn("sendPost url["+url+"]"+"params["+JSON.toJSONString(params)+"]");
				log.warn("sendPost status ["+status+"]");
				return null;
			}
			resStream = post.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(resStream, "UTF-8"));
			StringBuffer resBuffer = new StringBuffer();
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuffer.append(resTemp);
			}
			br.close();
			resStream.close();
			return resBuffer.toString();
		} catch (Exception e) {
			log.error("sendPost url["+url+"]"+"params["+JSON.toJSONString(params)+"]");
			log.error("sendPost error info:",e);
			return null;
		} finally{
			try {
				if(br != null) br.close();
				if(resStream != null) resStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 提交get请求
	 * @param url     请求路径
	 * @param params  请求参数 Map<String,String>
	 * @return String 获取内容的string
	 * @throws IOException
	 */
	public static String sendGet(String url, Map<String, String> params) {
		if (url == null || StringUtils.equals("", url))return null;
		HttpClient client = new HttpClient(new SimpleHttpConnectionManager(alwaysClose));
		client.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
		client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");
		StringBuffer sb = new StringBuffer("");
		try {
			if (params != null && params.size() > 0) {
				for (String key : params.keySet()) {
					sb.append(key).append("=").append(URLEncoder.encode(params.get(key),"UTF-8")).append("&");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		String pms = sb.toString();
		GetMethod get = new GetMethod(url + "?" + pms);
		get.setRequestHeader("Connection", "close"); 
		InputStream resStream = null;
		BufferedReader br = null;
		try {
			int status = client.executeMethod(get);
			if (status != HttpStatus.SC_OK){
				log.warn("sendGet url["+url+"]"+"params["+pms+"]");
				log.warn("sendGet status ["+status+"]");
				return null;
			}
			resStream = get.getResponseBodyAsStream();
			br = new BufferedReader(new InputStreamReader(resStream, "UTF-8"));
			StringBuffer resBuffer = new StringBuffer();
			String resTemp = "";
			while ((resTemp = br.readLine()) != null) {
				resBuffer.append(resTemp);
			}
			br.close();
			return resBuffer.toString();
		} catch (Exception e) {
			log.error("sendGet url["+url+"]"+"params["+pms+"]");
			log.error("sendGet error info:",e);
			return null;
		}finally{
			try {
				if(br != null) br.close();
				if(resStream != null) resStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    /**
     * 调用
     *
     * @param path
     * @param stringObject
     */
    public static String getHttpClient(String path, String stringObject,String contentType) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String content = "";
        // 创建HttpGet请求，相当于在浏览器输入地址
        HttpPost httpPost = new HttpPost(path);
        httpPost.addHeader("Content-Type",contentType);
        StringEntity stringEntity = new StringEntity(stringObject, "utf-8");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = null;
        try {
            // 执行请求，相当于敲完地址后按下回车。获取响应
            response = httpclient.execute(httpPost);
          //  if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
         //   }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                // 关闭资源
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 关闭浏览器
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }
}

package com.sae.express.dao.model.wechat;

import java.io.Serializable;

public class WxJsapiSignature implements Serializable{
   /*
    *  js-sdk实现 config 接口 参数持久化
    */
	private static final long serialVersionUID = -1314967809921297295L;
	
	private String appId;//企业号的唯一标识
	private String timestamp;//生成签名的时间戳
	private String noncestr;//生成签名的随机串
//	private String url; //地址
//	private String jsapiTicket;//公众号用于调用微信JS接口的临时票据
	private String signature;//生成签名
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

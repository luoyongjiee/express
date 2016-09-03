package com.sae.express.dao.model.wechat;


public class PlatformTokenTicket {

	private String appId;//企业号的唯一标识
	private String token;//微信通用接口凭证 
	private String ticket;//调用微信JS接口的临时票据
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
}

package com.sae.express.dao.model.wechat;

public class QRCode {

	// 	二维码的有效时间，以秒为单位。最大不超过1800。 
	private int expire_seconds;
	//获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码。 
	private String ticket;
	//二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片 
	private String url;
	public int getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(int expireSeconds) {
		expire_seconds = expireSeconds;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}

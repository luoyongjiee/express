package com.sae.express.dao.model.wechat;

import java.io.Serializable;

public class JsapiTicket implements Serializable {

	/**
	 * 公众号用于调用微信JS接口的临时票据
	 */
	private static final long serialVersionUID = -9094756401878339736L;

	private int errcode;//返回代码
	private String errmsg;//返回信息
	private String ticket;//调用微信JS接口的临时票据
	private int expires_in;//凭证有效时间，单位：秒 
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expiresIn) {
		expires_in = expiresIn;
	}
	
	
}

package com.sae.express.dao.model.wechat;

/**
 * 微信接口凭证，网页授权access_token
 * @author liuyuan
 *
 */

public class OAuthAccessToken extends AccessToken{
    //用户刷新access_token
	private String refresh_token;
	//用户唯一标识
	private String openid;
	//用户授权作用域，使用逗号 ，分隔
	private String scope;
	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
	private String unionid;
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refreshToken) {
		refresh_token = refreshToken;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
}

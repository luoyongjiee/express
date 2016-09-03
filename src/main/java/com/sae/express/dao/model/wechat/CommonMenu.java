package com.sae.express.dao.model.wechat;

public class CommonMenu {

	private String name;
	private String type;
	private String key;
	private String url;
	private CommonMenu[] sub_button;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public CommonMenu[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(CommonMenu[] subButton) {
		sub_button = subButton;
	}
	
	
}

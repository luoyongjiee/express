package com.sae.express.dao.model.wechat;

import java.util.Map;

/**
 * 模版消息实体类
 * @author liuyuan
 *
 */
public class TemplateMessage {

	private String touser;//用户openid
	private String template_id;//模版id
	private String url;//跳转链接
	private String topcolor;//颜色
	private Map<String, TemplateKeyNote> data;
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String templateId) {
		template_id = templateId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, TemplateKeyNote> getData() {
		return data;
	}
	
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public void setData(Map<String, TemplateKeyNote> data) {
		this.data = data;
	}
	
}

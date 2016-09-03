package com.sae.express.dao.model.wechat;

public class MenuTemplateRecords {

	private int level;
	private int number;
	private String nameid;
	private String keyid;
	private String name;
	private String key;
	private int parentId;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNameid() {
		return nameid;
	}
	public void setNameid(String nameid) {
		this.nameid = nameid;
	}
	public String getKeyid() {
		return keyid;
	}
	public void setKeyid(String keyid) {
		this.keyid = keyid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "MenuTemplateRecords [key=" + key + ", keyid=" + keyid
				+ ", level=" + level + ", name=" + name + ", nameid=" + nameid
				+ ", number=" + number + ", parentId=" + parentId + "]";
	}
	
	
}

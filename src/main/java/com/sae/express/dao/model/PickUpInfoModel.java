package com.sae.express.dao.model;

import java.util.Date;

public class PickUpInfoModel {
    private Integer id;

    private Integer pickUpId;

    private String expressCode;

    private String express;

    private Integer count;

    private Date expressDate;

    private String expressDateStr;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPickUpId() {
        return pickUpId;
    }

    public void setPickUpId(Integer pickUpId) {
        this.pickUpId = pickUpId;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express == null ? null : express.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getExpressDate() {
        return expressDate;
    }

    public void setExpressDate(Date expressDate) {
        this.expressDate = expressDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getExpressDateStr() {
        return expressDateStr;
    }

    public void setExpressDateStr(String expressDateStr) {
        this.expressDateStr = expressDateStr;
    }
}
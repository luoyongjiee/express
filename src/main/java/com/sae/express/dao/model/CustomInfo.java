package com.sae.express.dao.model;

/**
 * @Author： Administrator
 * @Date ： 2016/9/4. 19:21
 */
public class CustomInfo {
    private String userId;
    private String userName ;
    private String userPhone ;
    private String builderNum ;
    private String roomNum ;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getBuilderNum() {
        return builderNum;
    }

    public void setBuilderNum(String builderNum) {
        this.builderNum = builderNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }
}

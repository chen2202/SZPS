package com.szps.web.domain.mine;

import org.apache.ibatis.annotations.Param;

public class mine {

    //用户ID
    private Long userId;
    //用户编号
    private String userName;
    //归属部门
    private StringBuffer userDept;
    //所属岗位
    private String userPosition;
    //类型电话
    private String userPhone;
    //邮箱
    private String userEmail;
    //归属行政区
    private String userArea;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public StringBuffer getUserDept() {
        return userDept;
    }

    public void setUserDept(StringBuffer userDept) {
        this.userDept = userDept;
    }

    public String getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(String userPosition) {
        this.userPosition = userPosition;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserArea() {
        return userArea;
    }

    public void setUserArea(String userArea) {
        this.userArea = userArea;
    }

    @Override
    public String toString() {
        return userId + "," + userName + "," + userDept + "," + userPosition + "," + userPhone + "," + userEmail + "," + userArea;
    }
}

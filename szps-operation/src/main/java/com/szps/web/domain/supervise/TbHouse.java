package com.szps.web.domain.supervise;

import java.math.BigDecimal;

public class TbHouse {
    private String houseNumber;

    private String houseName;

    private String houseRegion;

    private String houseStreet;

    private String houseBasin;

    private String houseRole;

    private String houseType;

    private String housePoint;

    private String houseConnecting;

    private String housePhone;

    private String houseRule;

    private String houseFlag;

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber == null ? null : houseNumber.trim();
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName == null ? null : houseName.trim();
    }

    public String getHouseRegion() {
        return houseRegion;
    }

    public void setHouseRegion(String houseRegion) {
        this.houseRegion = houseRegion == null ? null : houseRegion.trim();
    }

    public String getHouseStreet() {
        return houseStreet;
    }

    public void setHouseStreet(String houseStreet) {
        this.houseStreet = houseStreet == null ? null : houseStreet.trim();
    }

    public String getHouseBasin() {
        return houseBasin;
    }

    public void setHouseBasin(String houseBasin) {
        this.houseBasin = houseBasin == null ? null : houseBasin.trim();
    }

    public String getHouseRole() {
        return houseRole;
    }

    public void setHouseRole(String houseRole) {
        this.houseRole = houseRole == null ? null : houseRole.trim();
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType == null ? null : houseType.trim();
    }

    public String getHousePoint() {
        return housePoint;
    }

    public void setHousePoint(String housePoint) {
        this.housePoint = housePoint == null ? null : housePoint.trim();
    }

    public String getHouseConnecting() {
        return houseConnecting;
    }

    public void setHouseConnecting(String houseConnecting) {
        this.houseConnecting = houseConnecting == null ? null : houseConnecting.trim();
    }

    public String getHousePhone() {
        return housePhone;
    }

    public void setHousePhone(String housePhone) {
        this.housePhone = housePhone;
    }

    public String getHouseRule() {
        return houseRule;
    }

    public void setHouseRule(String houseRule) {
        this.houseRule = houseRule;
    }

    public String getHouseFlag() {
        return houseFlag;
    }

    public void setHouseFlag(String houseFlag) {
        this.houseFlag = houseFlag;
    }
}
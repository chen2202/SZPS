package com.szps.web.domain.supervise;


public class TbHouse {
    private String houseNumber;

    private String houseName;

    private String houseRegion;

    private String houseBegin;

    private String houseRole;

    private String houseEnd;

    private String housePhone;

    private String houseFlag;

    private String houseTime;

    private String houseRule;


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

    public String getHouseBegin() {
        return houseBegin;
    }

    public void setHouseBegin(String houseBegin) {
        this.houseBegin = houseBegin == null ? null : houseBegin.trim();
    }

    public String getHouseEnd() {
        return houseEnd;
    }

    public void setHouseEnd(String houseEnd) {
        this.houseEnd = houseEnd == null ? null : houseEnd.trim();
    }

    public String getHouseRole() {
        return houseRole;
    }

    public void setHouseRole(String houseRole) {
        this.houseRole = houseRole == null ? null : houseRole.trim();
    }



    public String getHousePhone() {
        return housePhone;
    }

    public void setHousePhone(String housePhone) {
        this.housePhone = housePhone;
    }



    public String getHouseFlag() {
        return houseFlag;
    }

    public void setHouseFlag(String houseFlag) {
        this.houseFlag = houseFlag;
    }

    public String getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(String houseTime) {
        this.houseTime = houseTime;
    }

    public String getHouseRule() {
        return houseRule;
    }

    public void setHouseRule(String houseRule) {
        this.houseRule = houseRule;
    }
}
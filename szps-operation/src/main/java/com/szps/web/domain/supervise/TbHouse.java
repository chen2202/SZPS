package com.szps.web.domain.supervise;
import com.szps.common.annotation.Excel;

public class TbHouse {

    @Excel(name = "检查对象编号", prompt = "检查对象编号")
    private String houseNumber;

    @Excel(name = "检查对象名称", prompt = "检查对象名称")
    private String houseName;

    @Excel(name = "地址", prompt = "地址")
    private String houseRegion;

    @Excel(name = "联系人", prompt = "联系人")
    private String houseRole;

    @Excel(name = "联系电话", prompt = "联系电话")
    private String housePhone;

    @Excel(name = "项目名称", prompt = "项目名称")
    private  String houseItem;

    @Excel(name = "证件有效期", prompt = "证件有效期")
    private String houseTime;

    @Excel(name = "证件有效开始时间", prompt = "证件有效开始时间")
    private String houseBegin;

    @Excel(name = "证件有效结束时间", prompt = "证件有效结束时间")
    private String houseEnd;

    @Excel(name = "检查标记", prompt = "检查标记")
    private String houseFlag;

    @Excel(name = "抽取事项规则", prompt = "抽取事项规则")
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

    public String getHouseItem() {
        return houseItem;
    }

    public void setHouseItem(String houseItem) {
        this.houseItem = houseItem;
    }
}
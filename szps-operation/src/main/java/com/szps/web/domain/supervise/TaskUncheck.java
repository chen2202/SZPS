package com.szps.web.domain.supervise;


import com.szps.common.annotation.Excel;

public class TaskUncheck {
    //抽查编号
    @Excel(name = "抽查编号", prompt = "抽查编号")
    private String taskNumber;

    //创建时间
    @Excel(name = "创建时间", prompt = "创建时间")
    private String taskTime;

    //抽查事项
    @Excel(name = "抽查事项", prompt = "抽查事项")
    private String ruleName;

    //执法人员
    @Excel(name = "执法人员", prompt = "执法人员")
    private String tbStaffList;

    //抽查对象名称
    @Excel(name = "抽查对象名称", prompt = "抽查对象名称")
    private String houseName;

    //项目名称
    @Excel(name = "项目名称", prompt = "项目名称")
    private String houseItem;

    //地址
    @Excel(name = "地址", prompt = "地址")
    private String houseRegion;

    //联系人
    @Excel(name = "联系人", prompt = "联系人")
    private String houseRole;

    //联系电话
    @Excel(name = "联系电话", prompt = "联系电话")
    private String housePhone;

    //证照有效期
    @Excel(name = "证照有效期", prompt = "证照有效期")
    private String houseTime;

    //检查时间
    @Excel(name = "检查时间", prompt = "检查时间")
    private String taskCheckTime;

    //检查结果
    @Excel(name = "检查结果", prompt = "检查结果")
    private String taskResult;

    //处理情况
    @Excel(name = "处理情况", prompt = "处理情况")
    private String taskHandle;

    //补抽记录
    @Excel(name = "补抽记录", prompt = "补抽记录")
    private String taskBc;

    private String taskHouse;

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTbStaffList() {
        return tbStaffList;
    }

    public void setTbStaffList(String tbStaffList) {
        this.tbStaffList = tbStaffList;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseItem() {
        return houseItem;
    }

    public void setHouseItem(String houseItem) {
        this.houseItem = houseItem;
    }

    public String getHouseRegion() {
        return houseRegion;
    }

    public void setHouseRegion(String houseRegion) {
        this.houseRegion = houseRegion;
    }

    public String getHouseRole() {
        return houseRole;
    }

    public void setHouseRole(String houseRole) {
        this.houseRole = houseRole;
    }

    public String getHousePhone() {
        return housePhone;
    }

    public void setHousePhone(String housePhone) {
        this.housePhone = housePhone;
    }

    public String getHouseTime() {
        return houseTime;
    }

    public void setHouseTime(String houseTime) {
        this.houseTime = houseTime;
    }

    public String getTaskCheckTime() {
        return taskCheckTime;
    }

    public void setTaskCheckTime(String taskCheckTime) {
        this.taskCheckTime = taskCheckTime;
    }

    public String getTaskResult() {
        return taskResult;
    }

    public void setTaskResult(String taskResult) {
        this.taskResult = taskResult;
    }

    public String getTaskHandle() {
        return taskHandle;
    }

    public void setTaskHandle(String taskHandle) {
        this.taskHandle = taskHandle;
    }

    public String getTaskBc() {
        return taskBc;
    }

    public void setTaskBc(String taskBc) {
        this.taskBc = taskBc;
    }

    public String getTaskHouse() {
        return taskHouse;
    }

    public void setTaskHouse(String taskHouse) {
        this.taskHouse = taskHouse;
    }
}

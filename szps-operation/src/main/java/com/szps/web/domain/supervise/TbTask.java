package com.szps.web.domain.supervise;


import java.util.List;

public class TbTask {
    private String taskNumber;

    private String taskTime;

    private String taskHouse;

    private String ruleContent;

    private String ruleName;

    private List<TbStaff> tbStaffList;

    private String taskResult;

    private String taskHandle;

    private String taskFlag;

    private String beginTime;

    private String endTime;

    private TbHouse tbHouse;

    private String taskCheckTime;

    private String taskFile;

    private String taskBc;

    private String taskBcStaff;





    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime;
    }

    public String getTaskHouse() {
        return taskHouse;
    }

    public void setTaskHouse(String taskHouse) {
        this.taskHouse = taskHouse;
    }

    public List<TbStaff> getTbStaffList() {
        return tbStaffList;
    }

    public void setTbStaffList(List<TbStaff> tbStaffList) {
        this.tbStaffList = tbStaffList;
    }

    public TbHouse getTbHouse() {
        return tbHouse;
    }

    public void setTbHouse(TbHouse tbHouse) {
        this.tbHouse = tbHouse;
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
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

    public String getTaskFlag() {
        return taskFlag;
    }

    public void setTaskFlag(String taskFlag) {
        this.taskFlag = taskFlag;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTaskCheckTime() {
        return taskCheckTime;
    }

    public void setTaskCheckTime(String taskCheckTime) {
        this.taskCheckTime = taskCheckTime;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTaskFile() {
        return taskFile;
    }

    public void setTaskFile(String taskFile) {
        this.taskFile = taskFile;
    }

    public String getTaskBc() {
        return taskBc;
    }

    public void setTaskBc(String taskBc) {
        this.taskBc = taskBc;
    }

    public String getTaskBcStaff() {
        return taskBcStaff;
    }

    public void setTaskBcStaff(String taskBcStaff) {
        this.taskBcStaff = taskBcStaff;
    }
}
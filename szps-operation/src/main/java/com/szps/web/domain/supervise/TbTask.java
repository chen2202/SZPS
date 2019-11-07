package com.szps.web.domain.supervise;


import java.util.List;

public class TbTask {
    private String taskNumber;

    private String taskName;

    private String taskRegion;

    private String taskStreet;

    private String taskPartition;

    private String taskGrade;

    private String taskType;

    private String taskConnecting;

    private String taskTime;

    private String taskHouse;

    private String taskHousename;
    private String taskHousephone;

    private List<TbStaff> tbStaffList;

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getTaskRegion() {
        return taskRegion;
    }

    public void setTaskRegion(String taskRegion) {
        this.taskRegion = taskRegion == null ? null : taskRegion.trim();
    }

    public String getTaskStreet() {
        return taskStreet;
    }

    public void setTaskStreet(String taskStreet) {
        this.taskStreet = taskStreet == null ? null : taskStreet.trim();
    }

    public String getTaskPartition() {
        return taskPartition;
    }

    public void setTaskPartition(String taskPartition) {
        this.taskPartition = taskPartition == null ? null : taskPartition.trim();
    }

    public String getTaskGrade() {
        return taskGrade;
    }

    public void setTaskGrade(String taskGrade) {
        this.taskGrade = taskGrade == null ? null : taskGrade.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTaskConnecting() {
        return taskConnecting;
    }

    public void setTaskConnecting(String taskConnecting) {
        this.taskConnecting = taskConnecting == null ? null : taskConnecting.trim();
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

    public String getTaskHousename() {
        return taskHousename;
    }

    public void setTaskHousename(String taskHousename) {
        this.taskHousename = taskHousename;
    }

    public String getTaskHousephone() {
        return taskHousephone;
    }

    public void setTaskHousephone(String taskHousephone) {
        this.taskHousephone = taskHousephone;
    }


    public List<TbStaff> getTbStaffList() {
        return tbStaffList;
    }

    public void setTbStaffList(List<TbStaff> tbStaffList) {
        this.tbStaffList = tbStaffList;
    }
}
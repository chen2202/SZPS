package com.szps.web.domain.supervise;


import java.util.List;

public class TbFeedback {
    private String feedbackId;

    private String taskNumber;

    private String feedbackInformation;

    private String feedbackTime;
    private TbTask tbTask;
    private List<TbPicture> pictureList;
    private List<TbEnclosure> enclosureList;
    private List<TbStaff> tbStaffList;

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId == null ? null : feedbackId.trim();
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }


    public String getFeedbackInformation() {
        return feedbackInformation;
    }

    public void setFeedbackInformation(String feedbackInformation) {
        this.feedbackInformation = feedbackInformation == null ? null : feedbackInformation.trim();
    }

    public String getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }


    public TbTask getTbTask() {
        return tbTask;
    }

    public void setTbTask(TbTask tbTask) {
        this.tbTask = tbTask;
    }

    public List<TbPicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<TbPicture> pictureList) {
        this.pictureList = pictureList;
    }

    public List<TbEnclosure> getEnclosureList() {
        return enclosureList;
    }

    public void setEnclosureList(List<TbEnclosure> enclosureList) {
        this.enclosureList = enclosureList;
    }

    public List<TbStaff> getTbStaffList() {
        return tbStaffList;
    }

    public void setTbStaffList(List<TbStaff> tbStaffList) {
        this.tbStaffList = tbStaffList;
    }
}
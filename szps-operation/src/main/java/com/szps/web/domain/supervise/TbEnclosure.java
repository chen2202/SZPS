package com.szps.web.domain.supervise;

public class TbEnclosure {
    private String enclosureId;

    private String enclosureLocation;

    private String feedbackId;

    private String enclosureName;

    private String fatherName;

    private String flag;


    public String getEnclosureId() {
        return enclosureId;
    }

    public void setEnclosureId(String enclosureId) {
        this.enclosureId = enclosureId == null ? null : enclosureId.trim();
    }

    public String getEnclosureLocation() {
        return enclosureLocation;
    }

    public void setEnclosureLocation(String enclosureLocation) {
        this.enclosureLocation = enclosureLocation == null ? null : enclosureLocation.trim();
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getEnclosureName() {
        return enclosureName;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
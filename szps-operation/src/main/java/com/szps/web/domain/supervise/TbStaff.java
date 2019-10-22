package com.szps.web.domain.supervise;

import java.util.Date;

public class TbStaff {
    private String staffNumber;

    private String staffName;

    private String staffBirthday;

    private String staffGender;

    private String staffTelephone;

    private String staffPost;

    private String staffDept;

    private Short staffW;

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber == null ? null : staffNumber.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(String staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(String staffGender) {
        this.staffGender = staffGender == null ? null : staffGender.trim();
    }

    public String getStaffTelephone() {
        return staffTelephone;
    }

    public void setStaffTelephone(String staffTelephone) {
        this.staffTelephone = staffTelephone == null ? null : staffTelephone.trim();
    }

    public String getStaffPost() {
        return staffPost;
    }

    public void setStaffPost(String staffPost) {
        this.staffPost = staffPost == null ? null : staffPost.trim();
    }

    public String getStaffDept() {
        return staffDept;
    }

    public void setStaffDept(String staffDept) {
        this.staffDept = staffDept == null ? null : staffDept.trim();
    }

    public Short getStaffW() {
        return staffW;
    }

    public void setStaffW(Short staffW) {
        this.staffW = staffW;
    }
}
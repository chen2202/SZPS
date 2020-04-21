package com.szps.web.domain.supervise;

public class TbStaff {
    private String staffNumber;

    private String staffName;

    private String staffArea;

    private String staffCart;

    private String staffPost;

    private String staffDept;

    private String staffW;

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

    public String getStaffArea() {
        return staffArea;
    }

    public void setStaffArea(String staffArea) {
        this.staffArea = staffArea;
    }

    public String getStaffCart() {
        return staffCart;
    }

    public void setStaffCart(String staffCart) {
        this.staffCart = staffCart == null ? null : staffCart.trim();
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

    public String getStaffW() {
        return staffW;
    }

    public void setStaffW(String staffW) {
        this.staffW = staffW;
    }
}
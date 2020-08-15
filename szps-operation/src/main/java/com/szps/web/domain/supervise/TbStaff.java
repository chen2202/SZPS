package com.szps.web.domain.supervise;
import com.szps.common.annotation.Excel;

public class TbStaff {

    @Excel(name = "人员编号", prompt = "人员编号")
    private String staffNumber;

    @Excel(name = "人员姓名", prompt = "人员姓名")
    private String staffName;

    @Excel(name = "执法范围", prompt = "执法范围")
    private String staffArea;

    @Excel(name = "证件编号", prompt = "证件编号")
    private String staffCart;

    @Excel(name = "类型", prompt = "类型")
    private String staffPost;

    @Excel(name = "所属单位名称", prompt = "所属单位名称")
    private String staffDept;

    @Excel(name = "状态", prompt = "状态")
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
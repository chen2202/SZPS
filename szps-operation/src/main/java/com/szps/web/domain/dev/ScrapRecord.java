package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class ScrapRecord extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7933061974507435972L;
	private Long id;
	private Long deptId;
	private String devName;// 设备名称
	private String devSpecs;// 规格型号
	private String manufacturer;// 生产厂家
	private String devNumber;// 设备编号
	private String buyDate;// 购置日期
	private String price;// 购置价格
	private String applyScrapDate;// 申请报废日期
	private String useDept;// 使用部门
	private String scrapReason;// 报废原因及技术鉴定
	private String applyDept;// 申请部门
	private String applyDate;// 申请日期
	private String verifier;// 审核人
	private String verifyDate;// 审核日期
	private String approver;// 批准人
	private String approveDate;// 批准日期
	private String delFlag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevSpecs() {
		return devSpecs;
	}
	public void setDevSpecs(String devSpecs) {
		this.devSpecs = devSpecs;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDevNumber() {
		return devNumber;
	}
	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getApplyScrapDate() {
		return applyScrapDate;
	}
	public void setApplyScrapDate(String applyScrapDate) {
		this.applyScrapDate = applyScrapDate;
	}
	public String getUseDept() {
		return useDept;
	}
	public void setUseDept(String useDept) {
		this.useDept = useDept;
	}
	public String getScrapReason() {
		return scrapReason;
	}
	public void setScrapReason(String scrapReason) {
		this.scrapReason = scrapReason;
	}
	public String getApplyDept() {
		return applyDept;
	}
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getVerifier() {
		return verifier;
	}
	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}
	public String getVerifyDate() {
		return verifyDate;
	}
	public void setVerifyDate(String verifyDate) {
		this.verifyDate = verifyDate;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	

}

package com.szps.web.domain.dev.fixedasset;

import java.util.Date;

import com.szps.common.core.domain.BaseEntity;

public class Officeequipment extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	Long deptid;
	String deptname;
	String dlocation;
	String dnumber;
	String assetname;
	String dtype;
	String dparameter;
	String manufacturer;
	String measurement;
	String bookquantity;
	String realquantity;
	Date purchasedate;
	Date introductiondate;
	String dstatus;
	String originalvalue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDlocation() {
		return dlocation;
	}

	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDparameter() {
		return dparameter;
	}

	public void setDparameter(String dparameter) {
		this.dparameter = dparameter;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}

	public String getBookquantity() {
		return bookquantity;
	}

	public void setBookquantity(String bookquantity) {
		this.bookquantity = bookquantity;
	}

	public String getRealquantity() {
		return realquantity;
	}

	public void setRealquantity(String realquantity) {
		this.realquantity = realquantity;
	}

	public Date getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public Date getIntroductiondate() {
		return introductiondate;
	}

	public void setIntroductiondate(Date introductiondate) {
		this.introductiondate = introductiondate;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public String getOriginalvalue() {
		return originalvalue;
	}

	public void setOriginalvalue(String originalvalue) {
		this.originalvalue = originalvalue;
	}

}

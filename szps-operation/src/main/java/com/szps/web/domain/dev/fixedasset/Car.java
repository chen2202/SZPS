package com.szps.web.domain.dev.fixedasset;

import com.szps.common.core.domain.BaseEntity;

public class Car extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	Long deptid;
	String deptname;
	String deptname2;//所属部门
	String licenseaccount;
	String carnumber;
	String carname;
	String dtype;
	String manufacturer;
	String measurement;
	String purchasedate;
	String registrationdate;
	String mileage;
	String displacement;
	String fueltypes;
	String carcolour;
	String dstatus;
	String effectivedeadline;
	String bookquantity;
	String realquantity;
	String originalvalue;

	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
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

	public String getDeptname2() {
		return deptname2;
	}

	public void setDeptname2(String deptname2) {
		this.deptname2 = deptname2;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getLicenseaccount() {
		return licenseaccount;
	}

	public void setLicenseaccount(String licenseaccount) {
		this.licenseaccount = licenseaccount;
	}

	public String getCarnumber() {
		return carnumber;
	}

	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
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

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}

	public String getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(String registrationdate) {
		this.registrationdate = registrationdate;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getFueltypes() {
		return fueltypes;
	}

	public void setFueltypes(String fueltypes) {
		this.fueltypes = fueltypes;
	}

	public String getCarcolour() {
		return carcolour;
	}

	public void setCarcolour(String carcolour) {
		this.carcolour = carcolour;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public String getEffectivedeadline() {
		return effectivedeadline;
	}

	public void setEffectivedeadline(String effectivedeadline) {
		this.effectivedeadline = effectivedeadline;
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

	public String getOriginalvalue() {
		return originalvalue;
	}

	public void setOriginalvalue(String originalvalue) {
		this.originalvalue = originalvalue;
	}

}

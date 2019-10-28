package com.szps.web.domain.dev.fixedasset;

import com.szps.common.core.domain.BaseEntity;

public class Plant extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	Long deptid;
	String deptname;
	String dlocation;
	String assetname;
	String height;
	String dbh;
	String crowndiameter;
	String measurement;
	String realquantity;
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

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getDbh() {
		return dbh;
	}

	public void setDbh(String dbh) {
		this.dbh = dbh;
	}

	public String getCrowndiameter() {
		return crowndiameter;
	}

	public void setCrowndiameter(String crowndiameter) {
		this.crowndiameter = crowndiameter;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
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

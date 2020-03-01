package com.szps.web.domain.dev;

import java.util.Date;
import java.util.List;

import com.szps.common.core.domain.BaseEntity;

public class DevInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	String dnumber;
	String dname;
	String dbrand;
	String dtype;
	String dalias;
	String dmodel;
	Date buytime;
	Date beganusetime;
	String installationsite;
	String dstatus;
	String picurl;
	Long deptid;
	Long supplierid;
	String supplierStr;
	String buytimeStr;
	String beganusetimeStr;
	List<TechInfo> techInfos;

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

	public String getDnumber() {
		return dnumber;
	}

	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}

	public String getDbrand() {
		return dbrand;
	}

	public void setDbrand(String dbrand) {
		this.dbrand = dbrand;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getDalias() {
		return dalias;
	}

	public void setDalias(String dalias) {
		this.dalias = dalias;
	}

	public String getDmodel() {
		return dmodel;
	}

	public void setDmodel(String dmodel) {
		this.dmodel = dmodel;
	}

	public Date getBuytime() {
		return buytime;
	}

	public void setBuytime(Date buytime) {
		this.buytime = buytime;
	}

	public Date getBeganusetime() {
		return beganusetime;
	}

	public void setBeganusetime(Date beganusetime) {
		this.beganusetime = beganusetime;
	}

	public String getInstallationsite() {
		return installationsite;
	}

	public void setInstallationsite(String installationsite) {
		this.installationsite = installationsite;
	}

	public String getDstatus() {
		return dstatus;
	}

	public void setDstatus(String dstatus) {
		this.dstatus = dstatus;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	

	public Long getDeptid() {
		return deptid;
	}

	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public Long getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(Long supplierid) {
		this.supplierid = supplierid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSupplierStr() {
		return supplierStr;
	}

	public void setSupplierStr(String supplierStr) {
		this.supplierStr = supplierStr;
	}

	public String getBuytimeStr() {
		return buytimeStr;
	}

	public void setBuytimeStr(String buytimeStr) {
		this.buytimeStr = buytimeStr;
	}

	public String getBeganusetimeStr() {
		return beganusetimeStr;
	}

	public void setBeganusetimeStr(String beganusetimeStr) {
		this.beganusetimeStr = beganusetimeStr;
	}

	public List<TechInfo> getTechInfos() {
		return techInfos;
	}

	public void setTechInfos(List<TechInfo> techInfos) {
		this.techInfos = techInfos;
	}



}

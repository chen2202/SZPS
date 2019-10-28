package com.szps.web.domain.dev.fixedasset;

import java.util.Date;

import com.szps.common.core.domain.BaseEntity;

public class Structure extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	Long deptid;
	String deptname;
	String dlocation;
	String assetname;
	String structure;
	Date builttime;
	String dlength;
	String dwidth;
	String dhigh;
	String howmany;
	String dvolume;
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

	public String getAssetname() {
		return assetname;
	}

	public void setAssetname(String assetname) {
		this.assetname = assetname;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Date getBuilttime() {
		return builttime;
	}

	public void setBuilttime(Date builttime) {
		this.builttime = builttime;
	}

	public String getDlength() {
		return dlength;
	}

	public void setDlength(String dlength) {
		this.dlength = dlength;
	}

	public String getDwidth() {
		return dwidth;
	}

	public void setDwidth(String dwidth) {
		this.dwidth = dwidth;
	}

	public String getDhigh() {
		return dhigh;
	}

	public void setDhigh(String dhigh) {
		this.dhigh = dhigh;
	}

	public String getHowmany() {
		return howmany;
	}

	public void setHowmany(String howmany) {
		this.howmany = howmany;
	}

	public String getDvolume() {
		return dvolume;
	}

	public void setDvolume(String dvolume) {
		this.dvolume = dvolume;
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

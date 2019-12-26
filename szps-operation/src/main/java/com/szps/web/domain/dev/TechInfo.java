package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class TechInfo extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long id;
	String tname;
	String tversion;
	String url;
	Long devid;
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

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTversion() {
		return tversion;
	}

	public void setTversion(String tversion) {
		this.tversion = tversion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getDevid() {
		return devid;
	}

	public void setDevid(Long devid) {
		this.devid = devid;
	}

}

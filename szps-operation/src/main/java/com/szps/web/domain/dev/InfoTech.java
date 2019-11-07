package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class InfoTech extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2151640322585344725L;
	Long devid;
	String techid;
	public Long getDevid() {
		return devid;
	}
	public void setDevid(Long devid) {
		this.devid = devid;
	}
	public String getTechid() {
		return techid;
	}
	public void setTechid(String techid) {
		this.techid = techid;
	}
	

}

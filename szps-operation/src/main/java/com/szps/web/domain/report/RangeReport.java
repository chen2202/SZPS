package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class RangeReport extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3619465982860345204L;
	private Long deptId;
	private String deptName;
	private String startDate;
	private String endDate;
	
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}

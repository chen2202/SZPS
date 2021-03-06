package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class OpLog extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4503872105149032924L;
	private Long id;
	private String poolId;
	private Long deptId;
	private String deptName;
	private String logDate;// 日期
	private String weather;// 天气
	private String waterStartTime;
	private String waterEndTime;
	private String waterUsage;
	private String dryHour;
	private String dryMin;
	private String logRemarks;
	private String logRecorder;
	private String delFlag;

	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public String getPoolId() {
		return poolId;
	}

	public void setPoolId(String poolId) {
		this.poolId = poolId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getWaterStartTime() {
		return waterStartTime;
	}

	public void setWaterStartTime(String waterStartTime) {
		this.waterStartTime = waterStartTime;
	}

	public String getWaterEndTime() {
		return waterEndTime;
	}

	public void setWaterEndTime(String waterEndTime) {
		this.waterEndTime = waterEndTime;
	}

	public String getWaterUsage() {
		return waterUsage;
	}

	public void setWaterUsage(String waterUsage) {
		this.waterUsage = waterUsage;
	}

	public String getDryHour() {
		return dryHour;
	}

	public void setDryHour(String dryHour) {
		this.dryHour = dryHour;
	}

	public String getDryMin() {
		return dryMin;
	}

	public void setDryMin(String dryMin) {
		this.dryMin = dryMin;
	}

	public String getLogRemarks() {
		return logRemarks;
	}

	public void setLogRemarks(String logRemarks) {
		this.logRemarks = logRemarks;
	}

	public String getLogRecorder() {
		return logRecorder;
	}

	public void setLogRecorder(String logRecorder) {
		this.logRecorder = logRecorder;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}

package com.szps.web.domain.dev.pumpstation;

import com.szps.common.core.domain.BaseEntity;

public class PumpstationMaintenance extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -832850094101279834L;
	Long id;
	String optime;// 时间
	String devname;// 设备名称
	String optype;// 类型
	String opdetails;// 内容
	String replaceparts;// 更换零配件
	String operator;// 操作人员
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
	public String getOptime() {
		return optime;
	}
	public void setOptime(String optime) {
		this.optime = optime;
	}
	public String getDevname() {
		return devname;
	}
	public void setDevname(String devname) {
		this.devname = devname;
	}
	public String getOptype() {
		return optype;
	}
	public void setOptype(String optype) {
		this.optype = optype;
	}
	public String getOpdetails() {
		return opdetails;
	}
	public void setOpdetails(String opdetails) {
		this.opdetails = opdetails;
	}
	public String getReplaceparts() {
		return replaceparts;
	}
	public void setReplaceparts(String replaceparts) {
		this.replaceparts = replaceparts;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}

}

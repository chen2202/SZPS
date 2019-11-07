package com.szps.web.domain.dev;

import java.util.Date;

import com.szps.common.core.domain.BaseEntity;

public class MaintenanceRecord extends BaseEntity {

	private static final long serialVersionUID = 7659629254398683319L;
	private Long id;
	private Long devid;
	private String tasknumber;
	private String taskstatus;
	private Date duetime;
	private String responsibleperson;
	private Date taskcreatetime;
	private String creator;
	private String mrank;
	private String mpart;
	private String mspec;
	private String usetime;
	private String operator;
	private String mtype;
	private Long deptid;
	private String devname;
	private String deptname;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDevid() {
		return devid;
	}
	public void setDevid(Long devid) {
		this.devid = devid;
	}
	public String getTasknumber() {
		return tasknumber;
	}
	public void setTasknumber(String tasknumber) {
		this.tasknumber = tasknumber;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public Date getDuetime() {
		return duetime;
	}
	public void setDuetime(Date duetime) {
		this.duetime = duetime;
	}
	public String getResponsibleperson() {
		return responsibleperson;
	}
	public void setResponsibleperson(String responsibleperson) {
		this.responsibleperson = responsibleperson;
	}
	public Date getTaskcreatetime() {
		return taskcreatetime;
	}
	public void setTaskcreatetime(Date taskcreatetime) {
		this.taskcreatetime = taskcreatetime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getMrank() {
		return mrank;
	}
	public void setMrank(String mrank) {
		this.mrank = mrank;
	}
	public String getMpart() {
		return mpart;
	}
	public void setMpart(String mpart) {
		this.mpart = mpart;
	}
	public String getMspec() {
		return mspec;
	}
	public void setMspec(String mspec) {
		this.mspec = mspec;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}
	public String getDevname() {
		return devname;
	}
	public void setDevname(String devname) {
		this.devname = devname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}

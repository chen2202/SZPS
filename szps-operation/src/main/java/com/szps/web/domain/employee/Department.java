package com.szps.web.domain.employee;

public class Department {
	private String department_id; //部门代码
	private String department_name; //部门名称
	private String company_id; //公司/水厂代码
	private String parent_department_id; //上级部门代码
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getParent_department_id() {
		return parent_department_id;
	}
	public void setParent_department_id(String parent_department_id) {
		this.parent_department_id = parent_department_id;
	}
}

package com.szps.web.domain.employee;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.szps.common.annotation.Excel;

public class Department {
	@Excel(name = "部门代码")
	private String department_id; //部门代码
	@Excel(name = "部门名称")
	private String department_name; //部门名称
	@Excel(name = "公司/水厂代码")
	private String company_id; //公司/水厂代码
	@Excel(name = "上级部门代码")
	private String parent_department_id; //上级部门代码
	
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("department_id", getDepartment_id())
            .append("department_name", getDepartment_name())
            .append("company_id", getCompany_id())
            .append("parent_department_id", getParent_department_id())
            .toString();
    }
	
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

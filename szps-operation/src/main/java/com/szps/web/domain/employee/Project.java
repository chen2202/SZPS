package com.szps.web.domain.employee;

/**
 * EMPLOYEE_T_CP_PROJECT表的实体类
 * @author zxc
 *
 */
public class Project {
	private String company_id; //运营单位代码
	private String pipe_project; //运营项目
	private String project_scope; //项目范围
	private String pipe_stop_time; //运营截止时间
	private String project_company_name; //项目公司名称
	private String project_company_address; //项目公司地址
	private int project_people; //项目人数
	private String project_header; //项目负责人
	private long telephone; //联系电话
	
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getPipe_project() {
		return pipe_project;
	}
	public void setPipe_project(String pipe_project) {
		this.pipe_project = pipe_project;
	}
	public String getProject_scope() {
		return project_scope;
	}
	public void setProject_scope(String project_scope) {
		this.project_scope = project_scope;
	}
	public String getPipe_stop_time() {
		return pipe_stop_time;
	}
	public void setPipe_stop_time(String pipe_stop_time) {
		this.pipe_stop_time = pipe_stop_time;
	}
	public String getProject_company_name() {
		return project_company_name;
	}
	public void setProject_company_name(String project_company_name) {
		this.project_company_name = project_company_name;
	}
	public String getProject_company_address() {
		return project_company_address;
	}
	public void setProject_company_address(String project_company_address) {
		this.project_company_address = project_company_address;
	}
	public int getProject_people() {
		return project_people;
	}
	public void setProject_people(int project_people) {
		this.project_people = project_people;
	}
	public String getProject_header() {
		return project_header;
	}
	public void setProject_header(String project_header) {
		this.project_header = project_header;
	}
	public long getTelephone() {
		return telephone;
	}
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
}

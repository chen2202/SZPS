package com.szps.web.domain.employee;

/**
 * EMPLOYEE_T_COMPANY表的实体类
 * @author zxc
 *
 */
public class Company {
	private String company_id; //运营单位代码
	private String company_name; //运营单位名
	private String address; //运营单位地址
	private String representative; //法定代表人
	private String business_scope; //经营范围
	private int registered_capital; //注册资本
	private String qualification; //企业资质
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRepresentative() {
		return representative;
	}
	public void setRepresentative(String representative) {
		this.representative = representative;
	}
	public String getBusiness_scope() {
		return business_scope;
	}
	public void setBusiness_scope(String business_scope) {
		this.business_scope = business_scope;
	}
	public int getRegistered_capital() {
		return registered_capital;
	}
	public void setRegistered_capital(int registered_capital) {
		this.registered_capital = registered_capital;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
}

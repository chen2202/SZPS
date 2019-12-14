package com.szps.web.domain.employee;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.szps.common.annotation.Excel;

/**
 * EMPLOYEE_T_COMPANY表的实体类
 * @author zxc
 *
 */
public class Company {
	@Excel(name = "公司编号")
	private String company_id; //运营单位代码
	@Excel(name = "公司名称")
	private String company_name; //运营单位名
	@Excel(name = "地址")
	private String address; //运营单位地址
	@Excel(name = "法定代表人")
	private String representative; //法定代表人
	@Excel(name = "经营范围")
	private String business_scope; //经营范围
	@Excel(name = "注册资本")
	private int registered_capital; //注册资本
	@Excel(name = "企业资质")
	private String qualification; //企业资质
	
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("company_id", getCompany_id())
            .append("company_name", getCompany_name())
            .append("address", getAddress())
            .append("representative", getRepresentative())
            .append("business_scope", getBusiness_scope())
            .append("registered_capital", getRegistered_capital())
            .append("qualification", getQualification())
            .toString();
    }
	
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

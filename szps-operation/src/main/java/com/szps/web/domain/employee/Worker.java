package com.szps.web.domain.employee;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.szps.common.annotation.Excel;

/**
 * 数据库表EMPLOYEE_T_WORKER和EMPLOYEE_T_DEPARTMENT组成的Worker实体类
 * @author zxc
 */
public class Worker {
	@Excel(name = "身份证号")
	private String idCard; //身份证号
	@Excel(name = "姓名")
	private String name; //名字
	@Excel(name = "性别")
	private String sex; //性别
	@Excel(name = "参加工作时间")
	private String join_work_time; //参加工作时间
	@Excel(name = "受教育程度")
	private String education; //受教育程度
	@Excel(name = "职称")
	private String title; //职称
	@Excel(name = "专业")
	private String profession; //专业
	@Excel(name = "所属企业名称")
	private String company_name; //所属企业名称
	@Excel(name = "职务")
	private String position; //职务
	@Excel(name = "所属部门")
	private String department_name; //部门名称
	@Excel(name = "资质证书")
	private String qualification_certificate; //资质证书
	
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("idCard", getIdCard())
            .append("name", getName())
            .append("sex", getSex())
            .append("join_work_time", getJoin_work_time())
            .append("education", getEducation())
            .append("title", getTitle())
            .append("profession", getProfession())
            .append("company_name", getCompany_name())
            .append("position", getPosition())
            .append("department_name", getDepartment_name())
            .append("qualification_certificate", getQualification_certificate())
            .toString();
    }
	
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getJoin_work_time() {
		return join_work_time;
	}
	public void setJoin_work_time(String join_work_time) {
		this.join_work_time = join_work_time;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getQualification_certificate() {
		return qualification_certificate;
	}
	public void setQualification_certificate(String qualification_certificate) {
		this.qualification_certificate = qualification_certificate;
	}
}

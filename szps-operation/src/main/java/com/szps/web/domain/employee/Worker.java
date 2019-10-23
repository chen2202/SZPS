package com.szps.web.domain.employee;

/**
 * 数据库表EMPLOYEE_T_WORKER和EMPLOYEE_T_DEPARTMENT组成的Worker实体类
 * @author zxc
 */
public class Worker {
	private String idCard; //身份证号
	private String name; //名字
	private String sex; //性别
	private String join_work_time; //参加工作时间
	private String education; //受教育程度
	private String title; //职称
	private String profession; //专业
	private String company_name; //所属企业名称
	private String position; //职务
	private String department_name; //部门名称
	private String qualification_certificate; //资质证书
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

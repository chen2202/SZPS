package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

/**
 * 管网养护数据表
 * 
 * @author Jack
 *
 */
public class NetworkMaintenance extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2965726593387186442L;
	String workid;// 作业编号
	String s_point;// 起点管点编号
	String e_point;// 终点管点编号
	String maintain_date;// 管养日期，填写年、月、日之间用“－”连接，如：2010-03-10
	String weather;// 天气,1-晴； 2-阴； 3-小雨；4-大雨
	String maintain_dept;// 管养单位，参见地下管线相关单位代码表
	String maintain_pe;// 管养人
	String maintain_type;// 管养类型，1-巡查；2-清疏；3-修复
	String operation_status;// 运行状况，例如运行良好，高水位运行，运行水位高流动缓慢等
	String functional_defect;// 功能性缺陷，0-无缺陷；1-沉积；2-结垢；3-障碍物；4-残墙、坝根；5-树根；6-浮渣；7-封堵；8-井盖丢失；9-其他
	String structural_defect;// 结构性缺陷，0-无缺陷；1-破裂；2-变形；3-腐蚀；4-错口；5-起伏；6-脱节；7-接口材料脱落；8-支管暗接；9-异物穿入；10-渗漏；11-其他
	String psize;// 管径或断面尺寸，单位 mm
	String maintain_method;// 管养方法,详细描叙针对管网问题所采取的方法
	Double maintain_length;// 管养长度，单位 m
	Double maintain_amount;// 清淤量，单位：m3
	Double maintain_cost;// 工程费用，单位：元
	String note;// 备注
	String attachmenturl;// 备注

	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public String getAttachmenturl() {
		return attachmenturl;
	}

	public void setAttachmenturl(String attachmenturl) {
		this.attachmenturl = attachmenturl;
	}

	public String getWorkid() {
		return workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	public String getS_point() {
		return s_point;
	}

	public void setS_point(String s_point) {
		this.s_point = s_point;
	}

	public String getE_point() {
		return e_point;
	}

	public void setE_point(String e_point) {
		this.e_point = e_point;
	}

	public String getMaintain_date() {
		return maintain_date;
	}

	public void setMaintain_date(String maintain_date) {
		this.maintain_date = maintain_date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getMaintain_dept() {
		return maintain_dept;
	}

	public void setMaintain_dept(String maintain_dept) {
		this.maintain_dept = maintain_dept;
	}

	public String getMaintain_pe() {
		return maintain_pe;
	}

	public void setMaintain_pe(String maintain_pe) {
		this.maintain_pe = maintain_pe;
	}

	public String getMaintain_type() {
		return maintain_type;
	}

	public void setMaintain_type(String maintain_type) {
		this.maintain_type = maintain_type;
	}

	public String getOperation_status() {
		return operation_status;
	}

	public void setOperation_status(String operation_status) {
		this.operation_status = operation_status;
	}

	public String getFunctional_defect() {
		return functional_defect;
	}

	public void setFunctional_defect(String functional_defect) {
		this.functional_defect = functional_defect;
	}

	public String getStructural_defect() {
		return structural_defect;
	}

	public void setStructural_defect(String structural_defect) {
		this.structural_defect = structural_defect;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public String getMaintain_method() {
		return maintain_method;
	}

	public void setMaintain_method(String maintain_method) {
		this.maintain_method = maintain_method;
	}

	public Double getMaintain_length() {
		return maintain_length;
	}

	public void setMaintain_length(Double maintain_length) {
		this.maintain_length = maintain_length;
	}

	public Double getMaintain_amount() {
		return maintain_amount;
	}

	public void setMaintain_amount(Double maintain_amount) {
		this.maintain_amount = maintain_amount;
	}

	public Double getMaintain_cost() {
		return maintain_cost;
	}

	public void setMaintain_cost(Double maintain_cost) {
		this.maintain_cost = maintain_cost;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}

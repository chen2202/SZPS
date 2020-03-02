package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

/**
 * 内窥检测数据表
 * 
 * @author Jack
 *
 */
public class EndoscopicDetection extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2965726593387186442L;
	String workid;// 作业编号
	String exp_no;// 检测管渠编号
	String s_point;// 检测起点管线点号
	String e_point;// 检测终点管线点号
	String sampletime;// 检测时间，填写年、月、日、时、分之间用“－”连接，如：2010-03-10-10-10
	String detectdep;// 检测单位
	String detect_person;// 检测人员
	String detect_method;// 检测方法，1-CCTV；2-声纳；3-QV；4-其他
	Integer detect_dir;// 检测方向，1-与流向一致；2-与流向不一致
	String pipe_block;// 封堵情况
	String func_defect;// 功能性缺陷， 0-无缺陷；1-沉积；2-结垢；3-障碍物；4-残墙、坝根；5-树根；6-浮渣；7-封堵；8-其他
	Integer func_class;// 功能性缺陷等级，按现行行业标准《城镇排水管道检测与评估技术规程》CJJ 181 的有关规定填
	String struct_defect;// 结构性缺陷， 0-无缺陷；1-破裂；2-变形；3-腐蚀；4-错口；5-起伏；6-脱节；7-接口材料脱落；8-支管暗接；9-异物穿入；10-渗漏；11-其他
	Integer struct_class;// 结构性缺陷等级，按现行行业标准《城镇排水管道检测与评估技术规程》CJJ 181 的有关规定填写
	Double repair_index;// 修复指数 RI，按现行行业标准《城镇排水管道检测与评估技术规程》CJJ 181 的有关规定填写
	Double maintain_index;// 养护指数 MI, 按现行行业标准《城镇排水管道检测与评估技术规程》CJJ 181 的有关规定填写
	String problem;// 缺陷描述
	String video_filename;// 影像文件名，命名规则为起点管点编号-终点管点编号-检测日期
	String report_dept;// 数据填报单位
	String reportdate;// 填报日期，填写年、月、日、时、分之间用“－”连接，如：2010-03-10-10-10
	String note;// 备注
	String attachmenturl;// 备注
	Long dept_id;//CREATE_BY 部门ID
	String district;// 备注
	String river;// 备注
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public String getWorkid() {
		return workid;
	}
	public void setWorkid(String workid) {
		this.workid = workid;
	}
	public String getExp_no() {
		return exp_no;
	}
	public void setExp_no(String exp_no) {
		this.exp_no = exp_no;
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
	public String getSampletime() {
		return sampletime;
	}
	public void setSampletime(String sampletime) {
		this.sampletime = sampletime;
	}
	public String getDetectdep() {
		return detectdep;
	}
	public void setDetectdep(String detectdep) {
		this.detectdep = detectdep;
	}
	public String getDetect_person() {
		return detect_person;
	}
	public void setDetect_person(String detect_person) {
		this.detect_person = detect_person;
	}
	public String getDetect_method() {
		return detect_method;
	}
	public void setDetect_method(String detect_method) {
		this.detect_method = detect_method;
	}
	public Integer getDetect_dir() {
		return detect_dir;
	}
	public void setDetect_dir(Integer detect_dir) {
		this.detect_dir = detect_dir;
	}
	public String getPipe_block() {
		return pipe_block;
	}
	public void setPipe_block(String pipe_block) {
		this.pipe_block = pipe_block;
	}
	public String getFunc_defect() {
		return func_defect;
	}
	public void setFunc_defect(String func_defect) {
		this.func_defect = func_defect;
	}
	public Integer getFunc_class() {
		return func_class;
	}
	public void setFunc_class(Integer func_class) {
		this.func_class = func_class;
	}
	public String getStruct_defect() {
		return struct_defect;
	}
	public void setStruct_defect(String struct_defect) {
		this.struct_defect = struct_defect;
	}
	public Integer getStruct_class() {
		return struct_class;
	}
	public void setStruct_class(Integer struct_class) {
		this.struct_class = struct_class;
	}
	public Double getRepair_index() {
		return repair_index;
	}
	public void setRepair_index(Double repair_index) {
		this.repair_index = repair_index;
	}
	public Double getMaintain_index() {
		return maintain_index;
	}
	public void setMaintain_index(Double maintain_index) {
		this.maintain_index = maintain_index;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getVideo_filename() {
		return video_filename;
	}
	public void setVideo_filename(String video_filename) {
		this.video_filename = video_filename;
	}
	public String getReport_dept() {
		return report_dept;
	}
	public void setReport_dept(String report_dept) {
		this.report_dept = report_dept;
	}
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getAttachmenturl() {
		return attachmenturl;
	}
	public void setAttachmenturl(String attachmenturl) {
		this.attachmenturl = attachmenturl;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRiver() {
		return river;
	}

	public void setRiver(String river) {
		this.river = river;
	}

}

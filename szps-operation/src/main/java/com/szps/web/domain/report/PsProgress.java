package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class PsProgress extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -784717877188568306L;
	Long id;
	Long areaid;// 所属区id
	String areaname;// 所属区
	String deadline;//截止时间
	String recruitmentmethod;//专营单位招采方式
	String signingdate;//专营协议签订时间
	String planfinishdate;//首次进场（检测、测绘、清疏、修复）计划完成时间
	String rq_completed_num;//住宅小区-完成摸排数量（个）
	String rq_entrust;//住宅小区-委托管理协议签（份）
	String rq_actual;//住宅小区-实际接收管理小区数（个）
	String rq_reception_rate;//住宅小区-小区接收率（%）
	String rq_network_length;//住宅小区-接收管网长度（km）
	String rq_detection_length;//住宅小区-完成检测长度（km）
	String rq_mapping_length;//住宅小区-完成测绘长度（km）
	String rq_dredging_capacity;//住宅小区-完成清淤量（m3）
	String rq_renovation;//住宅小区-完成修复改造量（km）
	String iq_completed_num;//工业小区-完成摸排数量（个）
	String iq_entrust;//工业小区-委托管理协议签（份）
	String iq_actual;//工业小区-实际接收管理小区数（个）
	String iq_reception_rate;//工业小区-小区接收率（%）
	String iq_network_length;//工业小区-接收管网长度（km）
	String iq_detection_length;//工业小区-完成检测长度（km）
	String iq_mapping_length;//工业小区-完成测绘长度（km）
	String iq_dredging_capacity;//工业小区-完成清淤量（m3）
	String iq_renovation;//工业小区-完成修复改造量（km）
	String eq_completed_num;//商业小区-完成摸排数量（个）
	String eq_entrust;//商业小区-委托管理协议签（份）
	String eq_actual;//商业小区-实际接收管理小区数（个）
	String eq_reception_rate;//商业小区-小区接收率（%）
	String eq_network_length;//商业小区-接收管网长度（km）
	String eq_detection_length;//商业小区-完成检测长度（km）
	String eq_mapping_length;//商业小区-完成测绘长度（km）
	String eq_dredging_capacity;//商业小区-完成清淤量（m3）
	String eq_renovation;//商业小区-完成修复改造量（km）
	String erq_completed_num;//商住两用-完成摸排数量（个）
	String erq_entrust;//商住两用-委托管理协议签（份）
	String erq_actual;//商住两用-实际接收管理小区数（个）
	String erq_reception_rate;//商住两用-小区接收率（%）
	String erq_network_length;//商住两用-接收管网长度（km）
	String erq_detection_length;//商住两用-完成检测长度（km）
	String erq_mapping_length;//商住两用-完成测绘长度（km）
	String erq_dredging_capacity;//商住两用-完成清淤量（m3）
	String erq_renovation;//商住两用-完成修复改造量（km）
	String pq_completed_num;//公共机构-完成摸排数量（个）
	String pq_entrust;//公共机构-委托管理协议签（份）
	String pq_actual;//公共机构-实际接收管理小区数（个）
	String pq_reception_rate;//公共机构-小区接收率（%）
	String pq_network_length;//公共机构-接收管网长度（km）
	String pq_detection_length;//公共机构-完成检测长度（km）
	String pq_mapping_length;//公共机构-完成测绘长度（km）
	String pq_dredging_capacity;//公共机构-完成清淤量（m3）
	String pq_renovation;//公共机构-完成修复改造量（km）
	String vq_completed_num;//城中村-完成摸排数量（个）
	String vq_entrust;//城中村-委托管理协议签（份）
	String vq_actual;//城中村-实际接收管理小区数（个）
	String vq_reception_rate;//城中村-小区接收率（%）
	String vq_network_length;//城中村-接收管网长度（km）
	String vq_detection_length;//城中村-完成检测长度（km）
	String vq_mapping_length;//城中村-完成测绘长度（km）
	String vq_dredging_capacity;//城中村-完成清淤量（m3）
	String vq_renovation;//城中村-完成修复改造量（km）
	String tq_completed_num;//总计-完成摸排数量（个）
	String tq_entrust;//总计-委托管理协议签（份）
	String tq_actual;//总计-实际接收管理小区数（个）
	String tq_reception_rate;//总计-小区接收率（%）
	String tq_network_length;//总计-接收管网长度（km）
	String tq_detection_length;//总计-完成检测长度（km）
	String tq_mapping_length;//总计-完成测绘长度（km）
	String tq_dredging_capacity;//总计-完成清淤量（m3）
	String tq_renovation;//总计-完成修复改造量（km）
	Long dept_id;//CREATE_BY 部门ID
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAreaid() {
		return areaid;
	}
	public void setAreaid(Long areaid) {
		this.areaid = areaid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getRecruitmentmethod() {
		return recruitmentmethod;
	}
	public void setRecruitmentmethod(String recruitmentmethod) {
		this.recruitmentmethod = recruitmentmethod;
	}
	public String getSigningdate() {
		return signingdate;
	}
	public void setSigningdate(String signingdate) {
		this.signingdate = signingdate;
	}
	public String getPlanfinishdate() {
		return planfinishdate;
	}
	public void setPlanfinishdate(String planfinishdate) {
		this.planfinishdate = planfinishdate;
	}
	public String getRq_completed_num() {
		return rq_completed_num;
	}
	public void setRq_completed_num(String rq_completed_num) {
		this.rq_completed_num = rq_completed_num;
	}
	public String getRq_entrust() {
		return rq_entrust;
	}
	public void setRq_entrust(String rq_entrust) {
		this.rq_entrust = rq_entrust;
	}
	public String getRq_actual() {
		return rq_actual;
	}
	public void setRq_actual(String rq_actual) {
		this.rq_actual = rq_actual;
	}
	public String getRq_reception_rate() {
		return rq_reception_rate;
	}
	public void setRq_reception_rate(String rq_reception_rate) {
		this.rq_reception_rate = rq_reception_rate;
	}
	public String getRq_network_length() {
		return rq_network_length;
	}
	public void setRq_network_length(String rq_network_length) {
		this.rq_network_length = rq_network_length;
	}
	public String getRq_detection_length() {
		return rq_detection_length;
	}
	public void setRq_detection_length(String rq_detection_length) {
		this.rq_detection_length = rq_detection_length;
	}
	public String getRq_mapping_length() {
		return rq_mapping_length;
	}
	public void setRq_mapping_length(String rq_mapping_length) {
		this.rq_mapping_length = rq_mapping_length;
	}
	public String getRq_dredging_capacity() {
		return rq_dredging_capacity;
	}
	public void setRq_dredging_capacity(String rq_dredging_capacity) {
		this.rq_dredging_capacity = rq_dredging_capacity;
	}
	public String getRq_renovation() {
		return rq_renovation;
	}
	public void setRq_renovation(String rq_renovation) {
		this.rq_renovation = rq_renovation;
	}
	public String getIq_completed_num() {
		return iq_completed_num;
	}
	public void setIq_completed_num(String iq_completed_num) {
		this.iq_completed_num = iq_completed_num;
	}
	public String getIq_entrust() {
		return iq_entrust;
	}
	public void setIq_entrust(String iq_entrust) {
		this.iq_entrust = iq_entrust;
	}
	public String getIq_actual() {
		return iq_actual;
	}
	public void setIq_actual(String iq_actual) {
		this.iq_actual = iq_actual;
	}
	public String getIq_reception_rate() {
		return iq_reception_rate;
	}
	public void setIq_reception_rate(String iq_reception_rate) {
		this.iq_reception_rate = iq_reception_rate;
	}
	public String getIq_network_length() {
		return iq_network_length;
	}
	public void setIq_network_length(String iq_network_length) {
		this.iq_network_length = iq_network_length;
	}
	public String getIq_detection_length() {
		return iq_detection_length;
	}
	public void setIq_detection_length(String iq_detection_length) {
		this.iq_detection_length = iq_detection_length;
	}
	public String getIq_mapping_length() {
		return iq_mapping_length;
	}
	public void setIq_mapping_length(String iq_mapping_length) {
		this.iq_mapping_length = iq_mapping_length;
	}
	public String getIq_dredging_capacity() {
		return iq_dredging_capacity;
	}
	public void setIq_dredging_capacity(String iq_dredging_capacity) {
		this.iq_dredging_capacity = iq_dredging_capacity;
	}
	public String getIq_renovation() {
		return iq_renovation;
	}
	public void setIq_renovation(String iq_renovation) {
		this.iq_renovation = iq_renovation;
	}
	public String getEq_completed_num() {
		return eq_completed_num;
	}
	public void setEq_completed_num(String eq_completed_num) {
		this.eq_completed_num = eq_completed_num;
	}
	public String getEq_entrust() {
		return eq_entrust;
	}
	public void setEq_entrust(String eq_entrust) {
		this.eq_entrust = eq_entrust;
	}
	public String getEq_actual() {
		return eq_actual;
	}
	public void setEq_actual(String eq_actual) {
		this.eq_actual = eq_actual;
	}
	public String getEq_reception_rate() {
		return eq_reception_rate;
	}
	public void setEq_reception_rate(String eq_reception_rate) {
		this.eq_reception_rate = eq_reception_rate;
	}
	public String getEq_network_length() {
		return eq_network_length;
	}
	public void setEq_network_length(String eq_network_length) {
		this.eq_network_length = eq_network_length;
	}
	public String getEq_detection_length() {
		return eq_detection_length;
	}
	public void setEq_detection_length(String eq_detection_length) {
		this.eq_detection_length = eq_detection_length;
	}
	public String getEq_mapping_length() {
		return eq_mapping_length;
	}
	public void setEq_mapping_length(String eq_mapping_length) {
		this.eq_mapping_length = eq_mapping_length;
	}
	public String getEq_dredging_capacity() {
		return eq_dredging_capacity;
	}
	public void setEq_dredging_capacity(String eq_dredging_capacity) {
		this.eq_dredging_capacity = eq_dredging_capacity;
	}
	public String getEq_renovation() {
		return eq_renovation;
	}
	public void setEq_renovation(String eq_renovation) {
		this.eq_renovation = eq_renovation;
	}
	public String getErq_completed_num() {
		return erq_completed_num;
	}
	public void setErq_completed_num(String erq_completed_num) {
		this.erq_completed_num = erq_completed_num;
	}
	public String getErq_entrust() {
		return erq_entrust;
	}
	public void setErq_entrust(String erq_entrust) {
		this.erq_entrust = erq_entrust;
	}
	public String getErq_actual() {
		return erq_actual;
	}
	public void setErq_actual(String erq_actual) {
		this.erq_actual = erq_actual;
	}
	public String getErq_reception_rate() {
		return erq_reception_rate;
	}
	public void setErq_reception_rate(String erq_reception_rate) {
		this.erq_reception_rate = erq_reception_rate;
	}
	public String getErq_network_length() {
		return erq_network_length;
	}
	public void setErq_network_length(String erq_network_length) {
		this.erq_network_length = erq_network_length;
	}
	public String getErq_detection_length() {
		return erq_detection_length;
	}
	public void setErq_detection_length(String erq_detection_length) {
		this.erq_detection_length = erq_detection_length;
	}
	public String getErq_mapping_length() {
		return erq_mapping_length;
	}
	public void setErq_mapping_length(String erq_mapping_length) {
		this.erq_mapping_length = erq_mapping_length;
	}
	public String getErq_dredging_capacity() {
		return erq_dredging_capacity;
	}
	public void setErq_dredging_capacity(String erq_dredging_capacity) {
		this.erq_dredging_capacity = erq_dredging_capacity;
	}
	public String getErq_renovation() {
		return erq_renovation;
	}
	public void setErq_renovation(String erq_renovation) {
		this.erq_renovation = erq_renovation;
	}
	public String getPq_completed_num() {
		return pq_completed_num;
	}
	public void setPq_completed_num(String pq_completed_num) {
		this.pq_completed_num = pq_completed_num;
	}
	public String getPq_entrust() {
		return pq_entrust;
	}
	public void setPq_entrust(String pq_entrust) {
		this.pq_entrust = pq_entrust;
	}
	public String getPq_actual() {
		return pq_actual;
	}
	public void setPq_actual(String pq_actual) {
		this.pq_actual = pq_actual;
	}
	public String getPq_reception_rate() {
		return pq_reception_rate;
	}
	public void setPq_reception_rate(String pq_reception_rate) {
		this.pq_reception_rate = pq_reception_rate;
	}
	public String getPq_network_length() {
		return pq_network_length;
	}
	public void setPq_network_length(String pq_network_length) {
		this.pq_network_length = pq_network_length;
	}
	public String getPq_detection_length() {
		return pq_detection_length;
	}
	public void setPq_detection_length(String pq_detection_length) {
		this.pq_detection_length = pq_detection_length;
	}
	public String getPq_mapping_length() {
		return pq_mapping_length;
	}
	public void setPq_mapping_length(String pq_mapping_length) {
		this.pq_mapping_length = pq_mapping_length;
	}
	public String getPq_dredging_capacity() {
		return pq_dredging_capacity;
	}
	public void setPq_dredging_capacity(String pq_dredging_capacity) {
		this.pq_dredging_capacity = pq_dredging_capacity;
	}
	public String getPq_renovation() {
		return pq_renovation;
	}
	public void setPq_renovation(String pq_renovation) {
		this.pq_renovation = pq_renovation;
	}
	public String getVq_completed_num() {
		return vq_completed_num;
	}
	public void setVq_completed_num(String vq_completed_num) {
		this.vq_completed_num = vq_completed_num;
	}
	public String getVq_entrust() {
		return vq_entrust;
	}
	public void setVq_entrust(String vq_entrust) {
		this.vq_entrust = vq_entrust;
	}
	public String getVq_actual() {
		return vq_actual;
	}
	public void setVq_actual(String vq_actual) {
		this.vq_actual = vq_actual;
	}
	public String getVq_reception_rate() {
		return vq_reception_rate;
	}
	public void setVq_reception_rate(String vq_reception_rate) {
		this.vq_reception_rate = vq_reception_rate;
	}
	public String getVq_network_length() {
		return vq_network_length;
	}
	public void setVq_network_length(String vq_network_length) {
		this.vq_network_length = vq_network_length;
	}
	public String getVq_detection_length() {
		return vq_detection_length;
	}
	public void setVq_detection_length(String vq_detection_length) {
		this.vq_detection_length = vq_detection_length;
	}
	public String getVq_mapping_length() {
		return vq_mapping_length;
	}
	public void setVq_mapping_length(String vq_mapping_length) {
		this.vq_mapping_length = vq_mapping_length;
	}
	public String getVq_dredging_capacity() {
		return vq_dredging_capacity;
	}
	public void setVq_dredging_capacity(String vq_dredging_capacity) {
		this.vq_dredging_capacity = vq_dredging_capacity;
	}
	public String getVq_renovation() {
		return vq_renovation;
	}
	public void setVq_renovation(String vq_renovation) {
		this.vq_renovation = vq_renovation;
	}
	public String getTq_completed_num() {
		return tq_completed_num;
	}
	public void setTq_completed_num(String tq_completed_num) {
		this.tq_completed_num = tq_completed_num;
	}
	public String getTq_entrust() {
		return tq_entrust;
	}
	public void setTq_entrust(String tq_entrust) {
		this.tq_entrust = tq_entrust;
	}
	public String getTq_actual() {
		return tq_actual;
	}
	public void setTq_actual(String tq_actual) {
		this.tq_actual = tq_actual;
	}
	public String getTq_reception_rate() {
		return tq_reception_rate;
	}
	public void setTq_reception_rate(String tq_reception_rate) {
		this.tq_reception_rate = tq_reception_rate;
	}
	public String getTq_network_length() {
		return tq_network_length;
	}
	public void setTq_network_length(String tq_network_length) {
		this.tq_network_length = tq_network_length;
	}
	public String getTq_detection_length() {
		return tq_detection_length;
	}
	public void setTq_detection_length(String tq_detection_length) {
		this.tq_detection_length = tq_detection_length;
	}
	public String getTq_mapping_length() {
		return tq_mapping_length;
	}
	public void setTq_mapping_length(String tq_mapping_length) {
		this.tq_mapping_length = tq_mapping_length;
	}
	public String getTq_dredging_capacity() {
		return tq_dredging_capacity;
	}
	public void setTq_dredging_capacity(String tq_dredging_capacity) {
		this.tq_dredging_capacity = tq_dredging_capacity;
	}
	public String getTq_renovation() {
		return tq_renovation;
	}
	public void setTq_renovation(String tq_renovation) {
		this.tq_renovation = tq_renovation;
	}
	public Long getDept_id() {
		return dept_id;
	}
	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	
}

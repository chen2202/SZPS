package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

public class DayReportW extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 12653304690408370L;
	Long id;
	Long deptid;
	String deptname;// 设备名称
	String basin;//所属流域
	String reportdate;//日期
	String dscale;//设计规模
	String tcapacity;//处理量
	String loadrate;//负荷率
	String incod;//进水COD
	String inan;//进水氨氮
	String darea;//辖区
	String inp;//进水总磷
	String inss;//进水SS
	String inbod;//进水BOD
	String outcod;//出水COD
	String outan;//出水氨氮
	String outp;//出水总磷
	String outdo;//出水DO
	String dlevel;//提升泵坑 设计液位
	String aleave;//提升泵坑 实际液位
	String sludec;//污泥浓度
	String lanfilll;//垃圾渗滤液
	String sol;//渗滤液来源
	String operation;//运营单位
	String dtype;//类型
	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}
	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDeptid() {
		return deptid;
	}
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getBasin() {
		return basin;
	}
	public void setBasin(String basin) {
		this.basin = basin;
	}
	public String getReportdate() {
		return reportdate;
	}
	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}
	public String getDscale() {
		return dscale;
	}
	public void setDscale(String dscale) {
		this.dscale = dscale;
	}
	public String getTcapacity() {
		return tcapacity;
	}
	public void setTcapacity(String tcapacity) {
		this.tcapacity = tcapacity;
	}
	public String getLoadrate() {
		return loadrate;
	}
	public void setLoadrate(String loadrate) {
		this.loadrate = loadrate;
	}
	public String getIncod() {
		return incod;
	}
	public void setIncod(String incod) {
		this.incod = incod;
	}
	public String getInan() {
		return inan;
	}
	public void setInan(String inan) {
		this.inan = inan;
	}
	public String getDarea() {
		return darea;
	}
	public void setDarea(String darea) {
		this.darea = darea;
	}
	public String getInp() {
		return inp;
	}
	public void setInp(String inp) {
		this.inp = inp;
	}
	public String getInss() {
		return inss;
	}
	public void setInss(String inss) {
		this.inss = inss;
	}
	public String getInbod() {
		return inbod;
	}
	public void setInbod(String inbod) {
		this.inbod = inbod;
	}
	public String getOutcod() {
		return outcod;
	}
	public void setOutcod(String outcod) {
		this.outcod = outcod;
	}
	public String getOutan() {
		return outan;
	}
	public void setOutan(String outan) {
		this.outan = outan;
	}
	public String getOutp() {
		return outp;
	}
	public void setOutp(String outp) {
		this.outp = outp;
	}
	public String getOutdo() {
		return outdo;
	}
	public void setOutdo(String outdo) {
		this.outdo = outdo;
	}
	public String getDlevel() {
		return dlevel;
	}
	public void setDlevel(String dlevel) {
		this.dlevel = dlevel;
	}
	public String getAleave() {
		return aleave;
	}
	public void setAleave(String aleave) {
		this.aleave = aleave;
	}
	public String getSludec() {
		return sludec;
	}
	public void setSludec(String sludec) {
		this.sludec = sludec;
	}
	public String getLanfilll() {
		return lanfilll;
	}
	public void setLanfilll(String lanfilll) {
		this.lanfilll = lanfilll;
	}
	public String getSol() {
		return sol;
	}
	public void setSol(String sol) {
		this.sol = sol;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDtype() {
		return dtype;
	}
	public void setDtype(String dtype) {
		this.dtype = dtype;
	}


}
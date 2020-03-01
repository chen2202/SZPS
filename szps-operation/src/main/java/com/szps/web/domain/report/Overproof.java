package com.szps.web.domain.report;

import com.szps.common.core.domain.BaseEntity;

/**
 * 月报中的超标情况
 * @author Jack
 *
 */
public class Overproof extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -143705417226384084L;
	private Long id;
	String occurDate;
	String cod;
	String nhh;
	String tp;
	String tn;
	String ss;
	String ph;
	String type;//进水 OR 出水
	int monthReportId;
	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	public String getOccurDate() {
		return occurDate;
	}
	public void setOccurDate(String occurDate) {
		this.occurDate = occurDate;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public String getNhh() {
		return nhh;
	}
	public void setNhh(String nhh) {
		this.nhh = nhh;
	}
	public String getTp() {
		return tp;
	}
	public void setTp(String tp) {
		this.tp = tp;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String getSs() {
		return ss;
	}
	public void setSs(String ss) {
		this.ss = ss;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMonthReportId() {
		return monthReportId;
	}
	public void setMonthReportId(int monthReportId) {
		this.monthReportId = monthReportId;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
}

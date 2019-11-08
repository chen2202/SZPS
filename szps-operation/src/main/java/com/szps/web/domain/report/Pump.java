package com.szps.web.domain.report;

import java.util.List;

import com.szps.common.core.domain.BaseEntity;
/**
 * 污水泵站固定资产清单
 * @author Jack
 *
 */
public class Pump extends BaseEntity {
	private static final long serialVersionUID = -4503872105149032924L;
	Long id;
	Long deptid;
	String deptname;
	String pumpname;
	String recorddate;
	List<PumpDetail> pumpDetails;
	List<PumpDetail> list1;
	List<PumpDetail> list2;
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
	public String getPumpname() {
		return pumpname;
	}
	public void setPumpname(String pumpname) {
		this.pumpname = pumpname;
	}
	public String getRecorddate() {
		return recorddate;
	}
	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}
	public List<PumpDetail> getPumpDetails() {
		return pumpDetails;
	}
	public void setPumpDetails(List<PumpDetail> pumpDetails) {
		this.pumpDetails = pumpDetails;
	}
	public List<PumpDetail> getList1() {
		return list1;
	}
	public void setList1(List<PumpDetail> list1) {
		this.list1 = list1;
	}
	public List<PumpDetail> getList2() {
		return list2;
	}
	public void setList2(List<PumpDetail> list2) {
		this.list2 = list2;
	}

}

package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class RoutineCheck extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 235814072943042977L;
	private Long id;
	private Long deptId;
	private String recordDate;// 记录日期
	private String devName;// 设备名称：
	private String devNumber;// 设备编号：
	private String devModel;// 设备型号：
	private String useDept;// 使用部门：
	private String checkManager;// 保养负责人：
	private String manager;// 责任人：
	private String maintainResult1;// 保养结果1
	private String maintainResult2;// 保养结果2
	private String maintainResult3;// 保养结果3
	private String maintainResult4;// 保养结果4
	private String maintainResult5;// 保养结果5
	private String maintainResult6;// 保养结果6
	private String maintainResult7;// 保养结果7
	private String maintainResult8;// 保养结果8
	private String maintainResult9;// 保养结果9
	private String maintainResult10;// 保养结果10
	private String maintainResult11;// 保养结果11
	private String maintainPeople;// 保养人签名
	private String maintainResult;// 保养结果评价
	private String custodian;// 设备部监督人签名
	private String spotCheckResult;// 抽查人总体评价效果
	private String spotCheckSign;// 抽查人签名
	private String delFlag;
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
	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getDevNumber() {
		return devNumber;
	}

	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}

	public String getDevModel() {
		return devModel;
	}

	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}

	public String getUseDept() {
		return useDept;
	}

	public void setUseDept(String useDept) {
		this.useDept = useDept;
	}

	public String getCheckManager() {
		return checkManager;
	}

	public void setCheckManager(String checkManager) {
		this.checkManager = checkManager;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getMaintainResult1() {
		return maintainResult1;
	}

	public void setMaintainResult1(String maintainResult1) {
		this.maintainResult1 = maintainResult1;
	}

	public String getMaintainResult2() {
		return maintainResult2;
	}

	public void setMaintainResult2(String maintainResult2) {
		this.maintainResult2 = maintainResult2;
	}

	public String getMaintainResult3() {
		return maintainResult3;
	}

	public void setMaintainResult3(String maintainResult3) {
		this.maintainResult3 = maintainResult3;
	}

	public String getMaintainResult4() {
		return maintainResult4;
	}

	public void setMaintainResult4(String maintainResult4) {
		this.maintainResult4 = maintainResult4;
	}

	public String getMaintainResult5() {
		return maintainResult5;
	}

	public void setMaintainResult5(String maintainResult5) {
		this.maintainResult5 = maintainResult5;
	}

	public String getMaintainResult6() {
		return maintainResult6;
	}

	public void setMaintainResult6(String maintainResult6) {
		this.maintainResult6 = maintainResult6;
	}

	public String getMaintainResult7() {
		return maintainResult7;
	}

	public void setMaintainResult7(String maintainResult7) {
		this.maintainResult7 = maintainResult7;
	}

	public String getMaintainResult8() {
		return maintainResult8;
	}

	public void setMaintainResult8(String maintainResult8) {
		this.maintainResult8 = maintainResult8;
	}

	public String getMaintainResult9() {
		return maintainResult9;
	}

	public void setMaintainResult9(String maintainResult9) {
		this.maintainResult9 = maintainResult9;
	}

	public String getMaintainResult10() {
		return maintainResult10;
	}

	public void setMaintainResult10(String maintainResult10) {
		this.maintainResult10 = maintainResult10;
	}

	public String getMaintainResult11() {
		return maintainResult11;
	}

	public void setMaintainResult11(String maintainResult11) {
		this.maintainResult11 = maintainResult11;
	}

	public String getMaintainPeople() {
		return maintainPeople;
	}

	public void setMaintainPeople(String maintainPeople) {
		this.maintainPeople = maintainPeople;
	}

	public String getMaintainResult() {
		return maintainResult;
	}

	public void setMaintainResult(String maintainResult) {
		this.maintainResult = maintainResult;
	}

	public String getCustodian() {
		return custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}

	public String getSpotCheckResult() {
		return spotCheckResult;
	}

	public void setSpotCheckResult(String spotCheckResult) {
		this.spotCheckResult = spotCheckResult;
	}

	public String getSpotCheckSign() {
		return spotCheckSign;
	}

	public void setSpotCheckSign(String spotCheckSign) {
		this.spotCheckSign = spotCheckSign;
	}

	/**
	 * @return the deptId
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the delFlag
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

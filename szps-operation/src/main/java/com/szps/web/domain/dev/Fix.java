package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Fix extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6596163357669149705L;
	private Long id;
	private Long deptId;
	private String devName;// 设备名称
	private String devNumber;// 设备编号：
	private String devModel;// 设备型号：
	private String useDept;// 使用部门：
	private String installPlace;// 设备地点
	private String assetCode;// 资产编号
	private String maintainer;// 维修员
	private String operateDutyOfficer;// 操作责任人
	private String recordDate;// 记录日期
	private String troubleSpec;// 故障现象描述
	private String reason;// 原因分析
	private String assayer;// 分析人
	private String equiHead;// 设备部主管
	private String equiManager;// 设备部经理
	private String troubleType;// 故障类型
	private String dutyPeople;// 责任人
	private String fixspec;// 维修过程及耗材
	private String mechanic;// 维修人
	private String outServiceOpinion;// 委外维修意见
	private String equiHeadOut;// 设备主管
	private String equiManagerOut;// 设备经理
	private String prodManager;// 生产经理
	private String outRemarks;// 委外备注
	private String result;// 维修结果
	private String monitor;// 维修班长
	private String equiOwer;// 设备部主管
	private String userManger;// 使用部门主管
	private String planTime;// 计划时间
	private String doneTime;// 完成时间
	private String usesTime;// 维修耗时
	private String delFlag;
	private String jobnumber;//派工单号

	Long dept_id;//CREATE_BY 部门ID
	
	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}
	
	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getInstallPlace() {
		return installPlace;
	}

	public void setInstallPlace(String installPlace) {
		this.installPlace = installPlace;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getMaintainer() {
		return maintainer;
	}

	public void setMaintainer(String maintainer) {
		this.maintainer = maintainer;
	}

	public String getOperateDutyOfficer() {
		return operateDutyOfficer;
	}

	public void setOperateDutyOfficer(String operateDutyOfficer) {
		this.operateDutyOfficer = operateDutyOfficer;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getTroubleSpec() {
		return troubleSpec;
	}

	public void setTroubleSpec(String troubleSpec) {
		this.troubleSpec = troubleSpec;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAssayer() {
		return assayer;
	}

	public void setAssayer(String assayer) {
		this.assayer = assayer;
	}

	public String getEquiHead() {
		return equiHead;
	}

	public void setEquiHead(String equiHead) {
		this.equiHead = equiHead;
	}

	public String getEquiManager() {
		return equiManager;
	}

	public void setEquiManager(String equiManager) {
		this.equiManager = equiManager;
	}

	public String getTroubleType() {
		return troubleType;
	}

	public void setTroubleType(String troubleType) {
		this.troubleType = troubleType;
	}

	public String getDutyPeople() {
		return dutyPeople;
	}

	public void setDutyPeople(String dutyPeople) {
		this.dutyPeople = dutyPeople;
	}




	public String getFixspec() {
		return fixspec;
	}

	public void setFixspec(String fixspec) {
		this.fixspec = fixspec;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getOutServiceOpinion() {
		return outServiceOpinion;
	}

	public void setOutServiceOpinion(String outServiceOpinion) {
		this.outServiceOpinion = outServiceOpinion;
	}

	public String getEquiHeadOut() {
		return equiHeadOut;
	}

	public void setEquiHeadOut(String equiHeadOut) {
		this.equiHeadOut = equiHeadOut;
	}

	public String getEquiManagerOut() {
		return equiManagerOut;
	}

	public void setEquiManagerOut(String equiManagerOut) {
		this.equiManagerOut = equiManagerOut;
	}

	public String getProdManager() {
		return prodManager;
	}

	public void setProdManager(String prodManager) {
		this.prodManager = prodManager;
	}

	public String getOutRemarks() {
		return outRemarks;
	}

	public void setOutRemarks(String outRemarks) {
		this.outRemarks = outRemarks;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getEquiOwer() {
		return equiOwer;
	}

	public void setEquiOwer(String equiOwer) {
		this.equiOwer = equiOwer;
	}

	public String getUserManger() {
		return userManger;
	}

	public void setUserManger(String userManger) {
		this.userManger = userManger;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getDoneTime() {
		return doneTime;
	}

	public void setDoneTime(String doneTime) {
		this.doneTime = doneTime;
	}

	public String getUsesTime() {
		return usesTime;
	}

	public void setUsesTime(String usesTime) {
		this.usesTime = usesTime;
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

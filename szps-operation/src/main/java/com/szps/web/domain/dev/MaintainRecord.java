package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class MaintainRecord extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6101488506725005257L;
	private Long id;
	private Long deptId;
	private String useDept;//使用部门：
	private String recordDate;//填写日期
	private String devName;//设备名称
	private String devNumber;//设备编号：
	private String devModel;//设备型号：
	private String devSpec;//设备规格
	private String mType;//保养类别
	private String mCycle;//保养周期
	private String installPlace;//安装地点
	private String devType;//设备类别
	private String lastDate;//上次保养时间
	private String content;//保养内容
	private String maintainRemarks;//保养备注
	private String planStartTime;//计划保养开始日期
	private String planEndTime;//计划保养结束日期
	private String planUseTime;//计划耗时
	private String startTime;//实际保养开始时间
	private String endTime;//实际保养结束时间
	private String useTime;//实际耗时
	private String commodities;//保养耗材
	private String monitor;//维修班长
	private String result;//保养后运行结果
	private String maintainPerson;//保养人
	private String operator;//操作员确认
	private String operatorConfirmTime;//操作员确认时间
	private String prodSupr;//生产主管
	private String prodSuperConfirmTime;//生产主管确认时间
	private String faciSuper;//设备主管
	private String faciSuperConfirmTime;//设备主管确认时间
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
	public String getUseDept() {
		return useDept;
	}
	public void setUseDept(String useDept) {
		this.useDept = useDept;
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
	public String getDevSpec() {
		return devSpec;
	}
	public void setDevSpec(String devSpec) {
		this.devSpec = devSpec;
	}
	public String getmType() {
		return mType;
	}
	public void setmType(String mType) {
		this.mType = mType;
	}
	public String getmCycle() {
		return mCycle;
	}
	public void setmCycle(String mCycle) {
		this.mCycle = mCycle;
	}
	public String getInstallPlace() {
		return installPlace;
	}
	public void setInstallPlace(String installPlace) {
		this.installPlace = installPlace;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMaintainRemarks() {
		return maintainRemarks;
	}
	public void setMaintainRemarks(String maintainRemarks) {
		this.maintainRemarks = maintainRemarks;
	}
	public String getPlanStartTime() {
		return planStartTime;
	}
	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}
	public String getPlanEndTime() {
		return planEndTime;
	}
	public void setPlanEndTime(String planEndTime) {
		this.planEndTime = planEndTime;
	}
	public String getPlanUseTime() {
		return planUseTime;
	}
	public void setPlanUseTime(String planUseTime) {
		this.planUseTime = planUseTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUseTime() {
		return useTime;
	}
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
	public String getCommodities() {
		return commodities;
	}
	public void setCommodities(String commodities) {
		this.commodities = commodities;
	}
	public String getMonitor() {
		return monitor;
	}
	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMaintainPerson() {
		return maintainPerson;
	}
	public void setMaintainPerson(String maintainPerson) {
		this.maintainPerson = maintainPerson;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperatorConfirmTime() {
		return operatorConfirmTime;
	}
	public void setOperatorConfirmTime(String operatorConfirmTime) {
		this.operatorConfirmTime = operatorConfirmTime;
	}
	public String getProdSupr() {
		return prodSupr;
	}
	public void setProdSupr(String prodSupr) {
		this.prodSupr = prodSupr;
	}
	public String getProdSuperConfirmTime() {
		return prodSuperConfirmTime;
	}
	public void setProdSuperConfirmTime(String prodSuperConfirmTime) {
		this.prodSuperConfirmTime = prodSuperConfirmTime;
	}
	public String getFaciSuper() {
		return faciSuper;
	}
	public void setFaciSuper(String faciSuper) {
		this.faciSuper = faciSuper;
	}
	public String getFaciSuperConfirmTime() {
		return faciSuperConfirmTime;
	}
	public void setFaciSuperConfirmTime(String faciSuperConfirmTime) {
		this.faciSuperConfirmTime = faciSuperConfirmTime;
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

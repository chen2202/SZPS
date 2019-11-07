package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class MaintainPlan extends BaseEntity {

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
	private String devProDate;//设备出厂日期
	private String devType;//设备类别
	private String mType;//保养类别
	private String mCycle;//保养周期
	private String lastDate;//上次保养时间
	private String lastEffect;//上次保养效果
	private String reason;//保养原因
	private String planDate;//计划保养时间
	private String effect;//保养效果
	private String maker;//编制
	private String approver;//审批

	private String delFlag;
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
	public String getDevProDate() {
		return devProDate;
	}
	public void setDevProDate(String devProDate) {
		this.devProDate = devProDate;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
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
	public String getLastDate() {
		return lastDate;
	}
	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
	public String getLastEffect() {
		return lastEffect;
	}
	public void setLastEffect(String lastEffect) {
		this.lastEffect = lastEffect;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
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

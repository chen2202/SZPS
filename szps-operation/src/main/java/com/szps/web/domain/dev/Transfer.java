package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Transfer extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5377962690490866813L;
	private Long id;
	private Long deptId;
	private String applyDate;// 申请日期
	private String applyDept;// 申请单位
	private String applyEquip;// 申请调拨设备
	private String devModel;// 设备型号
	private String origDept;// 设备原使用单位
	private String devStatu;// 设备状况
	private String devNumber;// 设备编号
	private String transferType;// 调拨性质
	private String origValue;// 设备原值
	private String devType;// 设备类别
	private String planoutDate;// 计划迁出时间
	private String depreciateYear;// 设备折旧年限
	private String supplier;// 设备供应商
	private String planReturnDate;// 计划归还时间
	private String dutyCost;// 申请单位承担折旧费用
	private String buyDate;// 购置日期
	private String tPart;// 移交辅机配件
	private String accessory;// 移交附件（1说明书 2合格证 3发票 4保修卡 5装箱单 6商检证 7设备档案 8其它）
	private String applyReason;// 申请理由
	private String applicant;// 申请人
	private String origDeptOpinion;// 原使用部门意见
	private String origPeople;// 原使用部门人员
	private String equipDeptOpinion;// 设备部意见
	private String equipPeople;// 设备部人员
	private String leaderOpinion;// 分管领导意见
	private String leader;// 分管领导
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
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getApplyDept() {
		return applyDept;
	}
	public void setApplyDept(String applyDept) {
		this.applyDept = applyDept;
	}
	public String getApplyEquip() {
		return applyEquip;
	}
	public void setApplyEquip(String applyEquip) {
		this.applyEquip = applyEquip;
	}
	public String getDevModel() {
		return devModel;
	}
	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}
	public String getOrigDept() {
		return origDept;
	}
	public void setOrigDept(String origDept) {
		this.origDept = origDept;
	}
	public String getDevStatu() {
		return devStatu;
	}
	public void setDevStatu(String devStatu) {
		this.devStatu = devStatu;
	}
	public String getDevNumber() {
		return devNumber;
	}
	public void setDevNumber(String devNumber) {
		this.devNumber = devNumber;
	}
	public String getTransferType() {
		return transferType;
	}
	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}
	public String getOrigValue() {
		return origValue;
	}
	public void setOrigValue(String origValue) {
		this.origValue = origValue;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getPlanoutDate() {
		return planoutDate;
	}
	public void setPlanoutDate(String planoutDate) {
		this.planoutDate = planoutDate;
	}
	public String getDepreciateYear() {
		return depreciateYear;
	}
	public void setDepreciateYear(String depreciateYear) {
		this.depreciateYear = depreciateYear;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getPlanReturnDate() {
		return planReturnDate;
	}
	public void setPlanReturnDate(String planReturnDate) {
		this.planReturnDate = planReturnDate;
	}
	public String getDutyCost() {
		return dutyCost;
	}
	public void setDutyCost(String dutyCost) {
		this.dutyCost = dutyCost;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String gettPart() {
		return tPart;
	}
	public void settPart(String tPart) {
		this.tPart = tPart;
	}
	public String getAccessory() {
		return accessory;
	}
	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getOrigDeptOpinion() {
		return origDeptOpinion;
	}
	public void setOrigDeptOpinion(String origDeptOpinion) {
		this.origDeptOpinion = origDeptOpinion;
	}
	public String getOrigPeople() {
		return origPeople;
	}
	public void setOrigPeople(String origPeople) {
		this.origPeople = origPeople;
	}
	public String getEquipDeptOpinion() {
		return equipDeptOpinion;
	}
	public void setEquipDeptOpinion(String equipDeptOpinion) {
		this.equipDeptOpinion = equipDeptOpinion;
	}
	public String getEquipPeople() {
		return equipPeople;
	}
	public void setEquipPeople(String equipPeople) {
		this.equipPeople = equipPeople;
	}
	public String getLeaderOpinion() {
		return leaderOpinion;
	}
	public void setLeaderOpinion(String leaderOpinion) {
		this.leaderOpinion = leaderOpinion;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

package com.szps.web.domain.dev;

import com.szps.common.core.domain.BaseEntity;

public class Apply extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7659629254398683319L;
	private String devType;// 设备类型
	private String applyDate;// 申请时间
	private String applyDept;// 申请部门
	private String applyDeptManager;// 申请部门经理
	private String requireDate;// 要求购置时间
	private String applyPrj;// 申请项目
	private String applySpec;// 申请说明
	private String verifier;// 审核人
	private String approver;// 批准人
	private Long deptId;
	private String delFlag;
	private Long id;
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
	public String getDevType() {
		return devType;
	}

	public void setDevType(String devType) {
		this.devType = devType;
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

	public String getApplyDeptManager() {
		return applyDeptManager;
	}

	public void setApplyDeptManager(String applyDeptManager) {
		this.applyDeptManager = applyDeptManager;
	}

	public String getRequireDate() {
		return requireDate;
	}

	public void setRequireDate(String requireDate) {
		this.requireDate = requireDate;
	}

	public String getApplyPrj() {
		return applyPrj;
	}

	public void setApplyPrj(String applyPrj) {
		this.applyPrj = applyPrj;
	}

	public String getApplySpec() {
		return applySpec;
	}

	public void setApplySpec(String applySpec) {
		this.applySpec = applySpec;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
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

package com.szps.system.domain;

import com.szps.common.core.domain.BaseEntity;

public class SysBRF extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Long brfId;

	/** 父部门ID */
	private Long parentId;
	private String parentName;

	/** 祖级列表 */
	private String ancestors;

	private String brfName;

	/** 显示顺序 */
	private String orderNum;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	public Long getBrfId() {
		return brfId;
	}

	public void setBrfId(Long brfId) {
		this.brfId = brfId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getAncestors() {
		return ancestors;
	}

	public void setAncestors(String ancestors) {
		this.ancestors = ancestors;
	}

	public String getBrfName() {
		return brfName;
	}

	public void setBrfName(String brfName) {
		this.brfName = brfName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}

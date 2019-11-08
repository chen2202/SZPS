package com.szps.system.domain;

import com.szps.common.core.domain.BaseEntity;

public class SysPurPlant extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Long plantId;

	/** 父部门ID */
	private Long parentId;
	private String parentName;

	/** 祖级列表 */
	private String ancestors;

	private String plantName;

	/** 显示顺序 */
	private String orderNum;

	private Integer plantType;

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
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

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getPlantType() {
		return plantType;
	}

	public void setPlantType(Integer plantType) {
		this.plantType = plantType;
	}

}

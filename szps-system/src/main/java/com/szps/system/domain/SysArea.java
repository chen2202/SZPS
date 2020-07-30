package com.szps.system.domain;

import com.szps.common.core.domain.BaseEntity;

public class SysArea extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Long areaId;

	/** 父部门ID */
	private Long parentId;
	private String parentName;

	/** 祖级列表 */
	private String ancestors;

	private String areaName;

	/** 显示顺序 */
	private String orderNum;

	private String areaCode;

	private Integer areaType;
	/** 删除标志（0代表存在 2代表删除） */
	private String delFlag;

	private boolean flag = false;
	
    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
	


	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}


}

package com.szps.web.domain.report;

import java.util.List;

import com.szps.common.core.domain.BaseEntity;

public class OpLogList extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6072129909779044566L;
	List<OpLog> opLogList;

	public List<OpLog> getOpLogList() {
		return opLogList;
	}

	public void setOpLogList(List<OpLog> opLogList) {
		this.opLogList = opLogList;
	}
	
}

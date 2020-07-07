package com.szps.web.mapper.drainage;

import com.szps.web.domain.drainage.Committees;

import java.util.List;

public interface CommitteesMapper {
	/**
	 * 获取某个街道全部居委会名称（用于下拉菜单）
	 * @param committees
	 * @return
	 */
	public List<Committees> selectSomeCommittees(Committees committees);
}

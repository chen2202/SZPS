package com.szps.web.mapper.drainage;

import java.util.List;

import com.szps.web.domain.drainage.Street;

public interface StreetMapper {
	/**
	 * 获取某个行政区全部街道名称（用于下拉菜单）
	 * @param street
	 * @return
	 */
	public List<Street> selectSomeStreet(Street street);
}

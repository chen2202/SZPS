package com.szps.web.mapper.drainage;

import com.szps.web.domain.drainage.Administrative;

import java.util.List;

public interface AdministrativeMapper {
	/**
	 * 查询全部行政区名(用于下拉菜单)
	 * @return 
	 */
	public List<Administrative> selectAllAdministrativeName();
}

package com.szps.web.service.drainage;

import java.util.List;

import com.szps.web.domain.drainage.Administrative;

public interface AdministrativeService {
	/**
	 * 查询全部行政区名(用于下拉菜单)
	 * @return
	 */
	public List<Administrative> selectAllAdministrativeName();
}

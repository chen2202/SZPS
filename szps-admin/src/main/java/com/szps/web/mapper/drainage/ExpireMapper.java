package com.szps.web.mapper.drainage;

import com.szps.web.domain.drainage.Household;

import java.util.List;
import java.util.Map;

public interface ExpireMapper {
	/**
	 * 查询全部排水户
	 * @return
	 */
	public List<Household> selectAll(Map m);
}

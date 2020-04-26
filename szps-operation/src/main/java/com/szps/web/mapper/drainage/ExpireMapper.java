package com.szps.web.mapper.drainage;

import java.util.List;
import java.util.Map;

import com.szps.web.domain.drainage.Household;

public interface ExpireMapper {
	/**
	 * 查询全部排水户
	 * @return
	 */
	public List<Household> selectAll(Map m);
}

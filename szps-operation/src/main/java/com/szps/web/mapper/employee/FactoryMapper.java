package com.szps.web.mapper.employee;

import java.util.List;

import com.szps.web.domain.employee.Factory;

public interface FactoryMapper {
	/**
	 * 查询水厂全部的名称和代码
	 */
	public List<Factory> selectAllFactoryName();
	
	/**
	 * 查询全部水厂信息
	 */
	public List<Factory> selectAllFactory(Factory factory);
}

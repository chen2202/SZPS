package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Factory;

public interface FactoryService {
	/**
	 * add.html公司下拉菜单 添加水厂名
	 */
	public List<Factory> selectAllFactoryName();
	
	/**
	 * 查询全部水厂信息
	 */
	public List<Factory> selectAllFactory(Factory factory);
	
	/**
	 * 查询某个水厂名称
	 */
	public String selectFactoryById(String factory_id);
}

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
	
	/**
	 * 查询某个水厂名称
	 */
	public String selectFactoryById(String factory_id);
	
	
	/**
	 * 校验水厂代码唯一性
	 */
	public Factory checkFactoryIdUnique(String factory_id);
	
	/**
	 * 添加水厂
	 * @param factory
	 */
	public void insertFactory(Factory factory);
	
	/**
	 * 通过水厂代码查询水厂
	 */
	public Factory selectFactoryById2(String factory_id);
	
	/**
	 * 修改水厂信息
	 */
	public void updateFactory(Factory factory);
	
	/**
	 * 通过水厂代码删除水厂
	 */
	public int deleteFactoryById(String[] ids);
}

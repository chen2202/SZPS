package com.szps.web.service.employee.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.employee.Factory;
import com.szps.web.mapper.employee.FactoryMapper;
import com.szps.web.service.employee.FactoryService;

@Service
public class FactoryServiceImpl implements FactoryService{
	@Autowired
	private FactoryMapper factoryMapper;
	
	/**
	 * 实现查询全部水厂信息
	 */
	public List<Factory> selectAllFactoryName(){
		return factoryMapper.selectAllFactoryName();
	}
	
	/**
	 * 查询全部水厂信息
	 */
	public List<Factory> selectAllFactory(Factory factory){
		return factoryMapper.selectAllFactory(factory);
	}
	
	/**
	 * 查询某个水厂名称
	 */
	public String selectFactoryById(String factory_id) {
		return factoryMapper.selectFactoryById(factory_id);
	}
}

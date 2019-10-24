package com.szps.web.service.employee.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
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
	
	/**
	 * 校验水厂代码唯一性
	 * 参数：
	*返回值：如果水厂代码唯一，返回"0"，不唯一返回"1"
	 */
	public String checkFactoryIdUnique(Factory factory) {
		Factory f = null;
		f = factoryMapper.checkFactoryIdUnique(factory.getFactory_id());
		if(f != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**插入新的水厂数据
	*参数： 
	*返回值：
	*/
	public void insertFactory(Factory factory) {
		factoryMapper.insertFactory(factory);
	}
	
	/**
	 * 通过水厂代码查询水厂信息
	 */
	public Factory selectFactoryById2(String factory_id) {
		return factoryMapper.selectFactoryById2(factory_id);
	}
	
	/**
	 * 修改水厂信息
	 */
	public void updateFactory(Factory factory) {
		factoryMapper.updateFactory(factory);
	}
	
	/**
	 * 通过水厂代码删除水厂
	 */
	@Override
	public int deleteFactoryById(String ids) throws BusinessException{
		String[] factory_ids = Convert.toStrArray(ids);
		return factoryMapper.deleteFactoryById(factory_ids);
	}
}

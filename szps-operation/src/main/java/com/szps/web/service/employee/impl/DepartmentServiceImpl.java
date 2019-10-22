package com.szps.web.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.employee.Department;
import com.szps.web.mapper.employee.DepartmentMapper;
import com.szps.web.service.employee.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	//获取某公司全部部门信息
	//参数：某个公司信息
	//返回值：返回通过某个公司id查询到的部门信息
	public List<Department> selectSomeDepartment(Department department){
		return departmentMapper.selectSomeDepartment(department);
	}
}

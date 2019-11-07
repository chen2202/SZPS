package com.szps.web.mapper.employee;

import java.util.List;

import com.szps.web.domain.employee.Department;

public interface DepartmentMapper {
	/**
	 * 获取某个公司的全部部门信息 下拉菜单添加部门
	 */
	public List<Department> selectSomeDepartment(Department department);
	
	/**
	 * 通过公司/水厂代码查询该公司全部部门信息 用于创建组织结构图
	 */
	public List<Department> selectAllDepartmentByCompanyId(String company_id);
	
	/**
	 * 查询全部的部门信息
	 */
	public List<Department> selectAllDepartment(Department department);
	
	/**
	 * 判断新添加部门代码是否唯一
	 */
	public Department checkdDepartmentIdUnique(String department_id);
	
	/**
	 * 保存新增部门信息
	 */
	public void insertDepartment(Department department);
	
	/**
	 * 通过部门代码删除部门及其直接子部门
	 */
	public int deleteDepartmentById(String[] ids);
}

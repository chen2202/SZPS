package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Department;

public interface DepartmentService {
	/**
	 * 某公司全部部门信息
	 * @param department
	 * @return
	 */
	public List<Department> selectSomeDepartment(Department department);
	
	/**
	 * 通过公司/水厂代码查询该公司全部部门信息
	 * @param company_id
	 * @return
	 */
	public List<Department> selectAllDepartmentByCompanyId(String company_id);
	
	/**
	 * 查询全部的部门信息
	 * @return Department对象
	 */
	public List<Department> selectAllDepartment(Department department);
	
	/**
	 * 判断新添加部门代码是否唯一
	 * @param department
	 * @return
	 */
	public String checkdDepartmentIdUnique(Department department);
	
	/**
	 * 插入新部门信息
	 * @param department
	 */
	public void insertDepartment(Department department);
	
	/**
     * 通过部门代码删除部门及其直接子部门
     * @param 选中的部门代码数组
     */
	public int deleteDepartmentById(String ids) throws Exception;
}

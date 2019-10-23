package com.szps.web.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.employee.Department;
import com.szps.web.mapper.employee.DepartmentMapper;
import com.szps.web.service.employee.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	/**获取某公司全部部门信息
	*参数：某个公司信息
	*返回值：返回通过某个公司id查询到的部门信息
	*/
	public List<Department> selectSomeDepartment(Department department){
		return departmentMapper.selectSomeDepartment(department);
	}
	
	/**
	 * 通过公司/水厂代码查询该公司全部部门信息
	 * @param company_id
	 * @return 该公司全部部门信息
	 */
	public List<Department> selectAllDepartmentByCompanyId(String company_id){
		return departmentMapper.selectAllDepartmentByCompanyId(company_id);
	}
	
	/**
	 * 查询全部的部门信息
	 * @return Department对象
	 */
	public List<Department> selectAllDepartment(Department department){
		return departmentMapper.selectAllDepartment(department);
	}
	
	/**校验新部门代码
	*参数：
	*返回值：如果新部门代码唯一，返回"0"，不唯一返回"1"
	*/
	public String checkdDepartmentIdUnique(Department department) {
		Department d = null;
		d = departmentMapper.checkdDepartmentIdUnique(department.getDepartment_id());
		if(d != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**插入新的Department数据
	*参数：department表示新增部门信息对象
	*返回值：
	*/
	public void insertDepartment(Department department) {
		departmentMapper.insertDepartment(department);
	}
	
	/**
     * 通过部门代码删除部门及其直接子部门
     * @param 选中的部门代码数组
     */
	public int deleteDepartmentById(String ids) throws Exception{
		String[] department_ids = Convert.toStrArray(ids);
		return departmentMapper.deleteDepartmentById(department_ids);
	}
}

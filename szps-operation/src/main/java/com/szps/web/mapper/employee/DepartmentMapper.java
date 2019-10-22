package com.szps.web.mapper.employee;

import java.util.List;

import com.szps.web.domain.employee.Department;

public interface DepartmentMapper {
	/**
	 * 获取某个公司的全部部门信息
	 */
	public List<Department> selectSomeDepartment(Department department);
}

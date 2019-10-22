package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Department;

public interface DepartmentService {
	//某公司全部部门信息
	public List<Department> selectSomeDepartment(Department department);
}

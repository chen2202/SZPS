package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.web.domain.employee.Department;
import com.szps.web.service.employee.DepartmentService;

@Controller
@RequestMapping("/employee")
public class DepartmentController {
	private String prefix = "employee/worker"; //前缀路径
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 公司下拉框选择某公司后，添加公司的全部部门
	 */
	@PostMapping("/worker/departmentNameList")
    @ResponseBody
    public List<String> departmentNameList(Department department){
		List<Department> departmentModel = departmentService.selectSomeDepartment(department);
		List<String> departmentInfo = new ArrayList(); //存放某公司全部部门信息
		for(int i=0;i<departmentModel.size();i++) {
			Department d = departmentModel.get(i);
			departmentInfo.add(d.getDepartment_name());
			departmentInfo.add(d.getDepartment_id());
		}
		return departmentInfo;
	} 
}

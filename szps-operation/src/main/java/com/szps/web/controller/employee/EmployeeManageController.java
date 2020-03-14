package com.szps.web.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 从业人员管理主界面跳转
 * @author zxc
 *
 */
@Controller
@RequestMapping("/employee/manage")
public class EmployeeManageController {
	@GetMapping
	public String index() {
		return "/employee/main";
	}
}

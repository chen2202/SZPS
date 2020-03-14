package com.szps.web.controller.drainage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 排水户管理主界面跳转
 * @author zxc
 *
 */
@Controller
@RequestMapping("/drainage/manage")
public class DrainageManageController {
	@GetMapping
	public String index() {
		return "/drainage/main";
	}
}

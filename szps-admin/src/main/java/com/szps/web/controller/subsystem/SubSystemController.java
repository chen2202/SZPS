package com.szps.web.controller.subsystem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;

@Controller
public class SubSystemController extends BaseController {
	
	@ResponseBody
	@RequestMapping("/system/subsys/view/a")
	public AjaxResult subsysa() {
		System.out.println("/subsystem/sys1");
		return AjaxResult.warn("排水SCADA监管系统");
	}
	
	@ResponseBody
	@RequestMapping("/system/subsys/view/b")
	public AjaxResult subsysb() {
		System.out.println("/subsystem/sys1");
		return AjaxResult.warn("排水设施地理信息系统");
	}
}

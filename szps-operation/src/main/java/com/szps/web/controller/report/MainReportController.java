package com.szps.web.controller.report;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/report/main")
public class MainReportController extends BaseController {
	
	private String prefix = "/report";
	
    @RequiresPermissions("report:day:view")
    @GetMapping()
    public String main()
    {
        return prefix + "/main";
    }
}

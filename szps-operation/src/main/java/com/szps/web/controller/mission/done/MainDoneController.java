package com.szps.web.controller.mission.done;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/mission/done/main")
public class MainDoneController extends BaseController {
	
	private String prefix = "/mission/done";
	
    @RequiresPermissions("mission:done:view")
    @GetMapping()
    public String main()
    {
        return prefix + "/main";
    }
}

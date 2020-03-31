package com.szps.web.controller.mission.undo;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/mission/undo/main")
public class MainUndoController extends BaseController {
	
	private String prefix = "/mission/undo";
	
    @RequiresPermissions("mission:undo:view")
    @GetMapping()
    public String main()
    {
        return prefix + "/main";
    }
}

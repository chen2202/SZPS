package com.szps.web.controller.dev;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/dev/district")
public class DistrictController extends BaseController {
	
	private String prefix = "/dev";
	
    @RequiresPermissions("dev:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
}

package com.szps.web.controller.dev.fixedasset;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/fixedasset")
public class FixedAssetController extends BaseController {
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:view")
    @GetMapping()
    public String view()
    {
//        return prefix + "/view";
    	return "map/fixedasset";
    }
  
}

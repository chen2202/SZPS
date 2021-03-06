package com.szps.web.controller.dev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;

@Controller
@RequestMapping("/op/asset/main")
public class AssetMainReportController extends BaseController {
	
	private String prefix = "/dev";
	
    @GetMapping()
    public String main()
    {
        return prefix + "/assetmain";
    }
}

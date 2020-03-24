package com.szps.web.controller.dev.csdt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;
/**
 * csdt设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/csdtmain")
public class CsdtMainController extends BaseController {
	
	private String prefix = "/dev/csdt";
	
    @GetMapping()
    public String view()
    {
        return prefix + "/main";
    }
}

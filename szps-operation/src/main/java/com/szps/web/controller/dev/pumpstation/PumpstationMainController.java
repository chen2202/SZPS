package com.szps.web.controller.dev.pumpstation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;
/**
 * BO设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/pumpstationmain")
public class PumpstationMainController extends BaseController {
	
	private String prefix = "/dev/pumpstation";
	
    @GetMapping()
    public String view()
    {
        return prefix + "/main";
    }
}

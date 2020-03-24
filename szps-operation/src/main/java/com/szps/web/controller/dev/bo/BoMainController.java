package com.szps.web.controller.dev.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;
import com.szps.web.service.report.IYearAppraisalService;
/**
 * BO设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/bomain")
public class BoMainController extends BaseController {
	 @Autowired
	private IYearAppraisalService service;
	
	private String prefix = "/dev/bo";
	
    @GetMapping()
    public String view()
    {
        return prefix + "/main";
    }
}

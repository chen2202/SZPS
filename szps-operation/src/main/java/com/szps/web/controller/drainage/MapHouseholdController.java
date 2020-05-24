package com.szps.web.controller.drainage;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 排水户模块 地图服务控制器
 * @author zxc
 *
 */
@Controller
@RequestMapping("/drainage")
public class MapHouseholdController {
	private String prefix = "drainage/maphousehold";
	
	/**
	 * 跳转到maphousehold.html
	 * 
	 */
	@RequiresPermissions("drainage:maphousehold:view")
    @GetMapping("/maphousehold")
    public String household(){
        //return prefix + "/maphousehold";
    	return "redirect:/dist/index.html"; //重定向到GIS地图
    }
}

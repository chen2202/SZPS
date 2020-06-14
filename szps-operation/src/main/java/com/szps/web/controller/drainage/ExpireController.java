package com.szps.web.controller.drainage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.drainage.Household;
import com.szps.web.service.drainage.ExpireService;

/**
 * 排水户到期管理控制器
 * @author zxc
 * 20-4-9
 */
@Controller
@RequestMapping("/drainage")
public class ExpireController extends BaseController{
	private String prefix = "drainage/expire"; 
	
	@Autowired
	private ExpireService expireService;
	
	/**
	 * 跳转到expire.html
	 * 
	 */
	@RequiresPermissions("drainage:expire:view")
    @GetMapping("/expire")
    public String household(){
        return prefix + "/expire";
    }
	
	/**
	 * 添加 排水户 信息到expire.html
	 * 
	 */
	@RequiresPermissions("drainage:household:list")
    @PostMapping("/expire/list")
    @ResponseBody
    public TableDataInfo list(String administrativeName, String licenseType, String expireTime) {
		startPage();
		Map<String, Object> m = new HashMap<>();
		m.put("administrativeName", administrativeName);
		m.put("licenseType", licenseType);
		m.put("expireTime", expireTime);
		List<Household> list = expireService.selectAll(m);
		return getDataTable(list);
	}
	
	//@Log(title = "排水户管理", businessType = BusinessType.EXPORT)
		@RequiresPermissions("drainage:household:export")
	    @PostMapping("/expire/export")
	    @ResponseBody
	    public AjaxResult export(String administrativeName, String licenseType, String expireTime){
			Map<String, Object> m = new HashMap<>();
			m.put("administrativeName", administrativeName);
			m.put("licenseType", licenseType);
			m.put("expireTime", expireTime);
	        List<Household> list = expireService.selectAll(m);
	        ExcelUtil<Household> util = new ExcelUtil<Household>(Household.class);
	        return util.exportExcel(list, "排水户到期管理数据");
	    }
}

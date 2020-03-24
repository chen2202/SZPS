package com.szps.web.controller.dev.fixedasset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.szps.common.core.controller.BaseController;
import com.szps.system.domain.SysDept;
import com.szps.system.service.ISysDeptService;
/**
 * csdt设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/fixedassetmain")
public class FixedAssetMainController extends BaseController {
	 @Autowired
	 private ISysDeptService deptService;

	private String prefix = "/fixedasset";
	
    @GetMapping()
    public String view()
    {
        return prefix + "/main";
    }
    
    @GetMapping("/lista")
    public String lista(String deptname, ModelMap mmap)
    {
    	//mmap.put("deptname", deptname);
    	SysDept dept = deptService.selectDeptByName(deptname);
    	if (dept != null) {
    		mmap.put("deptId", dept.getDeptId());
		}else {
			mmap.put("deptId", -100);
		}
        return prefix + "/main";
    }
}

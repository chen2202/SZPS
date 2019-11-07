package com.szps.web.controller.dev;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.dev.DevInfo;
import com.szps.web.domain.dev.MaintenanceRecord;
import com.szps.web.service.dev.IDevInfoService;
import com.szps.web.service.dev.IMaintenanceRecordService;
import com.szps.web.service.dev.ISupplierService;

@Controller
@RequestMapping("/op/dev/maintenance")
public class MaintenanceRecordController extends BaseController {
	@Autowired
	private IMaintenanceRecordService service;
	 
	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private IDevInfoService devInfoService;
	
	private String prefix = "/dev/maintenance";
    @Value("${szps.profile}")
    private String filePath;
    @RequiresPermissions("dev:maintenance:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:maintenance:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MaintenanceRecord obj)
    {
        startPage();
        List<MaintenanceRecord> list = new ArrayList<MaintenanceRecord>();
        int flag = 0;
        if (obj!=null && obj.getDevname()!=null && !obj.getDevname().equals("")) {
			List<DevInfo> devinfoList = devInfoService.selectByName(obj.getDevname());
			if (devinfoList!=null) {
				for (DevInfo devInfo : devinfoList) {
					obj.setDevid(devInfo.getId());
					list.addAll(service.selectList(obj));
					flag = 1;
				}
			}
			
		}
        if (flag == 0) {
        	list = service.selectList(obj);
		}
        return getDataTable(list);
    }
    /**
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	SysDept sysDept = user.getDept();
    	mmap.put("sysDept",sysDept);
        return prefix + "/add";
    }
    

    /**
     */
    @RequiresPermissions("dev:maintenance:add")
    @Log(title = "添加设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MaintenanceRecord obj){
    
    	// 上传文件路径
    	SysUser user = ShiroUtils.getSysUser();
    
    	obj.setCreateBy(user.getLoginName());
    	int i =service.insert(obj);
    	
        return toAjax(i);
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	MaintenanceRecord obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "设备信息修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:maintenance:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MaintenanceRecord obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:maintenance:delete")
    @Log(title = "设备信息删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(service.deleteByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

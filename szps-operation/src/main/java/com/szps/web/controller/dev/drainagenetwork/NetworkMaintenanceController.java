package com.szps.web.controller.dev.drainagenetwork;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.dev.NetworkMaintenance;
import com.szps.web.service.dev.INetworkMaintenanceService;

@Controller
@RequestMapping("/op/dev/nm")
public class NetworkMaintenanceController extends BaseController {
	 @Autowired
	private INetworkMaintenanceService service;
	
	private String prefix = "/dev/drainagenetwork/maintenance/nm";
	
    @RequiresPermissions("dev:nm:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:nm:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NetworkMaintenance obj)
    {
        startPage();
        List<NetworkMaintenance> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    @RequiresPermissions("dev:nm:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( NetworkMaintenance obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
    	NetworkMaintenance obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:nm:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated NetworkMaintenance obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:nm:delete")
    @Log(title = "删除", businessType = BusinessType.DELETE)
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

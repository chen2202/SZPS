package com.szps.web.controller.dev.fixedasset;

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
import com.szps.web.domain.dev.fixedasset.Machine;
import com.szps.web.service.dev.fixedasset.IMachineService;

@Controller
@RequestMapping("/op/fixedasset/machine")
public class MachineController extends BaseController {
	 @Autowired
	private IMachineService service;
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:machine:view")
    @GetMapping()
    public String view(ModelMap mmap,String deptname)
    {
    	mmap.put("deptname", deptname);
        return prefix + "/machineview";
    }
    
    /**
     */
    @RequiresPermissions("fixedasset:machine:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Machine obj,ModelMap mmap,String deptname)
    {
        startPage();
        obj.setDeptname(deptname);
        List<Machine> list = service.selectList(obj);
        mmap.put("deptname", deptname);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/machineadd";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("fixedasset:machine:add")
    @Log(title = "添加固定资产-机器设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Machine obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Machine obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/machineedit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "固定资产-机器设备修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fixedasset:machine:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Machine obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("fixedasset:machine:delete")
    @Log(title = "固定资产-机器设备删除", businessType = BusinessType.DELETE)
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

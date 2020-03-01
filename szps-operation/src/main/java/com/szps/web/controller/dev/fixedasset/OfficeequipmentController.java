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
import com.szps.web.domain.dev.fixedasset.Officeequipment;
import com.szps.web.service.dev.fixedasset.IOfficeequipmentService;

@Controller
@RequestMapping("/op/fixedasset/officeequipment")
public class OfficeequipmentController extends BaseController {
	 @Autowired
	private IOfficeequipmentService service;
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:officeequipment:view")
    @GetMapping()
    public String view(ModelMap mmap,String deptname)
    {
    	mmap.put("deptname", deptname);
        return prefix + "/officeequipmentview";
    }
    
    /**
     */
    @RequiresPermissions("fixedasset:officeequipment:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Officeequipment obj,ModelMap mmap,String deptname)
    {
        startPage();
        obj.setDeptname(deptname);
        List<Officeequipment> list = service.selectList(obj);
        mmap.put("deptname", deptname);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/officeequipmentadd";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("fixedasset:officeequipment:add")
    @Log(title = "添加固定资产-电子办公设备", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Officeequipment obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Officeequipment obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/officeequipmentedit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "固定资产-电子办公设备修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fixedasset:officeequipment:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Officeequipment obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("fixedasset:officeequipment:delete")
    @Log(title = "固定资产-电子办公设备删除", businessType = BusinessType.DELETE)
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

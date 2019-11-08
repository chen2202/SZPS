package com.szps.web.controller.report;

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
import com.szps.web.domain.report.MHC;
import com.szps.web.service.report.IMHCService;

@Controller
@RequestMapping("/op/report/mhc")
public class MHCController extends BaseController {
	 @Autowired
	private IMHCService service;
	
	private String prefix = "/report/mhc";
	
    @RequiresPermissions("report:mhc:view")
    @GetMapping()
    public String mhc()
    {
        return prefix + "/view";
    }
    
    @RequiresPermissions("report:mhc:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MHC mhc)
    {
        startPage();
        List<MHC> list = service.selectReportList(mhc);
        return getDataTable(list);
    }
    

    
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @RequiresPermissions("report:mhc:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( MHC mhc)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	mhc.setCreateBy(user.getLoginName());
        return toAjax(service.insertReport(mhc));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	MHC mhc = service.selectReportById(id);
        
        mmap.put("obj", mhc);
        return prefix + "/edit";
    }
    
    
 
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:mhc:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated MHC report)
    {
    	report.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.updateReport(report));
    }

    @RequiresPermissions("report:mhc:delete")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(service.deleteReportByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

package com.szps.web.controller.report;

import java.util.ArrayList;
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
import com.szps.system.domain.SysArea;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysAreaService;
import com.szps.web.domain.report.YearAppraisal;
import com.szps.web.service.report.IYearAppraisalService;

@Controller
@RequestMapping("/op/report/yearappraisal")
public class YearAppraisalController extends BaseController {
	 @Autowired
	private IYearAppraisalService service;
    @Autowired
    private ISysAreaService areaService;
	private String prefix = "/report/yearappraisal";
	
    @RequiresPermissions("report:yearappraisal:view")
    @GetMapping()
    public String view(ModelMap mmap)
    {
    	List<SysArea> sysAreas = areaService.selectAreaAll();
    	List<SysArea> nList = new ArrayList<SysArea>();
    	SysArea s = new SysArea();
    	s.setAreaName("");
    	nList.add(s);
    	for (SysArea sysArea : sysAreas) {
			nList.add(sysArea);
		}
        mmap.put("areas", nList);
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("report:yearappraisal:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YearAppraisal obj,ModelMap mmap)
    {
        startPage();
        List<YearAppraisal> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add(ModelMap mmap)
    {	
    	mmap.put("areas", areaService.selectAreaAll());
        return prefix + "/add";
    }
    

    @RequiresPermissions("report:yearappraisal:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( YearAppraisal obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	YearAppraisal obj = service.selectById(id);
        
        mmap.put("obj", obj);
        List<SysArea> sysAreas = areaService.selectAreaAll();
        String ac = obj.getDarea();
        if(null != sysAreas && null != ac) {
        	for (SysArea sysArea : sysAreas) {
				String name = sysArea.getAreaName();
				if (ac.equalsIgnoreCase(name)) {
					sysArea.setFlag(true);
				}
			}
        }
        mmap.put("areas", sysAreas);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:yearappraisal:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated YearAppraisal obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("report:yearappraisal:delete")
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

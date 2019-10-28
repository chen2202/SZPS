package com.szps.web.controller.drainage;

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
import com.szps.web.domain.drainage.Household;
import com.szps.web.service.drainage.HouseholdService;

/**
 * 排水户 控制器
 * @author zxc
 *
 */
@Controller
@RequestMapping("/drainage/household")
public class HouseholdController extends BaseController{
	private String prefix = "drainage/household"; 
	
	@Autowired
	private HouseholdService householdService;
	
	/**
	 * 跳转到household.html
	 * 
	 */
	@RequiresPermissions("drainage:household:view")
    @GetMapping()
    public String household(){
        return prefix + "/household";
    }
    
    /**
	 * 添加 排水户 信息到household.html
	 * 
	 */
	@RequiresPermissions("drainage:household:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Household household) {
		startPage();
		List<Household> list = householdService.selectAllHousehold(household);
		return getDataTable(list);
	}
    
	/**
     * 新增排水户
     * 跳转到add.html
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 保存新增排水户
     */
    @RequiresPermissions("drainage:household:add")
    @Log(title = "排水户增加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Household household){   
	    householdService.insertHousehold(household);
        return toAjax(1); 
    }
    
    /**
     * 修改排水户
     * 跳转到edit.html
     */
    @GetMapping("/edit/{household_id}")
    public String edit(@PathVariable("household_id") String household_id,ModelMap mmap) {
    	mmap.put("household", householdService.selectHouseholdById(household_id));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存排水户
     * 
     */
    @RequiresPermissions("drainage:household:edit")
    @Log(title = "排水户修改", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Household household) {
    	householdService.updateHousehold(household);
    	return toAjax(1);
    }
    
    /**
     * 根据排水户编号删除排水户以及排水户下排水口
     */
    @RequiresPermissions("drainage:household:remove")
    @Log(title = "排水户删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		int deleterows = householdService.deleteDrainById(ids) + householdService.deleteHouseholdById(ids);
    		return toAjax(deleterows);
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验从业人员身份证号唯一性
     */
    @PostMapping("/checkHouseholdIdUnique")
    @ResponseBody
    public String checkHouseholdIdUnique(Household household){
        return householdService.checkHouseholdIdUnique(household); 
    }
}

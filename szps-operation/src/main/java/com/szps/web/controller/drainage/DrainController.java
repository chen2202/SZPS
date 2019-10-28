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
import com.szps.web.domain.drainage.Drain;
import com.szps.web.domain.employee.Project;
import com.szps.web.service.drainage.DrainService;

@Controller
@RequestMapping("/drainage")
public class DrainController extends BaseController{
	private String prefix = "drainage/drain";
	private String householdId=""; //某个查看排水口的排水户
	
	@Autowired
	private DrainService drainService;
	
	/**
	 * 跳转到drainage/drain/drain.html
	 */
	//@RequiresPermissions("")
	@GetMapping("/drain/drain/{household_id}")
	public String drain(@PathVariable("household_id") String household_id, ModelMap mmap) {
		householdId = household_id; //查看某排水户的排水口时，获取该排水口编号
		return prefix + "/drain";
	}
	
	/**
	 * 根据排水户编码显示该排水户的排水口信息
	 */
	//@RequiresPermissions("employee:company:list")
    @PostMapping("/drain/drain/list")
	@ResponseBody
	public TableDataInfo drainList(Drain drain) { //这个参数没有属性值！
		startPage();
		drain.setHousehold_id(householdId); //只需要排水户编号
		List<Drain> list = drainService.selectDrainByHouseholdId(drain);
		return getDataTable(list);
	}
    
    /**
     * 新增排水口
     * 跳转到add.html
     */
    @GetMapping("/drain/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 保存新增项目
     */
   // @RequiresPermissions("employee:company:add")
    @Log(title = "排水口添加", businessType = BusinessType.INSERT)
    @PostMapping("/drain/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Drain drain) {
    	drain.setHousehold_id(householdId); //浏览哪个排水户，就添加哪个排水户编号，覆盖掉前端传来的值'0'
    	drainService.insertDrain(drain);
    	return toAjax(1); 
    }
    
    /**
     * 修改排水口信息
     * 跳转到edit.html
     */
    @GetMapping("/drain/edit/{drain_id}")
    public String edit(@PathVariable("drain_id") String drain_id,ModelMap mmap) {
    	mmap.put("drain",drainService.selectDrainById(drain_id));
    	return prefix + "/edit";
    }
  
    /**
     * 修改保存排水口信息
     * 
     */
   // @RequiresPermissions("employee:company:edit")
    @Log(title = "排水口修改", businessType = BusinessType.UPDATE)
    @PostMapping("/drain/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Drain drain) {
    	drainService.updateDrain(drain);
    	return toAjax(1);
    }
    
    /**
     * 删除排水口
     * @param ids
     * @return
     */
    //@RequiresPermissions("drainage:household:remove")
    @Log(title = "排水口删除", businessType = BusinessType.DELETE)
    @PostMapping("/drain/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(drainService.deleteDrainById(ids));
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验项目名唯一性
     */
    @PostMapping("/drain/checkDrainUnique")
    @ResponseBody
    public String checkDrainUnique(Drain drain) {
    	return drainService.checkDrainUnique(drain);
    }
}

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
import com.szps.web.domain.dev.fixedasset.Car;
import com.szps.web.service.dev.fixedasset.ICarService;

@Controller
@RequestMapping("/op/fixedasset/car")
public class CarController extends BaseController {
	 @Autowired
	private ICarService service;
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:car:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/carview";
    }
    
    /**
     */
    @RequiresPermissions("fixedasset:car:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Car obj)
    {
        startPage();
        List<Car> list = service.selectList(obj);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/caradd";
    }
    

    /**
     * 新增保存
     */
    @RequiresPermissions("fixedasset:car:add")
    @Log(title = "添加固定资产-车辆", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Car obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Car obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/caredit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "固定资产-车辆修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fixedasset:car:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Car obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("fixedasset:car:delete")
    @Log(title = "固定资产-车辆删除", businessType = BusinessType.DELETE)
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

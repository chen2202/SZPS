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
import com.szps.web.domain.dev.fixedasset.Plant;
import com.szps.web.service.dev.fixedasset.IPlantService;

@Controller
@RequestMapping("/op/fixedasset/plant")
public class PlantController extends BaseController {
	 @Autowired
	private IPlantService service;
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:plant:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/plantview";
    }
    
    /**
     */
    @RequiresPermissions("fixedasset:plant:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Plant obj)
    {
        startPage();
        List<Plant> list = service.selectList(obj);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/plantadd";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("fixedasset:plant:add")
    @Log(title = "添加固定资产-绿化树木", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Plant obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Plant obj = service.selectById(id);
        mmap.put("obj", obj);
        return prefix + "/plantedit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "固定资产-绿化树木修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fixedasset:plant:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Plant obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("fixedasset:plant:delete")
    @Log(title = "固定资产-绿化树木删除", businessType = BusinessType.DELETE)
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

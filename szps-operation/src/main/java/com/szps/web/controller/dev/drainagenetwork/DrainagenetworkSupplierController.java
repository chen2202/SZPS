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
import com.szps.common.core.domain.Ztree;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.dev.Supplier;
import com.szps.web.service.dev.ISupplierService;
/**
 * BO设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/drainagenetworksupplier")
public class DrainagenetworkSupplierController extends BaseController {
	 @Autowired
	private ISupplierService service;
	
	private String prefix = "/dev/drainagenetwork/supplier";
	
    @RequiresPermissions("dev:drainagenetworksupplier:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:drainagenetworksupplier:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Supplier obj)
    {
        startPage();
        obj.setStype(1);
        List<Supplier> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    @RequiresPermissions("dev:drainagenetworksupplier:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Supplier obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
    	obj.setStype(1);
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Supplier obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:drainagenetworksupplier:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Supplier obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:drainagenetworksupplier:delete")
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
    
    @GetMapping("/selectSupplier/{sid}")
    public String selectSupplier(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        mmap.put("obj", service.selectById(sid));
        return prefix + "/tree";
    }
    
    /**
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
    	Supplier supplier = new Supplier();
    	supplier.setStype(1);
        List<Ztree> ztrees = service.selectSuppliertTree(supplier);
        return ztrees;
    }
}

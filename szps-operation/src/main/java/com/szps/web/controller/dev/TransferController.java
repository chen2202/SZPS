package com.szps.web.controller.dev;

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
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.dev.Transfer;
import com.szps.web.service.dev.ITransferService;

@Controller
@RequestMapping("/op/dev/transfer")
public class TransferController extends BaseController {
	 @Autowired
	private ITransferService service;
	
	private String prefix = "/dev/transfer";
	
    @RequiresPermissions("dev:transfer:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:transfer:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Transfer obj)
    {
        startPage();
        List<Transfer> list = service.selectList(obj);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("dev:transfer:add")
    @Log(title = "添加日报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Transfer obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	SysDept sysDept = user.getDept();
//    	obj.setDeptId(sysDept.getDeptId());
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
    	obj.setDelFlag(Transfer.DEL_FLAG_NORMAL);
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Transfer obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "日报修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:transfer:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Transfer obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:transfer:delete")
    @Log(title = "日报删除", businessType = BusinessType.DELETE)
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

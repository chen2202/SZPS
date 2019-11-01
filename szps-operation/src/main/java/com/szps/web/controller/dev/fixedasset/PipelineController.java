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
import com.szps.web.domain.dev.fixedasset.Pipeline;
import com.szps.web.service.dev.fixedasset.IPipelineService;

@Controller
@RequestMapping("/op/fixedasset/pipeline")
public class PipelineController extends BaseController {
	 @Autowired
	private IPipelineService service;
	
	private String prefix = "/fixedasset";
	
    @RequiresPermissions("fixedasset:pipeline:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/pipelineview";
    }
    
    /**
     */
    @RequiresPermissions("fixedasset:pipeline:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pipeline obj)
    {
        startPage();
        List<Pipeline> list = service.selectList(obj);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/pipelineadd";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("fixedasset:pipeline:add")
    @Log(title = "添加固定资产-管道和沟槽", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( Pipeline obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	Pipeline obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/pipelineedit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "固定资产-管道和沟槽修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("fixedasset:pipeline:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Pipeline obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("fixedasset:pipeline:delete")
    @Log(title = "固定资产-管道和沟槽删除", businessType = BusinessType.DELETE)
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

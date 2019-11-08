package com.szps.web.controller.system;

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
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysPurPlant;
import com.szps.system.service.ISysPurPlantService;


@Controller
@RequestMapping("/system/purplant")
public class SysPurPlantController extends BaseController
{
    private String prefix = "system/purplant";

    @Autowired
    private ISysPurPlantService purplantService;

    @RequiresPermissions("system:purplant:view")
    @GetMapping()
    public String purplant()
    {
        return prefix + "/purplant";
    }

    @RequiresPermissions("system:purplant:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysPurPlant> list(SysPurPlant purplant)
    {
        List<SysPurPlant> purplantList = purplantService.selectPurPlantList(purplant);
        return purplantList;
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        mmap.put("purplant", purplantService.selectPurPlantById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:purplant:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysPurPlant purplant)
    {
        purplant.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(purplantService.insertPurPlant(purplant));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{purplantId}")
    public String edit(@PathVariable("purplantId") Long purplantId, ModelMap mmap)
    {
        SysPurPlant purplant = purplantService.selectPurPlantById(purplantId);
        if (StringUtils.isNotNull(purplant) && 100L == purplantId)
        {
            purplant.setParentName("无");
        }
        mmap.put("purplant", purplant);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:purplant:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysPurPlant purplant)
    {
        if (purplant.getParentId().equals(purplant.getPlantId()))
        {
            return error("修改'" + purplant.getPlantName() + "'失败，上级不能是自己");
        }
        purplant.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(purplantService.updatePurPlant(purplant));
    }

    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:purplant:remove")
    @GetMapping("/remove/{purplantId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("purplantId") Long purplantId)
    {
        if (purplantService.selectPurPlantCount(purplantId) > 0)
        {
            return AjaxResult.warn("存在下级区域,不允许删除");
        }
        return toAjax(purplantService.deletePurPlantById(purplantId));
    }


    /**
     * 选择区域树
     */
    @GetMapping("/selectPurPlantTree/{purplantId}")
    public String selectPurPlantTree(@PathVariable("purplantId") Long purplantId, ModelMap mmap)
    {
        mmap.put("purplant", purplantService.selectPurPlantById(purplantId));
        return prefix + "/tree";
    }

    /**
     * 加载区域列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = purplantService.selectPurPlantTree(new SysPurPlant());
        return ztrees;
    }
}

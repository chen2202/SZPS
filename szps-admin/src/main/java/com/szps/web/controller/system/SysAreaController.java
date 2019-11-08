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
import com.szps.common.constant.UserConstants;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.domain.Ztree;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysArea;
import com.szps.system.domain.SysRole;
import com.szps.system.service.ISysAreaService;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/area")
public class SysAreaController extends BaseController
{
    private String prefix = "system/area";

    @Autowired
    private ISysAreaService areaService;

    @RequiresPermissions("system:area:view")
    @GetMapping()
    public String area()
    {
        return prefix + "/area";
    }

    @RequiresPermissions("system:area:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysArea> list(SysArea area)
    {
        List<SysArea> areaList = areaService.selectAreaList(area);
        return areaList;
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        mmap.put("area", areaService.selectAreaById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:area:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysArea area)
    {
        area.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(areaService.insertArea(area));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{areaId}")
    public String edit(@PathVariable("areaId") Long areaId, ModelMap mmap)
    {
        SysArea area = areaService.selectAreaById(areaId);
        if (StringUtils.isNotNull(area) && 100L == areaId)
        {
            area.setParentName("无");
        }
        mmap.put("area", area);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:area:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysArea area)
    {
        if (area.getParentId().equals(area.getAreaId()))
        {
            return error("修改'" + area.getAreaName() + "'失败，上级不能是自己");
        }
        area.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(areaService.updateArea(area));
    }

    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:area:remove")
    @GetMapping("/remove/{areaId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("areaId") Long areaId)
    {
        if (areaService.selectAreaCount(areaId) > 0)
        {
            return AjaxResult.warn("存在下级区域,不允许删除");
        }
        return toAjax(areaService.deleteAreaById(areaId));
    }


    /**
     * 选择区域树
     */
    @GetMapping("/selectAreaTree/{areaId}")
    public String selectAreaTree(@PathVariable("areaId") Long areaId, ModelMap mmap)
    {
        mmap.put("area", areaService.selectAreaById(areaId));
        return prefix + "/tree";
    }

    /**
     * 加载区域列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = areaService.selectAreaTree(new SysArea());
        return ztrees;
    }
}

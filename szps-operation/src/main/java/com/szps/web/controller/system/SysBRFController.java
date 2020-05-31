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
import com.szps.system.domain.SysBRF;
import com.szps.system.service.ISysBRFService;

/**
 * 部门信息
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/system/brf")
public class SysBRFController extends BaseController
{
    private String prefix = "system/brf";

    @Autowired
    private ISysBRFService brfService;

    @RequiresPermissions("system:brf:view")
    @GetMapping()
    public String brf()
    {
        return prefix + "/brf";
    }

    @RequiresPermissions("system:brf:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysBRF> list(SysBRF brf)
    {
        List<SysBRF> brfList = brfService.selectList(brf);
        return brfList;
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        mmap.put("brf", brfService.selectById(parentId));
        return prefix + "/add";
    }

    /**
     * 新增保存
     */
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @RequiresPermissions("system:brf:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated SysBRF brf)
    {
        brf.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(brfService.insert(brf));
    }

    /**
     * 修改
     */
    @GetMapping("/edit/{brfId}")
    public String edit(@PathVariable("brfId") Long brfId, ModelMap mmap)
    {
        SysBRF brf = brfService.selectById(brfId);
        if (StringUtils.isNotNull(brf) && 100L == brfId)
        {
            brf.setParentName("无");
        }
        mmap.put("brf", brf);
        return prefix + "/edit";
    }

    /**
     * 保存
     */
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @RequiresPermissions("system:brf:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated SysBRF brf)
    {
        if (brf.getParentId().equals(brf.getBrfId()))
        {
            return error("修改'" + brf.getBrfName() + "'失败，上级不能是自己");
        }
        brf.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(brfService.update(brf));
    }

    /**
     * 删除
     */
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @RequiresPermissions("system:brf:remove")
    @GetMapping("/remove/{brfId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("brfId") Long brfId)
    {
        if (brfService.selectCount(brfId) > 0)
        {
            return AjaxResult.warn("存在下级区域,不允许删除");
        }
        return toAjax(brfService.deleteById(brfId));
    }


    /**
     * 选择区域树
     */
    @GetMapping("/selectTree/{brfId}")
    public String selectTree(@PathVariable("brfId") Long brfId, ModelMap mmap)
    {
        mmap.put("brf", brfService.selectById(brfId));
        return prefix + "/tree";
    }

    /**
     * 加载区域列表树
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = brfService.selectTree(new SysBRF());
        return ztrees;
    }
}

package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.supervise.TbRule;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.service.supervise.RuleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/supervise/data2")
public class Data2Controller extends BaseController {

    @Autowired
    private RuleService ruleService;


    private String prefix = "supervise/data";


    @GetMapping("/data2")
    public String dataview2()
    {
        return prefix+"/Ruledata";
    }


    @RequiresPermissions("supervise:data2:add")
    @Log(title = "随机规则管理", businessType = BusinessType.INSERT)
    @GetMapping("/Ruleadd")
    public String add2()
    {
        return prefix + "/Ruleadd";
    }


    @RequiresPermissions("supervise:data2:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbRule rule)
    {
        startPage();
        List<TbRule> list = ruleService.selectRuleList(rule);
        return getDataTable(list);
    }


    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbRule rule)
    {
        int radomInt = new Random().nextInt(999999);
        rule.setRuleNumber(String.valueOf(radomInt));
        return toAjax(ruleService.insertRule(rule));
    }

    @RequiresPermissions("supervise:data2:edit")
    @GetMapping("/edit/{ruleNumber}")
    public String edit(@PathVariable("ruleNumber") String ruleNumber, ModelMap mmap)
    {
        mmap.put("rule", ruleService.selectRuleById(ruleNumber));

        return prefix + "/Ruleedit";
    }


//    @Log(title = "规则管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated TbRule rule)
    {
        return toAjax(ruleService.updateRule(rule));
    }

    @RequiresPermissions("supervise:data2:remove")
    @Log(title = "规则管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(ruleService.deleteRuleByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    //导出数据
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export()
    {
        List<TbRule> list = ruleService.selectRuleAll();
        ExcelUtil<TbRule> util = new ExcelUtil<TbRule>(TbRule.class);
        return util.exportExcel(list, "事项数据");
    }
}

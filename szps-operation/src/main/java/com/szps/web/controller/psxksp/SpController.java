package com.szps.web.controller.psxksp;


import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.domain.supervise.TbTaskStaff;
import com.szps.web.service.psxksp.EXService;
import com.szps.web.service.supervise.HouseService;
import com.szps.web.service.supervise.StaffService;
import com.szps.web.service.supervise.TaskService;
import com.szps.web.service.supervise.TaskStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/op/permit")
public class SpController extends BaseController {

    @Autowired
    private EXService exService;

    private String prefix = "op/permit";

    @GetMapping("/waiting")
    public String dataview()
    {
        return prefix+"/waiting";
    }

    @GetMapping("/done")
    public String dataview1()
    {
        return prefix+"/done";
    }

    @GetMapping("/remind")
    public String dataview2()
    {
        return prefix+"/remind";
    }

    @GetMapping("/table")
    public String dataview3()
    {
        return prefix+"/table";
    }

    @GetMapping("/statistic")
    public String dataview4()
    {
        return prefix+"/statistic";
    }



    @RequiresPermissions("op:permit:waiting")
    @PostMapping("/waiting")
    @ResponseBody
    public TableDataInfo list(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();

        return getDataTable(list);
    }

    @GetMapping("/edit/{sblsh}")
    public String edit(@PathVariable("sblsh") String sblsh, ModelMap mmap)
    {


        mmap.put("look", exService.selectById(sblsh));

        return prefix + "/looking";
    }

    @RequiresPermissions("op:permit:done")
    @PostMapping("/done")
    @ResponseBody
    public TableDataInfo listDone(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();

        return getDataTable(list);
    }

    @GetMapping("/editDone/{sblsh}")
    public String editDone(@PathVariable("sblsh") String sblsh, ModelMap mmap)
    {


        mmap.put("look", exService.selectById(sblsh));

        return prefix + "/Donelooking";
    }


    @RequiresPermissions("op:permit:remind")
    @PostMapping("/remind")
    @ResponseBody
    public TableDataInfo listRemind(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();
        list.get(0).setBYZD1("2019-11-22");
        list.get(1).setBYZD1("2020-10-22");
        list.get(2).setBYZD1("2019-12-25");
        list.get(3).setBYZD1("2021-11-22");
        return getDataTable(list);
    }


    @RequiresPermissions("op:permit:table")
    @PostMapping("/table")
    @ResponseBody
    public TableDataInfo listTable(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();
        list.get(0).setBYZD2("南山区");
        list.get(1).setBYZD2("罗湖区");
        list.get(2).setBYZD2("福田区");
        list.get(3).setBYZD2("盐田区");
        return getDataTable(list);
    }

    @GetMapping("/editTable/{sblsh}")
    public String editTable(@PathVariable("sblsh") String sblsh, ModelMap mmap)
    {


        mmap.put("look", exService.selectById(sblsh));

        return prefix + "/Tablelooking";
    }


    @RequiresPermissions("op:permit:statistic")
    @PostMapping("/statistic")
    @ResponseBody
    public TableDataInfo listStatistic(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();
        list.get(0).setBYZD3("测试1");
        list.get(1).setBYZD3("测试2");
        list.get(2).setBYZD3("测试3");
        list.get(3).setBYZD3("测试4");
        return getDataTable(list);
    }
}

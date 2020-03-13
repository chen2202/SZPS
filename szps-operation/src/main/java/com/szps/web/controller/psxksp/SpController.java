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

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @GetMapping("/list")
    public String dataview5()
    {
        return prefix+"/list";
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

    @GetMapping("/main")
    public String index() {
        return prefix+"/main";
    }

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @RequiresPermissions("op:permit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();

        return getDataTable(list);
    }

    @RequiresPermissions("op:permit:waiting")
    @PostMapping("/waiting")
    @ResponseBody
    public TableDataInfo waiting(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskWaiting();

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
        List<EX_GDBS_SB> list = exService.selectTaskDone();

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

        String remindtime=exGdbsSb.getBYZD1();
        if(remindtime!=null&&!Objects.equals(remindtime, ""))
        {
            int t= Integer.parseInt(remindtime);
            Date now = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(now);
            c.add(Calendar.MONTH,t);
            Date newDate =  c.getTime();
            startPage();
            List<EX_GDBS_SB> lists = exService.selectTaskBytime(DATE_FORMAT.format(newDate));
            return getDataTable(lists);
        }else {
            startPage();
            List<EX_GDBS_SB> list = exService.selectTaskAll();
            return getDataTable(list);
        }
    }


    @RequiresPermissions("op:permit:table")
    @PostMapping("/table")
    @ResponseBody
    public TableDataInfo listTable(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskAll();
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
        return getDataTable(list);
    }
}

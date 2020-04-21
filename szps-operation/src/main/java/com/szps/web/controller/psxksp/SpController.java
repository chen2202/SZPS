package com.szps.web.controller.psxksp;


import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.domain.psxksp.test1;
import com.szps.web.domain.psxksp.test2;
import com.szps.web.domain.supervise.TbEnclosure;
import com.szps.web.service.psxksp.EXService;
import com.szps.web.service.supervise.EnclosureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/op/permit")
public class SpController extends BaseController {

    @Autowired
    private EXService exService;
    @Autowired
    private EnclosureService enclosureService;

    private String prefix = "op/permit";

    @GetMapping("/waiting")
    public String dataview()
    {
        return prefix+"/waiting";
    }
    @GetMapping("/edit/op/permit//waiting")
    public String dataview7()
    {
        return prefix+"/waiting";
    }

    @GetMapping("/list")
    public String dataview5(@RequestParam("look") String look,ModelMap mmap)
    {

        mmap.put("look", look);

        mmap.put("ppp", exService.selectById(look));

        return prefix + "/looking";
    }

    @GetMapping("/tables")
    public String dataview8(@RequestParam("look") String look,ModelMap mmap)
    {

        mmap.put("look", look);

        mmap.put("ppp", exService.selectById(look));

        return prefix + "/stable";
    }

    @GetMapping("/sptable")
    public String dataview9(@RequestParam("look") String look,ModelMap mmap)
    {

        mmap.put("look", look);

        mmap.put("ppp", exService.selectById(look));

        return prefix + "/sptable";
    }
    @GetMapping("/cailiao")
    public String dataview10(@RequestParam("look") String look,ModelMap mmap)
    {

        mmap.put("look", look);

        mmap.put("ppp", exService.selectById(look));

        return prefix + "/cailiaotest";
    }

    @GetMapping("/check")
    public String dataview6(@RequestParam("look") String look,ModelMap mmap)
    {

        mmap.put("look", look);



        return prefix + "/check";
    }

    @GetMapping("/done")
    public String dataview1()
    {
        return prefix+"/done";
    }

    @GetMapping("/remind")
    public String dataview2(@RequestParam("look") String look,ModelMap mmap)
    {
        mmap.put("look", look);

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
    @RequiresPermissions("op:permit:lists")
    @PostMapping("/lists")
    @ResponseBody
    public TableDataInfo lists()
    {
        startPage();
        List<test1> list = new ArrayList<test1>();
        test1 a=new test1();
        test1 b=new test1();
        a.setName("李小萌");
        a.setTaskName("分办");
        a.setContent("同意");
        a.setBeginTime("2020-03-19 15:17:55");
        a.setEndTime("2020-03-19 16:23:49");
        a.setLongTime("0天1小时5分53秒");

        b.setName("张倩倩");
        b.setTaskName("承办");
        b.setContent("");
        b.setBeginTime("2020-03-19 16:23:49");
        b.setEndTime("");
        b.setLongTime("");
        list.add(a);
        list.add(b);

        return getDataTable(list);
    }

    @RequiresPermissions("op:permit:lists")
    @PostMapping("/listss")
    @ResponseBody
    public TableDataInfo listss()
    {
        startPage();
        List<test2> list = new ArrayList<test2>();
        test2 a=new test2();
        test2 b=new test2();
        a.setFatherName("事项情形:城市排水许可(建筑工程)(政府投资)");
        a.setTest("");
        b.setFatherName("事项情形:城市排水许可(建筑工程)(政府投资)");
        b.setTest("");
        list.add(a);
        list.add(b);

        return getDataTable(list);
    }

    @RequiresPermissions("op:permit:lists")
    @PostMapping("/listssChild")
    @ResponseBody
    public TableDataInfo listssChild()
    {
        startPage();
        List<TbEnclosure> list = enclosureService.selectRuleAll();
        System.out.println(list.size());
        for (int i=0;i<list.size();i++)
        {
            list.get(i).setFlag("1");
        }


        return getDataTable(list);
    }



    @RequiresPermissions("op:permit:waiting")
    @PostMapping("/waiting")
    @ResponseBody
    public TableDataInfo waiting(EX_GDBS_SB exGdbsSb)
    {
        startPage();

        List<EX_GDBS_SB> list = exService.selectTaskWaiting(exGdbsSb);

        return getDataTable(list);
    }


    @GetMapping("/edit/{sblsh}")
    public String edit( @PathVariable("sblsh")String sblsh,ModelMap mmap)
    {


        mmap.addAttribute("look", sblsh);
        mmap.put("look", sblsh);

        return prefix + "/smallmain";
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

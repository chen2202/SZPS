package com.szps.web.controller.psxksp;


import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.file.FileUtils;
import com.szps.web.controller.common.CommonController;
import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.domain.psxksp.test1;
import com.szps.web.domain.psxksp.test2;
import com.szps.web.domain.supervise.TbEnclosure;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.service.psxksp.EXService;
import com.szps.web.service.supervise.EnclosureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
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

    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

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
    public TableDataInfo waiting(EX_GDBS_SB exGdbsSb)  {

        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskDone(exGdbsSb);
        List<EX_GDBS_SB> lists = new ArrayList<EX_GDBS_SB>();

        String remindtime = exGdbsSb.getOkTime();
        String endTime="";
        if (remindtime != null && !Objects.equals(remindtime, ""))
        {
        int t = Integer.parseInt(remindtime);
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.MONTH, t);
        Date newDate = c.getTime();
        endTime=DATE_FORMAT.format(newDate);

            for (int i=0;i<list.size();i++){

                String []okTime=list.get(i).getBYZD1().split("~");
                //list.get(i).setBeginTime(okTime[1]);
                SimpleDateFormat  dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                Date dateTime1= null;
                Date dateTime2= null;
                try {
                    System.out.println(endTime);
                    dateTime1 = dateFormat.parse(endTime);
                    dateTime2=dateFormat.parse(okTime[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if(dateTime2.compareTo(dateTime1)<0)
                {
                    lists.add(list.get(i));
                }

            }
        }else {
            lists=list;
        }





        return getDataTable(lists);
    }


    @GetMapping("/edit/{sblsh}")
    public String edit( @PathVariable("sblsh")String sblsh,ModelMap mmap)
    {


        mmap.put("look", exService.selectById(sblsh));

        return prefix + "/done";
    }


    @RequiresPermissions("op:permit:done")
    @PostMapping("/done")
    @ResponseBody
    public TableDataInfo listDone(EX_GDBS_SB exGdbsSb)
    {
        startPage();
        List<EX_GDBS_SB> list = exService.selectTaskDone(exGdbsSb);

        return getDataTable(list);
    }

    @GetMapping("/look/{sblsh}")
    public String editDone(@PathVariable("sblsh") String sblsh, ModelMap mmap)
    {


        mmap.put("look", exService.selectById(sblsh));

        return prefix + "/Tablelooking";
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

  /*  @PostMapping("/location")
    @ResponseBody
    public AjaxResult gis( HttpServletRequest request,HttpServletResponse response) {
        String b=request.getParameter("sblsh");
        System.out.println(b);
        EX_GDBS_SB a=exService.selectById(b);

        Map<Object,Object> data = new HashMap<Object, Object>();
        data.put("WD1", a.getWD1());
        data.put("WD2", a.getWD2());
        data.put("JD1", a.getJD1());
        data.put("JD2",a.getJD2());
        return AjaxResult.success("success",data);

    }*/


    @GetMapping("/download")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request)
    {
        String sblsh=request.getParameter("sblsh");
        EX_GDBS_SB tb=exService.selectById(sblsh);
        String fileName1=tb.getFilePath();

        String fileName=fileName1.replace("/profile"+ File.separator+"upload","");
        try
        {
            String filePath = Global.getUploadPath()+ fileName;
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, fileName));

            FileUtils.writeBytes(filePath, response.getOutputStream());

        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }


    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated EX_GDBS_SB ex)
    {
        return toAjax(exService.updateEx(ex));
    }



}

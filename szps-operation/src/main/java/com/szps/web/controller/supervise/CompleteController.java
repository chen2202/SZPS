package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;

import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;

import com.szps.common.enums.BusinessType;
import com.szps.common.utils.file.FileUtils;
import com.szps.web.controller.common.CommonController;
import com.szps.web.domain.supervise.*;
import com.szps.web.service.supervise.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.DecimalFormat;
import java.util.*;


@Controller
@RequestMapping("/supervise/complete")
public class CompleteController extends BaseController {

    @Autowired
    private TaskService Service;


    @Autowired
    private TaskStaffService taskStaffService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private HouseService houseService;
    @Autowired
    private RuleService ruleService;

    @Autowired
    private PictureService pictureService;



    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Value("${szps.profile}")
    private String filePath;

    private String prefix = "supervise/complete";
    @GetMapping("/complete")
    public String dataview()
    {
        return prefix+"/TaskComplete";
    }

    /*@GetMapping("/TaskFeedback")
    public String TaskCheck(HttpServletRequest request)
    {
        int radomInt = new Random().nextInt(999999);
        String s=String.valueOf(radomInt);
        while (Service.checkfb(s)==1)
        {
            s=String.valueOf(new Random().nextInt(999999));
        }

        request.setAttribute("feedbackId",s);
        return prefix + "/TaskFeedback";
    }*/
     @PostMapping("/getRate")
     @ResponseBody
     public AjaxResult getRate(TbTask tbTask){
         String time="";
         String year="";
         Map<String,Object> mmap= new HashMap<>();
         int count=Service.selectTaskCountComplete();
         int all=houseService.selectHouseCount();
         String reach="无";
         String rate;

         String bl=ruleService.selectRuleByRuleName(tbTask.getRuleName());
         //选择了规则和年月
         if(tbTask.getBeginTime()!=""&&tbTask.getRuleName()!="")
         {

             year=tbTask.getBeginTime().substring(0,4);
             tbTask.setBeginTime(year);

             count=Service.selectTaskCountCompleteWithKey(tbTask);

//             year=tbTask.getBeginTime().substring(0,4);
//             tbTask.setBeginTime(year);

             all=houseService.selectHouseCount();
             float kk=0.0f;



             if(all>0)
             {
                 kk=(float)count/all;



             }
             DecimalFormat df = new DecimalFormat("#.00");

             if(kk==0.0)
             {
                 rate="0%";
             }else {
                 rate = df.format(kk * 100) + "%";
             }

                 reach =bl ;

         }
         //选了规则年月不选
         else if(tbTask.getBeginTime()==""&&tbTask.getRuleName()!=""){

             count=Service.selectTaskCountCompleteWithKey(tbTask);
             float kk=0.0f;
             if(all>0)
              kk=(float)count/all;
             DecimalFormat df = new DecimalFormat("#.00");

             if(kk==0.0)
             {
                 rate="0%";
             }else
             {
                 rate=df.format(kk*100)+"%";
             }
             reach =bl ;

         }
         //选了年月规则不选
         else if(tbTask.getBeginTime()!=""&&tbTask.getRuleName()==""){

             year=tbTask.getBeginTime().substring(0,4);
             tbTask.setBeginTime(year);
             count=Service.selectTaskCountCompleteWithKey(tbTask);
             all=houseService.selectHouseCount();
             float kk=0.0f;

             if(all>0)
             {
                 kk=(float)count/all;
             }
             DecimalFormat df = new DecimalFormat("#.00");

             if(kk==0.0)
             {
                 rate="0%";
             }else {
                 rate = df.format(kk * 100) + "%";
             }
         }else {
             float kk=0.0f;
             if(all>0)
                 kk=(float)count/all;
             DecimalFormat df = new DecimalFormat("#.00");

             if(kk==0.0)
             {
                 rate="0%";
             }else
             {
                 rate=df.format(kk*100)+"%";
             }
         }







        mmap.put("rate",rate);
        mmap.put("count",count);
        mmap.put("all",all);
        mmap.put("reach",reach);
         return AjaxResult.success("success",mmap);
     }
    @RequiresPermissions("supervise:complete:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbTask tbTask)
    {


        String time="";
        if(tbTask.getBeginTime()!="")
        {

             time=tbTask.getBeginTime().substring(0,7);
            System.out.println(time);
        }
        tbTask.setBeginTime(time);
        tbTask.setTaskFlag("完成");
        startPage();
        List<TbTask> list = Service.selectTaskList(tbTask);

        for(int i=0;i<list.size();i++)
        {
            String a=list.get(i).getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse=houseService.selectHouseById(a);


            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                //System.out.println(tbTaskStaffs.get(k));
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "一类"))
                    tbStaffs.add(staff);
            }
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                //System.out.println(tbTaskStaffs.get(k));
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "二类"))
                    tbStaffs.add(staff);
            }
            list.get(i).setTbStaffList(tbStaffs);
            list.get(i).setTbHouse(tbHouse);

        }



        return getDataTable(list);

    }
    @RequiresPermissions("supervise:complete:edit")
    @GetMapping("/edit/{taskNumber}")
    public String edit(@PathVariable("taskNumber") String taskNumber, ModelMap mmap)
    {

        TbTask task=Service.selectTaskById(taskNumber);

            String c=task.getTaskHouse();
            //System.out.println(a);
            TbHouse tbHouse=houseService.selectHouseById(c);
            String b=tbHouse.getHouseRule();
            task.setRuleContent(ruleService.selectRuleByRuleName(b));


            task.setTbHouse(tbHouse);


        List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(taskNumber);
        String a="【一类】";
        boolean f=false;
        for(int k=0;k<tbTaskStaffs.size();k++)
        {
            TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
            if(staff!=null&& staff.getStaffPost().equals("一类"))
            {
                if(f)
                {
                    a=a+",";
                }
                a=a+(staff.getStaffName());
                f=true;
            }

        }
        boolean ff=false;
        for(int k=0;k<tbTaskStaffs.size();k++)
        {
            TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
            if(staff!=null&& staff.getStaffPost().equals("二类"))
            {
                a=a+"【二类】";
                if(ff)
                {
                    a=a+",";
                }
                a=a+(staff.getStaffName());
                ff=true;
            }

        }

        mmap.put("task", task);
        mmap.put("taskStaff",a);

        return prefix + "/Taskedit";
    }



    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated TbTask task)
    {
        if(task.getTaskResult()!=""||task.getTaskCheckTime()!=""||task.getTaskHandle()!="")
        task.setTaskFlag("完成");
        return toAjax(Service.updateTask(task));
    }

    @RequiresPermissions("supervise:complete:edit")
    @GetMapping("/lookPic/{taskNumber}")
    public String lookPic(@PathVariable("taskNumber") String taskNumber, ModelMap mmap)
    {
        mmap.put("task",taskNumber);
        return prefix + "/pictureLook";
    }
    @PostMapping("/getPic")
    @ResponseBody
    public AjaxResult getPic(HttpServletRequest request){
         String taskNumber=request.getParameter("taskNumber");
        return AjaxResult.success("success",pictureService.selectPictureById(taskNumber));
    }


   /* @RequiresPermissions("supervise:complete:add")
    @Log(title = "已完成任务管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbFeedback data)
    {
        return toAjax( Service.insertTask(data));
    }*/





    /*@PostMapping("/uploadPicture")
    @ResponseBody
    public AjaxResult uploadPicture(@RequestParam("picture") MultipartFile []multipartFile,@RequestParam("feedbackId")String feedbackId){
        try {
        if(multipartFile.length==0){
            return error("文件为空,上传失败");
        }
        String filePath = Global.getUploadPath();
        String fileName[] = new String[10];
        String url[] = new String[10];
        System.out.println(filePath);
        for(int i=0;i<multipartFile.length;i++){
            fileName[i]=FileUploadUtils.upload(filePath, multipartFile[i]);
            url[i]="/profile"+fileName[i];

            int radomInt = new Random().nextInt(999999);
            String s=String.valueOf(radomInt);
            while (pictureService.checkPicture(s)==1)
            {
                s=String.valueOf(new Random().nextInt(999999));
            }
            TbPicture picture=new TbPicture();
            picture.setFeedbackId(feedbackId);
            picture.setPictureId(s);
            picture.setPictureLocation(url[i]);
            picture.setPictureName(multipartFile[i].getOriginalFilename());
            pictureService.insertRule(picture);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }
    @PostMapping("/uploadEnclosure")
    @ResponseBody
    public AjaxResult uploadEnclosure(@RequestParam("enclosure") MultipartFile []multipartFile,@RequestParam("feedbackId")String feedbackId){
        try {
            if(multipartFile.length==0){
                return error("文件为空,上传失败");
            }
            String filePath = Global.getUploadPath();

            String fileName[] = new String[10];
            String url[] = new String[10];
            System.out.println(filePath);
            for(int i=0;i<multipartFile.length;i++){
                fileName[i]=FileUploadUtils.upload(filePath, multipartFile[i]);
                System.out.println(fileName[i]);
                url[i]= "/profile"+fileName[i];
                int radomInt = new Random().nextInt(999999);
                String s=String.valueOf(radomInt);
                while (enclosureService.checkEnclosure(s)==1)
                {
                    s=String.valueOf(new Random().nextInt(999999));
                }
                TbEnclosure enclosure=new TbEnclosure();
                enclosure.setEnclosureId(s);
                enclosure.setEnclosureLocation(url[i]);
                enclosure.setEnclosureName(multipartFile[i].getOriginalFilename());
                enclosure.setFeedbackId(feedbackId);
                enclosureService.insertEnclosure(enclosure);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }
*/
    /*@RequiresPermissions("supervise:complete:remove")
    @Log(title = "任务管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(Service.deleteTaskByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }*/
    @RequiresPermissions("supervise:complete:download")
    @GetMapping("/download")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request)
    {
        String taskNumber=request.getParameter("taskNumber");
        TbTask tb=Service.selectTaskById(taskNumber);
        String fileName1=tb.getTaskFile();

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

    /*@PostMapping("/checkTask")
    @ResponseBody
    public String checkTaskUnique(@RequestParam("taskNumber")String taskNumber) {

        JSONObject json = new JSONObject();
        if (Service.checkTaskUnique(taskNumber) == 1)
        {
            json.fluentPut("code", 200);

        }else
        {
            json.fluentPut("code", 100);
        }
        return json.toString();
    }*/
}

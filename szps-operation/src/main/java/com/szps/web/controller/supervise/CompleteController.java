package com.szps.web.controller.supervise;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.config.ServerConfig;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.common.utils.file.FileUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysUser;
import com.szps.web.controller.common.CommonController;
import com.szps.web.domain.supervise.*;

import com.szps.web.service.supervise.*;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/supervise/complete")
public class CompleteController extends BaseController {

    @Autowired
    private FeedbackService Service;


    @Autowired
    private PictureService pictureService;

    @Autowired
    private EnclosureService enclosureService;

    @Autowired
    private TaskStaffService taskStaffService;

    @Autowired
    private StaffService staffService;


    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Value("${szps.profile}")
    private String filePath;

    private String prefix = "supervise/complete";
    @GetMapping("/complete")
    public String dataview()
    {
        return prefix+"/TaskComplete";
    }

    @GetMapping("/TaskFeedback")
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
    }

    @RequiresPermissions("supervise:complete:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbFeedback tbTask)
    {
        startPage();
        List<TbFeedback> list = Service.selectTaskList(tbTask);
        for (TbFeedback aList : list) {
            List<TbPicture> list1 = pictureService.selectPictureById(aList.getFeedbackId());
            List<TbEnclosure> list2 = enclosureService.selectEnclosureById(aList.getFeedbackId());
            aList.setPictureList(list1);
            aList.setEnclosureList(list2);
        }

        for(int i=0;i<list.size();i++)
        {

            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
            for(int k=0;k<tbTaskStaffs.size();k++)
            {

                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null)
                    tbStaffs.add(staff);
            }
            list.get(i).setTbStaffList(tbStaffs);
        }

        return getDataTable(list);

    }
    @RequiresPermissions("supervise:complete:add")
    @Log(title = "已完成任务管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbFeedback data)
    {
        return toAjax( Service.insertTask(data));
    }





    @PostMapping("/uploadPicture")
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

    @RequiresPermissions("supervise:complete:remove")
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
    }

    @GetMapping("/download")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request)
    {
        String enclosureId=request.getParameter("enclosureId");
        TbEnclosure tb=enclosureService.selectEnclosureByIds(enclosureId);
        String fileName1=tb.getEnclosureLocation();
        String fileRealName=tb.getEnclosureName();
        String fileName=fileName1.replace("/profile"+File.separator+"upload","");
        try
        {
            String filePath = Global.getUploadPath()+ fileName;
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, fileRealName));

            FileUtils.writeBytes(filePath, response.getOutputStream());

        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    @PostMapping("/checkTask")
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
    }
}

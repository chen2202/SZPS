package com.szps.web.controller.wechat;


import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.web.domain.check.PlantCheckDevice;
import com.szps.web.domain.check.PlantCheckRecord;
import com.szps.web.domain.drainage.Household;
import com.szps.web.domain.event.EventEmail;
import com.szps.web.domain.event.EventSend;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.domain.supervise.*;
import com.szps.web.service.check.IPlantCheckContentService;
import com.szps.web.service.check.IPlantCheckDeviceService;
import com.szps.web.service.check.IPlantCheckRecordService;
import com.szps.web.service.drainage.HouseholdService;
import com.szps.web.service.event.IEventSubmitService;
import com.szps.web.service.supervise.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class WeChatController extends BaseController {

    @Autowired
    private IPlantCheckRecordService plantCheckRecordService;

    @Autowired
    private IEventSubmitService eventSubmitService;

    @Autowired
    private HouseholdService householdService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private TaskStaffService taskStaffService;

    @Autowired
    private IPlantCheckContentService plantCheckContentService;

    @Autowired
    private IPlantCheckDeviceService plantCheckDeviceService;


    @Autowired
    private PictureService pictureService;

    @Autowired
    private FeedbackService Service;


    /**
     *  突发事件上传接口
     */

    @PostMapping("/eventsubmit")
    @ResponseBody
    public AjaxResult eventsubmit(String eventname, String eventplace, Date eventtime, String eventcontent, String eventattribute
            , String eventcreateuser, Date eventcreatetime) throws ParseException {

        EventSubmit eventSubmit = new EventSubmit(eventname, eventplace, eventtime, eventcontent, eventattribute, eventcreateuser, eventcreatetime, "未发送");
        return toAjax(eventSubmitService.insertEventSubmit(eventSubmit));
    }


    /**
     *  污水厂巡检上传接口
     */

    @PostMapping("/plantadd")
    @ResponseBody
    public AjaxResult plantadd(String plantId, String plantName, String deviceID, String deviceName, String checkID, String sloveRecode, Date checkDate,
                               String Screateuser, Date  Screatetime) throws ParseException {
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1=sdf.parse(checkDate);
//        Date date2=sdf.parse(Screatetime);
        PlantCheckRecord plantCheckRecord = new PlantCheckRecord(plantId, plantName, deviceID, deviceName, checkID, sloveRecode, checkDate,
                Screateuser, Screatetime);
        return toAjax(plantCheckRecordService.insertPlantCheckRecord(plantCheckRecord));

    }




    @PostMapping("/houseuser")
    @ResponseBody
    public TableDataInfo list(Household household) {
        List<Household> list = householdService.selectAllHousehold(household);
        return getDataTable(list);
    }

    @PostMapping(value = "/plantList")
    @ResponseBody
    public List<PlantCheckDevice> getPlant(PlantCheckDevice plantCheckDevice){
        List<PlantCheckDevice> plantList = new ArrayList<>();
        plantList = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        return plantList;
    }

    @PostMapping(value = "/eventAttrList")
    @ResponseBody
    public List<EventSend> getAttriList(){
        List<EventSend> emailList = eventSubmitService.getEventSendEmail();
        return  emailList;
    }



    /**
     *  获取排水监督检查任务接口
     */
    @PostMapping("/check")
    @ResponseBody
    public TableDataInfo list(TbTask tbTask){
        List<TbTask> list = taskService.selectTaskList(tbTask);
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




    /**
     *  排水监督检查反馈文字上传接口
     */
    @PostMapping(value = "/upload")
    @ResponseBody

    public String upload(@RequestParam("TaskNumber")String Tasknumber,
                         @RequestParam("FeedbackInf")String feedbackInf) throws ParseException {
        System.out.println(Tasknumber+feedbackInf);
        int radomInt = new Random().nextInt(999999);
        String s=String.valueOf(radomInt);
        while (Service.checkfb(s)==1)
        {
            s=String.valueOf(new Random().nextInt(999999));
        }
//
////
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String NowTime=simpleDateFormat.format(new Date());
        TbFeedback tbFeedback=new TbFeedback();
        tbFeedback.setFeedbackId(s);
        tbFeedback.setFeedbackInformation(feedbackInf);
        tbFeedback.setTaskNumber(Tasknumber);
        tbFeedback.setFeedbackTime(NowTime);
        Service.insertTask(tbFeedback);
        return s;
    }



    /**
     *  排水监督检查反馈图片上传接口
     */
    @PostMapping( value = "/uploadPicture")
    @ResponseBody
    public AjaxResult uploadPicture(@RequestParam("picture") MultipartFile []multipartFile,@RequestParam(required=true)String feedbackId){
        try {
            if(multipartFile.length==0){
                return error("文件为空,上传失败");
            }
            String filePath = Global.getUploadPath();
            String fileName[] = new String[10];
            String url[] = new String[10];
            for(int i=0;i<multipartFile.length;i++){
                fileName[i]=FileUploadUtils.upload(filePath, multipartFile[i]);
                url[i]= fileName[i];
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
}

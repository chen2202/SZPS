package com.szps.web.controller.wechat;


import com.szps.common.config.Global;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysArea;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysRole;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysDeptService;
import com.szps.web.config.Picture;
import com.szps.web.domain.event.EventLists;
import com.szps.web.domain.event.EventPicture;
import com.szps.web.domain.event.EventSubmit;
import com.szps.web.service.event.IEventSubmitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.szps.common.utils.file.FileUploadUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.szps.common.core.domain.AjaxResult.error;
import static com.szps.common.core.domain.AjaxResult.success;

@Controller
@RequestMapping(value = "/admin/eventUpload")
public class EventUploadController {


    @Autowired
    private IEventSubmitService iEventSubmitService;

    @Autowired
    private ISysDeptService iSysDeptService;

    @Autowired
    private LoginController loginController;

    @Autowired
    private Picture picture;


    /**
     * 获取突发事件列表
     *
     * @return
     */
    @PostMapping(value = "/eventLists")
    @ResponseBody
    public List<EventLists> getEventLists(@RequestBody Map<String, Object> params) {


        //获取时间
        String time = params.get("time").toString();

        //从方法中获取
        List<EventSubmit> eventSubmits = getEventSubmits();

        List<EventLists> eventLists = new ArrayList<>();

        if (time.equals("请选择日期")) {
            for (EventSubmit submit : eventSubmits) {

                EventPicture eventPicture = new EventPicture();
                eventPicture.setEventSid(submit.getEventSId());

                List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);

                EventLists lists = new EventLists();
                lists.setEventSubmit(submit);
                lists.setList(pictures);
                //服务器图片路径
                lists.setList(getPictures(pictures));

                eventLists.add(lists);
            }
        } else {
            for (EventSubmit submit : eventSubmits) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String eventTime = sdf.format(submit.getEventTime());
                if (eventTime.contains(time)) {
                    EventPicture eventPicture = new EventPicture();
                    eventPicture.setEventSid(submit.getEventSId());
                    List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);

                    EventLists lists = new EventLists();
                    lists.setEventSubmit(submit);
                    lists.setList(pictures);

                    //服务器图片路径
                    lists.setList(getPictures(pictures));

                    eventLists.add(lists);
                }
            }
        }

        return eventLists;
    }


    /**
     * 搜索突发事件
     *
     * @return
     */
    @PostMapping(value = "/searchEventLists")
    @ResponseBody
    public List<EventLists> getSearchEventLists(@RequestBody Map<String, Object> params) {


        String time = params.get("time").toString();
        String value = params.get("value").toString();


        List<EventSubmit> eventSubmits = getEventSubmits();

        List<EventLists> eventLists = new ArrayList<>();

        if (time.equals("请选择日期")) {
            for (EventSubmit submit : eventSubmits) {

                if (submit.getEventName().contains(value)) {


                    EventPicture eventPicture = new EventPicture();
                    eventPicture.setEventSid(submit.getEventSId());
                    List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);


                    EventLists lists = new EventLists();
                    lists.setEventSubmit(submit);
                    lists.setList(pictures);
                    //服务器图片路径
                    lists.setList(getPictures(pictures));

                    eventLists.add(lists);
                }

            }
        } else {
            for (EventSubmit submit : eventSubmits) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String eventTime = sdf.format(submit.getEventTime());
                if (eventTime.contains(time) && submit.getEventName().contains(value)) {
                    EventPicture eventPicture = new EventPicture();
                    eventPicture.setEventSid(submit.getEventSId());
                    List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);


                    EventLists lists = new EventLists();
                    lists.setEventSubmit(submit);
                    lists.setList(pictures);
                    //服务器图片路径
                    lists.setList(getPictures(pictures));

                    eventLists.add(lists);
                }
            }
        }

        return eventLists;
    }

    /**
     * 图片路径转为服务器图片路径
     *
     * @param pictures
     * @return
     */
    protected List<EventPicture> getPictures(List<EventPicture> pictures) {

        for (EventPicture eventPicture : pictures) {
            String url = eventPicture.getEventPictureUrl();
            url = picture.getUrl(url);
            eventPicture.setEventPictureUrl(url);
        }
        return pictures;
    }

    /**
     * 不同的角色获取不同的突发事件列表
     *
     * @return
     */
    protected List<EventSubmit> getEventSubmits() {
        EventSubmit eventSubmit = new EventSubmit();
        //获取管理员级别
        SysUser user = ShiroUtils.getSysUser();
        SysDept sysDept = iSysDeptService.selectDeptById(user.getDeptId());

        List<EventSubmit> eventSubmits = new ArrayList<>();


        SysArea s = new SysArea();
        //判断角色
        if (loginController.getSysRole().equals("市水务局人员") || loginController.getSysRole().equals("区水务局人员")) {
            if (loginController.getSysRole().equals("市水务局人员")) { //市水务局显示全市突发事件列表
                eventSubmits = iEventSubmitService.selectEventSubmitList(eventSubmit);
            } else {//区水务局显示全区突发事件列表
                eventSubmit.setEventArea(loginController.getUserArea(s));
                eventSubmits = iEventSubmitService.selectEventSubmitList(eventSubmit);
            }
        } else {//运营单位人员显示该单位所有突发事件列表
            eventSubmit.setEventUnit(sysDept.getDeptName());
            eventSubmits = iEventSubmitService.selectEventSubmitList(eventSubmit);
            System.out.println(eventSubmits);
        }


        return eventSubmits;

    }


    /**
     * 突发事件文字上传接口
     *
     * @param eventName
     * @param eventPlace
     * @param eventTime
     * @param eventContent
     * @return
     * @throws ParseException
     */
    @PostMapping(value = "/upload")
    @ResponseBody

    public String upload(@RequestParam("eventName") String eventName, @RequestParam("eventPlace") String eventPlace,
                         @RequestParam("eventTime") String eventTime, @RequestParam("eventContent") String eventContent) throws ParseException {

        System.out.println(eventName + " " + eventPlace + " " + eventTime + " " + eventContent);
        int radomInt = new Random().nextInt(999999);

        //判断编号是否重复
        while (checkEventSid(String.valueOf(radomInt)) == 1) {
            radomInt = new Random().nextInt(999999);
        }
        String s = String.valueOf(radomInt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String ss = sdf.format(date);

        Date date1 = sdf.parse(ss);

        EventSubmit eventSubmit = new EventSubmit();

        SysUser user = ShiroUtils.getSysUser();
        SysDept sysDept = iSysDeptService.selectDeptById(user.getDeptId());


        SysArea sysArea = new SysArea();
        eventSubmit.setEventSId(s);
        eventSubmit.setEventName(eventName);
        eventSubmit.setEventPlace(eventPlace);
        eventSubmit.setEventTime(sdf.parse(eventTime + ":00"));
        eventSubmit.setEventContent(eventContent);
        eventSubmit.setEventSubmitUser(user.getUserName());
        eventSubmit.setEventPhone(user.getPhonenumber());
        eventSubmit.setEventUnit(sysDept.getDeptName());
        eventSubmit.setEventSubmitTime(date1);
        eventSubmit.setEventArea(loginController.getSysDept());

        iEventSubmitService.insertEventSubmit(eventSubmit);

        return s;
    }


    /**
     * 上传突发事件图片
     *
     * @param multipartFile
     * @param feedbackId
     * @return
     */
    @PostMapping(value = "/eventPictureUpload")
    @ResponseBody
    public AjaxResult uploadPicture(@RequestParam("picture") MultipartFile[] multipartFile, @RequestParam(required = true)
            String feedbackId) {
        try {
            if (multipartFile.length == 0) {
                return error("文件为空,上传失败");
            }
            String filePath = Global.getUploadPath();
            String fileName[] = new String[10];
            String url[] = new String[10];
            for (int i = 0; i < multipartFile.length; i++) {

                fileName[i] = FileUploadUtils.upload(filePath, multipartFile[i]);
                url[i] = fileName[i];

                EventPicture picture = new EventPicture();
                picture.setEventSid(feedbackId);
                picture.setEventPictureUrl(url[i]);
                picture.setEventPictureName(multipartFile[i].getOriginalFilename());

                iEventSubmitService.insertEventPicture(picture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }

    /**
     * 判断编号是否重复
     *
     * @param sid
     * @return
     */
    protected int checkEventSid(String sid) {

        EventSubmit eventSubmit = new EventSubmit();

        eventSubmit.setEventSId(sid);

        List<EventSubmit> eventSubmit1 = iEventSubmitService.selectEventSubmitById(eventSubmit);

        if (eventSubmit1.size() == 1) {
            return 1;
        } else {
            return -1;
        }


    }
}

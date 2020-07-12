package com.szps.web.controller.wechat;


import com.szps.common.config.Global;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysRole;
import com.szps.system.domain.SysUser;
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
        String s = String.valueOf(radomInt);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String ss = sdf.format(date);

        Date date1 = sdf.parse(ss);

        EventSubmit eventSubmit = new EventSubmit();

        SysUser user= ShiroUtils.getSysUser();



        eventSubmit.setEventSId(s);
        eventSubmit.setEventName(eventName);
        eventSubmit.setEventPlace(eventPlace);
        eventSubmit.setEventTime(sdf.parse(eventTime + ":00"));
        eventSubmit.setEventContent(eventContent);
        eventSubmit.setEventSubmitUser("Jack");
        eventSubmit.setEventPhone("13088888888");
        eventSubmit.setEventUnit("龙华区二期水质净化厂");
        eventSubmit.setEventSubmitTime(date1);

        iEventSubmitService.insertEventSubmit(eventSubmit);


        return s;
    }


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
                System.out.println(1);
                fileName[i] = FileUploadUtils.upload(filePath, multipartFile[i]);
                url[i] = fileName[i];
                int radomInt = new Random().nextInt(999999);
                String s = String.valueOf(radomInt);
//                while (pictureService.checkPicture(s) == 1) {
//                    s = String.valueOf(new Random().nextInt(999999));
//                }
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
     * 获取突发事件列表
     *
     * @return
     */
    @PostMapping(value = "/eventLists")
    @ResponseBody
    public List<EventLists> getEventLists(@RequestBody Map<String, Object> params) {

        EventSubmit eventSubmit = new EventSubmit();

        String time = params.get("time").toString();


        List<EventSubmit> eventSubmits = iEventSubmitService.selectEventSubmitList(eventSubmit);

        List<EventLists> eventLists = new ArrayList<>();

        if (time.equals("请选择日期")) {
            for (EventSubmit submit : eventSubmits) {

                EventPicture eventPicture = new EventPicture();
                eventPicture.setEventSid(submit.getEventSId());
                List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);

                EventLists lists = new EventLists();
                lists.setEventSubmit(submit);
                lists.setList(pictures);

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

        EventSubmit eventSubmit = new EventSubmit();

        String time = params.get("time").toString();
        String value = params.get("value").toString();


        List<EventSubmit> eventSubmits = iEventSubmitService.selectEventSubmitList(eventSubmit);

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

                    eventLists.add(lists);
                }

            }
        } else {
            for (EventSubmit submit : eventSubmits) {

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String eventTime = sdf.format(submit.getEventTime());
                if (eventTime.contains(time)&&submit.getEventName().contains(value)) {
                    EventPicture eventPicture = new EventPicture();
                    eventPicture.setEventSid(submit.getEventSId());
                    List<EventPicture> pictures = iEventSubmitService.getEventPictures(eventPicture);

                    EventLists lists = new EventLists();
                    lists.setEventSubmit(submit);
                    lists.setList(pictures);

                    eventLists.add(lists);
                }
            }
        }

        return eventLists;
    }
}

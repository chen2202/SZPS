package com.szps.web.controller.wechat;


import com.szps.common.config.Global;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.web.domain.event.EventSubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.szps.common.core.domain.AjaxResult.error;
import static com.szps.common.core.domain.AjaxResult.success;

@Controller
@RequestMapping(value = "eventUpload")
public class EventUploadController {

    @PostMapping(value = "/event/list")
    @ResponseBody
    public List<EventSubmit> getEventList() {

        return null;
    }



    @PostMapping(value = "/eventUpload")
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
                int radomInt = new Random().nextInt(999999);
                String s = String.valueOf(radomInt);
//                while (pictureService.checkPicture(s) == 1) {
//                    s = String.valueOf(new Random().nextInt(999999));
//                }
//                TbPicture picture = new TbPicture();
//                picture.setFeedbackId(feedbackId);
//                picture.setPictureId(s);
//                picture.setPictureLocation(url[i]);
//                picture.setPictureName(multipartFile[i].getOriginalFilename());
//                pictureService.insertRule(picture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success("上传成功!");
    }
}

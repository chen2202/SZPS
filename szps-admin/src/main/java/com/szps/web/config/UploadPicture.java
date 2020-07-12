package com.szps.web.config;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

public class UploadPicture {
    public static final String PICTUREURL = "C:/szpsinfo/uploadfile/";
    public static final String CONFIGUREURL = "https://vx.newground.cn:7000/";

    public String uploadPictureByFile(MultipartFile file) {
        // TODO 自动生成的方法存根
        String filename1 = "picture_" + UUID.randomUUID() + ".jpg";//生成唯一图片路径
        if (!file.isEmpty()) {
            try {
                File filepath = new File(PICTUREURL);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = PICTUREURL + filename1;
                // 转存文件
                file.transferTo(new File(savePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String url = CONFIGUREURL + filename1;
        return url;
    }

}

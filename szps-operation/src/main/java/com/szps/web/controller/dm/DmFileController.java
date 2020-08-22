package com.szps.web.controller.dm;

import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.common.utils.file.FileUtils;
import com.szps.web.domain.dm.DmFile;
import com.szps.web.service.dm.IDmFileService;
import java.util.ArrayList;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.web.multipart.MultipartFile;


/**
 * 规划资料文件管理
 */
@Controller
@RequestMapping("/dm/file")
public class DmFileController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(DmFileController.class);

    private String prefix = "dm/file";

    @Autowired
    private IDmFileService fileService;

    /**
     * 通过uuid查询文件列表
     */
    @PostMapping("/select")
    @ResponseBody
    public TableDataInfo selectFileByDataId(@Param("uuid") String uuid) {
        startPage();
        List<DmFile> list = fileService.selectFileListByUuid(uuid);
        return getDataTable(list);
    }

    /**
     * 文件删除
     */
    @Log(title = "删除资料文件", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(@Param("fileId") Long fileId) {
        try {
            DmFile file = fileService.selectFileById(fileId);
            String filePath = file.getFilePath();
            filePath = Global.getUploadPath() + filePath.replace("/profile/upload", "");
            FileUtils.deleteFile(filePath);

            // 删除资料表信息
            fileService.deleteFileById(fileId);

            return success();
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 通过文件uuid下载
     */
    @Log(title = "通过文件uuid下载", businessType = BusinessType.OTHER)
    @GetMapping("/download/uuid")
    @ResponseBody
    public void downloadByUuid(@RequestParam("uuid") String uuid, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<DmFile> files = fileService.selectFileListByUuid(uuid);

        if (!CollectionUtils.isEmpty(files)) {
            resourceDownload(files, request, response);
        }
    }

    /**
     * 通过文件id列表下载
     */
    @Log(title = "通过文件id列表下载", businessType = BusinessType.OTHER)
    @GetMapping("/download/ids")
    @ResponseBody
    public void downloadByIds(@RequestParam("ids") Long[] ids, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 通过文件编号获取文件
        List<DmFile> files = fileService.selectFileListByIds(ids);

        if (!CollectionUtils.isEmpty(files)) {
            resourceDownload(files, request, response);
        }
    }

    /**
     * 下载
     */
    public void resourceDownload(List<DmFile> files, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String theme = "文件.zip";               // 如果没获取到资料，默认压缩包名为附属文件

        // 压缩
        String zipPath = toZip(files);

        // 下载
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, theme));
        FileUtils.writeBytes(zipPath, response.getOutputStream());

        // 删除压缩包
        FileUtils.deleteFile(zipPath);
    }

    /**
     * 文件压缩
     * zip格式
     * @return 返回压缩包的位置
     */
    public String toZip(List<DmFile> files){
        // 本地资源路径
        String localPath = Global.getUploadPath();

        // 创建压缩包
        String zip_name = UUID.randomUUID().toString().replaceAll("-", "")+".zip";
        String zip_path = localPath +"/"+ zip_name;
        File zip = new File(zip_path);
        if (!zip.exists()) {
            try {
                zip.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 遍历所有要下载的文件，压缩
        ZipOutputStream zos= null;
        BufferedInputStream bis = null;
        try {
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zip_path)));

            //设置压缩级别
            zos.setLevel(Deflater.BEST_COMPRESSION);

            for (DmFile f : files) {
                // 数据库资源地址
                //   /profile/upload/2019/09/19/1b637f0eed669b6181004542da9f24de.jpg 去掉 /profile/upload
                String downloadPath = localPath + f.getFilePath().replace("/profile/upload", "");

                ZipEntry ze = new ZipEntry(f.getFileName());
                zos.putNextEntry(ze);

                // 先把所有资料写入zip中
//                FileUtils.writeBytes(downloadPath, zos);
                bis = new BufferedInputStream(new FileInputStream(downloadPath));
                byte[] buffer = new byte[1024];
                int read = 0;
                while((read =bis.read(buffer)) != -1){
                    zos.write(buffer, 0, read);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {

            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(zos!=null){
                try {
                    zos.flush();
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return zip_path;
    }

    /**
     * 上传文件
     */
    public void upload(MultipartFile[] file, String uuid) throws IOException {
        // 上传文件路径
        String filePath = Global.getUploadPath();

        // 上传并返回新文件名称
        List<DmFile> fileList = new ArrayList<>();
        String path,name;
        for (int i=0;i<file.length;i++){
            path = FileUploadUtils.upload(filePath, file[i]);       //文件路径
            name = file[i].getOriginalFilename();                   //获取文件名
            DmFile f = new DmFile();
            f.setDataId(uuid);
            f.setFileName(name);
            f.setFilePath(path);
            fileList.add(f);
        }

        // 插入文件信息
        fileService.insertFileList(fileList);
    }
}

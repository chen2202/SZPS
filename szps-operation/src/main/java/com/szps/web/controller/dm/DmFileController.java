package com.szps.web.controller.dm;

import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.constant.Constants;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.file.FileUtils;
import com.szps.web.domain.dm.DmData;
import com.szps.web.domain.dm.DmFile;
import com.szps.web.service.dm.IDmDataService;
import com.szps.web.service.dm.IDmFileService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * 规划资料文件管理
 */
@Controller
@RequestMapping("/dm/file")
public class DmFileController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(DmFileController.class);

    private String prefix = "dm/file";

    @Autowired
    private IDmDataService dataService;

    @Autowired
    private IDmFileService fileService;

    /**
     * 修改资料
     */
    @GetMapping("/edit/{dataId}")
    public String edit(@PathVariable("dataId") Long dataId, ModelMap mmap)
    {
        DmData data = dataService.selectDataById(dataId);
        mmap.put("data",data);

        return prefix + "/edit";
    }

    /**
     * 修改保存资料
     */
    @Log(title = "修改规划资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DmData dmData)
    {
        return toAjax(dataService.updateData(dmData));
    }


    /**
     * 审批记录查看
     */
    @GetMapping("/auditView/{dataId}")
    public String auditView(@PathVariable("dataId") Long dataId, ModelMap mmap)
    {
        mmap.put("data",dataService.selectDataById(dataId));
        return prefix + "/auditView";
    }

    /**
     * 用户查看资料
     */
    @GetMapping("/userView/{dataId}")
    public String userView(@PathVariable("dataId") Long dataId, ModelMap mmap)
    {
        mmap.put("data",dataService.selectDataById(dataId));
        return prefix + "/userView";
    }


    /**
     * 通过资料ID获取对应文件
     */
    @PostMapping("/select")
    @ResponseBody
    public TableDataInfo selectFileByDataId(@Param("dataId") Long dataId) {
        startPage();
        List<DmFile> list = fileService.selectFileListByDataId(dataId);

        return getDataTable(list);
    }


    /**
     * 文件下载请求
     * 支持单文件与多文件,用资料主题当名字压缩成一个包
     */
    @Log(title = "下载规划资料文件", businessType = BusinessType.OTHER)
    @GetMapping("/download")
    @ResponseBody
    public void resourceDownload(@Param("ids") String ids, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 通过文件编号获取文件
        List<DmFile> files = fileService.selectFileListByFileIds(ids);
        if (files != null) {
            DmData data = dataService.selectDataById(files.get(0).getDataId());     // 获取资料信息
            String theme = data != null ? data.getDataTheme() : "附属文件";               // 如果没获取到资料，默认压缩包名为附属文件
            theme += ".zip";

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

    }


    /**
     * 文件删除
     */
    @Log(title = "删除资料文件", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    @ResponseBody
    public AjaxResult delete(@Param("fileId") Long fileId, @Param("filePath") String filePath) {
        try {
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

}

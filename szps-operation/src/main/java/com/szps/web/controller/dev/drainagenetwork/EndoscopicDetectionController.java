package com.szps.web.controller.dev.drainagenetwork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.file.FileUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.controller.common.CommonController;
import com.szps.web.domain.dev.EndoscopicDetection;
import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkMaintenance;
import com.szps.web.service.dev.IEndoscopicDetectionService;

@Controller
@RequestMapping("/op/dev/ed")
public class EndoscopicDetectionController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);

	 @Autowired
	private IEndoscopicDetectionService service;
	
	private String prefix = "/dev/drainagenetwork/maintenance/ed";
	
    @RequiresPermissions("dev:ed:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:ed:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EndoscopicDetection obj)
    {
        startPage();
        List<EndoscopicDetection> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    @RequiresPermissions("dev:ed:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( EndoscopicDetection obj)
    {
    	//影像文件名，命名规则为起点管点编号-终点管点编号-检测日期    	
    	String video_filename = obj.getS_point()+"-"+obj.getE_point()+"-"+obj.getSampletime();
    	obj.setVideo_filename(video_filename);
    	
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
    	EndoscopicDetection obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:ed:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated EndoscopicDetection obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:ed:delete")
    @Log(title = "删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(service.deleteByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    
    
    @Value("${szps.profile}")
    private String filePath;
    /**
     * 文件上传
     * @param multipartFile
     */
    @PostMapping("/uploadFile")
    @ResponseBody
    public AjaxResult uploadFile(@RequestParam("uploadfile") MultipartFile []multipartFile,@RequestParam("dataUuid")String dataUuid){

        if(multipartFile.length==0){
            return error("文件为空,上传失败");
        }

        for(int i=0;i<multipartFile.length;i++){
            String fileName = multipartFile[i].getOriginalFilename();//参数2
            String dir = dataUuid;
//            String dateDir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));//参数3

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(filePath).append(File.separator).append(dir).append(File.separator).append(fileName);

            System.out.println("上传信息  = "+sBuilder);

            File file = new File(sBuilder.toString());
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                InputStream inputStream = multipartFile[i].getInputStream();
                OutputStream out = new FileOutputStream(file);
                byte[] buffer = new byte[1024 * 1024];
                int len = 0;
                while((len = inputStream.read(buffer)) !=-1) {
                    out.write(buffer, 0, len);
                }
                out.flush();
                out.close();
                inputStream.close();

            }catch(IOException e) {
                e.printStackTrace();
            }catch(Exception ee) {
                ee.printStackTrace();
            }
        }
        return success("上传成功!");
    }
    
    @GetMapping("download")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
        	String id=request.getParameter("id");
        	EndoscopicDetection obj = service.selectById(id);
        	String fileName = obj.getAttachmenturl();
			/*
			 * if (fileName == null || fileName.equals("")) { fileName ="文件不存在,下载文件失败"; }
			 */
        	String fileTyle=fileName.substring(fileName.lastIndexOf("."),fileName.length());
            String realFileName = obj.getVideo_filename()+fileTyle;
            String filePath = Global.getPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, realFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
            try {
            	response.setCharacterEncoding("utf-8");
				response.getWriter().append("文件不存在,下载文件失败,请刷新");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		
    }
}

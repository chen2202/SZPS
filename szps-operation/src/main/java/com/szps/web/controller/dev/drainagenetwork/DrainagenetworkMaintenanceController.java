package com.szps.web.controller.dev.drainagenetwork;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.StringUtils;
import com.szps.common.utils.file.FileUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.controller.common.CommonController;
import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkMaintenance;
import com.szps.web.service.dev.drainagenetwork.IDrainagenetworkMaintenanceService;
/**
 * BO设备台账	设备清单	
 * @author Jack
 *
 */
@Controller
@RequestMapping("/op/dev/drainagenetworkmaintenance")
public class DrainagenetworkMaintenanceController extends BaseController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	 @Autowired
	private IDrainagenetworkMaintenanceService service;
	
	private String prefix = "/dev/drainagenetwork/maintenance";
	
    @RequiresPermissions("dev:drainagenetworkmaintenance:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:drainagenetworkmaintenance:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DrainagenetworkMaintenance obj)
    {
        startPage();
        List<DrainagenetworkMaintenance> list = service.selectList(obj);
        return getDataTable(list);
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }
    

    @RequiresPermissions("dev:drainagenetworkmaintenance:add")
    @Log(title = "添加", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( DrainagenetworkMaintenance obj)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
        return toAjax(service.insert(obj));
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	DrainagenetworkMaintenance obj = service.selectById(id);
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:drainagenetworkmaintenance:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DrainagenetworkMaintenance obj)
    {
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:drainagenetworkmaintenance:delete")
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
    @GetMapping("download")
    public void fileDownload(HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
        	Long id=Long.valueOf(request.getParameter("id"));
        	DrainagenetworkMaintenance obj = service.selectById(id);
        	String fileName = obj.getAttachmenturl();
			/*
			 * if (fileName == null || fileName.equals("")) { fileName ="文件不存在,下载文件失败"; }
			 */
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = Global.getPath() + fileName;

            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, fileName));
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

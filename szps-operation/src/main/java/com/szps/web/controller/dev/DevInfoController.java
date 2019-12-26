package com.szps.web.controller.dev;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.DateUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.dev.DevInfo;
import com.szps.web.domain.dev.Supplier;
import com.szps.web.domain.dev.TechInfo;
import com.szps.web.service.dev.IDevInfoService;
import com.szps.web.service.dev.IInfoTechService;
import com.szps.web.service.dev.ISupplierService;
import com.szps.web.service.dev.ITechInfoService;

@Controller
@RequestMapping("/op/dev/info")
public class DevInfoController extends BaseController {
	@Autowired
	private IDevInfoService service;
	 
	@Autowired
	private ISupplierService supplierService;
	
	@Autowired
	private ITechInfoService techInfoService;
	
	private String prefix = "/dev/info";
    @Value("${szps.profile}")
    private String filePath;
    @RequiresPermissions("dev:info:view")
    @GetMapping()
    public String view()
    {
        return prefix + "/view";
    }
    
    /**
     */
    @RequiresPermissions("dev:info:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DevInfo obj)
    {
        startPage();
        List<DevInfo> list = service.selectList(obj);
        return getDataTable(list);
    }
    /**
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	SysDept sysDept = user.getDept();
    	mmap.put("sysDept",sysDept);
        return prefix + "/add";
    }
    

    /**
     */
    @RequiresPermissions("dev:info:add")
    @Log(title = "添加设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DevInfo obj,@RequestParam("imgUrl") String imgUrl,@RequestParam("imgUrl2") String imgUrl2)
    {
    	// 上传文件路径
    	SysUser user = ShiroUtils.getSysUser();
    
    	obj.setCreateBy(user.getLoginName());
    	obj.setDept_id(user.getDeptId());
    	int i =service.insert(obj);
    	Long id = obj.getId();
    	
    	if (imgUrl != null && !StringUtils.isEmpty(imgUrl)) {
    		TechInfo spec = new TechInfo();
        	spec.setTname("产品说明书");
        	spec.setUrl(imgUrl);
        	spec.setTversion("1.0");
        	spec.setDevid(id);
        	spec.setCreateBy(user.getLoginName());
        	techInfoService.insert(spec);
		}
    	
    	if (imgUrl2 != null && !StringUtils.isEmpty(imgUrl2)) {
	    	TechInfo manual = new TechInfo();
	    	manual.setTname("操作手册");
	    	manual.setUrl(imgUrl2);
	    	manual.setTversion("1.0");
	    	manual.setDevid(id);
	    	manual.setCreateBy(user.getLoginName());
        	techInfoService.insert(manual);
    	}
    	
        return toAjax(i);
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	DevInfo obj = service.selectById(id);
        try {
        	Supplier supplier = supplierService.selectById(Long.valueOf(obj.getSupplierid()));
        	StringBuffer sBuffer = new StringBuffer();
        	sBuffer = sBuffer.append(supplier.getSname()).append(" ").append(supplier.getContact())
        	.append(supplier.getTel()).append(" ").append(supplier.getAddr());
        	obj.setSupplierStr(sBuffer.toString());
        	
        	obj.setBuytimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM, obj.getBuytime()));
        	obj.setBeganusetimeStr(DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM, obj.getBeganusetime()));
		} catch (Exception e) {
			// TODO: handle exception
		}
        try {
        	TechInfo techInfo = new TechInfo();
            techInfo.setDevid(id);
            List<TechInfo> techInfos =	techInfoService.selectList(techInfo);
            obj.setTechInfos(techInfos);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        mmap.put("obj", obj);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "设备信息修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("dev:info:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DevInfo obj)
    {
    	try {
			obj.setBuytime(DateUtils.dateTime(DateUtils.YYYY_MM_DD_HH_MM, obj.getBuytimeStr()));
		} catch (Exception e) {
		}
    	try {
			obj.setBeganusetime(DateUtils.dateTime(DateUtils.YYYY_MM_DD_HH_MM, obj.getBeganusetimeStr()));
		} catch (Exception e) {
		}
    	obj.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.update(obj));
    }

    @RequiresPermissions("dev:info:delete")
    @Log(title = "设备信息删除", businessType = BusinessType.DELETE)
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
}

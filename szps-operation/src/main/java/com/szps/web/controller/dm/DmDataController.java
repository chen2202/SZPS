package com.szps.web.controller.dm;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.szps.common.annotation.Log;
import com.szps.common.config.Global;
import com.szps.common.config.ServerConfig;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.file.FileUploadUtils;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.dm.DmAudit;
import com.szps.web.domain.dm.DmFile;
import com.szps.web.service.dm.IDmAuditService;
import com.szps.web.service.dm.IDmFileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.dm.DmData;
import com.szps.web.service.dm.IDmDataService;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;


/**
 * 综合资料管理
 * 
 * @author vic
 *
 */
@Controller
@RequestMapping("/dm/data")
public class DmDataController extends BaseController{
	
	private String prefix = "dm/data";

	@Autowired
	private IDmDataService dataService;

	@Autowired
    private IDmAuditService auditService;

    @Autowired
    private IDmFileService fileService;
	
	@GetMapping()
    public String show()
    {
        return prefix + "/data";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DmData dmData)
    {
        startPage();
        List<DmData> list = dataService.selectDataList(dmData);
        return getDataTable(list);
    }
	
	/**
	 * 
	 * 添加资料
	 * 
	 */
	@GetMapping("/add")
    public String add(HttpServletRequest request)
    {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        request.setAttribute("dataUuid",uuid);
        return prefix + "/add";
    }

    /**
     * 新增资料
     */
    @Log(title = "添加规划资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional
    @ResponseBody
    public AjaxResult addSave(@Validated DmData data,@RequestParam("file") MultipartFile []file) throws IOException {
        int result = dataService.insertData(data);
        if(result>0){
            DmData d = dataService.selectDataByUuid(data.getDataUuid());
            if(d!=null){
                long id = d.getDataId();

                // 上传文件路径
                String filePath = Global.getUploadPath();

                // 上传并返回新文件名称
                List<DmFile> fileList = new ArrayList<>();
                String path,name;
                for (int i=0;i<file.length;i++){
                    path = FileUploadUtils.upload(filePath, file[i]);       //文件路径
                    name = file[i].getOriginalFilename();                   //获取文件名
                    DmFile f = new DmFile();
                    f.setDataId(id);
                    f.setFileName(name);
                    f.setFilePath(path);
                    fileList.add(f);
                }

                // 插入文件信息
                fileService.insertFileList(fileList);

                // 新添加的资料都是未审批状态，存在审批表里
                DmAudit dmAudit = new DmAudit();
                dmAudit.setDataId(id);
                dmAudit.setAuditStatus("0");
                auditService.insertAudit(dmAudit);
                return success();
            }
        }
        return error();
    }


    /**
     *删除资料(改变状态)
     */
    @Log(title = "删除综合资料", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(dataService.changeDataFlagByIds(ids,"2"));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     *查看资料
     */
    @GetMapping("/dataView/{dataId}")
    public String dataView(@PathVariable("dataId") Long dataId, ModelMap mmap)
    {
        mmap.put("data", dataService.selectDataById(dataId));
        return prefix + "/view";
    }

    @Log(title = "资料导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("dm:data:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DmData data)
    {
        List<DmData> list = dataService.selectPassDataList(data);
        ExcelUtil<DmData> util = new ExcelUtil<DmData>(DmData.class);
        return util.exportExcel(list, "资料数据");
    }


}

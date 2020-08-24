package com.szps.web.controller.dm;

import com.szps.web.service.dm.IDmAuditService;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import com.szps.common.annotation.Log;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.dm.DmAudit;
import com.szps.web.service.dm.IDmFileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.dm.DmData;
import com.szps.web.service.dm.IDmDataService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


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
    private IDmFileService fileService;

    @Autowired
    private IDmAuditService auditService;

    @Autowired
    private DmFileController dmFileController;

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

	@GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增资料
     */
    @Log(title = "添加规划资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(DmData data, @RequestParam("file") MultipartFile []file) throws IOException {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        data.setDataUuid(uuid);
        dataService.insertData(data);

        long id = data.getDataId();

        dmFileController.upload(file, uuid);

        // 新添加的资料都是未审批状态，存在审批表里
        DmAudit dmAudit = new DmAudit();
        dmAudit.setDataId(id);
        dmAudit.setAuditStatus("1");
        auditService.insertAudit(dmAudit);
        return success();
    }


    /**
     *删除资料
     */
    @Log(title = "删除综合资料", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        auditService.deleteAuditByDataIds(ids);
        return toAjax(dataService.deleteDataByIds(ids));
    }

    /**
     *查看资料
     */
    @GetMapping("/view/{dataId}")
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
        List<DmData> list = dataService.selectDataList(data);
        ExcelUtil<DmData> util = new ExcelUtil<DmData>(DmData.class);
        return util.exportExcel(list, "资料数据");
    }

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
}

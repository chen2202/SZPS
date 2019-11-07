package com.szps.web.controller.check;

import java.util.ArrayList;
import java.util.List;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.check.PlantCheckDevice;
import com.szps.web.service.check.IPlantCheckRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szps.web.domain.check.PlantCheckContent;
import com.szps.web.service.check.IPlantCheckContentService;


/**
 * 点检内容Controller
 *
 * @author HJR
 * @date 2019-10-30
 */
@Controller
@RequestMapping("/check/plant/content")
public class PlantCheckContentController extends BaseController {
    private String prefix = "check/plant/content";

    @Autowired
    private IPlantCheckContentService plantCheckContentService;


    @RequiresPermissions("check:content:view")
    @GetMapping()
    public String content(ModelMap mmap) {

        return prefix + "/content";
    }

    /**
     * 查询点检内容列表
     */
    @RequiresPermissions("check:content:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PlantCheckContent plantCheckContent) {
        startPage();
        List<PlantCheckContent> list = plantCheckContentService.selectPlantCheckContentList(plantCheckContent);
        return getDataTable(list);
    }

    /**
     * 导出点检内容列表
     */
    @RequiresPermissions("check:content:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlantCheckContent plantCheckContent) {
        List<PlantCheckContent> list = plantCheckContentService.selectPlantCheckContentList(plantCheckContent);
        ExcelUtil<PlantCheckContent> util = new ExcelUtil<PlantCheckContent>(PlantCheckContent.class);
        return util.exportExcel(list, "content");
    }

    /**
     * 新增点检内容
     */
    @GetMapping("/add")
    public String add(Model model, ModelMap mmap) {
        SysUser user = ShiroUtils.getSysUser();
        List<PlantCheckDevice> deviceList1 = plantCheckContentService.getALL(user);
        List<PlantCheckDevice> deviceList = new ArrayList<>();
        deviceList = getdeviceList(deviceList, deviceList1);
        model.addAttribute("deviceList", deviceList);
        model.addAttribute("deviceList1", deviceList1);
        PlantCheckContent content=new PlantCheckContent();
        content.setContentCreateuser(user.getUserName());
        mmap.put("user", content);
        return prefix + "/add";
    }

    /**
     * 新增保存点检内容
     */
    @RequiresPermissions("check:content:add")
    @Log(title = "点检内容", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PlantCheckContent plantCheckContent) {
        return toAjax(plantCheckContentService.insertPlantCheckContent(plantCheckContent));
    }

    /**
     * 修改点检内容
     */
    @GetMapping("/edit/{contentSid}")
    public String edit(@PathVariable("contentSid") Long contentSid, ModelMap mmap, Model model) {
        SysUser user = ShiroUtils.getSysUser();
        PlantCheckContent plantCheckContent = plantCheckContentService.selectPlantCheckContentById(contentSid);
        mmap.put("plantCheckContent", plantCheckContent);
        List<PlantCheckDevice> deviceList1 = plantCheckContentService.getALL(user);
        List<PlantCheckDevice> deviceList = new ArrayList<>();
        deviceList = getdeviceList(deviceList, deviceList1);
        model.addAttribute("deviceList", deviceList);
        model.addAttribute("deviceList1", deviceList1);
        return prefix + "/edit";
    }

    /**
     * 修改保存点检内容
     */
    @RequiresPermissions("check:content:edit")
    @Log(title = "点检内容", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PlantCheckContent plantCheckContent) {
        return toAjax(plantCheckContentService.updatePlantCheckContent(plantCheckContent));
    }

    /**
     * 删除点检内容
     */
    @RequiresPermissions("check:content:remove")
    @Log(title = "点检内容", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(plantCheckContentService.deletePlantCheckContentByIds(ids));
    }

    /**
     * 查看详细信息
     */
    @GetMapping("/detail/{contentSid}")
    public String detail(@PathVariable("contentSid") Long contentSid, ModelMap mmap, Model model) {
        SysUser user = ShiroUtils.getSysUser();
        PlantCheckContent plantCheckContent = plantCheckContentService.selectPlantCheckContentById(contentSid);
        mmap.put("plantCheckContent", plantCheckContent);
        List<PlantCheckDevice> deviceList = plantCheckContentService.getALL(user);
        model.addAttribute("deviceList", deviceList);
        return prefix + "/detail";
    }

    public static List<PlantCheckDevice> getdeviceList(List<PlantCheckDevice> deviceList, List<PlantCheckDevice> deviceList1) {

        for (int i = 0; i < deviceList1.size(); i++) {
            deviceList.add(deviceList1.get(i));
        }
        for (int i = 0; i < deviceList.size() - 1; i++) {
            for (int j = deviceList.size() - 1; j > i; j--) {
                if (deviceList.get(j).getPlantId().equals(deviceList.get(i).getPlantId())) {
                    deviceList.remove(j);
                }
            }
        }
        return deviceList;
    }

}

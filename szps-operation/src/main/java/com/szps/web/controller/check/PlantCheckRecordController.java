package com.szps.web.controller.check;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysDeptService;
import com.szps.web.domain.check.PlantCheckDevice;
import com.szps.web.service.check.IPlantCheckContentService;
import com.szps.web.service.check.IPlantCheckDeviceService;
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
import com.szps.web.domain.check.PlantCheckRecord;
import com.szps.web.service.check.IPlantCheckRecordService;


/**
 * 污水厂巡检Controller
 *
 * @author HJR
 * @date 2019-11-05
 */
@Controller
@RequestMapping("/check/plant/plant")
public class PlantCheckRecordController extends BaseController {
    private String prefix = "check/plant/plant";

    @Autowired
    private IPlantCheckRecordService plantCheckRecordService;

    @Autowired
    private IPlantCheckContentService plantCheckContentService;

    @Autowired
    private IPlantCheckDeviceService plantCheckDeviceService;

    @Autowired
    private ISysDeptService iSysDeptService;

    @RequiresPermissions("check:plant:view")
    @GetMapping()
    public String plant(PlantCheckDevice plantCheckDevice, SysDept sysDept, Model model) {
        SysUser user = ShiroUtils.getSysUser();
        List<PlantCheckDevice> plantList = new ArrayList<>();
        List<PlantCheckDevice> plantList2 = new ArrayList<>();
        if (user.getUserName().equals("admin")) {
            List<SysDept> sysDepts = iSysDeptService.selectDeptList(sysDept);
            for (int i = 0; i < sysDepts.size(); i++) {
                PlantCheckDevice plant = new PlantCheckDevice();
                plant.setPlantName(sysDepts.get(i).getDeptName());
                plantList2.add(plant);
            }
            plantList = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        } else {
            plantList = plantCheckContentService.getALL(user);
            plantList2 = plantList;
        }
        model.addAttribute("plantList", plantList);
        model.addAttribute("plantList1", plantList2);
        return prefix + "/plant";
    }

    /**
     * 查询污水厂巡检列表
     */
    @RequiresPermissions("check:plant:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PlantCheckRecord plantCheckRecord) throws Exception {
        startPage();
        List<PlantCheckRecord> list = new ArrayList<>();
        SysUser user = ShiroUtils.getSysUser();
        if (user.getUserName().equals("admin")) {
            list = plantCheckRecordService.selectPlantCheckRecordList(plantCheckRecord);
        } else {
            list = plantCheckRecordService.selectPlantCheckRecordList2(user);
        }
        return getDataTable(list);
    }

    /**
     * 导出污水厂巡检列表
     */
    @RequiresPermissions("check:plant:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlantCheckRecord plantCheckRecord) {
        List<PlantCheckRecord> list = plantCheckRecordService.selectPlantCheckRecordList(plantCheckRecord);
        ExcelUtil<PlantCheckRecord> util = new ExcelUtil<PlantCheckRecord>(PlantCheckRecord.class);
        return util.exportExcel(list, "plant");
    }

    /**
     * 新增污水厂巡检
     */
    @GetMapping("/add")
    public String add(Model model, ModelMap mmap, PlantCheckDevice plantCheckDevice) {

        SysUser user = ShiroUtils.getSysUser();
        List<PlantCheckDevice> plantList = new ArrayList<>();
        if (user.getUserName().equals("admin")) {
            plantList = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        } else {
            plantList = plantCheckContentService.getALL(user);
        }
        model.addAttribute("plantList", plantList);
        PlantCheckRecord plant = new PlantCheckRecord();
        plant.setSystemCreateuser(user.getUserName());
        mmap.put("user", plant);
        return prefix + "/add";
    }

    /**
     * 新增保存污水厂巡检
     */
    @RequiresPermissions("check:plant:add")
    @Log(title = "污水厂巡检", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PlantCheckRecord plantCheckRecord) {
        return toAjax(plantCheckRecordService.insertPlantCheckRecord(plantCheckRecord));
    }


    /**
     * 修改污水厂巡检
     */
    @GetMapping("/edit/{systemId}")
    public String edit(@PathVariable("systemId") Long systemId, ModelMap mmap, Model model, PlantCheckDevice plantCheckDevice) {
        PlantCheckRecord plantCheckRecord = plantCheckRecordService.selectPlantCheckRecordById(systemId);
        SysUser user = ShiroUtils.getSysUser();
        List<PlantCheckDevice> plantList = new ArrayList<>();
        if (user.getUserName().equals("admin")) {
            plantList = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        } else {
            plantList = plantCheckContentService.getALL(user);
        }
        model.addAttribute("plantList", plantList);
        mmap.put("plantCheckRecord", plantCheckRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存污水厂巡检
     */
    @RequiresPermissions("check:plant:edit")
    @Log(title = "污水厂巡检", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PlantCheckRecord plantCheckRecord) {
        return toAjax(plantCheckRecordService.updatePlantCheckRecord(plantCheckRecord));
    }

    /**
     * 删除污水厂巡检
     */
    @RequiresPermissions("check:plant:remove")
    @Log(title = "污水厂巡检", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(plantCheckRecordService.deletePlantCheckRecordByIds(ids));
    }


}

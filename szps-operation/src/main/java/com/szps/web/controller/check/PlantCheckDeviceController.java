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
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysDeptService;
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
import com.szps.web.domain.check.PlantCheckDevice;
import com.szps.web.service.check.IPlantCheckDeviceService;

/**
 * 点检设备资料Controller
 *
 * @author HJR
 * @date 2019-10-30
 */
@Controller
@RequestMapping("/check/plant/device")
public class PlantCheckDeviceController extends BaseController
{
    private String prefix = "check/plant/device";

    @Autowired
    private IPlantCheckDeviceService plantCheckDeviceService;


    @Autowired
    private ISysDeptService iSysDeptService;

    @RequiresPermissions("check:device:view")
    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询点检设备资料列表
     */
    @RequiresPermissions("check:device:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PlantCheckDevice plantCheckDevice)
    {
        startPage();
        List<PlantCheckDevice> list = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        return getDataTable(list);
    }

    /**
     * 导出点检设备资料列表
     */
    @RequiresPermissions("check:device:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PlantCheckDevice plantCheckDevice)
    {
        List<PlantCheckDevice> list = plantCheckDeviceService.selectPlantCheckDeviceList(plantCheckDevice);
        ExcelUtil<PlantCheckDevice> util = new ExcelUtil<PlantCheckDevice>(PlantCheckDevice.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 新增点检设备资料
     */
    @GetMapping("/add")
    public String add(ModelMap mmap, SysDept sysDept, Model model)
    {

        SysUser user = ShiroUtils.getSysUser();

        PlantCheckDevice device=new PlantCheckDevice();
        device.setDeviceCreateuser(user.getUserName());
        List<SysDept> sysDepts = iSysDeptService.selectDeptList(sysDept);
        List<PlantCheckDevice> plantList2 = new ArrayList<>();
        for (int i = 0; i < sysDepts.size(); i++) {
            PlantCheckDevice plant = new PlantCheckDevice();
            plant.setPlantName(sysDepts.get(i).getDeptName());
            plantList2.add(plant);
        }
        model.addAttribute("plantList1", plantList2);
        mmap.put("user",device);

        return prefix + "/add";
    }

    /**
     * 新增保存点检设备资料
     */
    @RequiresPermissions("check:device:add")
    @Log(title = "点检设备资料", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PlantCheckDevice plantCheckDevice)
    {
        return toAjax(plantCheckDeviceService.insertPlantCheckDevice(plantCheckDevice));
    }

    /**
     * 修改点检设备资料
     */
    @GetMapping("/edit/{deviceSid}")
    public String edit(@PathVariable("deviceSid") Long deviceSid, ModelMap mmap)
    {
        PlantCheckDevice plantCheckDevice = plantCheckDeviceService.selectPlantCheckDeviceById(deviceSid);
        mmap.put("plantCheckDevice", plantCheckDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存点检设备资料
     */
    @RequiresPermissions("check:device:edit")
    @Log(title = "点检设备资料", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PlantCheckDevice plantCheckDevice)
    {
        return toAjax(plantCheckDeviceService.updatePlantCheckDevice(plantCheckDevice));
    }

    /**
     * 删除点检设备资料
     */
    @RequiresPermissions("check:device:remove")
    @Log(title = "点检设备资料", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(plantCheckDeviceService.deletePlantCheckDeviceByIds(ids));
    }
}

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
import com.szps.framework.web.domain.server.Sys;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysDeptService;


import com.szps.web.domain.event.EventPicture;
import com.szps.web.domain.event.EventSubmit;
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
    private ISysDeptService iSysDeptService;

    @RequiresPermissions("check:plant:view")
    @GetMapping()
    public String plant( SysDept sysDept, Model model) {

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
        List<PlantCheckRecord> list = plantCheckRecordService.selectCheckManagerList(plantCheckRecord);


        if (plantCheckRecord.getCheckSubmitTime() != null) {


            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            List<PlantCheckRecord> list1=new ArrayList<PlantCheckRecord>();

            for (PlantCheckRecord plantCheckRecord1 : list) {

                String Time = sdf1.format(plantCheckRecord.getCheckSubmitTime());
                String beginTime = sdf.format(plantCheckRecord1.getCheckSubmitTime()) + " 00:00:00";
                String endTime = sdf.format(plantCheckRecord1.getCheckSubmitTime()) + " 24:00:00";
                Date begin = sdf1.parse(beginTime);
                Date end = sdf1.parse(endTime);
                Date time = sdf1.parse(Time);

                if (belongCalendar(time, begin, end) ==true) {

                    list1.add(plantCheckRecord1);
                }

            }
            return getDataTable(list1);

        }else {

            return getDataTable(list);
        }
    }


    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {

        long nowtime=nowTime.getTime();
        long begintime=beginTime.getTime();
        long endtime=endTime.getTime();



        if (nowtime>=begintime&&nowtime<=endtime) {
            return true;
        } else {
            return false;
        }
    }


    @GetMapping("/detail/{eventSid}")
    public String detail(@PathVariable("eventSid") Integer eventSid, Model mmap, EventSubmit eventSubmit) {


        return prefix + "/detail";
    }


//    /**
//     * 导出污水厂巡检列表
//     */
//    @RequiresPermissions("check:plant:export")
//    @PostMapping("/export")
//    @ResponseBody
//    public AjaxResult export(PlantCheckRecord plantCheckRecord) {
//        List<PlantCheckRecord> list = plantCheckRecordService.selectCheckManagerList(plantCheckRecord);
//        ExcelUtil<PlantCheckRecord> util = new ExcelUtil<PlantCheckRecord>(PlantCheckRecord.class);
//        return util.exportExcel(list, "plant");
//    }

//    /**
//     * 新增污水厂巡检
//     */
//    @GetMapping("/add")
//    public String add(Model model, ModelMap mmap) {
//
//        SysUser user = ShiroUtils.getSysUser();
//
//
//
//        PlantCheckRecord plant = new PlantCheckRecord();
//        plant.setSystemCreateuser(user.getUserName());
//        mmap.put("user", plant);
//        return prefix + "/add";
//    }

//    /**
//     * 新增保存污水厂巡检
//     */
//    @RequiresPermissions("check:plant:add")
//    @Log(title = "污水厂巡检", businessType = BusinessType.INSERT)
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(PlantCheckRecord plantCheckRecord) {
//        return toAjax(plantCheckRecordService.insertPlantCheckRecord(plantCheckRecord));
//    }
//
//
//    /**
//     * 修改污水厂巡检
//     */
//    @GetMapping("/edit/{systemId}")
//    public String edit(@PathVariable("systemId") Long systemId, ModelMap mmap, Model model,  ) {
//        PlantCheckRecord plantCheckRecord = plantCheckRecordService.selectPlantCheckRecordById(systemId);
//        SysUser user = ShiroUtils.getSysUser();
//
//
//        mmap.put("plantCheckRecord", plantCheckRecord);
//        return prefix + "/edit";
//    }
//
//    /**
//     * 修改保存污水厂巡检
//     */
//    @RequiresPermissions("check:plant:edit")
//    @Log(title = "污水厂巡检", businessType = BusinessType.UPDATE)
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(PlantCheckRecord plantCheckRecord) {
//        return toAjax(plantCheckRecordService.updatePlantCheckRecord(plantCheckRecord));
//    }
//
//    /**
//     * 删除污水厂巡检
//     */
//    @RequiresPermissions("check:plant:remove")
//    @Log(title = "污水厂巡检", businessType = BusinessType.DELETE)
//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids) {
//        return toAjax(plantCheckRecordService.deletePlantCheckRecordByIds(ids));
//    }


}

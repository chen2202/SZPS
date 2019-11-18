package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.core.text.Convert;
import com.szps.common.enums.BusinessType;
import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.domain.supervise.TbTask;
import com.szps.web.domain.supervise.TbTaskStaff;
import com.szps.web.service.supervise.HouseService;
import com.szps.web.service.supervise.StaffService;
import com.szps.web.service.supervise.TaskService;
import com.szps.web.service.supervise.TaskStaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


@Controller
@RequestMapping("/supervise/data")
public class DataController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private TaskStaffService taskStaffService;

    private String prefix = "supervise/data";

    @GetMapping("/data")
    public String dataview()
    {
        return prefix+"/Taskdata";
    }


    @GetMapping("/Taskadd")
    public String add()
    {
        return prefix + "/Taskadd";
    }




    @RequiresPermissions("supervise:data:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbTask tbTask)
    {
        startPage();
        List<TbTask> list = taskService.selectTaskList(tbTask);

        for(int i=0;i<list.size();i++)
        {

            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                //System.out.println(tbTaskStaffs.get(k));
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null)
                  tbStaffs.add(staff);
            }
            list.get(i).setTbStaffList(tbStaffs);
        }

        return getDataTable(list);
    }
    @RequiresPermissions("supervise:data:add")
    @Log(title = "任务库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbTask task, String taskStaff)
    {
        int radomInt = new Random().nextInt(999999);
        String s=String.valueOf(radomInt);
        while (taskService.checkTask(s)==1)
        {
           s=String.valueOf(new Random().nextInt(999999));
        }
        task.setTaskNumber(s);
        if(!task.getTaskHouse().equals("")&&!taskStaff.equals(""))
        {
            String[] strs = taskStaff.split(",|，");
            TbHouse house=houseService.selectHouseById(task.getTaskHouse());
            task.setTaskPartition(house.getHousePoint());
            task.setTaskHousename(house.getHouseName());
            task.setTaskHousephone(house.getHousePhone());
            for(int i=0; i<strs.length; i++) {
                TbTaskStaff tbTaskStaff=new TbTaskStaff();
                tbTaskStaff.setTaskNumber(s);
                tbTaskStaff.setStaffNumber(strs[i]);

                taskStaffService.insertTbTaskStaff(tbTaskStaff);
            }
        }

        return toAjax(taskService.insertTask(task));
    }
    @GetMapping("/edit/{taskNumber}")
    public String edit(@PathVariable("taskNumber") String taskNumber, ModelMap mmap)
    {

        List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(taskNumber);
        String a="";
        for(int k=0;k<tbTaskStaffs.size();k++)
        {
            TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
            if(staff!=null)
            {
                a=a+(staff.getStaffNumber());
                if(k!=(tbTaskStaffs.size()-1))
                {
                    a=a+",";
                }
            }

        }

        mmap.put("task", taskService.selectTaskById(taskNumber));
        mmap.put("taskStaff",a);
        return prefix + "/Taskedit";
    }

    @RequiresPermissions("supervise:data:edit")
    @Log(title = "任务管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated TbTask task,String taskStaff)
    {
        if(!task.getTaskHouse().equals("")&&!taskStaff.equals("")) {
            String s = task.getTaskNumber();
            TbTask tbTask = taskService.selectTaskById(s);
            TbHouse house = houseService.selectHouseById(tbTask.getTaskHouse());
            List<TbTaskStaff> tbTaskStaffs = taskStaffService.selectTbTaskStaffById(task.getTaskNumber());
            if (!Objects.equals(task.getTaskHouse(), house.getHouseNumber())) {
                TbHouse houses = houseService.selectHouseById(task.getTaskHouse());

                task.setTaskPartition(houses.getHousePoint());
                task.setTaskHousename(houses.getHouseName());
                task.setTaskHousephone(houses.getHousePhone());

            }

            String a = "";
            String[] strs = taskStaff.split(",|，");
            for (int k = 0; k < tbTaskStaffs.size(); k++) {
                TbStaff staff = staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if (staff != null) {
                    a = a + (staff.getStaffNumber());
                }

            }
            if (!Objects.equals(taskStaff.replaceAll(",|，", ""), a)) {
                taskStaffService.deleteTbTaskStaffById(s);
                for (int i = 0; i < strs.length; i++) {
                    TbTaskStaff tbTaskStaff = new TbTaskStaff();
                    tbTaskStaff.setTaskNumber(s);
                    tbTaskStaff.setStaffNumber(strs[i]);

                    taskStaffService.insertTbTaskStaff(tbTaskStaff);
                }
            }
        }

            return toAjax(taskService.updateTask(task));

    }
    @RequiresPermissions("supervise:data:remove")
    @Log(title = "任务管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(taskService.deleteTaskByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

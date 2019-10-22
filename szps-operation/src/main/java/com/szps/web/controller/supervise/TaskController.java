package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/supervise/task")
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private TaskStaffService taskStaffService;
    private String prefix = "supervise/task";

    @GetMapping("/task")
    public String dataview()
    {
        return prefix+"/TaskManage";
    }

    @GetMapping("/TaskCheck")
    public String TaskCheck()
    {
        return prefix + "/TaskCheck";
    }


    @RequiresPermissions("supervise:task:list")
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

                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null)
                    tbStaffs.add(staff);
            }
            list.get(i).setTbStaffList(tbStaffs);
        }
        return getDataTable(list);
    }

    @RequiresPermissions("supervise:task:list1")
    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list1(TbTask tbTask)
    {
        startPage();
        List<TbTask> list = taskService.selectTaskRandom();
        return getDataTable(list);
    }



    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(String ids)
    {
        String[] strs = ids.split(",");
        Random random = new Random();
        try
        {
            for(int i=0; i<strs.length; i++){
                TbTask t=taskService.selectTaskById(strs[i]);
                String region=t.getTaskRegion();
                String street=t.getTaskStreet();
                List<TbHouse> houses=houseService.selectByRegionAndStreet(region,street);
                TbHouse house=houses.get(random.nextInt(houses.size()));
                String s=house.getHouseNumber();
                String p=house.getHouseName();
                String phone=house.getHousePhone();
                String par=house.getHousePoint();
                t.setTaskHouse(s);
                t.setTaskHousename(p);
                t.setTaskPartition(par);
                t.setTaskHousephone(phone);
                List<TbStaff> staff=staffService.selectStaffAll();
                ArrayList<String> list = new ArrayList<String>();
                ArrayList<String> list_for_random = new ArrayList<String>();
                int max=staff.size();
                int val=3;
                for(int k=0;k<max;k++){
                    list_for_random.add(staff.get(k).getStaffNumber());
                }
                for(int j=0;j<val;j++){
                    int number = random.nextInt(max);
                    String num = list_for_random.get(number);
                    list.add(num);
                    list_for_random.remove(number);
                    max--;
                }
                for(int l=0;l<val;l++) {
                    TbTaskStaff tbTaskStaff=new TbTaskStaff();
                    tbTaskStaff.setTaskNumber(strs[i]);
                    tbTaskStaff.setStaffNumber(list.get(l));
                    taskStaffService.insertTbTaskStaff(tbTaskStaff);
                }
                taskService.updateTask(t);
            }

            return toAjax(strs.length);
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

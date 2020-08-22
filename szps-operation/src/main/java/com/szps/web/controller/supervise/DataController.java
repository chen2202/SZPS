package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.web.domain.server.Sys;
import com.szps.web.domain.supervise.*;
import com.szps.web.service.supervise.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/supervise/datas")
public class DataController extends BaseController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HouseService houseService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private TaskStaffService taskStaffService;
    @Autowired
    private RuleService ruleService;

    private String prefix = "supervise/data";

    @GetMapping("/datas")
    public String dataview()
    {
        return prefix+"/Taskdatas";
    }


    @RequiresPermissions("supervise:datas:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<TbTask> list = taskService.selectTaskAll();

        for(int i=0;i<list.size();i++)
        {
               String a=list.get(i).getTaskHouse();

               TbHouse tbHouse=houseService.selectHouseById(a);

//               String b=tbHouse.getHouseRule();
//            list.get(i).setRuleContent(ruleService.selectRuleByRuleName(b));

            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                //System.out.println(tbTaskStaffs.get(k));
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "一类"))
                  tbStaffs.add(staff);
            }
            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                //System.out.println(tbTaskStaffs.get(k));
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "二类"))
                    tbStaffs.add(staff);
            }

            list.get(i).setTbStaffList(tbStaffs);
            list.get(i).setTbHouse(tbHouse);
        }

        return getDataTable(list);
    }

     //双随机
    @RequiresPermissions("supervise:datas:add")
    @Log(title = "双随机", businessType = BusinessType.INSERT)
    @PostMapping("/Taskadd")
    @ResponseBody
    public AjaxResult addSave(String houseRule,String value1,String value2,String value3)
    {
        Random random = new Random();
        ArrayList<String> listnew = new ArrayList<String>();

        //拿到相应抽取事项的检查对象（满足抽取事项，且没被抽查过）

        int blint= Integer.parseInt(value3);

        List<TbHouse> list=houseService.selectHouseCheckList(houseRule);
        if(list.size()==0){
            return AjaxResult.error("暂时无可抽查的任务");
        }
        else if(list.size()<blint)
        {
            return AjaxResult.error("抽查数量大于可抽查的任务数，当前可抽查的任务数为"+list.size());
        }

            ArrayList<String> list_for_random = new ArrayList<String>();
            int max=list.size();


            //int val= Integer.parseInt(c);
            for(int k=0;k<max;k++){
                list_for_random.add(list.get(k).getHouseNumber());
            }

            for(int j=0;j<blint;j++){
                int number = random.nextInt(max);
                String num = list_for_random.get(number);
                listnew.add(num);
                list_for_random.remove(number);
                max--;
            }




        //生成任务
       for (int i=0;i<blint;i++){
           //抽取相应比例的抽查事项；并循环分配检查人员
            TbTask task=new TbTask();
           int radomInt = new Random().nextInt(999999);
           String s=String.valueOf(radomInt);
           while (taskService.checkTask(s)==1)
           {
               s=String.valueOf(new Random().nextInt(999999));
           }
           Date date = new Date();
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
           task.setTaskNumber(s);
           task.setTaskTime(formatter.format(date));
           task.setTaskHouse(listnew.get(i));
           task.setTaskFlag("未完成");
           task.setTaskBc("无");
           Date a=new Date();
           java.sql.Date b=new java.sql.Date(a.getTime());
           task.setUpdateTime(b);

           TbHouse house=houseService.selectHouseById(listnew.get(i));
           //String address=house.getHouseRegion().substring(3,6);


           house.setHouseFlag("是");



               //一类人员随机

                   List<TbStaff> staff=staffService.selectStaffOne();
                   ArrayList<String> list_for_random2 = new ArrayList<String>();
                   ArrayList<String> listnew2 = new ArrayList<String>();
                   int max2=staff.size();


                   for(int k=0;k<max2;k++){
                       list_for_random2.add(staff.get(k).getStaffNumber());
                   }
                   System.out.println(listnew2);
                   for(int j=0;j<Integer.parseInt(value1);j++){
                       int number = random.nextInt(max2);
                       String num = list_for_random2.get(number);
                       listnew2.add(num);
                       list_for_random2.remove(number);
                       max2--;
                   }



             for(int c=0;c<Integer.parseInt(value1);c++)
                {
                   TbTaskStaff tbTaskStaff=new TbTaskStaff();
                   tbTaskStaff.setTaskNumber(s);
                   tbTaskStaff.setStaffNumber(listnew2.get(c));
                   taskStaffService.insertTbTaskStaff(tbTaskStaff);

                 }

               //二类人员随机
                 if(value2!=null&&value2!=""&&Integer.parseInt(value2)>0) {
                     List<TbStaff> staff1 = staffService.selectStaffSecond();
                     ArrayList<String> list_for_random3 = new ArrayList<String>();
                     ArrayList<String> listnew3 = new ArrayList<String>();
                     int max3 = staff1.size();


                     for (int k = 0; k < max3; k++) {
                         list_for_random3.add(staff1.get(k).getStaffNumber());
                     }
                     for (int j = 0; j < Integer.parseInt(value2); j++) {
                         int number = random.nextInt(max3);
                         String num = list_for_random3.get(number);
                         listnew3.add(num);
                         list_for_random3.remove(number);
                         max3--;
                     }


                     for (int g = 0; g < Integer.parseInt(value2); g++) {
                         TbTaskStaff tbTaskStaff = new TbTaskStaff();
                         tbTaskStaff.setTaskNumber(s);
                         tbTaskStaff.setStaffNumber(listnew3.get(g));
                         taskStaffService.insertTbTaskStaff(tbTaskStaff);

                     }
                 }

           houseService.updateHouse(house);
           taskService.insertTask(task);
       }

        //把人员插入人员任务表

/*


        task.setTaskNumber(s);
        if(!task.getTaskHouse().equals("")&&!taskStaff.equals(""))
        {
            String[] strs = taskStaff.split(",|，");
            TbHouse house=houseService.selectHouseById(task.getTaskHouse());

            for(int i=0; i<strs.length; i++) {
                TbTaskStaff tbTaskStaff=new TbTaskStaff();
                tbTaskStaff.setTaskNumber(s);
                tbTaskStaff.setStaffNumber(strs[i]);

                taskStaffService.insertTbTaskStaff(tbTaskStaff);
            }
        }*/

        return  toAjax(blint);
    }


//    @GetMapping("/Taskadd")
//    public String edit( )
//    {
//
//       /* List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(taskNumber);
//        String a="";
//        for(int k=0;k<tbTaskStaffs.size();k++)
//        {
//            TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
//            if(staff!=null)
//            {
//                a=a+(staff.getStaffNumber());
//                if(k!=(tbTaskStaffs.size()-1))
//                {
//                    a=a+",";
//                }
//            }
//
//        }
//
//        mmap.put("task", taskService.selectTaskById(taskNumber));
//        mmap.put("taskStaff",a);*/
//        return prefix + "/bcmain";
//    }
    @GetMapping("/TaskBcStaff/{id}")

    public String TaskBcStaff(@PathVariable("id") String id, ModelMap mmap)
    {


        String ids=id.replace("\"","").replace("\"","");

        TbTask task= taskService.selectTaskById(ids);

        String a=task.getTaskHouse();

        TbHouse tbHouse=houseService.selectHouseById(a);
        String b=tbHouse.getHouseRule();
        task.setRuleName(b);


        mmap.put("task", task);
        return prefix + "/TaskBcStaff";
    }
    @GetMapping("/TaskBcHouse/{id}")
    public String TaskBcHouse(@PathVariable("id") String id , ModelMap mmap)
    {
        String ids=id.replace("\"","").replace("\"","");

        TbTask task= taskService.selectTaskById(ids);

        String a=task.getTaskHouse();

        TbHouse tbHouse=houseService.selectHouseById(a);
        String b=tbHouse.getHouseRule();
        task.setRuleName(b);
        task.setTbHouse(tbHouse);
        mmap.put("task", task);
        return prefix + "/TaskBcHouse";
    }

    @RequiresPermissions("supervise:datas:addbc")
    @GetMapping("/edit/{id}")
    public String ed(@PathVariable("id") String id ,ModelMap map)
    {
           map.addAttribute("id",id);

        return prefix + "/bcmain";
    }
    /*@RequiresPermissions("supervise:data:edit")
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

                //task.setTaskPartition(houses.getHousePoint());
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

    }*/
    /*@RequiresPermissions("supervise:data:remove")
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
    }*/
    @PostMapping("/getRule")
    @ResponseBody
    public AjaxResult getRule(){


        return AjaxResult.success("success",ruleService.selectRuleName());
    }
    @PostMapping("/getStaff")
    @ResponseBody
    public AjaxResult getStaff(HttpServletRequest request){
        String id=request.getParameter("id");

        List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(id);
        List<TbStaff> tbStaffs =new ArrayList<TbStaff>();
        for(int k=0;k<tbTaskStaffs.size();k++)
        {

            TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());

            tbStaffs.add(staff);
        }


        return AjaxResult.success("success",tbStaffs);
    }
    @PostMapping("/bcedit")
    @ResponseBody
    public AjaxResult editBcsSave(@Validated TbTask task)
    {


        //找出那一个被替换的人员
        List <TbTaskStaff> tbTaskStaffs= taskStaffService.selectTbTaskStaffById(task.getTaskNumber());
        TbStaff staff=new TbStaff();
        for(int k=0;k<tbTaskStaffs.size();k++)
        {

            staff=staffService.selectStaffById(task.getTaskBcStaff());
            System.out.println(staff.getStaffName());

        }
        //查看是几类人员
        String a=staff.getStaffPost();
        String b=staff.getStaffNumber();

        TbTaskStaff tbTaskStaff = new TbTaskStaff();
        //随机出一个人员
        Random random = new Random();
        if(a.equals("二类"))
        {
            List<TbStaff> staff1 = staffService.selectStaffSecond();
            List<TbStaff> staff2 = new ArrayList<TbStaff>();
            for (int i=0;i<staff1.size();i++)
            {
                for (int k=0;k<tbTaskStaffs.size();k++)
                {
                    if(staff1.get(i).getStaffNumber()!=tbTaskStaffs.get(k).getStaffNumber())
                    {
                                 staff2.add(staff1.get(i));
                    }
                }

            }
            int max3 = staff2.size();
            if(max3==0){
                return AjaxResult.success(max3);
           }
            int number = random.nextInt(max3);
            tbTaskStaff.setBcStaff(staff2.get(number).getStaffNumber());

        }else if(a.equals("一类"))
        {
            List<TbStaff> staff1 = staffService.selectStaffOne();
            List<TbStaff> staff2 = new ArrayList<TbStaff>();
            for (int i=0;i<staff1.size();i++)
            {
                for (int k=0;k<tbTaskStaffs.size();k++)
                {
                    if(staff1.get(i).getStaffNumber()!=tbTaskStaffs.get(k).getStaffNumber())
                    {
                        staff2.add(staff1.get(i));
                    }
                }

            }
            int max3 = staff2.size();
            if(max3==0){
                return AjaxResult.success(max3);
            }
            int number = random.nextInt(max3);
            tbTaskStaff.setBcStaff(staff2.get(number).getStaffNumber());

        }

        //修改
        tbTaskStaff.setTaskNumber(task.getTaskNumber());
        tbTaskStaff.setStaffNumber(b);
        taskStaffService.updateTbTaskStaff(tbTaskStaff);
        TbTask tbTask= taskService.selectTaskById(task.getTaskNumber());
        tbTask.setTaskBc(task.getTaskBc());
        taskService.updateTask(tbTask);




        return toAjax(1);

    }

    @PostMapping("/getHouse")
    @ResponseBody
    public AjaxResult getHouse(HttpServletRequest request){
        String houseRule=request.getParameter("houseRule");
        return AjaxResult.success("success",houseService.selectHouseName(houseRule));
    }


    @PostMapping("/bchedit")
    @ResponseBody
    public AjaxResult editBchSave(@Validated TbTask task) throws Exception {
        Random random = new Random();
        List<TbHouse> list=houseService.selectHouseCheckList(task.getRuleName());
        int max = list.size();
        if(max==0){

            return AjaxResult.success(max);
        }
        int number = random.nextInt(max);

        TbTask tbTask= taskService.selectTaskById(task.getTaskNumber());
        tbTask.setTaskBc(task.getTaskBc());
        tbTask.setTaskHouse(list.get(number).getHouseNumber());
        taskService.updateTask(tbTask);
        return toAjax(1);
    }

    //导出数据
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export()
    {
        List<TaskUncheck> list = taskService.selectTaskAllExport();

        //********
        for(int i=0;i<list.size();i++)
        {
            String a=list.get(i).getTaskHouse();

            TbHouse tbHouse=houseService.selectHouseById(a);

            list.get(i).setRuleName(tbHouse.getHouseRule());
            list.get(i).setHouseName(tbHouse.getHouseName());
            list.get(i).setHouseItem(tbHouse.getHouseItem());
            list.get(i).setHouseRegion(tbHouse.getHouseRegion());
            list.get(i).setHouseRole(tbHouse.getHouseRole());
            list.get(i).setHousePhone(tbHouse.getHousePhone());
            list.get(i).setHouseTime(tbHouse.getHouseTime());

            List <TbTaskStaff> tbTaskStaffs=taskStaffService.selectTbTaskStaffById(list.get(i).getTaskNumber());
            String S="【一类】";

            for(int k=0;k<tbTaskStaffs.size();k++)
            {
                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "一类"))
                {
                    S=S+staff.getStaffName();
                    if(k!=tbTaskStaffs.size()-1)
                        S=S+",";
                }

            }
            boolean flag=true;
            for(int k=0;k<tbTaskStaffs.size();k++)
            {

                TbStaff staff=staffService.selectStaffById(tbTaskStaffs.get(k).getStaffNumber());
                if(staff!=null&& Objects.equals(staff.getStaffPost(), "二类"))
                {
                    if(flag)
                    {
                        S=S+"【二类】"+staff.getStaffName();
                        flag=false;
                    }
                    else {
                        S=S+staff.getStaffName();
                    }
                    if(k!=tbTaskStaffs.size()-1)
                        S=S+",";
                }

            }
            list.get(i).setTbStaffList(S);

        }

        //********
        ExcelUtil<TaskUncheck> util = new ExcelUtil<TaskUncheck>(TaskUncheck.class);
        return util.exportExcel(list, "抽查任务数据");
    }

}

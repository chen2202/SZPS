package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.service.supervise.HouseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/supervise/data")
public class HouseController extends BaseController {


    @Autowired
    private HouseService houseService;


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

    @GetMapping("/main")
    public String datamain()
    {
        return prefix+"/main";
    }


    @RequiresPermissions("supervise:data:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbHouse tbHouse) throws Exception {

        if(sql_inj(tbHouse.getHouseRule())||sql_inj(tbHouse.getHouseName())||sql_inj(tbHouse.getHouseItem()))
        {
            throw new Exception("输入字符非法！！");
        }
        startPage();
        List<TbHouse> list = houseService.selectHouseList(tbHouse);

        for(int i=0;i<list.size();i++)
        {
            String houseTime="";
            String a=list.get(i).getHouseBegin();
            String b=list.get(i).getHouseEnd();
            houseTime=a+"~"+b;
            list.get(i).setHouseTime(houseTime);
        }

        return getDataTable(list);
    }
//    @RequiresPermissions("supervise:data:add")
//    @Log(title = "任务库管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbHouse task)
    {
        int radomInt = new Random().nextInt(999999);
        String s=String.valueOf(radomInt);
        while (houseService.checkTask(s)==1)
        {
           s=String.valueOf(new Random().nextInt(999999));
        }
        task.setHouseNumber(s);

        return toAjax(houseService.insertHouse(task));
    }

    @RequiresPermissions("supervise:data:edit")
    @Log(title = "检查对象管理", businessType = BusinessType.UPDATE)
    @GetMapping("/edit/{houseNumber}")
    public String edit(@PathVariable("houseNumber") String taskNumber, ModelMap mmap)
    {
        mmap.put("task", houseService.selectHouseById(taskNumber));
        return prefix + "/Taskedit";
    }


    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated TbHouse tbHouse)
    {           String houseTime="";
                 String a=tbHouse.getHouseBegin();
                String b=tbHouse.getHouseEnd();
                 houseTime=a+"~"+b;
             tbHouse.setHouseTime(houseTime);
            return toAjax(houseService.updateHouse(tbHouse));

    }
    @RequiresPermissions("supervise:data:remove")
    @Log(title = "检查对象管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(houseService.deleteTaskByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    public static boolean sql_inj(String str){

        String inj_str = "'|and|exec|insert|select|delete|update|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";

        String inj_stra[] = inj_str.split("|");

        for (String anInj_stra : inj_stra) {

            if (str.contains(anInj_stra)) {

                return true;

            }

        }

        return false;

    }
}

package com.szps.web.controller.supervise;


import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.web.domain.supervise.TbStaff;
import com.szps.web.service.supervise.StaffService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Controller
@RequestMapping("/supervise/data1")
public class Data1Controller extends BaseController {

    @Autowired
    private StaffService staffService;


    private String prefix = "supervise/data";


    @GetMapping("/data1")
    public String dataview1()
    {
        return prefix+"/Staffdata";
    }




    @GetMapping("/Staffadd")
    public String add1()
    {
        return prefix + "/Staffadd";
    }




    @RequiresPermissions("supervise:data1:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TbStaff staff)
    {
        startPage();
        List<TbStaff> list = staffService.selectStaffList(staff);
        return getDataTable(list);
    }

    @RequiresPermissions("supervise:data1:add")
    @Log(title = "检查人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated TbStaff staff)
    {
        int radomInt = new Random().nextInt(999999);
        String s=String.valueOf(radomInt);
        while (staffService.checkStaff(s)==1)
        {
            s=String.valueOf(new Random().nextInt(999999));
        }

        staff.setStaffNumber(s);
        return toAjax(staffService.insertStaff(staff));
    }

    @GetMapping("/edit/{staffNumber}")
    public String edit(@PathVariable("staffNumber") String staffNumber, ModelMap mmap)
    {
        mmap.put("staff", staffService.selectStaffById(staffNumber));

        return prefix + "/Staffedit";
    }

    @RequiresPermissions("supervise:data1:edit")
    @Log(title = "检查人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated TbStaff staff)
    {
        return toAjax(staffService.updateStaff(staff));
    }

    @RequiresPermissions("supervise:data1:remove")
    @Log(title = "检查人员管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(staffService.deleteStaffByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

package com.szps.web.controller.report;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.report.WeekReport;
import com.szps.web.service.report.IWeekReportService;


@Controller
@RequestMapping("/op/report/week")
public class WeekReportController extends BaseController {
	 @Autowired
	private IWeekReportService reportService;
	
	private String prefix = "/report/week";
	
   @RequiresPermissions("report:week:view")
   @GetMapping()
   public String week()
   {
       return prefix + "/report";
   }
   
   /**
    * 查询周报列表
    */
   @RequiresPermissions("report:week:view")
   @PostMapping("/list")
   @ResponseBody
   public TableDataInfo list(WeekReport WeekReport)
   {
       startPage();
       List<WeekReport> list = reportService.selectReportList(WeekReport);
       return getDataTable(list);
   }
   /**
    * 新增参数配置
    */
   @GetMapping("/add")
   public String add()
   {
       return prefix + "/add";
   }
   

   /**
    * 新增保存周报
    */
   @RequiresPermissions("report:week:add")
   @Log(title = "添加周报", businessType = BusinessType.INSERT)
   @PostMapping("/add")
   @ResponseBody
   public AjaxResult addSave( WeekReport WeekReport)
   {
   	SysUser user = ShiroUtils.getSysUser();
   	SysDept sysDept = user.getDept();
   	WeekReport.setDeptId(sysDept.getDeptId());
   	WeekReport.setDeptName(sysDept.getDeptName());
   	WeekReport.setCreateBy(user.getLoginName());
   	WeekReport.setDelFlag(WeekReport.DEL_FLAG_NORMAL);
       return toAjax(reportService.insertReport(WeekReport));
   }
   
   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") Long id, ModelMap mmap)
   {
   	WeekReport WeekReport = reportService.selectReportById(id);
       
       mmap.put("weekReport", WeekReport);
       return prefix + "/edit";
   }
   
   
   /**
    * 保存
    */
   @Log(title = "周报修改", businessType = BusinessType.UPDATE)
   @RequiresPermissions("report:week:edit")
   @PostMapping("/edit")
   @ResponseBody
   public AjaxResult editSave(@Validated WeekReport report)
   {
   	report.setUpdateBy(ShiroUtils.getLoginName());
       return toAjax(reportService.updateReport(report));
   }

   @RequiresPermissions("report:week:delete")
   @Log(title = "周报删除", businessType = BusinessType.DELETE)
   @PostMapping("/remove")
   @ResponseBody
   public AjaxResult remove(String ids)
   {
       try
       {
           return toAjax(reportService.deleteReportByIds(ids));
       }
       catch (Exception e)
       {
           return error(e.getMessage());
       }
   }
}

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
import com.szps.web.domain.report.MonthReport;
import com.szps.web.service.report.IMonthReportService;


@Controller
@RequestMapping("/op/report/month-bo")
public class MonthReportBOController extends BaseController {
	 @Autowired
	private IMonthReportService reportService;
	
	private String prefix = "/report/month";
	
   @RequiresPermissions("report:month:view")
   @GetMapping()
   public String month()
   {
       return prefix + "/report-bo";
   }
   
   /**
    * 查询月报列表
    */
   @RequiresPermissions("report:month:view")
   @PostMapping("/list")
   @ResponseBody
   public TableDataInfo list(MonthReport monthReport)
   {
       startPage();
       List<MonthReport> list = reportService.selectReportList(monthReport);
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
    * 新增保存月报
    */
   @RequiresPermissions("report:month:add")
   @Log(title = "添加月报", businessType = BusinessType.INSERT)
   @PostMapping("/add")
   @ResponseBody
   public AjaxResult addSave( MonthReport monthReport)
   {
   	SysUser user = ShiroUtils.getSysUser();
   	SysDept sysDept = user.getDept();
   	monthReport.setDeptId(sysDept.getDeptId());
   	monthReport.setDeptName(sysDept.getDeptName());
   	monthReport.setCreateBy(user.getLoginName());
   	monthReport.setDelFlag(MonthReport.DEL_FLAG_NORMAL);
       return toAjax(reportService.insertReport(monthReport));
   }
   
   @GetMapping("/edit/{id}")
   public String edit(@PathVariable("id") Long id, ModelMap mmap)
   {
	   MonthReport monthReport = reportService.selectReportById(id);
       
       mmap.put("monthReport", monthReport);
       return prefix + "/edit";
   }
   
   
   /**
    * 保存
    */
   @Log(title = "月报修改", businessType = BusinessType.UPDATE)
   @RequiresPermissions("report:month:edit")
   @PostMapping("/edit")
   @ResponseBody
   public AjaxResult editSave(@Validated MonthReport report)
   {
   	report.setUpdateBy(ShiroUtils.getLoginName());
       return toAjax(reportService.updateReport(report));
   }

   @RequiresPermissions("report:month:delete")
   @Log(title = "月报删除", businessType = BusinessType.DELETE)
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

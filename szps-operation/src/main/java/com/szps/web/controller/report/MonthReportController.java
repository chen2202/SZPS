package com.szps.web.controller.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.DateUtils;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.service.report.IDayReportWService;


@Controller
@RequestMapping("/op/report/month")
public class MonthReportController extends BaseController {
	@Autowired
	private IDayReportWService reportService;
	
	private String prefix = "/report/month";
	
   @RequiresPermissions("report:month:view")
   @GetMapping()
   public String month()
   {
       return prefix + "/report";
   }
   
   /**
    * 查询月报列表
    */
   @RequiresPermissions("report:month:view")
   @PostMapping("/list")
   @ResponseBody
   public TableDataInfo list(DayReportW dayReport,ModelMap mmap)
   {
       startPage();
       
       List<DayReportW> list = searchReport(dayReport);
       List<DayReportW> nlist = dayReport.calMonthReport(list);
       mmap.put("reportdate", dayReport.getReportdate());
       return getDataTable(nlist);
   }
   
   @Log(title = "资料导出", businessType = BusinessType.EXPORT)
   @RequiresPermissions("report:day:export")
   @PostMapping("/export")
   @ResponseBody
   public AjaxResult export(DayReportW dayReport,ModelMap mmap)
   {
	   List<DayReportW> list = searchReport(dayReport);
       List<DayReportW> nlist = dayReport.calMonthReport(list);
       ExcelUtil<DayReportW> util = new ExcelUtil<DayReportW>(DayReportW.class);
       return util.exportExcel(nlist, "资料数据");
   }
   
   public List<DayReportW> searchReport(DayReportW dayReport){
	   if (null != dayReport) {
	       	dayReport.setDtype("a");
	       	
	   }
      String startTime1 = dayReport.getStartTime1();
      String endTime1 = dayReport.getEndTime1();
      if (null == startTime1 || startTime1.equals("")) {
   	   startTime1 ="1900-01-01";
      }
      if (null == endTime1 || endTime1.equals("")) {
  			endTime1 = DateUtils.getTomorrowStr();
      }else {
   	   endTime1 = endTime1 +"-32";
      }
      List<DayReportW> list = reportService.selectListBetween(dayReport.getDtype(), startTime1, endTime1);
      return list;
   }
  
}

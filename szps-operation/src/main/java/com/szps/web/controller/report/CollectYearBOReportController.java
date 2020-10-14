package com.szps.web.controller.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.szps.web.domain.report.DayReport;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.domain.report.YearReport;
import com.szps.web.domain.report.YearReportStat;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/collect/year-bo")
public class CollectYearBOReportController extends BaseController {
	 @Autowired
	private IDayReportWService reportService;
	
	private String prefix = "/report/collect";

    
    @GetMapping("")
    public String collect( ModelMap mmap)
    {
        return prefix + "/yearcollect-bo";
    }
    @GetMapping("/stat")
    public String stat(ModelMap mmap)
    {
    	DayReportW dayReport = new DayReportW();
    	dayReport.setDtype("b");
        YearReportStat yearReportStat = new YearReportStat();
        List<DayReportW> list = reportService.selectList(dayReport);
        List<YearReportStat> list2 = yearReportStat.calYearReport(list);
    	mmap.put("nlist", list2);
        return prefix + "/stat";
    }
    @RequiresPermissions("report:daycollect:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayReportW dayReport,ModelMap mmap)
    {
        startPage();
        
        YearReport yearReport  = new YearReport();
        List<YearReport> yList = yearReport.calYearReport(searchReport(dayReport));
        
        return getDataTable(yList);
    }
    
    public List<DayReportW> searchReport(DayReportW dayReport){
    	if (null == dayReport) {
        	dayReport = new DayReportW();
 		}
        dayReport.setDtype("b");
        String startTime1 = dayReport.getStartTime1();
        String endTime1 = "9999-12-31" ;
        if (null == startTime1 || startTime1.equals("")) {
			try {
				startTime1 = String.valueOf(DateUtils.getYear(DateUtils.getDate(), DateUtils.YYYY_MM_DD))+"-00-00";
				endTime1 =  String.valueOf(DateUtils.getYear(DateUtils.getDate(), DateUtils.YYYY_MM_DD))+"-12-32";
			} catch (Exception e) {
				
			}
		}else {
			endTime1 = startTime1+"-12-32";
			startTime1 = startTime1+"-00-00";
		}
        List<DayReportW> list = reportService.selectListForYear(dayReport.getDtype(), startTime1, endTime1);
        return list;
    }
    
    @Log(title = "资料导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:day:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DayReportW dayReport,ModelMap mmap)
    {
    	YearReport yearReport  = new YearReport();
        List<YearReport> yList = yearReport.calYearReport(searchReport(dayReport));
        ExcelUtil<YearReport> util = new ExcelUtil<YearReport>(YearReport.class);
        return util.exportExcel(yList, "资料数据");
    }
}

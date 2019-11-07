package com.szps.web.controller.report;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.szps.common.core.controller.BaseController;
import com.szps.common.utils.DateUtils;
import com.szps.web.domain.report.DayReport;
import com.szps.web.service.report.IDayReportService;

@Controller
@RequestMapping("/op/report/collect")
public class CollectReportController extends BaseController {
	 @Autowired
	private IDayReportService reportService;
	
	private String prefix = "/report/collect";
	
    @GetMapping("/day")
    public String daycollect( ModelMap mmap)
    {
    	DayReport dayReport = new DayReport();
		dayReport.setReportDate(DateUtils.getDistanceDay(new Date(), -1));
		List<DayReport> list = reportService.selectReportList(dayReport);
        mmap.put("list", list);
        if (dayReport!=null && dayReport.getReportDate()!=null) {
        	mmap.put("reportDate", dayReport.getReportDate());
		}else {
			mmap.put("reportDate","");
		}
        mmap.put("dayReport",dayReport);
        return prefix + "/daycollect";
    }
    @GetMapping("/month")
    public String monthcollect( ModelMap mmap)
    {
        return prefix + "/monthcollect";
    }
    
    /**
     * 查询日报列表
     */
    @RequiresPermissions("report:daycollect:view")
    @PostMapping("/day/list")
    public String list(DayReport dayReport, ModelMap mmap)
    {
        List<DayReport> list = reportService.selectReportList(dayReport);
        mmap.put("list", list);
        if (dayReport!=null && dayReport.getReportDate()!=null) {
        	mmap.put("reportDate", dayReport.getReportDate());
		}else {
			mmap.put("reportDate","");
		}
        mmap.put("dayReport",dayReport);
        return prefix + "/daycollect";
    }
 
    @RequiresPermissions("report:monthcollect:view")
    @PostMapping("/month/list")
    public String monthlist(ModelMap mmap, @RequestParam("deptId") String deptId, @RequestParam("deptName") String deptName, 
    		@RequestParam("startTime") String startTime, 
    		@RequestParam("endTime") String endTime)
    {
    	
    	
    	
    	mmap.put("deptName",deptName);
    	mmap.put("startTime",startTime);
    	mmap.put("endTime",endTime);
        return prefix + "/monthcollect";
    }
}

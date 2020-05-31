package com.szps.web.controller.report;

import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.utils.DateUtils;
import com.szps.web.domain.report.DayReport;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/collect/year")
public class CollectYearReportController extends BaseController {
	 @Autowired
	private IDayReportWService reportService;
	
	private String prefix = "/report/collect";

    
    @GetMapping("")
    public String collect( ModelMap mmap)
    {
        return prefix + "/yearcollect";
    }
    
    @RequiresPermissions("report:daycollect:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayReportW dayReport)
    {
        startPage();
        if (null != dayReport) {
        	dayReport.setDtype("a");
		}
        List<DayReportW> list = reportService.selectList(dayReport);
        return getDataTable(list);
    }
}

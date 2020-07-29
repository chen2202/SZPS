package com.szps.web.controller.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.szps.common.utils.DateUtils;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.domain.report.MonthReport;
import com.szps.web.service.report.IDayReportWService;
import com.szps.web.service.report.IMonthReportService;


@Controller
@RequestMapping("/op/report/month-bo")
public class MonthReportBOController extends BaseController {
	@Autowired
	private IDayReportWService reportService;
	
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
   public TableDataInfo list(DayReportW dayReport,ModelMap mmap)
   {
       startPage();
       if (null != dayReport) {
       	dayReport.setDtype("b");
       	mmap.put("reportdate", dayReport.getReportdate());
		}
       String startTime1 = dayReport.getStartTime1();
       String endTime1 = dayReport.getEndTime1();
       if (null == startTime1 || startTime1.equals("")) {
    	   startTime1 ="1900-01-01";
       }
       if (null == endTime1 || endTime1.equals("")) {
   			endTime1 = DateUtils.getTomorrowStr();
       }else {
    	   endTime1 = endTime1 +"-31";
       }
       List<DayReportW> list = reportService.selectListBetween(dayReport.getDtype(), startTime1, endTime1);
       List<DayReportW> nlist = new ArrayList<DayReportW>();
       if (null != list && list.size()>0) {
       	Map<String, List<DayReportW>> map = new HashMap<>();
       	int k = 0;
       	int lastIndex = k;
       	Long id = 1L;
       	for (DayReportW dayReportW : list) {
       		List<DayReportW> tmpList = map.get(dayReportW.getBasin());
       		if (tmpList == null) {
       			if (k > 0) {
       				DayReportW lt =list.get(k-1);
       				DayReportW w = dayReportW.calReport(list, lastIndex, k);
       				//String.valueOf(/t1)
       				List<DayReportW> tList = map.get(lt.getBasin());
       				tList.add(w);
       				nlist.addAll(tList);
       				lastIndex = k;
       				id=1L;
					}
       			tmpList = new ArrayList<>();
       			dayReportW.setId(id);
       			tmpList.add(dayReportW);
       			map.put(dayReportW.getBasin(), tmpList);
       		} else {
       			id++;
       			dayReportW.setId(id);
       			tmpList.add(dayReportW);
       		}
       		k++;
			}
       	if (k>lastIndex) {
       		DayReportW lt =list.get(k-1);
				DayReportW w = lt.calReport(list, lastIndex, k);
				//String.valueOf(/t1)
				List<DayReportW> tList = map.get(lt.getBasin());
				tList.add(w);
				nlist.addAll(tList);
			}
       	
		}
       return getDataTable(nlist);
   }
}

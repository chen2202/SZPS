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
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysBRF;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysAreaService;
import com.szps.system.service.ISysBRFService;
import com.szps.web.domain.report.DayReportStat;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/daybo")
public class DayReportBOController extends BaseController {
	 @Autowired
	private IDayReportWService reportService;
		@Autowired
		private ISysBRFService brfService;
	    @Autowired
	    private ISysAreaService areaService;
	private String prefix = "report/day";
	
    @RequiresPermissions("report:day:view")
    @GetMapping()
    public String day()
    {
        return prefix + "/report-bo";
    }
    
    /**
     * 查询日报列表
     */
    @RequiresPermissions("report:day:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayReportW dayReport)
    {
        startPage();
        if (null != dayReport) {
        	dayReport.setDtype("b");
		}
        List<DayReportW> list = reportService.selectList(dayReport);
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
    /**
     * 新增参数配置
     */
    @GetMapping("/collect")
    public String collect()
    {
        return prefix + "/collect";
    }
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SysBRF brf = new SysBRF();
    	brf.setParentId(100L);
    	mmap.put("basins", brfService.selectList(brf));
    	mmap.put("areas", areaService.selectAreaAll());
        return prefix + "/add-bo";
    }

    /**
     * 新增保存日报
     */
    @RequiresPermissions("report:day:add")
    @Log(title = "添加日报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( DayReportW dayReport)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	SysDept sysDept = user.getDept();
		/*
		 * dayReport.setDeptid(sysDept.getDeptId());
		 * dayReport.setDeptname(sysDept.getDeptName());
		 */
    	dayReport.setCreateBy(user.getLoginName());
    	dayReport.setDept_id(user.getDeptId());
    	dayReport.setDtype("b");
    	reportService.insert(dayReport);
        return toAjax(1);
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	DayReportW dayReport = reportService.selectById(id);
        
        mmap.put("dayReport", dayReport);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "日报修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:day:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated DayReportW report)
    {
    	report.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(reportService.update(report));
    }

    @RequiresPermissions("report:day:delete")
    @Log(title = "日报删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(reportService.deleteByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    
    
    @GetMapping("/stat/{rd}")
    public String stat(@PathVariable("rd") String rd,ModelMap mmap)
    {
    	if (null!=rd && rd.equalsIgnoreCase("{rd}")) {
			rd = "";
		}
    	DayReportW dayReport = new DayReportW();
    	dayReport.setDtype("b");
    	dayReport.setReportdate(rd);
    	List<DayReportW> list = reportService.selectList(dayReport);
    	List<DayReportStat> nlist = new ArrayList<DayReportStat>();
    	DayReportStat ds = new DayReportStat();
        if (null != list && list.size()>0) {
        	Map<String, List<DayReportW>> map = new HashMap<>();
        	int k = 0;
        	int lastIndex = k;
        	Long id = 1L;
        	for (DayReportW dayReportW : list) {
        		List<DayReportW> tmpList = map.get(dayReportW.getBasin());
        		if (tmpList == null) {
        			if (k > 0) {
        				DayReportStat w = ds.statReport(list, lastIndex, k);
        				nlist.add(w);
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
        		DayReportStat w = ds.statReport(list, lastIndex, k);
				nlist.add(w);
			}
        	
		}
    	if (null != nlist && nlist.size()>0) {
    		DayReportStat tStat = new DayReportStat();
    		tStat.setBasin("全市");
    		Double tcapacity = 0d;
    		Double loadrate = 0d;
			for (DayReportStat dayReportStat : nlist) {
				try {
					tcapacity = tcapacity+ Double.valueOf(dayReportStat.getTcapacity());
				} catch (Exception e) {
				}
				
				try {
					loadrate = loadrate + Double.valueOf(dayReportStat.getLoadrate());
				} catch (Exception e) {
				}
			}
			tStat.setTcapacity(String.format("%.2f", tcapacity));
			tStat.setLoadrate(String.format("%.2f", loadrate));

			nlist.add(tStat);
		}
    	
    	mmap.put("reportDate", rd);
    	mmap.put("nlist", nlist);
        return prefix + "/stat";
    }
    
}

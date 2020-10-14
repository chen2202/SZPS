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
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysBRF;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.system.service.ISysAreaService;
import com.szps.system.service.ISysBRFService;
import com.szps.web.domain.dm.DmData;
import com.szps.web.domain.report.DayReportStat;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/day")
public class DayReportController extends BaseController {
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
        return prefix + "/report";
    }
    
    /**
     * 查询日报列表
     */
    @RequiresPermissions("report:day:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DayReportW dayReport,ModelMap mmap)
    {
        startPage();
        if (null != dayReport) {
        	dayReport.setDtype("a");
			/*
			 * String reportDate = dayReport.getReportdate(); if (reportDate==null ||
			 * reportDate.equals("")) { reportDate = DateUtils.getDistanceDay(new Date(),
			 * -1); } dayReport.setReportdate(reportDate);
			 */
        	mmap.put("reportdate", dayReport.getReportdate());
		}
        List<DayReportW> list = reportService.selectList(dayReport);
        List<DayReportW> nlist = dayReport.totalReport(list);
        
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
    
    @GetMapping("/stat/{rd}")
    public String stat(@PathVariable("rd") String rd,ModelMap mmap)
    {
    	if (null!=rd && rd.equalsIgnoreCase("{rd}")) {
			rd = DateUtils.getDistanceDay(new Date(), -1);
		}
    	DayReportW dayReport = new DayReportW();
    	dayReport.setDtype("a");
    	dayReport.setReportdate(rd);
    	List<DayReportW> list = reportService.selectList(dayReport);
    	List<DayReportStat> nlist = new ArrayList<DayReportStat>();
    	DayReportStat ds = new DayReportStat();
    	StringBuffer loadratelt90 = new StringBuffer("");
    	StringBuffer inOver1 = new StringBuffer("");
    	StringBuffer inOver2 = new StringBuffer("");
    	StringBuffer inOver3 = new StringBuffer("");
    	StringBuffer inless1 = new StringBuffer("");
    	StringBuffer inless2 = new StringBuffer("");
    	StringBuffer inless3 = new StringBuffer("");
    	StringBuffer outCOD = new StringBuffer("");
    	StringBuffer sludecHigh1 = new StringBuffer("");
    	StringBuffer sludecHigh2 = new StringBuffer("");
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
        		try {
        			String a = dayReportW.getLoadrate();
                	if (a!=null && a.contains("%")) {
        				a=a.replace("%", "");
        			}
                	if (Double.valueOf(a)<90) {
                		loadratelt90.append(dayReportW.getDeptname()+"  ");
        			}
				} catch (Exception e) {
					// TODO: handle exception
				}
        		
        		
        		try {
        			//inOver;
        			String a = dayReportW.getIncod();
                	
				} catch (Exception e) {
					// TODO: handle exception
				}
        		try {
        			//inless;
        			String a = dayReportW.getIncod();
        			if (Double.valueOf(a)<180) {
						inless1.append(dayReportW.getDeptname()+"  ");
					}
        			
        			String b = dayReportW.getInan();
        			if (Double.valueOf(b)<18) {
						inless2.append(dayReportW.getDeptname()+"  ");
					}
        			
        			String c = dayReportW.getInbod();
        			if (Double.valueOf(b)<180) {
						inless3.append(dayReportW.getDeptname()+"  ");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
        		
        		try {
        			//outCOD;
        			String a = dayReportW.getOutcod();
                	
                	if (Double.valueOf(a)<5) {
                		outCOD.append(dayReportW.getDeptname()+"  ");
        			}
				} catch (Exception e) {
					// TODO: handle exception
				}
        		try {
        			//sludecHigh;
        			String a = dayReportW.getSludec();
                	
                	if (Double.valueOf(a)>10000) {
                		sludecHigh1.append(dayReportW.getDeptname()+"  ");
        			}
                	if (Double.valueOf(a)>=8000 && Double.valueOf(a)<=10000) {
                		sludecHigh2.append(dayReportW.getDeptname()+"  ");
        			}
				} catch (Exception e) {
					// TODO: handle exception
				}
            	
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
					String s = dayReportStat.getLoadrate();
					if (s!=null && s.contains("%")) {
						s=s.replace("%", "");
					}
					loadrate = loadrate + Double.valueOf(s);
				} catch (Exception e) {
				}
			}
			tStat.setTcapacity(String.format("%.2f", tcapacity));
			tStat.setLoadrate(String.format("%.2f", loadrate)+"%");
			
			nlist.add(tStat);
		}
    	mmap.put("loadratelt90", loadratelt90.toString());
    	mmap.put("inOver1", inOver1.toString());
    	mmap.put("inOver2", inOver2.toString());
    	mmap.put("inOver3", inOver3.toString());
    	mmap.put("inless1", inless1.toString());
    	mmap.put("inless2", inless2.toString());
    	mmap.put("inless3", inless3.toString());
    	mmap.put("outCOD", outCOD.toString());
    	mmap.put("sludecHigh1", sludecHigh1.toString());
    	mmap.put("sludecHigh2", sludecHigh2.toString());
    	mmap.put("reportDate", rd);
    	mmap.put("nlist", nlist);
        return prefix + "/stat";
    }
    
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
    	SysBRF brf = new SysBRF();
    	brf.setParentId(100L);
    	mmap.put("basins", brfService.selectList(brf));
    	mmap.put("areas", areaService.selectAreaAll());
        return prefix + "/add";
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
    	dayReport.setDtype("a");
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

 
    
    @Log(title = "资料导出", businessType = BusinessType.EXPORT)
    @RequiresPermissions("report:day:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DayReportW dayReport,ModelMap mmap)
    {
    	if (null != dayReport) {
        	dayReport.setDtype("a");
			/*
			 * String reportDate = dayReport.getReportdate(); if (reportDate==null ||
			 * reportDate.equals("")) { reportDate = DateUtils.getDistanceDay(new Date(),
			 * -1); } dayReport.setReportdate(reportDate);
			 */
        	mmap.put("reportdate", dayReport.getReportdate());
		}
        List<DayReportW> list = reportService.selectList(dayReport);
        List<DayReportW> nlist = dayReport.totalReport(list);
    	
        ExcelUtil<DayReportW> util = new ExcelUtil<DayReportW>(DayReportW.class);
        return util.exportExcel(nlist, "资料数据");
    }
}

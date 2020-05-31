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
import com.szps.web.domain.report.DayReportW;
import com.szps.web.service.report.IDayReportWService;

@Controller
@RequestMapping("/op/report/daybo")
public class DayReportBOController extends BaseController {
	 @Autowired
	private IDayReportWService reportService;
	
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
        return getDataTable(list);
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
    public String add()
    {
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
}

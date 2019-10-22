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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.framework.util.ShiroUtils;
import com.szps.system.domain.SysDept;
import com.szps.system.domain.SysUser;
import com.szps.web.domain.report.OpLog;
import com.szps.web.service.report.IOpLogService;

@Controller
@RequestMapping("/op/report/oplog")
public class OpLogController extends BaseController {
	 @Autowired
	private IOpLogService service;
	
	private String prefix = "/report/oplog";
	
    @RequiresPermissions("report:oplog:view")
    @GetMapping()
    public String oplog(ModelMap mmap)
    {
        return prefix + "/report";
    }
    
    /**
     * 查询日报列表
     */
    @RequiresPermissions("report:oplog:view")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OpLog opLog)
    {
        startPage();
        List<OpLog> list = service.selectReportList(opLog);
        return getDataTable(list);
    }
    /**
     * 新增参数配置
     */
    @GetMapping("/add")
    public String add( ModelMap mmap)
    {
    	SysUser user = ShiroUtils.getSysUser();
    	SysDept sysDept = user.getDept();
    	mmap.put("dept", sysDept.getDeptName());
        return prefix + "/add";
    }
    

    /**
     * 新增保存日报
     */
    @RequiresPermissions("report:oplog:add")
    @Log(title = "添加日报", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave( OpLog opLog, @RequestParam("poolId")String[] poolIds,  
											@RequestParam("waterStartTime")String[] waterStartTimes,  
											@RequestParam("waterEndTime")String[] waterEndTimes, 
											@RequestParam("waterUsage")String[] waterUsages,  
											@RequestParam("dryHour")String[] dryHours,
											@RequestParam("dryMin")String[] dryMins,  
											@RequestParam("logRemarks")String[] logRemarks,
											@RequestParam("logRecorder")String[] logRecorders)
    {
    	try {
    		SysUser user = ShiroUtils.getSysUser();
        	SysDept sysDept = user.getDept();
        	int size = poolIds.length;
    		for(int i =0;i<size;i++){
    			OpLog ol = new OpLog();
    			ol.setLogDate(opLog.getLogDate());
    			ol.setWeather(opLog.getWeather());
    			ol.setDeptId(sysDept.getDeptId());
    			ol.setDeptName(sysDept.getDeptName());
    			ol.setPoolId(poolIds[i]);
    			ol.setWaterStartTime(waterStartTimes[i]);
    			ol.setWaterEndTime(waterEndTimes[i]);
    			ol.setWaterUsage(waterUsages[i]);
    			ol.setDryHour(dryHours[i]);
    			ol.setDryMin(dryMins[i]);
    			ol.setLogRemarks(logRemarks[i]);
    			ol.setLogRecorder(logRecorders[i]);
    			ol.setCreateBy(user.getLoginName());
    			ol.setDelFlag(OpLog.DEL_FLAG_NORMAL);
    			service.insertReport(ol);
    		}
    		return success();
		} catch (Exception e) {
			return error();
		}
    }
    
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
    	OpLog opLog = service.selectReportById(id);
        
        mmap.put("opLog", opLog);
        return prefix + "/edit";
    }
    
    
    /**
     * 保存
     */
    @Log(title = "日报修改", businessType = BusinessType.UPDATE)
    @RequiresPermissions("report:oplog:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OpLog report,@RequestParam("poolId")String[] poolIds,  
			@RequestParam("waterStartTime")String[] waterStartTimes,  
			@RequestParam("waterEndTime")String[] waterEndTimes)
    {
    	System.out.println(poolIds);
    	report.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(service.updateReport(report));
    }

    @RequiresPermissions("report:oplog:delete")
    @Log(title = "日报删除", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(service.deleteReportByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}

package com.szps.web.controller.employee;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.employee.Worker;
import com.szps.web.service.employee.WorkerService;

/**
 * 从业人员页面 控制器
 * @author zxc
 *
 */
@Controller
@RequestMapping("/employee/worker")
public class WorkerController extends BaseController{
	private String prefix = "employee/worker"; //前缀路径
	
	@Autowired
	private WorkerService workerService;
	
	/**
	 * 跳转到employee.html的路径
	 * 
	 */
	@RequiresPermissions("employee:worker:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }
	
	/**
	 * 添加 从业人员信息表 到employee.html
	 * 
	 */
	@RequiresPermissions("employee:worker:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Worker worker)
    {
        startPage();
        List<Worker> list = workerService.selectAllWorker(worker);
        return getDataTable(list);
    }
	
	/**
	 * 导出从业人员信息到excel表
	 * @param worker
	 * @return
	 */
	//@Log(title = "从业人员管理", businessType = BusinessType.EXPORT)
	@RequiresPermissions("employee:worker:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Worker worker)
    {
        List<Worker> list = workerService.selectAllWorker(worker);
        ExcelUtil<Worker> util = new ExcelUtil<Worker>(Worker.class);
        return util.exportExcel(list, "从业人员数据");
    }
	
	/**
     * 新增从业人员
     * 跳转到add.html
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 保存新增从业人员
     */
    @RequiresPermissions("employee:worker:add")
    @Log(title = "从业人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Worker worker){   
	    workerService.insertWorker(worker);
        return toAjax(1); 
    }
    
    /**
     * 修改从业人员
     * 跳转到edit.html
     */
    @GetMapping("/edit/{idCard}")
    public String edit(@PathVariable("idCard") String idCard,ModelMap mmap) {
    	mmap.put("worker", workerService.selectWorkerById(idCard));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存从业人员
     * 
     */
    @RequiresPermissions("employee:worker:edit")
    @Log(title = "从业人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Worker worker) {
    	workerService.updateWorker(worker);
    	return toAjax(1);
    }
    
    /**
     * 根据身份证号删除从业人员信息
     */
    @RequiresPermissions("employee:worker:remove")
    @Log(title = "从业人员管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(workerService.deleteWorkerById(ids));
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
   
   /**
    * 校验从业人员身份证号唯一性
    */
   @PostMapping("/checkWorkerIdcardUnique")
   @ResponseBody
   public String checkWorkerIdcardUnique(Worker worker){
       return workerService.checkWorkerIdcardUnique(worker); 
   }
	
}

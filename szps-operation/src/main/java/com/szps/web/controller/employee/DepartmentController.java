package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.szps.common.annotation.Log;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.domain.AjaxResult;
import com.szps.common.core.page.TableDataInfo;
import com.szps.common.enums.BusinessType;
import com.szps.web.domain.employee.Department;
import com.szps.web.service.employee.DepartmentService;

/**
 * 部门页面 控制器
 * @author zxc  
 *
 */
@Controller
@RequestMapping("/employee")
public class DepartmentController extends BaseController{
	private String prefix = "employee/department"; //前缀路径
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 人员信息
	 * 公司/水厂下拉框选择某公司/水厂后，添加公司/水厂的全部部门
	 * @return 部门名称，部门代码组成的字符串列表
	 */
	@PostMapping("/worker/departmentNameList")
    @ResponseBody
    public List<String> departmentNameList(Department department){
		List<Department> departmentModel = departmentService.selectSomeDepartment(department);
		List<String> departmentInfo = new ArrayList<String>(); //存放某公司全部部门信息
		for(int i=0;i<departmentModel.size();i++) {
			Department d = departmentModel.get(i);
			departmentInfo.add(d.getDepartment_name());
			departmentInfo.add(d.getDepartment_id());
		}
		return departmentInfo;
	} 
	
	/**
	 * 人员信息 编辑页面
	 * 公司/水厂下拉框选择某公司/水厂后，添加公司/水厂的全部部门
	 * @return 部门名称，部门代码组成的字符串列表
	 */
	@PostMapping("/worker/edit/departmentNameList")
    @ResponseBody
    public List<String> departmentNameList3(Department department){
		List<Department> departmentModel = departmentService.selectSomeDepartment(department);
		List<String> departmentInfo = new ArrayList<String>(); //存放某公司全部部门信息
		for(int i=0;i<departmentModel.size();i++) {
			Department d = departmentModel.get(i);
			departmentInfo.add(d.getDepartment_name());
			departmentInfo.add(d.getDepartment_id());
		}
		return departmentInfo;
	}
	
	/**
	 * 新增部门时
	 * 跳转到/department/add.html
	 */
	 @GetMapping("/department/add")
	 public String add()
	 {
		 return prefix + "/add";
	 }
	 
	 /**
	  * 新增部门
	  */
	 @RequiresPermissions("employee:department:add")
	 @Log(title = "部门管理", businessType = BusinessType.INSERT)
	 @PostMapping("/department/add")
	 @ResponseBody
	 public AjaxResult addSave(@Validated Department department) {
		 departmentService.insertDepartment(department);
		 return toAjax(1);
	 }
	 
	 /**
	  * 添加新部门时，校验部门代码唯一性
	  */
	 @PostMapping("/department/checkDepartmentIdUnique")
	 @ResponseBody
	 public String checkDepartmentIdcardUnique(Department department) {
		return departmentService.checkdDepartmentIdUnique(department);
	 }
	
	/**
	 * 部门信息
	 * 公司/水厂下拉框选择某公司/水厂后，添加公司/水厂的全部部门
	 * @return 部门名称，部门代码组成的字符串列表
	 */
	@PostMapping("/department/departmentNameList")
    @ResponseBody
    public List<String> departmentNameList2(Department department){
		List<Department> departmentModel = departmentService.selectSomeDepartment(department);
		List<String> departmentInfo = new ArrayList<String>(); //存放某公司全部部门信息
		for(int i=0;i<departmentModel.size();i++) {
			Department d = departmentModel.get(i);
			departmentInfo.add(d.getDepartment_name());
			departmentInfo.add(d.getDepartment_id());
		}
		return departmentInfo;
	} 
	
	/**
     * 跳转department/department.html
     */
    @RequiresPermissions("employee:department:view")
    @GetMapping("/department")
    public String company(){
        return prefix + "/department";
    }
    
    /**
     *查询全部公司信息，表格显示
     *@return 全部部门信息 
     */
    @RequiresPermissions("employee:department:list")
    @PostMapping("/department/list")
    @ResponseBody
    public TableDataInfo list(Department department) {
    	startPage();
    	List<Department> list = departmentService.selectAllDepartment(department);
    	return getDataTable(list);
    }
    
    /**
     * 根据部门代码删除部门及其直接子部门
     * 
     */
    @RequiresPermissions("employee:department:remove")
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @PostMapping("/department/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(departmentService.deleteDepartmentById(ids));
    	}catch(Exception e) {
    		 return error(e.getMessage());
    	}
    }
    
}

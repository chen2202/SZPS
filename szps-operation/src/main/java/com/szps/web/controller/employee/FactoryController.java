package com.szps.web.controller.employee;

import java.util.ArrayList;
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
import com.szps.web.domain.employee.Department;
import com.szps.web.domain.employee.Factory;
import com.szps.web.service.employee.DepartmentService;
import com.szps.web.service.employee.FactoryService;

<<<<<<< HEAD
=======
/**
 * 水厂页面
 * @author zxc
 *
 */
>>>>>>> cc172c9ebff30d4594bca7e8bfd8d691701d16bb
@Controller
@RequestMapping("/employee")
public class FactoryController extends BaseController{
	private String prefix = "employee/factory"; 
	private String oneFactoryID = "";
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private FactoryService factoryService;
	
	/**
	 * 查询全部水厂名称，添加到worker/add.html和worker/edit.html
	 * 下拉菜单中
	 * @return 水厂名称 水厂代码
	 */
	@PostMapping("/worker/factoryNameList")
    @ResponseBody
	public List<String> factoryNameList(){
		List<Factory> factoryModel = factoryService.selectAllFactoryName();
		List<String> factoryInfo = new ArrayList<String>();
		for(int i=0;i<factoryModel.size();i++) { 
			Factory f = (Factory)factoryModel.get(i);
			factoryInfo.add(f.getName());
			factoryInfo.add(f.getFactory_id());
        }
		return factoryInfo;
	}
	
	/**
	 * 查询全部水厂名称，添加到department/add.html
	 * 下拉菜单中
	 * @return 水厂名称 水厂代码
	 */
	@PostMapping("/department/factoryNameList")
    @ResponseBody
	public List<String> factoryNameList2(){
		List<Factory> factoryModel = factoryService.selectAllFactoryName();
		List<String> factoryInfo = new ArrayList<String>();
		for(int i=0;i<factoryModel.size();i++) { 
			Factory f = (Factory)factoryModel.get(i);
			factoryInfo.add(f.getName());
			factoryInfo.add(f.getFactory_id());
        }
		return factoryInfo;
	}
	
	/**
	 * 跳转到factory.html的路径
	 * 
	 */
	@RequiresPermissions("employee:factory:view")
    @GetMapping("/factory")
    public String factory()
    {
        return prefix + "/factory";
    }
	
	/**
	 * 将水厂信息添加到factory.html
	 */
	@RequiresPermissions("employee:factory:list")
    @PostMapping("/factory/list")
    @ResponseBody
    public TableDataInfo list(Factory factory)
    {
        startPage();
        List<Factory> list = factoryService.selectAllFactory(factory);
        return getDataTable(list);
    }
	
	 /**
     * 跳转factory/detail.html
     */
    @GetMapping("factory/detail/{factory_id}")
    public String detail(@PathVariable("factory_id") String factory_id,ModelMap mmap) {
    	oneFactoryID = factory_id; //打开details.html时，获取的company_id提取出来
    	
    	return prefix + "/detail";
    }
    
    /**
   	 * 生成水厂的组织结构图
   	 * @return 拼接的组织结构图json
   	 */
    @RequiresPermissions("employee:factory:detail")
    @PostMapping("/factory/detail/orgChart")
	@ResponseBody
    public String companyOrgChart() {
    	String factroyName = factoryService.selectFactoryById(oneFactoryID);
    	List<Department> departmentInfo = departmentService.selectAllDepartmentByCompanyId(oneFactoryID);
    	
    	List<TreeNode> list = new ArrayList<TreeNode>(); //空树
		list.add(new TreeNode("no",factroyName,"0")); //根节点
		for(int i=0;i<departmentInfo.size();i++) { //子节点初始化
			list.add(new TreeNode(departmentInfo.get(i).getDepartment_id(),
					departmentInfo.get(i).getDepartment_name(),
					departmentInfo.get(i).getParent_department_id()));
		}
		List<TreeNode> list2 = TreeBuild.toTree02(list,"0"); //所有节点成树
		
		String cpOrgChart = "{\"data\": " + list2.toString() + "}"; //树结构json数据进一步完善
		
		return cpOrgChart;
    }
    
    /**
     * 新增水厂
     * 跳转到add.html
     */
    @GetMapping("/factory/add")
    public String add(){
        return prefix + "/add";
    }
    
    /**
     * 保存新增水厂
     */
    @RequiresPermissions("employee:factory:add")
    @Log(title = "水厂添加", businessType = BusinessType.INSERT)
    @PostMapping("/factory/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Factory factory) {
    	factoryService.insertFactory(factory);
    	return toAjax(1);
    }
    
    /**
     * 修改水厂
     * 跳转到edit.html
     */
    @GetMapping("/factory/edit/{factory_id}")
    public String edit(@PathVariable("factory_id") String factory_id,ModelMap mmap) {
    	mmap.put("factory", factoryService.selectFactoryById2(factory_id));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存水厂
     * @param factory 要修改的水厂对象
     */
    @RequiresPermissions("employee:factory:edit")
    @Log(title = "水厂修改", businessType = BusinessType.UPDATE)
    @PostMapping("/factory/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Factory factory) {
    	factoryService.updateFactory(factory);
    	return toAjax(1);
    }
    
    /**
     * 根据水厂代码删除水厂信息
     */
    @RequiresPermissions("employee:factory:remove")
    @Log(title = "水厂删除", businessType = BusinessType.DELETE)
    @PostMapping("/factory/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(factoryService.deleteFactoryById(ids));
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验水厂代码唯一性
     */
    @PostMapping("/factory/checkFactoryIdUnique")
    @ResponseBody
    public String checkFactoryIdUnique(Factory factory) {
    	return factoryService.checkFactoryIdUnique(factory);
    }
}

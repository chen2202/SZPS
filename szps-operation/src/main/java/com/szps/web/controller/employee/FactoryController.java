package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;

import com.szps.web.domain.employee.Department;
import com.szps.web.domain.employee.Factory;
import com.szps.web.service.employee.DepartmentService;
import com.szps.web.service.employee.FactoryService;

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
}

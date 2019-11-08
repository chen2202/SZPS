package com.szps.web.controller.employee;

import java.util.List;

<<<<<<< HEAD
import org.apache.shiro.authz.annotation.RequiresPermissions;
=======
>>>>>>> cc172c9ebff30d4594bca7e8bfd8d691701d16bb
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
import com.szps.web.domain.employee.Project;
import com.szps.web.service.employee.ProjectService;

/**
<<<<<<< HEAD
 * 公司的项目信息
=======
 * 公司的项目信息页面 控制器
>>>>>>> cc172c9ebff30d4594bca7e8bfd8d691701d16bb
 * @author zxc
 */
@Controller
@RequestMapping("/employee")
public class ProjectController extends BaseController{
	private String prefix = "employee/project";
	private String companyId=""; //某个查看项目的公司代码
	
	@Autowired
	private ProjectService projectService;
	
	/**
	 * 跳转到employee/project/project.html
	 */
	//@RequiresPermissions("employee:company:view")
	@GetMapping("/project/project/{company_id}")
	public String project(@PathVariable("company_id") String company_id, ModelMap mmap) {
		companyId = company_id; //查看某公司的项目时，获取该公司代码
		return prefix + "/project";
	}
	
	/**
	 * 根据公司代码显示该公司项目信息
	 */
	//@RequiresPermissions("employee:company:list")
    @PostMapping("/project/project/list")
	@ResponseBody
	public TableDataInfo projectList(Project project) { //这个参数没有属性值！
		startPage();
		project.setCompany_id(companyId); //只需要公司代码值
		List<Project> list = projectService.selectProjectById(project);
		return getDataTable(list);
	}
	
	/**
     * 新增项目
     * 跳转到add.html
     */
    @GetMapping("/project/add")
    public String add()
    {
        return prefix + "/add";
    }
	
    /**
     * 保存新增项目
     */
   // @RequiresPermissions("employee:company:add")
    @Log(title = "项目添加", businessType = BusinessType.INSERT)
    @PostMapping("/project/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Project project) {
    	project.setCompany_id(companyId); //浏览哪个公司，就添加哪个公司代码，覆盖掉前端传来的值'0'
    	projectService.insertProject(project);
    	return toAjax(1); 
    }
    
    /**
     * 修改项目信息
     * 跳转到edit.html
     */
    @GetMapping("/project/edit/{pipe_project}")
    public String edit(@PathVariable("pipe_project") String pipe_project,ModelMap mmap) {
    	mmap.put("project", projectService.selectProjectByName(pipe_project));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存项目信息
     * 
     */
   // @RequiresPermissions("employee:company:edit")
    @Log(title = "项目修改", businessType = BusinessType.UPDATE)
    @PostMapping("/project/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Project project) {
    	projectService.updateProject(project);
    	return toAjax(1);
    }
    
    /**
     * 根据项目名删除项目
     */
   // @RequiresPermissions("employee:company:remove")
    @Log(title = "项目删除", businessType = BusinessType.DELETE)
    @PostMapping("/project/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(projectService.deleteProjectByName(ids));
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验项目名唯一性
     */
    @PostMapping("/project/checkProjectUnique")
    @ResponseBody
    public String checkProjectUnique(Project project) {
    	return projectService.checkProjectUnique(project);
    }
}

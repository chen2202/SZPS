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
import com.szps.common.utils.poi.ExcelUtil;
import com.szps.web.domain.employee.Company;
import com.szps.web.domain.employee.Department;
import com.szps.web.service.employee.CompanyService;
import com.szps.web.service.employee.DepartmentService;

/**
 * 公司页面 控制器 
 * @author zxc 
 *
 */
@Controller
@RequestMapping("/employee") //请求的根路径
public class CompanyController extends BaseController{
	private String prefix = "employee/company"; //前缀路径
	private String oneCompanyID = ""; //用于组织结构图的公司代码
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private CompanyService companyService;
	
	/**
	 * 查询全部公司名称 代码,在从业人员编辑添加时，添加到下拉菜单
	 * @return 全部公司名称 代码
	 */
    @PostMapping("/worker/companyNameList")
    @ResponseBody
    public List<String> companyNameList(){
        List<Company> companyModel = companyService.selectAllCompanyName();
        List<String> companyInfo = new ArrayList<String>(); //存放公司名称和公司代码的List
        //遍历EMPLOYEE_T_COMPANY表中数据，提取出公司名称
        for(int i=0;i<companyModel.size();i++) { 
        	Company company = (Company)companyModel.get(i);
        	companyInfo.add(company.getCompany_name());
        	companyInfo.add(company.getCompany_id());
        }
        return companyInfo;
    }
    
    /**
	 * 查询全部公司名称 代码,在部门添加时，添加到下拉菜单
	 * @return 全部公司名称 代码
	 */
    @PostMapping("/department/companyNameList")
    @ResponseBody
    public List<String> companyNameList2(){
        List<Company> companyModel = companyService.selectAllCompanyName();
        List<String> companyInfo = new ArrayList<String>(); //存放公司名称和公司代码的List
        //遍历T_COMPANY表中数据，提取出公司名称
        for(int i=0;i<companyModel.size();i++) { 
        	Company company = (Company)companyModel.get(i);
        	companyInfo.add(company.getCompany_name());
        	companyInfo.add(company.getCompany_id());
        }
        return companyInfo;
    }
    
    /**
     * 跳转company/company.html
     */
    @RequiresPermissions("employee:company:view")
    @GetMapping("/company")
    public String company()
    {
        return prefix + "/company";
    }
    
    /**
     *查询全部公司信息，表格显示
     *@return 全部公司信息 
     */
    @RequiresPermissions("employee:company:list")
    @PostMapping("/company/list")
    @ResponseBody
    public TableDataInfo list(Company company) {
    	startPage();
    	List<Company> list = companyService.selectAllCompany(company);
    	return getDataTable(list);
    }
    
    /**
     * 公司信息导出excel表
     * @param company
     * @return
     */
    //@Log(title = "公司管理", businessType = BusinessType.EXPORT)
  	@RequiresPermissions("employee:company:export")
    @PostMapping("/company/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
        List<Company> list = companyService.selectAllCompany(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "公司数据");
    }
    
    /**
     * 跳转company/details.html
     */
    @GetMapping("company/detail/{company_id}")
    public String detail(@PathVariable("company_id") String company_id,ModelMap mmap) {
    	oneCompanyID = company_id; //打开details.html时，获取的company_id提取出来
    	
    	return prefix + "/detail";
    }
    
    /**
	 * 生成公司的组织结构图
	 * @return 拼接的组织结构图json
	 */
	@RequiresPermissions("employee:company:detail")
    @PostMapping("/company/detail/orgChart")
	@ResponseBody
	public String companyOrgChart() {
		String companyName = companyService.selectCompanyById(oneCompanyID); //根节点 name,oneCompanyID是id	
		List<Department> departmentInfo = departmentService.selectAllDepartmentByCompanyId(oneCompanyID);//该公司全部部门名称
		
		List<TreeNode> list = new ArrayList<TreeNode>(); //空树
		list.add(new TreeNode("no",companyName,"0")); //根节点
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
     * 新增公司
     * 跳转到add.html
     */
    @GetMapping("/company/add")
    public String add()
    {
        return prefix + "/add";
    }
    
    /**
     * 保存新增公司
     */
    @RequiresPermissions("employee:company:add")
    @Log(title = "公司添加", businessType = BusinessType.INSERT)
    @PostMapping("/company/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Company company) {
    	companyService.insertCompany(company);
    	return toAjax(1);
    }
    
    /**
     * 修改公司
     * 跳转到edit.html
     */
    @GetMapping("/company/edit/{company_id}")
    public String edit(@PathVariable("company_id") String company_id,ModelMap mmap) {
    	mmap.put("company", companyService.selectCompanyById2(company_id));
    	return prefix + "/edit";
    }
    
    /**
     * 修改保存公司
     * 
     */
    @RequiresPermissions("employee:company:edit")
    @Log(title = "公司修改", businessType = BusinessType.UPDATE)
    @PostMapping("/company/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Company company) {
    	companyService.updateCompany(company);
    	return toAjax(1);
    }
    
    /**
     * 根据公司代码删除公司信息
     */
    @RequiresPermissions("employee:company:remove")
    @Log(title = "公司删除", businessType = BusinessType.DELETE)
    @PostMapping("/company/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
    	try {
    		return toAjax(companyService.deleteCompanyById(ids));
    	} catch (Exception e) {
	        return error(e.getMessage());
	    }
    }
    
    /**
     * 校验公司代码唯一性
     */
    @PostMapping("/company/checkCompanyIdUnique")
    @ResponseBody
    public String checkCompanyIdUnique(Company company) {
    	return companyService.checkCompanyIdUnique(company);
    }
}



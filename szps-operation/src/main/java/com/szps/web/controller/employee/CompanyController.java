package com.szps.web.controller.employee;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.szps.common.core.controller.BaseController;
import com.szps.common.core.page.TableDataInfo;
import com.szps.web.domain.employee.Company;
import com.szps.web.service.employee.CompanyService;

@Controller
@RequestMapping("/employee") //请求的根路径
public class CompanyController extends BaseController{
	private String prefix = "employee/company"; //前缀路径
	
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
}

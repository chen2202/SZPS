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

import com.szps.web.domain.employee.Factory;
import com.szps.web.service.employee.FactoryService;

@Controller
@RequestMapping("/employee")
public class FactoryController extends BaseController{
	private String prefix = "employee/factory"; 
	
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
}

package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Company;

public interface CompanyService {
	
	/**
	 * add.html 公司下拉菜单 公司名称加载
	 * @return
	 */
	public List<Company> selectAllCompanyName();
	
	/**
	 * 查询全部公司信息
	 */
	public List<Company> selectAllCompany(Company company);
}

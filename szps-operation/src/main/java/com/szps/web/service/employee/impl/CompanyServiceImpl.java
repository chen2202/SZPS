package com.szps.web.service.employee.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.employee.Company;
import com.szps.web.mapper.employee.CompanyMapper;
import com.szps.web.service.employee.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Autowired
	private CompanyMapper companyMapper;
	
	/**
	 * 查询全部公司名称 代码
	 * @return 公司信息
	 */
	public List<Company> selectAllCompanyName(){
		return companyMapper.selectAllCompanyName();
	}
	
	/**
	 * 查询全部公司信息
	 * @return 公司信息
	 */
	public List<Company> selectAllCompany(Company company){
		return companyMapper.selectAllCompany(company);
	}
}

package com.szps.web.mapper.employee;

import java.util.List;

import com.szps.web.domain.employee.Company;

/**
 * Company模型数据层
 *
 */
public interface CompanyMapper {
	/**
	 * 查询全部公司名称 代码
	 * @return
	 */
	public List<Company> selectAllCompanyName();
	
	/**
	 * 查询全部公司信息
	 */
	public List<Company> selectAllCompany(Company company);
}

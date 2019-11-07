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
	
	/**
	 * 通过公司代码查询某个公司
	 */
	public String selectCompanyById(String company_id);
	
	/**
	 * 校验公司代码唯一性
	 */
	public Company checkCompanyIdUnique(String company_id);
	
	/**
	 * 添加公司
	 */
	public void insertCompany(Company company);
	
	/**
	 * 通过公司代码查询某公司
	 */
	public Company selectCompanyById2(String company_id);
	
	/**
	 * 修改公司信息
	 */
	public void updateCompany(Company company);
	
	/**
     * 通过公司代码删除公司信息
     */
    public int deleteCompanyById(String[] ids);
}

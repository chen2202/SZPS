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
	
	/**
	 * 查询某个公司名称
	 */
	public String selectCompanyById(String company_id);
	
	/**
	 * 校验公司代码唯一性
	 */
	public String checkCompanyIdUnique(Company company);
	
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
     * @param 选中的公司代码数组
     */
    public int deleteCompanyById(String ids) throws Exception;
}

package com.szps.web.service.employee.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
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
	
	/**
	 * 查询某个公司名称
	 */
	public String selectCompanyById(String company_id) {
		return companyMapper.selectCompanyById(company_id);
	}
	
	/**校验公司代码唯一性
	*参数：
	*返回值：如果公司代码唯一，返回"0"，不唯一返回"1"
	*/
	public String checkCompanyIdUnique(Company company) {
		Company c = null;
		c = companyMapper.checkCompanyIdUnique(company.getCompany_id());
		if(c != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**插入新的公司数据
	*参数： 
	*返回值：
	*/
	public void insertCompany(Company company) {
		companyMapper.insertCompany(company);
	}
	
	/**
     * 通过公司代码查询公司
     * 
     * @param company_id 从业人员身份证号
     * @return 从业人员对象信息
     */
    @Override
	public Company selectCompanyById2(String company_id) {
    	return companyMapper.selectCompanyById2(company_id);
    }
    
    /**
     * 通过公司代码修改公司信息
     */
    public void updateCompany(Company company) {
    	companyMapper.updateCompany(company);
    }
    
    /**
     * 通过公司代码删除公司信息
     */
    @Override
    public int deleteCompanyById(String ids) throws BusinessException {
    	String[] company_ids = Convert.toStrArray(ids);
    	return companyMapper.deleteCompanyById(company_ids);
    }
}

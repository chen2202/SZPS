package com.szps.web.service.employee;

import java.util.List;

import com.szps.web.domain.employee.Project;

public interface ProjectService {
	/**
	 * 通过公司代码查询该公司全部项目
	 * @param company_id 公司代码
	 * @return
	 */
	public List<Project> selectProjectById(Project project);
	
	/**
	 * 校验项目名称唯一性
	 * @param project需要校验的项目对象
	 * @return
	 */
	public String checkProjectUnique(Project project);
	
	/**
     * 新增项目信息
     * 
     * @param  Project信息
     */
    public void insertProject(Project project);
    
    /**
     * 通过项目名查询项目信息
     */
    public Project selectProjectByName(String pipe_project);
    
    /**
     * 修改项目信息
     * @param project 项目对象
     */
    public void updateProject(Project project);
    
    /**
     * 通过项目名删除项目
     */
    public int deleteProjectByName(String ids) throws Exception;
}

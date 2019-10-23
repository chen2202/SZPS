package com.szps.web.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
import com.szps.web.domain.employee.Project;
import com.szps.web.mapper.employee.ProjectMapper;
import com.szps.web.service.employee.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectMapper projectMapper;
	
	/**
	 * 通过公司代码查询到的项目信息
	 * @param company_id 公司代码
	 * @return 查询到的某公司全部项目信息
	 */
	@DataScope
	public List<Project> selectProjectById(Project project) {
		return projectMapper.selectProjectById(project);
	}
	
	/**
	 * 添加新项目信息
	 * @param project 添加的项目对象
	 */
	public void insertProject(Project project) {
		projectMapper.insertProject(project);
	}
	
	/**校验项目名
	*参数：
	*返回值：如果项目名唯一，返回"0"，不唯一返回"1"
	*/
	public String checkProjectUnique(Project project) {
		Project p = null;
		p = projectMapper.checkProjectUnique(project.getPipe_project());
		if(p != null) {
			return "1";
		}
		return "0"; 
	}
	
	/**
     * 通过项目名查询项目信息
     */
    public Project selectProjectByName(String pipe_project) {
    	return projectMapper.selectProjectByName(pipe_project);
    }
	
	/**
     * 修改项目信息
     * @param project 项目对象
     */
    public void updateProject(Project project) {
    	projectMapper.updateProject(project);
    }
    
    /**
     * 通过项目名删除项目
     */
    @Override
    public int deleteProjectByName(String ids) throws BusinessException{
    	String[] pipe_projects = Convert.toStrArray(ids);
    	return projectMapper.deleteProjectByName(pipe_projects);
    }
}

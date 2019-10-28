package com.szps.web.service.drainage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.drainage.Administrative;
import com.szps.web.mapper.drainage.AdministrativeMapper;
import com.szps.web.service.drainage.AdministrativeService;

@Service
public class AdministrativeServiceImpl implements AdministrativeService{
	@Autowired
	private AdministrativeMapper administrativeMapper;
	
	/**
	 * 查询全部行政区名(用于下拉菜单)
	 * @return
	 */
	public List<Administrative> selectAllAdministrativeName(){
		return administrativeMapper.selectAllAdministrativeName();
	}
}

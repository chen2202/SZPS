package com.szps.web.service.drainage.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.drainage.Household;
import com.szps.web.mapper.drainage.ExpireMapper;
import com.szps.web.service.drainage.ExpireService;

@Service
public class ExpireServiceImpl implements ExpireService{
	@Autowired
	private ExpireMapper expireMapper;
	
	/**
	 * 查询全部排水户
	 * @return
	 */
	public List<Household> selectAll(Map m){
		return expireMapper.selectAll(m);
	}
}

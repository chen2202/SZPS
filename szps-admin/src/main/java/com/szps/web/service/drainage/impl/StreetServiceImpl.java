package com.szps.web.service.drainage.impl;

import com.szps.web.domain.drainage.Street;
import com.szps.web.mapper.drainage.StreetMapper;
import com.szps.web.service.drainage.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService{
	@Autowired
	private StreetMapper streetMapper;
	
	/**
	 * 获取某个行政区全部街道名称（用于下拉菜单）
	 * @param street
	 * @return
	 */
	public List<Street> selectSomeStreet(Street street){
		return streetMapper.selectSomeStreet(street);
	}
}

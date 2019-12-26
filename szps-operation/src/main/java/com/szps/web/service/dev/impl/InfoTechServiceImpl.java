package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.InfoTech;
import com.szps.web.mapper.dev.InfoTechMapper;
import com.szps.web.service.dev.IInfoTechService;
@Service
public class InfoTechServiceImpl implements IInfoTechService {
	@Autowired
	private InfoTechMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<InfoTech> selectList(InfoTech obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public InfoTech selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(InfoTech obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		Long[] idsL = Convert.toLongArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(InfoTech obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

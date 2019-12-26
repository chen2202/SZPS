package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.EndoscopicDetection;
import com.szps.web.mapper.dev.EndoscopicDetectionMapper;
import com.szps.web.service.dev.IEndoscopicDetectionService;
@Service
public class EndoscopicDetectionServiceImpl implements IEndoscopicDetectionService {
	@Autowired
	private EndoscopicDetectionMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<EndoscopicDetection> selectList(EndoscopicDetection obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public EndoscopicDetection selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(EndoscopicDetection obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String[] idsL = Convert.toStrArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(EndoscopicDetection obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<EndoscopicDetection> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

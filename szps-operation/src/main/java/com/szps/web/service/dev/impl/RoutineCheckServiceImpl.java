package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.RoutineCheck;
import com.szps.web.mapper.dev.RoutineCheckMapper;
import com.szps.web.service.dev.IRoutineCheckService;
@Service
public class RoutineCheckServiceImpl implements IRoutineCheckService {

	@Autowired
	private RoutineCheckMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<RoutineCheck> selectList(RoutineCheck obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public RoutineCheck selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(RoutineCheck obj) {
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
	public int update(RoutineCheck obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

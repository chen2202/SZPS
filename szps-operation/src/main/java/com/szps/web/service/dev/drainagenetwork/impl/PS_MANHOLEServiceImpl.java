package com.szps.web.service.dev.drainagenetwork.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.drainagenetwork.PS_MANHOLE;
import com.szps.web.mapper.dev.drainagenetwork.PS_MANHOLEMapper;
import com.szps.web.service.dev.drainagenetwork.IPS_MANHOLEService;
@Service
public class PS_MANHOLEServiceImpl implements IPS_MANHOLEService {
	@Autowired
	private PS_MANHOLEMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<PS_MANHOLE> selectList(PS_MANHOLE obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public PS_MANHOLE selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(PS_MANHOLE obj) {
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
	public int update(PS_MANHOLE obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<PS_MANHOLE> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

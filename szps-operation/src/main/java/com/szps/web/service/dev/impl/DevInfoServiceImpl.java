package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.DevInfo;
import com.szps.web.mapper.dev.DevInfoMapper;
import com.szps.web.service.dev.IDevInfoService;
@Service
public class DevInfoServiceImpl implements IDevInfoService {
	@Autowired
	private DevInfoMapper mapper;
	@Override
	public List<DevInfo> selectList(DevInfo obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public DevInfo selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(DevInfo obj) {
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
	public int update(DevInfo obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<DevInfo> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

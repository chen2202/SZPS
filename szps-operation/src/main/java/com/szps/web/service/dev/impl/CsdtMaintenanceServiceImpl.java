package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.csdt.CsdtMaintenance;
import com.szps.web.mapper.dev.CsdtMaintenanceMapper;
import com.szps.web.service.dev.ICsdtMaintenanceService;
@Service
public class CsdtMaintenanceServiceImpl implements ICsdtMaintenanceService {
	@Autowired
	private CsdtMaintenanceMapper mapper;
	@Override
	public List<CsdtMaintenance> selectList(CsdtMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public CsdtMaintenance selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(CsdtMaintenance obj) {
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
	public int update(CsdtMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<CsdtMaintenance> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

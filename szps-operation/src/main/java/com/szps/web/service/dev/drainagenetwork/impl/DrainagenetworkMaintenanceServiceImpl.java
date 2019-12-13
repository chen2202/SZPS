package com.szps.web.service.dev.drainagenetwork.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkMaintenance;
import com.szps.web.mapper.dev.drainagenetwork.DrainagenetworkMaintenanceMapper;
import com.szps.web.service.dev.drainagenetwork.IDrainagenetworkMaintenanceService;
@Service
public class DrainagenetworkMaintenanceServiceImpl implements IDrainagenetworkMaintenanceService {
	@Autowired
	private DrainagenetworkMaintenanceMapper mapper;
	@Override
	public List<DrainagenetworkMaintenance> selectList(DrainagenetworkMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public DrainagenetworkMaintenance selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(DrainagenetworkMaintenance obj) {
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
	public int update(DrainagenetworkMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<DrainagenetworkMaintenance> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

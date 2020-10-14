package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.bo.BOMaintenance;
import com.szps.web.mapper.dev.BOMaintenanceMapper;
import com.szps.web.service.dev.IBOMaintenanceService;
@Service
public class BOMaintenanceServiceImpl implements IBOMaintenanceService {
	@Autowired
	private BOMaintenanceMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<BOMaintenance> selectList(BOMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public BOMaintenance selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(BOMaintenance obj) {
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
	public int update(BOMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<BOMaintenance> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

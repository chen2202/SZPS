package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.NetworkMaintenance;
import com.szps.web.mapper.dev.NetworkMaintenanceMapper;
import com.szps.web.service.dev.INetworkMaintenanceService;
@Service
public class NetworkMaintenanceServiceImpl implements INetworkMaintenanceService {
	@Autowired
	private NetworkMaintenanceMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<NetworkMaintenance> selectList(NetworkMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public NetworkMaintenance selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(NetworkMaintenance obj) {
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
	public int update(NetworkMaintenance obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<NetworkMaintenance> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

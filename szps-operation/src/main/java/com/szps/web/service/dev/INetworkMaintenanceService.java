package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.NetworkMaintenance;

public interface INetworkMaintenanceService {

	public List<NetworkMaintenance> selectList(NetworkMaintenance obj);

	public NetworkMaintenance selectById(String id);
	public List<NetworkMaintenance> selectByName(String name);

	public int insert(NetworkMaintenance obj);

	public int deleteById(String id);

	public int deleteByIds(String ids);

	public int update(NetworkMaintenance obj);
}
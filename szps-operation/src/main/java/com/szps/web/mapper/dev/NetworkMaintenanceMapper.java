package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.NetworkMaintenance;

public interface NetworkMaintenanceMapper {

	public List<NetworkMaintenance> selectList(NetworkMaintenance obj);

	public NetworkMaintenance selectById(String id);

	public int insert(NetworkMaintenance obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(NetworkMaintenance obj);

	public List<NetworkMaintenance> selectByName(String name);
}
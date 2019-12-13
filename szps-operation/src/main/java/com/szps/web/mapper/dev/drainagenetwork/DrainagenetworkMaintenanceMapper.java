package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkMaintenance;

public interface DrainagenetworkMaintenanceMapper {

	public List<DrainagenetworkMaintenance> selectList(DrainagenetworkMaintenance obj);

	public DrainagenetworkMaintenance selectById(Long id);

	public int insert(DrainagenetworkMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(DrainagenetworkMaintenance obj);
	public List<DrainagenetworkMaintenance> selectByName(String name);
}
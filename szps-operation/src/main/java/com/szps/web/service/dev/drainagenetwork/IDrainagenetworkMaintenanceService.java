package com.szps.web.service.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkMaintenance;

public interface IDrainagenetworkMaintenanceService {

	public List<DrainagenetworkMaintenance> selectList(DrainagenetworkMaintenance obj);

	public DrainagenetworkMaintenance selectById(Long id);
	public List<DrainagenetworkMaintenance> selectByName(String name);

	public int insert(DrainagenetworkMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(DrainagenetworkMaintenance obj);
}
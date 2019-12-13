package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.pumpstation.PumpstationMaintenance;

public interface PumpstationMaintenanceMapper {

	public List<PumpstationMaintenance> selectList(PumpstationMaintenance obj);

	public PumpstationMaintenance selectById(Long id);

	public int insert(PumpstationMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(PumpstationMaintenance obj);
	public List<PumpstationMaintenance> selectByName(String name);
}
package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.pumpstation.PumpstationMaintenance;

public interface IPumpstationMaintenanceService {

	public List<PumpstationMaintenance> selectList(PumpstationMaintenance obj);

	public PumpstationMaintenance selectById(Long id);
	public List<PumpstationMaintenance> selectByName(String name);

	public int insert(PumpstationMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(PumpstationMaintenance obj);
}
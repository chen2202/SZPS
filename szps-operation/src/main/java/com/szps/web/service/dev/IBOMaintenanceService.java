package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BOMaintenance;

public interface IBOMaintenanceService {

	public List<BOMaintenance> selectList(BOMaintenance obj);

	public BOMaintenance selectById(Long id);
	public List<BOMaintenance> selectByName(String name);

	public int insert(BOMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(BOMaintenance obj);
}
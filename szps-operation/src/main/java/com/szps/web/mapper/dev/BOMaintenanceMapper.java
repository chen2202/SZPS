package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BOMaintenance;

public interface BOMaintenanceMapper {

	public List<BOMaintenance> selectList(BOMaintenance obj);

	public BOMaintenance selectById(Long id);

	public int insert(BOMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(BOMaintenance obj);
	public List<BOMaintenance> selectByName(String name);
}
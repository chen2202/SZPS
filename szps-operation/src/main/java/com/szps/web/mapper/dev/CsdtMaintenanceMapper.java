package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.CsdtMaintenance;

public interface CsdtMaintenanceMapper {

	public List<CsdtMaintenance> selectList(CsdtMaintenance obj);

	public CsdtMaintenance selectById(Long id);

	public int insert(CsdtMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(CsdtMaintenance obj);
	public List<CsdtMaintenance> selectByName(String name);
}
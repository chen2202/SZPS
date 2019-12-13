package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.CsdtMaintenance;

public interface ICsdtMaintenanceService {

	public List<CsdtMaintenance> selectList(CsdtMaintenance obj);

	public CsdtMaintenance selectById(Long id);
	public List<CsdtMaintenance> selectByName(String name);

	public int insert(CsdtMaintenance obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(CsdtMaintenance obj);
}
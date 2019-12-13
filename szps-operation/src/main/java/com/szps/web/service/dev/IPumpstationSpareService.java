package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.pumpstation.PumpstationSpare;

public interface IPumpstationSpareService {

	public List<PumpstationSpare> selectList(PumpstationSpare obj);

	public PumpstationSpare selectById(Long id);
	public List<PumpstationSpare> selectByName(String name);

	public int insert(PumpstationSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(PumpstationSpare obj);
}
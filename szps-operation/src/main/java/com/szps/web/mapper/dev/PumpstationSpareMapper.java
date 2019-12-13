package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.pumpstation.PumpstationSpare;

public interface PumpstationSpareMapper {

	public List<PumpstationSpare> selectList(PumpstationSpare obj);

	public PumpstationSpare selectById(Long id);

	public int insert(PumpstationSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(PumpstationSpare obj);
	public List<PumpstationSpare> selectByName(String name);
}
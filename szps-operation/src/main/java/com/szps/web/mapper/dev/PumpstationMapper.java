package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Pumpstation;

public interface PumpstationMapper {

	public List<Pumpstation> selectList(Pumpstation obj);

	public Pumpstation selectById(Long id);

	public int insert(Pumpstation obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Pumpstation obj);
	public List<Pumpstation> selectByName(String name);
}
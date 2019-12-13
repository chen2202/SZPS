package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkSpare;

public interface DrainagenetworkSpareMapper {

	public List<DrainagenetworkSpare> selectList(DrainagenetworkSpare obj);

	public DrainagenetworkSpare selectById(Long id);

	public int insert(DrainagenetworkSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(DrainagenetworkSpare obj);
	public List<DrainagenetworkSpare> selectByName(String name);
}
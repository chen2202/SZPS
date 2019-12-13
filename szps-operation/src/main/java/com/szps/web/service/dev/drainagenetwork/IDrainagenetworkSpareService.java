package com.szps.web.service.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkSpare;

public interface IDrainagenetworkSpareService {

	public List<DrainagenetworkSpare> selectList(DrainagenetworkSpare obj);

	public DrainagenetworkSpare selectById(Long id);
	public List<DrainagenetworkSpare> selectByName(String name);

	public int insert(DrainagenetworkSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(DrainagenetworkSpare obj);
}
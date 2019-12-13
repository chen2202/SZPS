package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.pumpstation.Pumpstation;

public interface IPumpstationService {

	public List<Pumpstation> selectList(Pumpstation obj);

	public Pumpstation selectById(Long id);
	public List<Pumpstation> selectByName(String name);

	public int insert(Pumpstation obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Pumpstation obj);
}
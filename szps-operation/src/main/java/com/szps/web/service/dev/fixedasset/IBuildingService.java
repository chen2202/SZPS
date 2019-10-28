package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Building;

public interface IBuildingService {

	public List<Building> selectList(Building obj);

	public Building selectById(Long id);

	public int insert(Building obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Building obj);
}
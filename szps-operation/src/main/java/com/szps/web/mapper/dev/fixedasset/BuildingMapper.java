package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Building;

public interface BuildingMapper {

	public List<Building> selectList(Building obj);

	public Building selectById(Long id);

	public int insert(Building obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Building obj);
	public List<Building> selectByName(String name);
}
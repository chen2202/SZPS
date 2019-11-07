package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Plant;

public interface PlantMapper {

	public List<Plant> selectList(Plant obj);

	public Plant selectById(Long id);

	public int insert(Plant obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Plant obj);
	public List<Plant> selectByName(String name);
}
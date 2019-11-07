package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Plant;

public interface IPlantService {

	public List<Plant> selectList(Plant obj);

	public Plant selectById(Long id);

	public int insert(Plant obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Plant obj);	
}
package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Structure;

public interface StructureMapper {

	public List<Structure> selectList(Structure obj);

	public Structure selectById(Long id);

	public int insert(Structure obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Structure obj);
	public List<Structure> selectByName(String name);
}
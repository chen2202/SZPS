package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Structure;

public interface IStructureService {

	public List<Structure> selectList(Structure obj);

	public Structure selectById(Long id);

	public int insert(Structure obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Structure obj);
}
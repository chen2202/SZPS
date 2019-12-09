package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Drainagenetwork;

public interface DrainagenetworkMapper {

	public List<Drainagenetwork> selectList(Drainagenetwork obj);

	public Drainagenetwork selectById(Long id);

	public int insert(Drainagenetwork obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Drainagenetwork obj);
	public List<Drainagenetwork> selectByName(String name);
}
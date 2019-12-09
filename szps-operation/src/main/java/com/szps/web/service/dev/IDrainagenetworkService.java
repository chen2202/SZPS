package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.Drainagenetwork;

public interface IDrainagenetworkService {

	public List<Drainagenetwork> selectList(Drainagenetwork obj);

	public Drainagenetwork selectById(Long id);
	public List<Drainagenetwork> selectByName(String name);

	public int insert(Drainagenetwork obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Drainagenetwork obj);
}
package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.PS_CONDUIT;


public interface PS_CONDUITMapper {

	public List<PS_CONDUIT> selectList(PS_CONDUIT obj);

	public PS_CONDUIT selectById(String id);

	public int insert(PS_CONDUIT obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(PS_CONDUIT obj);
	public List<PS_CONDUIT> selectByName(String name);
}
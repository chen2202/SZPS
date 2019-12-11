package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.PS_COMB;


public interface PS_COMBMapper {

	public List<PS_COMB> selectList(PS_COMB obj);

	public PS_COMB selectById(String id);

	public int insert(PS_COMB obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(PS_COMB obj);
	public List<PS_COMB> selectByName(String name);
}
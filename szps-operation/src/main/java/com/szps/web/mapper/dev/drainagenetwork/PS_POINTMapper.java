package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.PS_POINT;

public interface PS_POINTMapper {

	public List<PS_POINT> selectList(PS_POINT obj);

	public PS_POINT selectById(String id);

	public int insert(PS_POINT obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(PS_POINT obj);

	public List<PS_POINT> selectByName(String name);
}
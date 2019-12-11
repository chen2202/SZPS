package com.szps.web.mapper.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.PS_OUTFALL;

public interface PS_OUTFALLMapper {

	public List<PS_OUTFALL> selectList(PS_OUTFALL obj);

	public PS_OUTFALL selectById(String id);

	public int insert(PS_OUTFALL obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(PS_OUTFALL obj);

	public List<PS_OUTFALL> selectByName(String name);
}
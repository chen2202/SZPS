package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BOSpare;

public interface BOSpareMapper {

	public List<BOSpare> selectList(BOSpare obj);

	public BOSpare selectById(Long id);

	public int insert(BOSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(BOSpare obj);
	public List<BOSpare> selectByName(String name);
}
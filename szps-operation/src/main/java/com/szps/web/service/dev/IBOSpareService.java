package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BOSpare;

public interface IBOSpareService {

	public List<BOSpare> selectList(BOSpare obj);

	public BOSpare selectById(Long id);
	public List<BOSpare> selectByName(String name);

	public int insert(BOSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(BOSpare obj);
}
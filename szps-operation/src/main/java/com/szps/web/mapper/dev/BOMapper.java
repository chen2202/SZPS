package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BO;

public interface BOMapper {

	public List<BO> selectList(BO obj);

	public BO selectById(Long id);

	public int insert(BO obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(BO obj);
	public List<BO> selectByName(String name);
}
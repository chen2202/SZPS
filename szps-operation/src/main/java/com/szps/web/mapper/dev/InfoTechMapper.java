package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.InfoTech;

public interface InfoTechMapper {

	public List<InfoTech> selectList(InfoTech obj);

	public InfoTech selectById(Long id);

	public int insert(InfoTech obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(InfoTech obj);
}
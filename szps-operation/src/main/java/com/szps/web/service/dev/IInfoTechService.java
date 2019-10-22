package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.InfoTech;

public interface IInfoTechService {

	public List<InfoTech> selectList(InfoTech obj);

	public InfoTech selectById(Long id);

	public int insert(InfoTech obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(InfoTech obj);
}
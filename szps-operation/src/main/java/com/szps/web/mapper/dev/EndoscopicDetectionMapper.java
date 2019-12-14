package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.EndoscopicDetection;

public interface EndoscopicDetectionMapper {

	public List<EndoscopicDetection> selectList(EndoscopicDetection obj);

	public EndoscopicDetection selectById(String id);

	public int insert(EndoscopicDetection obj);

	public int deleteById(String id);

	public int deleteByIds(String[] ids);

	public int update(EndoscopicDetection obj);

	public List<EndoscopicDetection> selectByName(String name);
}
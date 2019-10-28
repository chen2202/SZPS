package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Pipeline;

public interface PipelineMapper {

	public List<Pipeline> selectList(Pipeline obj);

	public Pipeline selectById(Long id);

	public int insert(Pipeline obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Pipeline obj);
	public List<Pipeline> selectByName(String name);
}
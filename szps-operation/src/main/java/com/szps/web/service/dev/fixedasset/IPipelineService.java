package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Pipeline;

public interface IPipelineService {

	public List<Pipeline> selectList(Pipeline obj);

	public Pipeline selectById(Long id);

	public int insert(Pipeline obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Pipeline obj);
}
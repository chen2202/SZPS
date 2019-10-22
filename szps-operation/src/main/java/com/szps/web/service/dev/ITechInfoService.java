package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.TechInfo;

public interface ITechInfoService {

	public List<TechInfo> selectList(TechInfo obj);

	public TechInfo selectById(Long id);

	public int insert(TechInfo obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(TechInfo obj);
}
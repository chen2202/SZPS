package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.TechInfo;

public interface TechInfoMapper {

	public List<TechInfo> selectList(TechInfo obj);

	public TechInfo selectById(Long id);

	public int insert(TechInfo obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(TechInfo obj);
}
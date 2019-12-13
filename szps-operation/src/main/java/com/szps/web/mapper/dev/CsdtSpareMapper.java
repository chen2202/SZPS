package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.CsdtSpare;

public interface CsdtSpareMapper {

	public List<CsdtSpare> selectList(CsdtSpare obj);

	public CsdtSpare selectById(Long id);

	public int insert(CsdtSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(CsdtSpare obj);
	public List<CsdtSpare> selectByName(String name);
}
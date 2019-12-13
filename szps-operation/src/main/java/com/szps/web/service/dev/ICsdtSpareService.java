package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.CsdtSpare;

public interface ICsdtSpareService {

	public List<CsdtSpare> selectList(CsdtSpare obj);

	public CsdtSpare selectById(Long id);
	public List<CsdtSpare> selectByName(String name);

	public int insert(CsdtSpare obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(CsdtSpare obj);
}
package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.PsProgressN;

public interface IPsProgressNService {

	public List<PsProgressN> selectList(PsProgressN obj);

	public PsProgressN selectById(Long id);
	public List<PsProgressN> selectByName(String name);

	public int insert(PsProgressN obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(PsProgressN obj);
}
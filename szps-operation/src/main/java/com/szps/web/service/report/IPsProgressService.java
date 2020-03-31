package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.PsProgress;

public interface IPsProgressService {

	public List<PsProgress> selectList(PsProgress obj);

	public PsProgress selectById(Long id);
	public List<PsProgress> selectByName(String name);

	public int insert(PsProgress obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(PsProgress obj);
}
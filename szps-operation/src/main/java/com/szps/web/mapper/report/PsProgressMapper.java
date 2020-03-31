package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.PsProgress;

/**
 * 
 */
public interface PsProgressMapper {

	public List<PsProgress> selectList(PsProgress obj);

	public PsProgress selectById(Long id);

	public int insert(PsProgress obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(PsProgress obj);
	public List<PsProgress> selectByName(String name);
}
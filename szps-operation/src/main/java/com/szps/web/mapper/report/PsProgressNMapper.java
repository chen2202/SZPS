package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.PsProgressN;

/**
 * 
 */
public interface PsProgressNMapper {

	public List<PsProgressN> selectList(PsProgressN obj);

	public PsProgressN selectById(Long id);

	public int insert(PsProgressN obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(PsProgressN obj);
	public List<PsProgressN> selectByName(String name);
}
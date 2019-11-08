package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.YearAppraisal;

public interface YearAppraisalMapper {

	public List<YearAppraisal> selectList(YearAppraisal obj);

	public YearAppraisal selectById(Long id);

	public int insert(YearAppraisal obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(YearAppraisal obj);
	public List<YearAppraisal> selectByName(String name);
}
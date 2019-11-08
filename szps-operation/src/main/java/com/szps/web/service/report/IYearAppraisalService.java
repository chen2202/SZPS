package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.YearAppraisal;

public interface IYearAppraisalService {

	public List<YearAppraisal> selectList(YearAppraisal obj);

	public YearAppraisal selectById(Long id);

	public int insert(YearAppraisal obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(YearAppraisal obj);
}
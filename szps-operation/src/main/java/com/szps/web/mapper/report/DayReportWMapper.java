package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.DayReportW;

public interface DayReportWMapper {

	public List<DayReportW> selectList(DayReportW obj);

	public DayReportW selectById(Long id);

	public int insert(DayReportW obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(DayReportW obj);
}
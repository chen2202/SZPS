package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.WeekReport;

/**
 * 
 */
public interface WeekReportMapper {
	public List<WeekReport> selectReportList(WeekReport report);
	public WeekReport selectReportById(Long id);

	public int insertReport(WeekReport report);
	
	public int deleteReportById(Long id);
	public int deleteReportByIds(Long[] ids);

	public int updateReport(WeekReport report);
}
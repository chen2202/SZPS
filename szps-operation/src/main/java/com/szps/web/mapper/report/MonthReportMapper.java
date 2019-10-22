package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.MonthReport;

/**
 * 
 */
public interface MonthReportMapper {
	public List<MonthReport> selectReportList(MonthReport report);
	public MonthReport selectReportById(Long id);

	public int insertReport(MonthReport report);
	
	public int deleteReportById(Long id);
	public int deleteReportByIds(Long[] ids);

	public int updateReport(MonthReport report);
}
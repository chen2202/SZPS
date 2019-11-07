package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.DayReport;

/**
 * 
 */
public interface DayReportMapper {

	public List<DayReport> selectReportList(DayReport report);
	public DayReport selectReportById(Long id);

	public int insertReport(DayReport report);
	
	public int deleteReportById(Long id);
	public int deleteReportByIds(Long[] ids);

	public int updateReport(DayReport report);
}
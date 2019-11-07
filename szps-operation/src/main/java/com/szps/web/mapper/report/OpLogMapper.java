package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.OpLog;

/**
 * 
 */
public interface OpLogMapper {
	public List<OpLog> selectReportList(OpLog report);
	public OpLog selectReportById(Long id);

	public int insertReport(OpLog report);
	
	public int deleteReportById(Long id);
	public int deleteReportByIds(Long[] ids);

	public int updateReport(OpLog report);
}
package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.Pump;

/**
 * 
 */
public interface PumpMapper {
	public List<Pump> selectReportList(Pump report);

	public Pump selectReportById(Long id);

	public int insertReport(Pump report);

	public int deleteReportById(Long id);

	public int deleteReportByIds(Long[] ids);

	public int updateReport(Pump report);
}
package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.Pump;

public interface IPumpService {

	public List<Pump> selectReportList(Pump report);

	public Pump selectReportById(Long id);

	public int insertReport(Pump report);

	public int deleteReportById(Long id);

	public int updateReport(Pump report);

	public int deleteReportByIds(String ids);
}

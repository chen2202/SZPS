package com.szps.web.mapper.report;

import java.util.List;

import com.szps.web.domain.report.MHC;

/**
 * 
 */
public interface MHCMapper {
	public List<MHC> selectReportList(MHC report);

	public MHC selectReportById(Long id);

	public int insertReport(MHC report);

	public int deleteReportById(Long id);

	public int deleteReportByIds(Long[] ids);

	public int updateReport(MHC report);
}
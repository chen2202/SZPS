package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.MHC;

public interface IMHCService {

	public List<MHC> selectReportList(MHC report);

	public MHC selectReportById(Long id);

	public int insertReport(MHC report);

	public int deleteReportById(Long id);

	public int updateReport(MHC report);

	public int deleteReportByIds(String ids);
}

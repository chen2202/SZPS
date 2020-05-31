package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.DayReportW;

public interface IDayReportWService {

	public List<DayReportW> selectList(DayReportW obj);

	public DayReportW selectById(Long id);

	public int insert(DayReportW obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(DayReportW obj);
}
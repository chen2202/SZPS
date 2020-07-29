package com.szps.web.service.report;

import java.util.List;

import com.szps.web.domain.report.DayReportW;

public interface IDayReportWService {

	public List<DayReportW> selectList(DayReportW obj);
	public List<DayReportW> selectListBetween(String dtype,String startTime1,String endTime1);
	public List<DayReportW> selectListForYear(String dtype,String startTime1,String endTime1);
	public DayReportW selectById(Long id);

	public int insert(DayReportW obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(DayReportW obj);
}
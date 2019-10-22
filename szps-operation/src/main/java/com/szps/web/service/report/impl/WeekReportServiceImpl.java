package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.WeekReport;
import com.szps.web.mapper.report.WeekReportMapper;
import com.szps.web.service.report.IWeekReportService;

/**
 * 日报 服务层
 * 
 */
@Service
public class WeekReportServiceImpl implements IWeekReportService {
	@Autowired
	private WeekReportMapper reportMapper;

	@Override
	public List<WeekReport> selectReportList(WeekReport report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(WeekReport report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public WeekReport selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(WeekReport report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
        return reportMapper.deleteReportByIds(postIds);
	}


}

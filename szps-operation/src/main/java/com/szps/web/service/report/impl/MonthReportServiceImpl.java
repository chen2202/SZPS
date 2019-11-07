package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.MonthReport;
import com.szps.web.mapper.report.MonthReportMapper;
import com.szps.web.service.report.IMonthReportService;

/**
 * 日报 服务层
 * 
 */
@Service
public class MonthReportServiceImpl implements IMonthReportService {
	@Autowired
	private MonthReportMapper reportMapper;

	@Override
	public List<MonthReport> selectReportList(MonthReport report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(MonthReport report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public MonthReport selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(MonthReport report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
        return reportMapper.deleteReportByIds(postIds);
	}

}

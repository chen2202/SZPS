package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.common.exception.BusinessException;
import com.szps.system.domain.SysPost;
import com.szps.web.domain.report.DayReport;
import com.szps.web.mapper.report.DayReportMapper;
import com.szps.web.service.report.IDayReportService;

/**
 * 日报 服务层
 * 
 */
@Service
public class DayReportServiceImpl implements IDayReportService {
	@Autowired
	private DayReportMapper reportMapper;

	@Override
	public List<DayReport> selectReportList(DayReport report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(DayReport report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public DayReport selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(DayReport report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
        return reportMapper.deleteReportByIds(postIds);
	}

}

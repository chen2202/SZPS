package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.Pump;
import com.szps.web.mapper.report.PumpMapper;
import com.szps.web.service.report.IPumpService;

@Service
public class PumpServiceImpl implements IPumpService {
	@Autowired
	private PumpMapper reportMapper;

	@Override
	@DataScope(deptAlias = "r")
	public List<Pump> selectReportList(Pump report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(Pump report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public Pump selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(Pump report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
		return reportMapper.deleteReportByIds(postIds);
	}

}

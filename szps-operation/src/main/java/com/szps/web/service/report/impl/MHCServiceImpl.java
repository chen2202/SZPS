package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.MHC;
import com.szps.web.mapper.report.MHCMapper;
import com.szps.web.service.report.IMHCService;

@Service
public class MHCServiceImpl implements IMHCService {
	@Autowired
	private MHCMapper reportMapper;

	@Override
	@DataScope(deptAlias = "r")
	public List<MHC> selectReportList(MHC report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(MHC report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public MHC selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(MHC report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
		return reportMapper.deleteReportByIds(postIds);
	}

}

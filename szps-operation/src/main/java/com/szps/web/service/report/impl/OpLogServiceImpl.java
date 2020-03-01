package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.OpLog;
import com.szps.web.mapper.report.OpLogMapper;
import com.szps.web.service.report.IOpLogService;

/**
 * 日报 服务层
 * 
 */
@Service
public class OpLogServiceImpl implements IOpLogService {
	@Autowired
	private OpLogMapper reportMapper;

	@Override
	@DataScope(deptAlias = "r")
	public List<OpLog> selectReportList(OpLog report) {
		return reportMapper.selectReportList(report);
	}

	@Override
	public int insertReport(OpLog report) {
		return reportMapper.insertReport(report);
	}

	@Override
	public OpLog selectReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.selectReportById(id);
	}

	@Override
	public int deleteReportById(Long id) {
		// TODO Auto-generated method stub
		return reportMapper.deleteReportById(id);
	}

	@Override
	public int updateReport(OpLog report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}

	@Override
	public int deleteReportByIds(String ids) {
		Long[] postIds = Convert.toLongArray(ids);
        return reportMapper.deleteReportByIds(postIds);
	}


}

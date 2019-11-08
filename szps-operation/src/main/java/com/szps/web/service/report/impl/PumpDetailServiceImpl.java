package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.PumpDetail;
import com.szps.web.mapper.report.PumpDetailMapper;
import com.szps.web.service.report.IPumpDetailService;

@Service
public class PumpDetailServiceImpl implements IPumpDetailService {
	@Autowired
	private PumpDetailMapper reportMapper;

	@Override
	public List<PumpDetail> selectListByPumpId(Long pumpid) {
		return reportMapper.selectListByPumpId(pumpid);
	}

	@Override
	public int insertReport(PumpDetail report) {
		return reportMapper.insertReport(report);
	}


	@Override
	public int deleteByPumpIds(String ids) {
		// TODO Auto-generated method stub
		Long[] postIds = Convert.toLongArray(ids);
		return reportMapper.deleteByPumpIds(postIds);
	}

	@Override
	public int updateReport(PumpDetail report) {
		// TODO Auto-generated method stub
		return reportMapper.updateReport(report);
	}


}

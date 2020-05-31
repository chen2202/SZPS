package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.DayReportW;
import com.szps.web.mapper.report.DayReportWMapper;
import com.szps.web.service.report.IDayReportWService;
@Service
public class DayReportServiceWImpl implements IDayReportWService {
	@Autowired
	private DayReportWMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<DayReportW> selectList(DayReportW obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public DayReportW selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(DayReportW obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		Long[] idsL = Convert.toLongArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(DayReportW obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}



}

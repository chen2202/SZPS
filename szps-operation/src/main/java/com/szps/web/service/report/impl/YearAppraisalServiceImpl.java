package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.YearAppraisal;
import com.szps.web.mapper.report.YearAppraisalMapper;
import com.szps.web.service.report.IYearAppraisalService;
@Service
public class YearAppraisalServiceImpl implements IYearAppraisalService {
	@Autowired
	private YearAppraisalMapper mapper;
	
	@Override
	@DataScope(deptAlias = "r")
	public List<YearAppraisal> selectList(YearAppraisal obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public YearAppraisal selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(YearAppraisal obj) {
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
	public int update(YearAppraisal obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

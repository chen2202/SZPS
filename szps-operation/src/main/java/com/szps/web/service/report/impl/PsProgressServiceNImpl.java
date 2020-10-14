package com.szps.web.service.report.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.report.PsProgressN;
import com.szps.web.mapper.report.PsProgressNMapper;
import com.szps.web.service.report.IPsProgressNService;
@Service
public class PsProgressServiceNImpl implements IPsProgressNService {
	@Autowired
	private PsProgressNMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<PsProgressN> selectList(PsProgressN obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public PsProgressN selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(PsProgressN obj) {
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
	public int update(PsProgressN obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<PsProgressN> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

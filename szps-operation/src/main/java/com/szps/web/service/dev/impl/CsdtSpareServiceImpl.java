package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.csdt.CsdtSpare;
import com.szps.web.mapper.dev.CsdtSpareMapper;
import com.szps.web.service.dev.ICsdtSpareService;
@Service
public class CsdtSpareServiceImpl implements ICsdtSpareService {
	@Autowired
	private CsdtSpareMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<CsdtSpare> selectList(CsdtSpare obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public CsdtSpare selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(CsdtSpare obj) {
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
	public int update(CsdtSpare obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<CsdtSpare> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

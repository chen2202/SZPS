package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.pumpstation.Pumpstation;
import com.szps.web.mapper.dev.PumpstationMapper;
import com.szps.web.service.dev.IPumpstationService;
@Service
public class PumpstationServiceImpl implements IPumpstationService {
	@Autowired
	private PumpstationMapper mapper;
	@Override
	public List<Pumpstation> selectList(Pumpstation obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public Pumpstation selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(Pumpstation obj) {
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
	public int update(Pumpstation obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<Pumpstation> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

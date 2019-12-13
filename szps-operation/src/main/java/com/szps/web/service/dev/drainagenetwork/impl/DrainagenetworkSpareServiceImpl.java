package com.szps.web.service.dev.drainagenetwork.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.drainagenetwork.DrainagenetworkSpare;
import com.szps.web.mapper.dev.drainagenetwork.DrainagenetworkSpareMapper;
import com.szps.web.service.dev.drainagenetwork.IDrainagenetworkSpareService;
@Service
public class DrainagenetworkSpareServiceImpl implements IDrainagenetworkSpareService{
	@Autowired
	private DrainagenetworkSpareMapper mapper;
	@Override
	public List<DrainagenetworkSpare> selectList(DrainagenetworkSpare obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public DrainagenetworkSpare selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(DrainagenetworkSpare obj) {
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
	public int update(DrainagenetworkSpare obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<DrainagenetworkSpare> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

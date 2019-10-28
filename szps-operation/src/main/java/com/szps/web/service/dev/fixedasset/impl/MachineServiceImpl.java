package com.szps.web.service.dev.fixedasset.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.fixedasset.Machine;
import com.szps.web.mapper.dev.fixedasset.MachineMapper;
import com.szps.web.service.dev.fixedasset.IMachineService;
@Service
public class MachineServiceImpl implements IMachineService {
	@Autowired
	private MachineMapper mapper;
	@Override
	public List<Machine> selectList(Machine obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public Machine selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(Machine obj) {
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
	public int update(Machine obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

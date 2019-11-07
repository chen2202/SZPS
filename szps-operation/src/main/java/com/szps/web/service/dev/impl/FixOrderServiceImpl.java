package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.FixOrder;
import com.szps.web.mapper.dev.FixOrderMapper;
import com.szps.web.service.dev.IFixOrderService;
@Service
public class FixOrderServiceImpl implements IFixOrderService {

	@Autowired
	private FixOrderMapper mapper;
	@Override
	public List<FixOrder> selectList(FixOrder obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public FixOrder selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(FixOrder obj) {
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
	public int update(FixOrder obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.bo.BOSpare;
import com.szps.web.mapper.dev.BOSpareMapper;
import com.szps.web.service.dev.IBOSpareService;
@Service
public class BOSpareServiceImpl implements IBOSpareService {
	@Autowired
	private BOSpareMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<BOSpare> selectList(BOSpare obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public BOSpare selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(BOSpare obj) {
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
	public int update(BOSpare obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<BOSpare> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

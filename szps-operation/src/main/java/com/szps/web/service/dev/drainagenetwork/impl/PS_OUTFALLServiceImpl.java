package com.szps.web.service.dev.drainagenetwork.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.drainagenetwork.PS_OUTFALL;
import com.szps.web.mapper.dev.drainagenetwork.PS_OUTFALLMapper;
import com.szps.web.service.dev.drainagenetwork.IPS_OUTFALLService;
@Service
public class PS_OUTFALLServiceImpl implements IPS_OUTFALLService {
	@Autowired
	private PS_OUTFALLMapper mapper;
	@Override
	public List<PS_OUTFALL> selectList(PS_OUTFALL obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public PS_OUTFALL selectById(String id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(PS_OUTFALL obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		String[] idsL = Convert.toStrArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(PS_OUTFALL obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public List<PS_OUTFALL> selectByName(String name) {
		// TODO Auto-generated method stub
		return mapper.selectByName(name);
	}

}

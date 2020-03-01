package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.MaintainRecord;
import com.szps.web.mapper.dev.MaintainRecordMapper;
import com.szps.web.service.dev.IMaintainRecordService;
@Service
public class MaintainRecordServiceImpl implements IMaintainRecordService {

	@Autowired
	private MaintainRecordMapper mapper;
	@Override
	@DataScope(deptAlias = "r")
	public List<MaintainRecord> selectList(MaintainRecord obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public MaintainRecord selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(MaintainRecord obj) {
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
	public int update(MaintainRecord obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

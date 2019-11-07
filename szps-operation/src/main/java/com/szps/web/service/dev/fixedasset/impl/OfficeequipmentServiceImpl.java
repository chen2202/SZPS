package com.szps.web.service.dev.fixedasset.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.fixedasset.Officeequipment;
import com.szps.web.mapper.dev.fixedasset.OfficeequipmentMapper;
import com.szps.web.service.dev.fixedasset.IOfficeequipmentService;
@Service
public class OfficeequipmentServiceImpl implements IOfficeequipmentService {
	@Autowired
	private OfficeequipmentMapper mapper;
	@Override
	public List<Officeequipment> selectList(Officeequipment obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public Officeequipment selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(Officeequipment obj) {
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
	public int update(Officeequipment obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

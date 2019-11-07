package com.szps.web.service.dev.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.MaintenanceRecord;
import com.szps.web.mapper.dev.MaintenanceRecordMapper;
import com.szps.web.service.dev.IMaintenanceRecordService;
@Service
public class MaintenanceRecordServiceImpl implements IMaintenanceRecordService {
	@Autowired
	private MaintenanceRecordMapper mapper;
	@Override
	public List<MaintenanceRecord> selectList(MaintenanceRecord obj) {
		return mapper.selectList(obj);
	}

	@Override
	public MaintenanceRecord selectById(Long id) {
		return mapper.selectById(id);
	}

	@Override
	public int insert(MaintenanceRecord obj) {
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		Long[] idsL = Convert.toLongArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(MaintenanceRecord obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

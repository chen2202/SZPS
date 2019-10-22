package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.MaintenanceRecord;

public interface IMaintenanceRecordService {

	public List<MaintenanceRecord> selectList(MaintenanceRecord obj);

	public MaintenanceRecord selectById(Long id);

	public int insert(MaintenanceRecord obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(MaintenanceRecord obj);
}
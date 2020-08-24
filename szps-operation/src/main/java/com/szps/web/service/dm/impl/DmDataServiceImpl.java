package com.szps.web.service.dm.impl;

import java.util.List;

import com.szps.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.web.domain.dm.DmData;
import com.szps.web.mapper.dm.DmDataMapper;
import com.szps.web.service.dm.IDmDataService;

@Service
public class DmDataServiceImpl implements IDmDataService{

	@Autowired
	private DmDataMapper dmDataMapper;

	@Override
	public List<DmData> selectDataList(DmData dmData) {
		return dmDataMapper.selectDataList(dmData);
	}

	@Override
	public List<DmData> selectApprovalDataList(DmData dmData) {
		return dmDataMapper.selectApprovalDataList(dmData);
	}

	@Override
	public DmData selectDataById(Long dataId) {
		return dmDataMapper.selectDataById(dataId);
	}

	@Override
	public DmData selectDataByUuid(String dataUuid){
		return dmDataMapper.selectDataByUuid(dataUuid);
	}

	@Override
	public int deleteDataByIds(String ids){
		Long[] dataIds = Convert.toLongArray(ids);
		return dmDataMapper.deleteDataByIds(dataIds);
	}

	@Override
	public int insertData(DmData data) {
		return dmDataMapper.insertData(data);
	}

	@Override
	public int updateData(DmData dmData) {
		return dmDataMapper.updateData(dmData);
	}

}

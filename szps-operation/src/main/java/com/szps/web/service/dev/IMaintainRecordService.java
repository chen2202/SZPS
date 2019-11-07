package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.MaintainRecord;

public interface IMaintainRecordService {

	public List<MaintainRecord> selectList(MaintainRecord obj);

	public MaintainRecord selectById(Long id);

	public int insert(MaintainRecord obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(MaintainRecord obj);
}
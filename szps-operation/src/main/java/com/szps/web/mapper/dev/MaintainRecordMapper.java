package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.MaintainRecord;

public interface MaintainRecordMapper {

	public List<MaintainRecord> selectList(MaintainRecord obj);

	public MaintainRecord selectById(Long id);

	public int insert(MaintainRecord obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(MaintainRecord obj);
}
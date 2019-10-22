package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.ScrapRecord;

public interface ScrapRecordMapper {

	public List<ScrapRecord> selectList(ScrapRecord obj);

	public ScrapRecord selectById(Long id);

	public int insert(ScrapRecord obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(ScrapRecord obj);
}
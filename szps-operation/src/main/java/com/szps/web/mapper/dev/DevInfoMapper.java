package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.DevInfo;

public interface DevInfoMapper {

	public List<DevInfo> selectList(DevInfo obj);

	public DevInfo selectById(Long id);

	public int insert(DevInfo obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(DevInfo obj);
	public List<DevInfo> selectByName(String name);
}
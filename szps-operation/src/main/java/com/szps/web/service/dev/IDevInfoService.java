package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.DevInfo;

public interface IDevInfoService {

	public List<DevInfo> selectList(DevInfo obj);

	public DevInfo selectById(Long id);
	public List<DevInfo> selectByName(String name);

	public int insert(DevInfo obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(DevInfo obj);
}
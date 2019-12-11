package com.szps.web.service.dev.drainagenetwork;

import java.util.List;

import com.szps.web.domain.dev.drainagenetwork.PS_MANHOLE;

public interface IPS_MANHOLEService {

	public List<PS_MANHOLE> selectList(PS_MANHOLE obj);

	public PS_MANHOLE selectById(String id);

	public List<PS_MANHOLE> selectByName(String name);

	public int insert(PS_MANHOLE obj);

	public int deleteById(String id);

	public int deleteByIds(String ids);

	public int update(PS_MANHOLE obj);
}
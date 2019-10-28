package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Machine;

public interface MachineMapper {

	public List<Machine> selectList(Machine obj);

	public Machine selectById(Long id);

	public int insert(Machine obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Machine obj);
	public List<Machine> selectByName(String name);
}
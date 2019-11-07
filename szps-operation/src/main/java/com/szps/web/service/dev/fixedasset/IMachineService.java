package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Machine;

public interface IMachineService {

	public List<Machine> selectList(Machine obj);

	public Machine selectById(Long id);

	public int insert(Machine obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Machine obj);
}
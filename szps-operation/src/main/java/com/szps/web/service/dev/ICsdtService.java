package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.Csdt;

public interface ICsdtService {

	public List<Csdt> selectList(Csdt obj);

	public Csdt selectById(Long id);
	public List<Csdt> selectByName(String name);

	public int insert(Csdt obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Csdt obj);
}
package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.csdt.Csdt;

public interface CsdtMapper {

	public List<Csdt> selectList(Csdt obj);

	public Csdt selectById(Long id);

	public int insert(Csdt obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Csdt obj);
	public List<Csdt> selectByName(String name);
}
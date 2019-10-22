package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.Check;

public interface ICheckService {

	public List<Check> selectList(Check obj);

	public Check selectById(Long id);

	public int insert(Check obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Check obj);
}
package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.RoutineCheck;

public interface IRoutineCheckService {

	public List<RoutineCheck> selectList(RoutineCheck obj);

	public RoutineCheck selectById(Long id);

	public int insert(RoutineCheck obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(RoutineCheck obj);
}
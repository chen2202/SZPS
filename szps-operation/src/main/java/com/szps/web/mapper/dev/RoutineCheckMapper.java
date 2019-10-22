package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.RoutineCheck;

public interface RoutineCheckMapper {

	public List<RoutineCheck> selectList(RoutineCheck obj);

	public RoutineCheck selectById(Long id);

	public int insert(RoutineCheck obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(RoutineCheck obj);
}
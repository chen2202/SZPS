package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Car;

public interface CarMapper {

	public List<Car> selectList(Car obj);

	public Car selectById(Long id);

	public int insert(Car obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Car obj);
	public List<Car> selectByName(String name);
}
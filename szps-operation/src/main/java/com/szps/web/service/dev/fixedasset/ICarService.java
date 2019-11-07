package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Car;

public interface ICarService {

	public List<Car> selectList(Car obj);

	public Car selectById(Long id);

	public int insert(Car obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Car obj);
}
package com.szps.web.service.dev.fixedasset.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.dev.fixedasset.Car;
import com.szps.web.mapper.dev.fixedasset.CarMapper;
import com.szps.web.service.dev.fixedasset.ICarService;
@Service
public class CarServiceImpl implements ICarService {
	@Autowired
	private CarMapper mapper;
	@Override
	public List<Car> selectList(Car obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public Car selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(Car obj) {
		// TODO Auto-generated method stub
		return mapper.insert(obj);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		return mapper.deleteById(id);
	}

	@Override
	public int deleteByIds(String ids) {
		// TODO Auto-generated method stub
		Long[] idsL = Convert.toLongArray(ids);
		return mapper.deleteByIds(idsL);
	}

	@Override
	public int update(Car obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

}

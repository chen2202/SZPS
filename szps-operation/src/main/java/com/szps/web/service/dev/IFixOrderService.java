package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.FixOrder;

public interface IFixOrderService {
	public List<FixOrder> selectList(FixOrder obj);

	public FixOrder selectById(Long id);

	public int insert(FixOrder obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(FixOrder obj);
}
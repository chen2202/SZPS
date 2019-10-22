package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.FixOrder;

public interface FixOrderMapper {

	public List<FixOrder> selectList(FixOrder obj);

	public FixOrder selectById(Long id);

	public int insert(FixOrder obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(FixOrder obj);
}
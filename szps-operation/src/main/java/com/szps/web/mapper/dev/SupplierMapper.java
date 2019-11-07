package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Supplier;

public interface SupplierMapper {

	public List<Supplier> selectList(Supplier obj);

	public Supplier selectById(Long id);

	public int insert(Supplier obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Supplier obj);
	
	public Supplier checkUnique(String name);
}
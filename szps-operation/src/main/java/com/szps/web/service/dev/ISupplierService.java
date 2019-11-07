package com.szps.web.service.dev;

import java.util.List;

import com.szps.common.core.domain.Ztree;
import com.szps.system.domain.SysDept;
import com.szps.web.domain.dev.Supplier;

public interface ISupplierService {

	public List<Supplier> selectList(Supplier obj);

	public Supplier selectById(Long id);

	public int insert(Supplier obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Supplier obj);

	public String checkUnique(Supplier obj);
	
	public List<Ztree> selectSuppliertTree(Supplier obj);
}
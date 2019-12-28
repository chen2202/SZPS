package com.szps.web.service.dev.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.szps.common.annotation.DataScope;
import com.szps.common.constant.UserConstants;
import com.szps.common.core.domain.Ztree;
import com.szps.common.core.text.Convert;
import com.szps.common.utils.StringUtils;
import com.szps.system.domain.SysDept;
import com.szps.web.domain.dev.Supplier;
import com.szps.web.mapper.dev.SupplierMapper;
import com.szps.web.service.dev.ISupplierService;

@Service
public class SupplierServiceImpl implements ISupplierService {
	@Autowired
	private SupplierMapper mapper;

	@Override
	//@DataScope(deptAlias = "r")
	public List<Supplier> selectList(Supplier obj) {
		// TODO Auto-generated method stub
		return mapper.selectList(obj);
	}

	@Override
	public Supplier selectById(Long id) {
		// TODO Auto-generated method stub
		return mapper.selectById(id);
	}

	@Override
	public int insert(Supplier obj) {
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
	public int update(Supplier obj) {
		// TODO Auto-generated method stub
		return mapper.update(obj);
	}

	@Override
	public String checkUnique(Supplier obj) {
		Supplier reault = mapper.checkUnique(obj.getSname());
		if (StringUtils.isNotNull(reault) && reault.getSname().equalsIgnoreCase(obj.getSname())) {
			return UserConstants.UNIQUE;
		}
		return UserConstants.NOT_UNIQUE;
	}

	@Override
	public List<Ztree> selectSuppliertTree(Supplier obj) {
		List<Supplier> list = mapper.selectList(obj);
        List<Ztree> ztrees = initZtree(list);
        return ztrees;
	}


    public List<Ztree> initZtree(List<Supplier> list)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Supplier supplier : list)
        {
                Ztree ztree = new Ztree();
                ztree.setId(supplier.getId());
                ztree.setName(supplier.getSname());
                ztree.setTitle(supplier.getSname()+" "+supplier.getContact()+" "+ supplier.getTel()+" "+supplier.getAddr());
                ztrees.add(ztree);
        }
        return ztrees;
    }
}

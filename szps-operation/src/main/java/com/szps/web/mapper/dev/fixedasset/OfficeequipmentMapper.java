package com.szps.web.mapper.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Officeequipment;

public interface OfficeequipmentMapper {

	public List<Officeequipment> selectList(Officeequipment obj);

	public Officeequipment selectById(Long id);

	public int insert(Officeequipment obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Officeequipment obj);
	public List<Officeequipment> selectByName(String name);
}
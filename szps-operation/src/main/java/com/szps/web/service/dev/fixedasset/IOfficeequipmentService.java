package com.szps.web.service.dev.fixedasset;

import java.util.List;

import com.szps.web.domain.dev.fixedasset.Officeequipment;

public interface IOfficeequipmentService {

	public List<Officeequipment> selectList(Officeequipment obj);

	public Officeequipment selectById(Long id);

	public int insert(Officeequipment obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Officeequipment obj);
}
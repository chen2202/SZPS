package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.Transfer;

public interface ITransferService {

	public List<Transfer> selectList(Transfer obj);

	public Transfer selectById(Long id);

	public int insert(Transfer obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Transfer obj);
}
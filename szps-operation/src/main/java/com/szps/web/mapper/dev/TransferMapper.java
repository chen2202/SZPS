package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Transfer;

public interface TransferMapper {

	public List<Transfer> selectList(Transfer obj);

	public Transfer selectById(Long id);

	public int insert(Transfer obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Transfer obj);
}
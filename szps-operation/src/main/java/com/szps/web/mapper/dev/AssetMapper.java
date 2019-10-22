package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Asset;

public interface AssetMapper {

	public List<Asset> selectList(Asset obj);

	public Asset selectById(Long id);

	public int insert(Asset obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Asset obj);
}
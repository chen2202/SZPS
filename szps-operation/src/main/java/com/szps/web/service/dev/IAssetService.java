package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.Asset;

public interface IAssetService {

	public List<Asset> selectList(Asset obj);

	public Asset selectById(Long id);

	public int insert(Asset obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Asset obj);
}
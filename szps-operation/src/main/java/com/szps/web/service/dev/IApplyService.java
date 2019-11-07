package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.Apply;

public interface IApplyService {

	public List<Apply> selectList(Apply obj);

	public Apply selectById(Long id);

	public int insert(Apply obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(Apply obj);
}
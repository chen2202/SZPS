package com.szps.web.mapper.dev;

import java.util.List;

import com.szps.web.domain.dev.Apply;

public interface ApplyMapper {

	public List<Apply> selectList(Apply obj);

	public Apply selectById(Long id);

	public int insert(Apply obj);

	public int deleteById(Long id);

	public int deleteByIds(Long[] ids);

	public int update(Apply obj);
}
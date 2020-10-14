package com.szps.web.service.dev;

import java.util.List;

import com.szps.web.domain.dev.bo.BO;

public interface IBOService {

	public List<BO> selectList(BO obj);

	public BO selectById(Long id);
	public List<BO> selectByName(String name);

	public int insert(BO obj);

	public int deleteById(Long id);

	public int deleteByIds(String ids);

	public int update(BO obj);
}
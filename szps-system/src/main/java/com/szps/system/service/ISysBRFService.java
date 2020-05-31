package com.szps.system.service;

import java.util.List;

import com.szps.common.core.domain.Ztree;
import com.szps.system.domain.SysBRF;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysBRFService {
	public List<SysBRF> selectList(SysBRF brf);

	public List<Ztree> selectTree(SysBRF brf);

	public int deleteById(Long id);

	public int insert(SysBRF brf);

	public int update(SysBRF brf);

	public SysBRF selectById(Long id);
	public int  selectCount(Long areaId);
}

package com.szps.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szps.system.domain.SysBRF;

public interface SysBRFMapper {

	public List<SysBRF> selectList(SysBRF brf);

	public int deleteById(Long id);

	public int insert(SysBRF brf);

	public int update(SysBRF brf);

	public SysBRF selectById(Long id);
	public int  selectCount(SysBRF brf);

	public List<SysBRF> selectChildrenById(Long id);

	public int updateChildren(@Param("brfs") List<SysBRF> brfs);

}

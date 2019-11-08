package com.szps.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szps.system.domain.SysArea;

public interface SysAreaMapper {

	public List<SysArea> selectAreaList(SysArea area);

	public int deleteAreaById(Long id);

	public int insertArea(SysArea area);

	public int updateArea(SysArea area);

	public SysArea selectAreaById(Long id);
	public int  selectAreaCount(SysArea area);

	public List<SysArea> selectChildrenAreaById(Long id);

	public int updateAreaChildren(@Param("areas") List<SysArea> areas);

}

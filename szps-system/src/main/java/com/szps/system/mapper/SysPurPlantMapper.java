package com.szps.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.szps.system.domain.SysPurPlant;

public interface SysPurPlantMapper {

	public List<SysPurPlant> selectPurPlantList(SysPurPlant plant);

	public int deletePurPlantById(Long id);

	public int insertPurPlant(SysPurPlant plant);

	public int updatePurPlant(SysPurPlant plant);

	public SysPurPlant selectPurPlantById(Long id);
	public int  selectPurPlantCount(SysPurPlant plant);

	public List<SysPurPlant> selectChildrenPurPlantById(Long id);

	public int updatePurPlantChildren(@Param("plants") List<SysPurPlant> plants);

}

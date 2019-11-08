package com.szps.system.service;

import java.util.List;

import com.szps.common.core.domain.Ztree;
import com.szps.system.domain.SysPurPlant;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysPurPlantService {
	public List<SysPurPlant> selectPurPlantList(SysPurPlant plant);

	public List<Ztree> selectPurPlantTree(SysPurPlant plant);

	public int deletePurPlantById(Long id);

	public int insertPurPlant(SysPurPlant plant);

	public int updatePurPlant(SysPurPlant plant);

	public SysPurPlant selectPurPlantById(Long id);
	public int  selectPurPlantCount(Long plantId);
}

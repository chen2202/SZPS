package com.szps.system.service;

import java.util.List;

import com.szps.common.core.domain.Ztree;
import com.szps.system.domain.SysArea;

/**
 * 部门管理 服务层
 * 
 * @author ruoyi
 */
public interface ISysAreaService {
	public List<SysArea> selectAreaList(SysArea area);

	public List<Ztree> selectAreaTree(SysArea area);

	public int deleteAreaById(Long id);

	public int insertArea(SysArea area);

	public int updateArea(SysArea area);

	public SysArea selectAreaById(Long id);
	public int  selectAreaCount(Long areaId);
	public List<SysArea> selectAreaAll();
}

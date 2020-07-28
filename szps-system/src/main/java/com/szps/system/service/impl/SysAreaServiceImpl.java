package com.szps.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szps.common.core.domain.Ztree;
import com.szps.common.utils.StringUtils;
import com.szps.system.domain.SysArea;
import com.szps.system.domain.SysDept;
import com.szps.system.mapper.SysAreaMapper;
import com.szps.system.service.ISysAreaService;

/**
 * 
 * @author Jack
 *
 */
@Service
public class SysAreaServiceImpl implements ISysAreaService
{
    @Autowired
    private SysAreaMapper mapper;

    public List<SysArea> selectAreaList(SysArea area)
    {
        return mapper.selectAreaList(area);
    }

    public List<Ztree> selectAreaTree(SysArea area)
    {
        List<SysArea> areaList = mapper.selectAreaList(area);
        List<Ztree> ztrees = initZtree(areaList);
        return ztrees;
    }

    /**
     * 对象转部门树
     *
     * @param areaList 部门列表
     * @return 树结构列表
     */
	/*
	 * public List<Ztree> initZtree(List<SysArea> areaList) { return
	 * initZtree(areaList); }
	 */

    /**
     * 对象转部门树
     *
     * @param areaList 部门列表
     * @param roleAreaList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysArea> areaList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysArea area : areaList)
        {
                Ztree ztree = new Ztree();
                ztree.setId(area.getAreaId());
                ztree.setpId(area.getParentId());
                ztree.setName(area.getAreaName());
                ztree.setTitle(area.getAreaName());
                ztrees.add(ztree);
        }
        return ztrees;
    }

    public int deleteAreaById(Long areaId)
    {
        return mapper.deleteAreaById(areaId);
    }

    @Override
    public int insertArea(SysArea area)
    {
        SysArea info = mapper.selectAreaById(area.getParentId());
        area.setAncestors(info.getAncestors() + "," + area.getParentId());
        return mapper.insertArea(area);
    }

    /**
     * 修改保存信息
     * 
     * @param area 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateArea(SysArea area)
    {
        SysArea newParentArea = mapper.selectAreaById(area.getParentId());
        SysArea oldArea = selectAreaById(area.getAreaId());
        if (StringUtils.isNotNull(newParentArea) && StringUtils.isNotNull(oldArea))
        {
            String newAncestors = newParentArea.getAncestors() + "," + newParentArea.getAreaId();
            String oldAncestors = oldArea.getAncestors();
            area.setAncestors(newAncestors);
            updateAreaChildren(area.getAreaId(), newAncestors, oldAncestors);
        }
        int result = mapper.updateArea(area);
        return result;
    }

  

    /**
     * 修改子元素关系
     * 
     * @param areaId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateAreaChildren(Long areaId, String newAncestors, String oldAncestors)
    {
        List<SysArea> children = mapper.selectChildrenAreaById(areaId);
        for (SysArea child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            mapper.updateAreaChildren(children);
        }
    }

    /**
     * 根据部门ID查询信息
     * 
     * @param areaId 部门ID
     * @return 部门信息
     */
    @Override
    public SysArea selectAreaById(Long areaId)
    {
        return mapper.selectAreaById(areaId);
    }

	@Override
	public int selectAreaCount(Long areaId) {
		SysArea area = new SysArea();
		area.setParentId(areaId);
		return mapper.selectAreaCount(area);
	}


	@Override
	public List<SysArea> selectAreaAll() {
		// TODO Auto-generated method stub
		return mapper.selectAreaAll();
	}



    /**
     * 根据Area_Code查找
     * @param sysArea
     * @return
     * made by HJR
     */
    public SysArea getSysArea(SysArea sysArea){return mapper.getSysArea(sysArea);}

}

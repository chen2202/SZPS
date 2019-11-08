package com.szps.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szps.common.core.domain.Ztree;
import com.szps.common.utils.StringUtils;
import com.szps.system.domain.SysPurPlant;
import com.szps.system.mapper.SysPurPlantMapper;
import com.szps.system.service.ISysPurPlantService;

/**
 * 
 * @author Jack
 *
 */
@Service
public class SysPurPlantServiceImpl implements ISysPurPlantService
{
    @Autowired
    private SysPurPlantMapper mapper;

    public List<SysPurPlant> selectPurPlantList(SysPurPlant plant)
    {
        return mapper.selectPurPlantList(plant);
    }

    public List<Ztree> selectPurPlantTree(SysPurPlant plant)
    {
        List<SysPurPlant> plantList = mapper.selectPurPlantList(plant);
        List<Ztree> ztrees = initZtree(plantList);
        return ztrees;
    }

    /**
     * 对象转部门树
     *
     * @param plantList 部门列表
     * @return 树结构列表
     */
	/*
	 * public List<Ztree> initZtree(List<SysPurPlant> plantList) { return
	 * initZtree(plantList); }
	 */

    /**
     * 对象转部门树
     *
     * @param plantList 部门列表
     * @param rolePurPlantList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysPurPlant> plantList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysPurPlant plant : plantList)
        {
                Ztree ztree = new Ztree();
                ztree.setId(plant.getPlantId());
                ztree.setpId(plant.getParentId());
                ztree.setName(plant.getPlantName());
                ztree.setTitle(plant.getPlantName());
                ztrees.add(ztree);
        }
        return ztrees;
    }

    public int deletePurPlantById(Long plantId)
    {
        return mapper.deletePurPlantById(plantId);
    }

    @Override
    public int insertPurPlant(SysPurPlant plant)
    {
        SysPurPlant info = mapper.selectPurPlantById(plant.getParentId());
        plant.setAncestors(info.getAncestors() + "," + plant.getParentId());
        return mapper.insertPurPlant(plant);
    }

    /**
     * 修改保存信息
     * 
     * @param plant 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updatePurPlant(SysPurPlant plant)
    {
        SysPurPlant newParentPurPlant = mapper.selectPurPlantById(plant.getParentId());
        SysPurPlant oldPurPlant = selectPurPlantById(plant.getPlantId());
        if (StringUtils.isNotNull(newParentPurPlant) && StringUtils.isNotNull(oldPurPlant))
        {
            String newAncestors = newParentPurPlant.getAncestors() + "," + newParentPurPlant.getPlantId();
            String oldAncestors = oldPurPlant.getAncestors();
            plant.setAncestors(newAncestors);
            updatePurPlantChildren(plant.getPlantId(), newAncestors, oldAncestors);
        }
        int result = mapper.updatePurPlant(plant);
        return result;
    }

  

    /**
     * 修改子元素关系
     * 
     * @param plantId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updatePurPlantChildren(Long plantId, String newAncestors, String oldAncestors)
    {
        List<SysPurPlant> children = mapper.selectChildrenPurPlantById(plantId);
        for (SysPurPlant child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            mapper.updatePurPlantChildren(children);
        }
    }

    /**
     * 根据部门ID查询信息
     * 
     * @param plantId 部门ID
     * @return 部门信息
     */
    @Override
    public SysPurPlant selectPurPlantById(Long plantId)
    {
        return mapper.selectPurPlantById(plantId);
    }

	@Override
	public int selectPurPlantCount(Long plantId) {
		SysPurPlant plant = new SysPurPlant();
		plant.setParentId(plantId);
		return mapper.selectPurPlantCount(plant);
	}

}

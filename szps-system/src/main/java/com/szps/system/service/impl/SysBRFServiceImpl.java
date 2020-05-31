package com.szps.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.szps.common.core.domain.Ztree;
import com.szps.common.utils.StringUtils;
import com.szps.system.domain.SysBRF;
import com.szps.system.domain.SysDept;
import com.szps.system.mapper.SysBRFMapper;
import com.szps.system.service.ISysBRFService;

/**
 * 
 * @author Jack
 *
 */
@Service
public class SysBRFServiceImpl implements ISysBRFService
{
    @Autowired
    private SysBRFMapper mapper;

    public List<SysBRF> selectList(SysBRF brf)
    {
        return mapper.selectList(brf);
    }

    public List<Ztree> selectTree(SysBRF brf)
    {
        List<SysBRF> brfList = mapper.selectList(brf);
        List<Ztree> ztrees = initZtree(brfList);
        return ztrees;
    }

    /**
     * 对象转部门树
     *
     * @param brfList 部门列表
     * @return 树结构列表
     */
	/*
	 * public List<Ztree> initZtree(List<SysBRF> brfList) { return
	 * initZtree(brfList); }
	 */

    /**
     * 对象转部门树
     *
     * @param brfList 部门列表
     * @param roleList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<SysBRF> brfList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysBRF brf : brfList)
        {
                Ztree ztree = new Ztree();
                ztree.setId(brf.getBrfId());
                ztree.setpId(brf.getParentId());
                ztree.setName(brf.getBrfName());
                ztree.setTitle(brf.getBrfName());
                ztrees.add(ztree);
        }
        return ztrees;
    }

    public int deleteById(Long brfId)
    {
        return mapper.deleteById(brfId);
    }

    @Override
    public int insert(SysBRF brf)
    {
        SysBRF info = mapper.selectById(brf.getParentId());
        brf.setAncestors(info.getAncestors() + "," + brf.getParentId());
        return mapper.insert(brf);
    }

    /**
     * 修改保存信息
     * 
     * @param brf 信息
     * @return 结果
     */
    @Override
    @Transactional
    public int update(SysBRF brf)
    {
        SysBRF newParent = mapper.selectById(brf.getParentId());
        SysBRF old = selectById(brf.getBrfId());
        if (StringUtils.isNotNull(newParent) && StringUtils.isNotNull(old))
        {
            String newAncestors = newParent.getAncestors() + "," + newParent.getBrfId();
            String oldAncestors = old.getAncestors();
            brf.setAncestors(newAncestors);
            updateChildren(brf.getBrfId(), newAncestors, oldAncestors);
        }
        int result = mapper.update(brf);
        return result;
    }

  

    /**
     * 修改子元素关系
     * 
     * @param brfId 被修改的部门ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateChildren(Long brfId, String newAncestors, String oldAncestors)
    {
        List<SysBRF> children = mapper.selectChildrenById(brfId);
        for (SysBRF child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            mapper.updateChildren(children);
        }
    }

    /**
     * 根据部门ID查询信息
     * 
     * @param brfId 部门ID
     * @return 部门信息
     */
    @Override
    public SysBRF selectById(Long brfId)
    {
        return mapper.selectById(brfId);
    }

	@Override
	public int selectCount(Long brfId) {
		SysBRF brf = new SysBRF();
		brf.setParentId(brfId);
		return mapper.selectCount(brf);
	}

}

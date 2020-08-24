package com.szps.web.service.dm.impl;

import com.szps.web.domain.dm.DmCost;
import com.szps.web.mapper.dm.DmCostMapper;
import com.szps.web.service.dm.IDmCostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmCostServiceImpl implements IDmCostService {

    @Autowired
    private DmCostMapper dmCostMapper;

    @Override
    public List<DmCost> selectCostList(DmCost dmCost) {
        return dmCostMapper.selectCostList(dmCost);
    }

    @Override
    public int insertCost(DmCost dmCost) {
        return dmCostMapper.insertCost(dmCost);
    }

    @Override
    public int deleteCostByIds(Long[] ids) {
        return dmCostMapper.deleteCostByIds(ids);
    }

    @Override
    public DmCost selectCostById(Long costId) {
        return dmCostMapper.selectCostById(costId);
    }

    @Override
    public int updateCost(DmCost dmCost) {
        return dmCostMapper.updateCost(dmCost);
    }
}

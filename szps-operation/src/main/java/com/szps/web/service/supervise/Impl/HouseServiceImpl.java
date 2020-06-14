package com.szps.web.service.supervise.Impl;

import com.szps.common.core.text.Convert;
import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.mapper.supervise.TbHouseMapper;
import com.szps.web.service.supervise.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService{

    @Autowired
    private TbHouseMapper houseMapper;

    @Override
    public List<TbHouse> selectHouseAll() {
        return houseMapper.selectAll();
    }

    @Override
    public TbHouse selectHouse() {
        return houseMapper.selectHouse();
    }

    @Override
    public List<TbHouse> selectHouseList(TbHouse tbHouse) {
        return houseMapper.selectHouseList(tbHouse);
    }

    @Override
    public TbHouse selectHouseById(String houseNumber) {
        return houseMapper.selectByPrimaryKey(houseNumber);
    }

    @Override
    public int checkTask(String taskNumber) {
        return 0;
    }

    @Override
    public int deleteHouseById(String houseNumber) {
        return houseMapper.deleteByPrimaryKey(houseNumber);
    }

    @Override
    public int deleteTaskByIds(String ids) throws Exception {
        Long[] Ids = Convert.toLongArray(ids);
        return houseMapper.deleteHouseByIds(Ids);
    }

    @Override
    public int insertHouse(TbHouse house) {
        return houseMapper.insert(house);
    }

    @Override
    public int updateHouse(TbHouse house) {
        return houseMapper.updateByPrimaryKey(house);
    }

    @Override
    public List<TbHouse> selectByRegionAndStreet(String houseRegion, String houseStreet) {
        return houseMapper.selectByRegionAndStreet(houseRegion,houseStreet);
    }

    @Override
    public List<TbHouse> selectHouseCheckList(String houseRule) {
        return houseMapper.selectHouseCheckList(houseRule);
    }

    @Override
    public String[] selectHouseName(String houseRule) {
        return houseMapper.selectHouseName(houseRule);
    }
}

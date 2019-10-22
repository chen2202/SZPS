package com.szps.web.service.supervise.Impl;

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
    public TbHouse selectHouseById(String houseNumber) {
        return houseMapper.selectByPrimaryKey(houseNumber);
    }

    @Override
    public int deleteHouseById(String houseNumber) {
        return houseMapper.deleteByPrimaryKey(houseNumber);
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
    public List<TbHouse> selectByRegionAndStreet(String houseRegion,  String houseStreet) {
        return houseMapper.selectByRegionAndStreet(houseRegion,houseStreet);
    }
}

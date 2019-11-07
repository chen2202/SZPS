package com.szps.web.service.supervise;

import com.szps.web.domain.supervise.TbHouse;
import com.szps.web.domain.supervise.TbRule;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface HouseService
{




    public List<TbHouse> selectHouseAll();

    public TbHouse selectHouse();

    public TbHouse selectHouseById(String houseNumber);


    public int deleteHouseById(String houseNumber);



    public int insertHouse(TbHouse house);

    public int updateHouse(TbHouse house);

    public List<TbHouse> selectByRegionAndStreet(String houseRegion, String houseStreet);

}

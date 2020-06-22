package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbHouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbHouseMapper {
    int deleteByPrimaryKey(String houseNumber);

    int insert(TbHouse record);

    TbHouse selectByPrimaryKey(String houseNumber);

    List<TbHouse> selectAll();

    int updateByPrimaryKey(TbHouse record);

    TbHouse selectHouse();

    List<TbHouse> selectByRegionAndStreet(@Param("houseRegion") String houseRegion, @Param("houseStreet") String houseStreet);

    List<TbHouse> selectHouseList(TbHouse tbHouse);
    int deleteHouseByIds(Long[] ids);
    int CheckdTask(String taskNumber);

    List<TbHouse>selectHouseCheckList(@Param("houseRule")String houseRule);

    String[] selectHouseName(@Param("houseRule")String houseRule);

    int selectHouseCount();
}
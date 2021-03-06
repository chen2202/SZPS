package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbStaff;

import java.util.List;

public interface TbStaffMapper {
    int deleteByPrimaryKey(String staffNumber);

    int insert(TbStaff record);

    TbStaff selectByPrimaryKey(String staffNumber);

    List<TbStaff> selectAll();

    int updateByPrimaryKey(TbStaff record);

    List<TbStaff> selectStaffList(TbStaff staff);

    List<TbStaff> selectStaffByStaffName(String staffName);

    int deleteUserByIds(Long[] ids);
    //TbStaff selectStaff();
    int CheckdStaff(String staffNumber);

    List<TbStaff> selectStaffOne();
    List<TbStaff> selectStaffSecond();


}
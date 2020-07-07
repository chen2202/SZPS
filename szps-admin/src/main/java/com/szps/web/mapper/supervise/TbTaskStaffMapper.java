package com.szps.web.mapper.supervise;

import com.szps.web.domain.supervise.TbTaskStaff;

import java.util.List;

public interface TbTaskStaffMapper {
    int deleteByPrimaryKey(String taskNumber);

    int insert(TbTaskStaff record);

    List<TbTaskStaff> selectByPrimaryKey(String taskNumber);

    List<TbTaskStaff> selectAll();

    int updateByPrimaryKey(TbTaskStaff record);



}
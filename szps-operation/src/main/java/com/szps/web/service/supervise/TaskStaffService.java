package com.szps.web.service.supervise;

import com.szps.web.domain.supervise.TbTaskStaff;

import java.util.List;

/**
 * 检查人员业务层
 * 
 * @author ruoyi
 */
public interface TaskStaffService
{



    public List<TbTaskStaff> selectTbTaskStaffAll();


    public List<TbTaskStaff> selectTbTaskStaffById(String taskNumber);



    public int deleteTbTaskStaffById(String taskNumber);


    public int insertTbTaskStaff(TbTaskStaff tbTaskStaff);

    public int updateTbTaskStaff(String tbTaskStaff);




}

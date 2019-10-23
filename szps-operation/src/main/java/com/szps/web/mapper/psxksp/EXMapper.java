package com.szps.web.mapper.psxksp;


import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.domain.supervise.TbTask;

import java.util.List;

public interface EXMapper {

   // int deleteByPrimaryKey(String taskNumber);

    //int insert(TbTask record);

   // TbTask selectByPrimaryKey(String taskNumber);

    List<EX_GDBS_SB> selectAll();

    //int updateByPrimaryKey(TbTask record);

   // List<TbTask> selectTaskList(TbTask task);

   // List<TbTask> selectTaskByTaskName(String taskName);

   // int deleteTaskByIds(Long[] ids);



}
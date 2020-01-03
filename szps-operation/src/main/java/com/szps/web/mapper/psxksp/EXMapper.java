package com.szps.web.mapper.psxksp;


import com.szps.web.domain.psxksp.EX_GDBS_SB;
import com.szps.web.domain.supervise.TbTask;

import java.util.List;

public interface EXMapper {

   // int deleteByPrimaryKey(String taskNumber);

    //int insert(TbTask record);

   // TbTask selectByPrimaryKey(String taskNumber);

    List<EX_GDBS_SB> selectAll();

    EX_GDBS_SB selectById(String sblsh);
    //int updateByPrimaryKey(TbTask record);

   // List<TbTask> selectTaskList(TbTask task);

   // List<TbTask> selectTaskByTaskName(String taskName);

   // int deleteTaskByIds(Long[] ids);
   List<EX_GDBS_SB> selectTaskBytime(String BYZD1);
   List<EX_GDBS_SB> selectTaskWaiting();
   List<EX_GDBS_SB> selectTaskDone();





}